package service;

import entity.Comment;
import entity.User;

public interface CommentServiceInterface {

	public void createComment(String comment, int userId, int postId);

	public Comment readComment(int id);

	public void deleteComment(int userId);

	public void updateComment(Comment comment);
	
	public Comment getComment();

	public void setComment(Comment comment);

	public User getUser();

	public void setUser(User user);

}
