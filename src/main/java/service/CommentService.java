package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.Comment;
import entity.Post;
import entity.User;

@Component
public class CommentService implements CommentServiceInterface {
	@Autowired
	Comment comment;
	
	@Autowired
	User user;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	

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

	public void createComment(String comment, int userId, int postId) {
		Session sess = CommentService.getSession();
		Post post = new Post();
		post.setPostId(postId);

		User userComment = new User();
		userComment.setUserId(userId);

		Comment newComment = new Comment();

		newComment.setComment(comment);
		newComment.setUser(userComment);
		newComment.setPost(post);
		sess.beginTransaction();
		sess.save(newComment);
		sess.getTransaction().commit();
		sess.close();
	}

	public Comment readComment(int id) {
		Session sess = CommentService.getSession();
		Comment myComment = sess.get(Comment.class, id);
		sess.close();
		return myComment;
	}

	public void deleteComment(int userId) {
		Session sess = CommentService.getSession();
		sess.beginTransaction();
		sess.createQuery("delete from Comment where userId ='" + userId).executeUpdate();
		sess.getTransaction().commit();
		sess.close();
	}

	public void updateComment(Comment comment) {
		Session sess = CommentService.getSession();
		sess.beginTransaction();
		sess.createQuery(
				"update Comment set comment='" + comment.getComment() + "' where comment_id=" + comment.getCommentId())
				.executeUpdate();
		sess.getTransaction().commit();
		sess.close();
	}

}
