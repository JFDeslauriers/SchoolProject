package controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.FollowDAO;
import dao.PostDAO;
import dao.UserDAO;
import dao.UserDAOInterface;
import entity.Comment;
import entity.Follow;
import entity.Post;
import entity.User;
import service.CommentService;
import service.FollowService;
import service.FollowServiceInterface;
@Controller

public class TestController {
	

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

	UserDAOInterface objUserServiceInterface = context.getBean("userDAO", UserDAO.class);

	FollowServiceInterface objFollowServiceInterface = context.getBean("followService", FollowService.class);

	FollowDAO objFollowDAO = new FollowDAO();
	
	@RequestMapping("/test")
	public String PostList(HttpSession session,Model model) {
		User usertest = (User) session.getAttribute("user");
		model.addAttribute("userList", objUserServiceInterface.findAllUser());
		List<Integer>a =(List<Integer>)session.getAttribute("afollowingOBJList");
		
		model.addAttribute("afollowingOBJList",a);
	
		model.addAttribute("user");
		return "test";
	}

//addFollowUser?userId=2
	@RequestMapping(value = "/addFollowUser1", method = RequestMethod.GET)
	public String addFollowUser(HttpSession session, Model model, User user, @RequestParam("userId") int userId,
			@ModelAttribute("flollowadd")Follow follow) {

		user = (User) session.getAttribute("user");

		objFollowServiceInterface.createFollowing(user.getUserId(), userId);
		return "follow";
	}

	@RequestMapping(value = "/deleteFollow1", method = RequestMethod.GET)
	public String deleteFollowUser(HttpSession session, Model model, User user, @RequestParam("userId") int userId) {

		user = (User) session.getAttribute("user");
		objFollowServiceInterface.deleteFollow(user.getUserId(), userId);
		return "follow";
	}
	/*@PostMapping("getFollow")
	public void populateRadio( @RequestParam("userId") int userId) {
		
		objFollowServiceInterface.readFollow(userId);
			
	}*/

	  
	        
		 
		 
	/*@RequestMapping("/test")
	public void  PostList(Model model) {
	
		List<Post> postList = objPostDAO.findallposts();
		Iterator iter = postList.iterator();	
		while (iter.hasNext()) {
			Post post = new Post();
			int a=   post.getPostId();
			System.out.print(a);
			
		}*/
	 }
	
	


