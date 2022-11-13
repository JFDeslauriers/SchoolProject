package database;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CommentDAO;
import dao.FollowDAO;
import dao.PostDAO;

import dao.UserDAO;
import entity.Follow;
import entity.Post;
import entity.User;
import service.CommentService;
import service.FollowService;
import service.PostService;
import service.UserService;
import service.UserServiceInterface;


public class TestMemberCRUD {

	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		UserServiceInterface objUserServiceInterface = context.getBean("userService", UserService.class);
		
		Follow follow = new Follow();
		
		FollowService objFollowService = new FollowService();
		
		PostService objPostService = new PostService();
		
		Post objPost = new Post();
		
		CommentDAO objCommentDAO = new CommentDAO();
		
		UserService objUserService = new UserService();
		
		UserDAO objUserDAO = new UserDAO();
		
		PostDAO objPostDAO =new PostDAO();
		
		CommentService objCommentService = new CommentService();
		
		User user = new User();
		
		FollowDAO objFollowDAO = new FollowDAO();

		//objCommentService.createComment("ouch", 1);
		
		//System.out.print(objCommentDAO.findallPostsById(1));
		
		//objUserService.createuser("Jean", "Jean", "aaa@aaa.com", "1");
		
		//objCommentService.createComment("cool", 1, 3);
		
		//System.out.print(objPost.getCommentList().next());
		
		//objUserServiceInterface.createuser("Jean", "Jean", "aaa@aaa.com", "1");
		
		//objPostService.createPost("123", 1);
		
		//objCommentService.createComment("nice", 1, 3);
		
		//System.out.print(objUserService.getUserByEmail("aaa@aaa.com"));
		
		//System.out.print(objUserService.validateUserPassword("1", "aaa@aaa"));
		
		//objFollowService.deleteFollow(1, 1);
		
		List<Integer> a = objFollowDAO.findFollowedUser(1);
		
	System.out.print(a);
		
	List<Follow> b = objFollowDAO.findFollowedUserObj(1);
		
	System.out.print(b);
		}
		
		
	}



