package service;

import entity.User;
import entity.UserInterface;

public interface UserServiceInterface {

	public User getUser();

	public void setUser(User user);

	public User readuserByEmail(String email);

	public void createuserOld(String firstName, String lastName, String email, String password);

	public User readuser(int userId);

	public void updateUser(User user, int userId);

	public void deleteuser(String firstName, String lastName);

	public User validateUserPassword(String password, String email);

	public User getUserByEmail(String email);

	public void creatUser(User user);

}
