/**
 * 
 */
package com.ramu.online.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ramu.online.api.dao.service.RegisterService;
import com.ramu.online.api.model.Users;

/**
 * @author Ramu
 *
 *         29-Apr-2018
 */
@Controller
public class RegestrationController {
	@Autowired
	RegisterService service;

	@RequestMapping("/register")
	public String register() {
		return "regestration";
	}

	@ResponseBody
	@RequestMapping("/registerUser")
	public String registerUser(Model model,
			@RequestParam("fname") String fname,
			@RequestParam("lname") String lname,
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("BirthDay") String BirthDay,
			@RequestParam("BirthYear") String birthyear,
			@RequestParam("BirthMonth") String BirthMonth,
			@RequestParam("gender") String gender,
			@RequestParam("phone") String phone) {
		Users isSaved  = service
				.saveUser(fname, lname, username, email, password, BirthDay,
						birthyear, BirthMonth, gender, phone);
		return isSaved.toString();
	}
}
