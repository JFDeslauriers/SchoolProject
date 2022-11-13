package controller;


import javax.servlet.http.HttpSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.User;
import service.FollowService;
import service.FollowServiceInterface;
import service.UserService;
import service.UserServiceInterface;

@Controller
@RequestMapping("/updateUser")
public class UpdateController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

	UserServiceInterface objUserServiceInterface = context.getBean("userService", UserService.class);

	FollowServiceInterface objFollowServiceInterface = context.getBean("followService", FollowService.class);
	
	

	@RequestMapping("/processUpdate")
	public String add(Model model, HttpSession session) {

		model.addAttribute("user",new User());
		
		return "updateUser";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("user") User user, HttpSession session,Model model) {

		user = (User) session.getAttribute("user");
		objUserServiceInterface.updateUser(user, user.getUserId());
		session.setAttribute("user", user);
		return "personal_setting";
	}

}