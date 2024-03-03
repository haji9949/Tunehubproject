package com.TunehubApp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TunehubApp.entities.Songs;
import com.TunehubApp.entities.Users;
import com.TunehubApp.service.SongsService;
import com.TunehubApp.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService songserv;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		boolean userstatus= userv.emailExists(user.getEmail());
		
		if(userstatus==false) {	
		userv.addUsers(user);
		return "registationsuccess";
		//System.out.println("user is added");
		}
		else {
			return "registationfail";
			//System.out.println("alredy is existing");
		}
	

	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,
					@RequestParam String password) 
	{
		if(userv.validateUser(email, password) == true)
		{
			if(userv.getRole(email).equals("admin"))
			{
			return "adminhome";
			}
			else 
			{
			return "customerhome";
			}
		}
		else 
		{
			return "loginfail";
		}
	}
	@GetMapping("/exploresongs")
	public String exploreSongs(HttpSession session, Model model) {
		
		String email = (String) session.getAttribute("email");
		
		Users user = userv.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			List<Songs> songslist = songserv.fetchAllSongs();
			model.addAttribute("songslist", songslist);
			return "displaysongs";
		}
		else {
			return "payment";
		}
	}
}
