package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

	// I added this method so we could go straight to
	@GetMapping()
	public String displayUserIndex(Model model) {
		User nullUser = new User();
		model.addAttribute("user", nullUser);
		return "user/index";
	}


	@GetMapping("/add")
	public String displayAddUserForm() {
		return "user/add";
	}

	@PostMapping
	public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {

		model.addAttribute("username", user.getUsername());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("id", user.getId());

		if (user.getPassword().equals(verify)) {
			return "user/index";
		} else {
			model.addAttribute("error", "Passwords do not match");
			return "user/add";
		}


	}

}
