package ru.ovv.javapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ovv.javapp.model.User;
import ru.ovv.javapp.service.UserService;


@Controller
public class UserController {

	private final UserService userService;


	public UserController(UserService userService) {
		this.userService = userService;
	}



	@GetMapping( "/")
	public String start(Model model){
		model.addAttribute("start");
		return "start";
	}

	@GetMapping(value = "/users")
	public String tableUsers(Model model) {
		model.addAttribute("users", userService.allUsers());
		return "users";
	}

	@GetMapping("/addUser")
	public String newUser(@ModelAttribute("user") User user) {
		return "/addUser";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/changeUser/{id}")
	public String changeUser(Model model, @PathVariable("id") long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "/changeUser";
	}

	@PatchMapping("/changeUser/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
		userService.changeUser(id, user);
		return "redirect:/users";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}





}