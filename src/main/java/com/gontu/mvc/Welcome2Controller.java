package com.gontu.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/greet")
public class Welcome2Controller {

	@RequestMapping("/welcome2")
	public ModelAndView displayWelcomePage() {
		ModelAndView mv =new ModelAndView("index.jsp");
		mv.addObject("welcomeMessage", "Hello Everyone in Welcome2.");
		return mv;
	}
	
	@RequestMapping("/ssa")
	public ModelAndView displayWelcomePageWithHi() {
		ModelAndView mv =new ModelAndView("index.jsp");
		mv.addObject("welcomeMessage", "Sat Sri Akal Ji.");
		return mv;
	}
	
	@RequestMapping("/jan")
	public ModelAndView displayWelcomePageWithJan() {
		ModelAndView mv =new ModelAndView("index");
		mv.addObject("welcomeMessage", "Jee Aaiya Nu...");
		return mv;
	}
	
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView displayWelcomePageWithPathVariable(@PathVariable("countryName")String countryName, @PathVariable("userName")String userName) {
		ModelAndView mv =new ModelAndView("index");
		mv.addObject("welcomeMessage", "Hi "+userName+", you are from "+countryName);
		return mv;
	}
	
	@RequestMapping("/welcome-map/{countryName}/{userName}")
	public ModelAndView displayWelcomePageWithPathVariable(@PathVariable Map<String, String> pathVariables) {
		ModelAndView mv =new ModelAndView("index");
		pathVariables.get("");
		mv.addObject("welcomeMessage", "Hi "+pathVariables.get("userName")+", you are from "+pathVariables.get("countryName"));
		return mv;
	}
}
