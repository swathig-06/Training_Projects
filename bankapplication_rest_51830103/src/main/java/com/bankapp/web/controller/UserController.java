package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.service.UserService;

@RestController
@RequestMapping(path="/admin/api")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(path="/user")
public List<AppUser> getUsers(){
		List<AppUser> appUsers=userService.findAll();
		return appUsers;
	}
	@GetMapping(path="/user/{id}")
	public AppUser getUserBtId(@PathVariable(name="id")Long id){
			AppUser appUser=userService.findById(id);
			return appUser;
		}
}
