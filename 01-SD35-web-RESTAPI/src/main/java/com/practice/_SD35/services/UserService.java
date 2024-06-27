package com.practice._SD35.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice._SD35.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	public UserRepo userRepo;

}
