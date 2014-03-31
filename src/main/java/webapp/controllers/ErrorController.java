package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.service.UserService;

@Controller
public class ErrorController {
	@Autowired UserService userService;
	
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String index() {
		return "error";
	}
}
