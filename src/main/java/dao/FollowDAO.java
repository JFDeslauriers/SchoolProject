package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Follow;
import entity.User;

@Component
public class FollowDAO implements FollowDAOInterface{
	
	@Autowired
	Follow follow;

	@Autowired
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public Follow getFollow() {
		return follow;
	}

	public void setFollow(Follow follow) {
		this.follow = follow;
	}

	public static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		Session sess = Factory.openSession();
		return sess;
	}

	public List<Integer> findFollowedUser(int userId) {
		Session sess = FollowDAO.getSession();
		Query<Integer> query = sess.createQuery(" select followinguserId from Follow where user_id=" + userId);
		List<Integer> myFollow = query.list();
		sess.close();
		
		return myFollow;

	}
	
	public List<Follow> findFollowedUserObj(int userId) {
		Session sess = FollowDAO.getSession();
		Query<Follow> query = sess.createQuery(" from Follow where user_id=" + userId);
		List<Follow> myFollow = query.list();
		sess.close();

		return myFollow;

	}

}
