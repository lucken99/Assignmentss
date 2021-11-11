package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.model.User;
import com.nagarro.service.UserService;


@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(path="/processform", method=RequestMethod.POST)
	public String handleForm(final @ModelAttribute("user") User user,final Model model) {
		this.userService.createUser(user);
		String nextPage=null;
		final boolean successfulLogin=userService.isValidUser(user.getUserName());
		if(successfulLogin) {
			model.addAttribute("name", user.getUserName());
			nextPage="success";
		}else {
			nextPage="index";
		}
		return "success";
	}

}
