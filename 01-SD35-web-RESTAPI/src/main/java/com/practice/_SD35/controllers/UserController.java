package com.practice._SD35.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice._SD35.services.ProductService;
import com.practice._SD35.services.UserService;

@RestController
@RequestMapping("/arsh/users")
public class UserController {
	
	@Autowired
	public UserService userService;


}
