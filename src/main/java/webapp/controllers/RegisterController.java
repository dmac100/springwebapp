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

import webapp.service.AlreadyExistsException;
import webapp.service.UserService;

@Controller
public class RegisterController {
	@Autowired UserService userService;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(
		@RequestParam(defaultValue="") String username,
		@RequestParam(defaultValue="") String password,
		@RequestParam(defaultValue="") String passwordRepeat,
		RedirectAttributes redirectAttributes
	) {
		username = username.trim();
		password = password.trim();
		passwordRepeat = passwordRepeat.trim();
		
		List<String> errors = new ArrayList<String>();
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("errors", errors);
		modelMap.addAttribute("username", username);
		
		if(username.length() < 3 || username.length() > 50) {
			errors.add("Username must be between 3 and 50 characters");
		}
		
		if(password.length() < 5) {
			errors.add("Password must be at least 5 characters");
		} else {
			if(!password.equals(passwordRepeat)) {
				errors.add("Passwords do not match");
			}
		}
		
		try {
			userService.register(username, password);
		} catch(AlreadyExistsException e) {
			errors.add("Username already exists");
		}
		
		if(!errors.isEmpty()) {
			return new ModelAndView("register", modelMap);
		}
		
		redirectAttributes.addFlashAttribute("message", "Successfully registered");
		return new ModelAndView("redirect:index");
	}
}
