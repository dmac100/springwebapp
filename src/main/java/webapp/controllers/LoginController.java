package webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.service.UserService;

@Controller
public class LoginController {
	@Autowired UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(
		@RequestParam(defaultValue="") String username,
		@RequestParam(defaultValue="") String password,
		RedirectAttributes redirectAttributes
	) {
		username = username.trim();
		password = password.trim();
		
		List<String> errors = new ArrayList<String>();
		
		if(!userService.login(username, password)) {
			errors.add("Invalid username or password");
		}
		
		if(!errors.isEmpty()) {
			return new ModelAndView("login", new ModelMap("errors", errors));
		}

		redirectAttributes.addFlashAttribute("message", "Successfully logged in");
		return new ModelAndView("redirect:index");
	}
}
