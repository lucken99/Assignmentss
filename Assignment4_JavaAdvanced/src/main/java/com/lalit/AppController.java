package com.lalit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TShirtRepository tShirtRepo;

	@Autowired
	private TShirtService tShirtService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

	@GetMapping("/search_tshirts")
	public String searchTShirts(Model model) {
		return "searchPage";
	}

	@GetMapping("/tshirts")
	public String listTShirts(Model model,
							  @Param("color") String color,
							  @Param("gender") String gender,
							  @Param("size") String size) {
		List<TShirt> listTShirts = tShirtService.listAll(color, gender, size);
		model.addAttribute("listTShirst", listTShirts);
		model.addAttribute("color", color);
		model.addAttribute("gender", gender);
		model.addAttribute("size", size);

		return "availTShirts";
	}
}
