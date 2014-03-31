package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import webapp.service.UserService;

@Controller
public class IndexController {
	@Autowired UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		userService.register("username", "password");
		
		return new ModelAndView(
			"helloSpring",
			new ModelMap("message", "Users: " + userService.getAllUsers().size())
		);
	}
}
