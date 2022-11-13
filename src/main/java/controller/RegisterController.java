package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.PostDAO;
import dao.PostDAOInterface;
import dao.UserDAO;
import dao.UserDAOInterface;
import entity.Post;
import entity.User;
import service.FollowService;
import service.FollowServiceInterface;
import service.UserService;
import service.UserServiceInterface;

@Controller
@RequestMapping("/registration")
public class RegisterController {

	ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

	UserServiceInterface objUserServiceInterface = context.getBean("userService", UserService.class);

	FollowServiceInterface objFollowServiceInterface = context.getBean("followService", FollowService.class);

	@RequestMapping("/processRegistration")
	public String add(Model model) {
		model.addAttribute("user",new User());
		
		return "registration";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute("user") User user, HttpSession session) {
	
		objUserServiceInterface.creatUser(user);
		session.setAttribute("user", user);

		return "personal_setting";
	}
	

}