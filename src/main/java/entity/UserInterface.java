package entity;

import java.util.List;

public interface UserInterface {

	public int getUserId();

	public void setUserId(int userId);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public List<Follow> getFollowList();

	public void setFollowList(List<Follow> followList);

	public List<Post> getPostList();

	public void setPostList(List<Post> postList);

	public List<Comment> getCommentList();

	public void setCommentList(List<Comment> commentList);
	
	public int getFollowinguserId();

	public void setFollowinguserId(int followinguserId);

}
