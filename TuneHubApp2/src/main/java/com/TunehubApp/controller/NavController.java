package com.TunehubApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.TunehubApp.service.UsersService;


@Controller
public class NavController {
	@Autowired
	UsersService userv;
	
	@GetMapping("/map-register")
	public String registerMapping() {
		 return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping() {
		 return "login";
	}
	@GetMapping("/map-songs")
	public String songsMapping() {
		 return "addsongs";
	}
}

