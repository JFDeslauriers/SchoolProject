package service;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.User;
import entity.UserInterface;

@Component
public class UserService implements UserServiceInterface {

	@Autowired
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User readuserByEmail(String email) {
		Session sess = UserService.getSession();
		User myuser = (User) sess.createQuery(" from User where email='" + email + "'").getSingleResult();
		return myuser;

	}

	public static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		Session sess = Factory.openSession();
		return sess;

	}

	public User validateUserPassword(String password, String email) {
		Session sess = UserService.getSession();
		User myuser = (User) sess.createQuery(" from User where email='" + email + "'and password='" + password + "'")
				.getSingleResult();
		sess.close();
		return myuser;

	}
	
	public User validateUserObjPassword(User user) {
		Session sess = UserService.getSession();
		User myuser = (User) sess.createQuery(" from User where email='" + user.getEmail() + "'and password='" + user.getPassword() + "'")
				.getSingleResult();
		System.out.print("hello");
		System.out.print(myuser.getEmail());
		sess.close();
		return myuser;

	}
	
	public void creatUser(User user) {
		Session sess = UserService.getSession();
		
		System.out.print(user);
		sess.beginTransaction();
		sess.save(user);
		sess.getTransaction().commit();
		sess.close();
		
	}

	public void createuserOld(String firstName, String lastName, String email, String password) {

		Session sess = UserService.getSession();
		User user = new User(firstName, lastName, email, password);
		sess.beginTransaction();
		sess.save(user);
		sess.getTransaction().commit();
		sess.close();
	}

	public User readuser(int userId) {
		Session sess = UserService.getSession();
		User myuser = sess.get(User.class, userId);
		sess.close();
		return myuser;

	}

	public User getUserByEmail(String email) {
		Session sess = UserService.getSession();
		Query query = sess.createQuery("FROM User where email=:email");
		query.setParameter("email", email);
		User user = (User) query.getSingleResult();
		sess.close();
		return user;
	}

	public void updateUser(User user, int userId) {
		Session sess = UserService.getSession();
		sess.beginTransaction();
		sess.createQuery("update User set firstName='" + user.getFirstName() + "', lastName='" + user.getLastName()
				+ "',email='" + user.getEmail() + "', password='" + user.getPassword() + "' where id=" + userId)
				.executeUpdate();
		sess.getTransaction().commit();
		sess.close();
	}

	public void deleteuser(String firstName, String lastName) {
		Session sess = UserService.getSession();
		sess.beginTransaction();
		sess.createQuery("delete from user where firstName ='" + firstName + "'and lastName ='" + lastName + "'")
				.executeUpdate();
		sess.getTransaction().commit();
		sess.close();
	}

}
