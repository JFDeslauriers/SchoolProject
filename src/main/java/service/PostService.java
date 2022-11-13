package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.Post;
import entity.User;

@Component
public class PostService implements PostServiceInterface {

	@Autowired
	Post post;
	
	@Autowired
	User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public void createPost(String post, int userId) {
		Session sess = PostService.getSession();
		User user = new User();
		user.setUserId(userId);
		Post objPost = new Post();
		objPost.setPost(post);
		objPost.setUser(user);
		sess.beginTransaction();
		sess.save(objPost);
		sess.getTransaction().commit();
		sess.close();

	}

	public Post readPost(int id) {
		Session sess = PostService.getSession();
		Post myPost = sess.get(Post.class, id);
		sess.close();
		return myPost;

	}

	public void deletePost(int userId) {
		Session sess = PostService.getSession();
		sess.beginTransaction();
		sess.createQuery("delete from Post where userId ='" + userId).executeUpdate();
		sess.getTransaction().commit();
		sess.close();

	}

	public void updatePost(Post post) {
		Session sess = PostService.getSession();
		sess.beginTransaction();
		sess.createQuery("update Post set post='" + post.getPost() + "' where postId=" + post.getPostId())
				.executeUpdate();
		sess.getTransaction().commit();
		sess.close();
	}

}