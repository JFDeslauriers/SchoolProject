package service;

import java.util.List;

import dao.FollowDAO;
import entity.User;

public interface FollowServiceInterface {
	
	



	public User getUser();

	public void setUser(User user);

	public void createFollowing(int userId, int otheruserId);

	public void deleteFollow(int userId, int otheruserId);

	public List<User> readFollow(int userId);
	
}
