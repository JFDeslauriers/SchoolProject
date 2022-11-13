package service;

import entity.Post;
import entity.User;

public interface PostServiceInterface {

	public void createPost(String post, int userId);

	public Post readPost(int id);

	public void deletePost(int userId);

	public void updatePost(Post post);
	
	public void setUser(User user);
	
	public User getUser();

}
