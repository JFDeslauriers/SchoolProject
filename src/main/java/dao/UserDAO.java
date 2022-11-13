package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Post;
import entity.User;
import service.FollowService;
import service.UserService;

@Repository
public class UserDAO implements UserDAOInterface {

	@Autowired
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static Session getSession() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		Session sess = Factory.openSession();
		return sess;

	}



	public List<User> findAllUser() {

		Session sess = UserDAO.getSession();
		EntityManager em = sess.getEntityManagerFactory().createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Users", User.class);
		List<User> usertList = q.getResultList();
		sess.close();

		return usertList;
	}

}
