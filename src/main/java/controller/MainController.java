package controller;


import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import dao.FollowDAO;
import dao.FollowDAOInterface;
import dao.PostDAO;
import dao.PostDAOInterface;
import dao.UserDAO;
import dao.UserDAOInterface;
import entity.Follow;
import entity.Post;
import entity.User;
import service.CommentServiceInterface;
import service.FollowService;
import service.FollowServiceInterface;
import service.PostService;
import service.PostServiceInterface;
import service.CommentService;

@Controller
public class MainController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

	PostServiceInterface objPostServiceInterface = context.getBean("postService", PostService.class);

	CommentServiceInterface objCommentServiceInterface = context.getBean("commentService", CommentService.class);

	PostDAOInterface objPostDAOInterface = context.getBean("postDAO", PostDAO.class);

	UserDAOInterface objUserDAOInterface = context.getBean("userDAO", UserDAO.class);

	FollowServiceInterface objFollowServiceInterface = context.getBean("followService", FollowService.class);
	
	FollowDAOInterface  objFollowDAOInterface = context.getBean("followDAO", FollowDAO.class);


	@RequestMapping("/main")
	public String PostList(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		List<Post> lpost = objPostDAOInterface.findallposts();
		Collections.reverse(lpost);
		/*for (Post p:lpost) {
			Collections.reverse(p.getCommentList());
		}*/
		lpost.stream().forEach(p -> {
			Collections.reverse(p.getCommentList());
		});
		model.addAttribute("userList", objUserDAOInterface.findAllUser());
		model.addAttribute("PostList",lpost );
		List<Integer>followedIdList=  objFollowDAOInterface.findFollowedUser(user.getUserId());
		model.addAttribute("afollowingOBJList",followedIdList);
		return "main";
	}
	
	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String addPost(HttpServletRequest request, HttpServletResponse response, @RequestParam("post") String post,
			Model model)
			 {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		objPostServiceInterface.createPost(post, user.getUserId());
		
	
		
		return "redirect:/main";
	}

	@RequestMapping(value = "/addComment", method = RequestMethod.GET)
	public String addComment(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("postId") int postId, @RequestParam("comment") String comment) {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		objCommentServiceInterface.createComment(comment, user.getUserId(), postId);
		

		return "redirect:/main";
	}

	@RequestMapping(value = "/addFollowUser", method = RequestMethod.GET)
	public String addFollowUser(HttpSession session, Model model, User user, @RequestParam("userId") int userId,
			@ModelAttribute("followadd")Follow follow) {	
		user = (User) session.getAttribute("user");
		objFollowServiceInterface.createFollowing(user.getUserId(), userId);
		
		return "redirect:/main";
	}

	@RequestMapping(value = "/deleteFollow", method = RequestMethod.GET)
	public String deleteFollowUser(HttpSession session, Model model, User user, @RequestParam("userId") int userId) {
		
		user = (User) session.getAttribute("user");
		objFollowServiceInterface.deleteFollow(user.getUserId(), userId);
	
		return "redirect:/main";
	}
	
	

}
