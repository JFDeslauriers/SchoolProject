package dao;

import java.util.List;

import entity.Follow;

public interface FollowDAOInterface {
	
	public List<Integer> findFollowedUser(int userId);
	
	public List<Follow> findFollowedUserObj(int userId);

}
