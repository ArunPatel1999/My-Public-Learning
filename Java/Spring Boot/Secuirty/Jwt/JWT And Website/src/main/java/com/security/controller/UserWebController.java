package com.security.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.security.entity.User;
import com.security.entity.UserService;

@Controller
@RequestMapping("/")
public class UserWebController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public String getLoginPage() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String getDetailPage(HttpServletRequest request) {
	System.out.println(request.getParameter("class"));
		return "Login";
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, value={"/web", "/web/{id}"})
	public String getUser(Model model, @PathVariable Optional<Integer> id) throws Exception {
		model.addAttribute("users", userService.getAll());
		User user;
		if(id.isPresent())
			user = userService.getById(id.get());
		else
			user = new User();
		model.addAttribute("userObject", user);
		return "User";
	}
	
	
	@PostMapping
	public RedirectView save(RedirectAttributes redirectAttributes, @ModelAttribute User user) throws Exception {
		if(user.getId() == 0)
			userService.save(user);
		else
			userService.editUser(user.getId(), user);
		RedirectView redirectView = new RedirectView("/web/user", true);
	    redirectAttributes.addFlashAttribute("userMessage", "Successful Add User");
	    return redirectView;
	}
	
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(RedirectAttributes redirectAttributes, @PathVariable int id) {
		RedirectView redirectView = new RedirectView("/web/user", true);
	    redirectAttributes.addFlashAttribute("userMessage", userService.delete(id));
	    return redirectView;
	}
	
}
