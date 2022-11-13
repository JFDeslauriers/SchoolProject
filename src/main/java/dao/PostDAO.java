package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Post;

@Component
public class PostDAO implements PostDAOInterface {

	@Autowired
	Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static Session getSession() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		Session sess = Factory.openSession();
		return sess;

	}

	public List<Post> findallposts() {

		Session sess = PostDAO.getSession();
		EntityManager em = sess.getEntityManagerFactory().createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Post", Post.class);
		List<Post> postList = q.getResultList();
		sess.close();

		return postList;
	}

}
