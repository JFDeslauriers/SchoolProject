package service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Follow;
import entity.User;

@Component
public class FollowService implements FollowServiceInterface {
	


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

	
	
	public void createFollowing(int userId, int otheruserId) {
		Session sess = FollowService.getSession();

		User user = new User();
		user.setUserId(userId);

		Follow follow = new Follow();
		follow.setUser(user);
		follow.setFollowinguserId(otheruserId);
		sess.beginTransaction();
		sess.save(follow);
		sess.getTransaction().commit();
		sess.close();
	}

	public void deleteFollow(int userId, int otheruserId) {
		Session sess = FollowService.getSession();
		sess.beginTransaction();
		sess.createQuery(
				"delete from Follow where user_id ='" + userId + "'and following_user_id ='" + otheruserId + "'")
				.executeUpdate();
		sess.getTransaction().commit();
		sess.close();
	}

	public List<User> readFollow(int userId) {
		Session sess = FollowService.getSession();
		List<User> myFollow = new ArrayList<User>();

		Query query = sess.createQuery("select followinguserId from Follow where user_id=" + userId);
		List<Integer> followinguserId = query.list();
		for (int id : followinguserId) {
			User myuser = sess.get(User.class, id);
			myFollow.add(myuser);
		}
		sess.close();
		return myFollow;
	}
	

}