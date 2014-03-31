package webapp.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloSpring {
	@RequestMapping("/hellospring")
	public ModelAndView index() {
		return new ModelAndView(
			"helloSpring",
			new ModelMap("message", "Testing... 123")
		);
	}
}
