package controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.User;


@Controller
public class PersonalSettingsController {

	

	@RequestMapping("/personal_setting")
	public String review(Model model, HttpSession session) {

		model.addAttribute("followingList");
		
		return "personal_setting";
	}

}
