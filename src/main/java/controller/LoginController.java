package controller;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import dao.FollowDAO;
import dao.FollowDAOInterface;
import entity.User;
import service.UserServiceInterface;
import service.FollowService;
import service.FollowServiceInterface;
import service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

	UserServiceInterface objUserServiceInterface = context.getBean("userService", UserService.class);
	
	FollowServiceInterface objFollowServiceInterface = context.getBean("followService", FollowService.class);
	
	FollowDAOInterface objFollowDAOInterface = context.getBean("followDAO", FollowDAO.class);

	
	
	@RequestMapping("/error")
	public String showErrorPage() {

		return "error";

	}

	@RequestMapping("/login")
	public String showLoginPage() {

		return "login";

	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public String verifyLogin1(Model model, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		User user = objUserServiceInterface.validateUserPassword(password, email);
		if(user != null) {
		session.setAttribute("user", user);
		List<User>followedUsers=objFollowServiceInterface.readFollow(user.getUserId());
		session.setAttribute("followingList",followedUsers);
		
		return "redirect:/main";
		}else {
			return "error";
	}	
			
		
		

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout( HttpSession session) {
		session.invalidate();	
		return "login";
	}
}
