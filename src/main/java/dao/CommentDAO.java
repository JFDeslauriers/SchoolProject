package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import entity.Comment;
import entity.Post;

@Component
public class CommentDAO implements CommentDAOInterface{
	public static Session getSession() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		Session sess = Factory.openSession();
		return sess;

	}

	public List<Comment> findallPostsById(int post_id) {

		Session sess = CommentDAO.getSession();
		EntityManager em = sess.getEntityManagerFactory().createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Comment where post_id=?1", Comment.class);
		q.setParameter(1, post_id);
		List<Comment> commenttList = q.getResultList();
		sess.close();
		return commenttList;
	}
}