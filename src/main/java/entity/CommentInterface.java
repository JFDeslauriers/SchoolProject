package entity;

import java.util.List;

public interface CommentInterface {

	public int getCommentId();

	public void setCommentId(int commentId);

	public String getComment();

	public void setComment(String comment);

	public User getUser();

	public void setUser(User user);

	public Post getPost();

	public void setPost(Post post);
}
