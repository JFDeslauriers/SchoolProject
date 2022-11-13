package entity;

import java.util.List;

public interface PostInterface {

	public int getPostId();

	public void setPostId(int postId);

	public String getPost();

	public void setPost(String post);

	public List<Comment> getCommentList();

	public void setCommentList(List<Comment> commentList);

	public User getUser();

	public void setUser(User user);
	


}
