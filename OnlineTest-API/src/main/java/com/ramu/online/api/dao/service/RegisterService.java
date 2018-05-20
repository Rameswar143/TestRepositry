/**
 * 
 */
package com.ramu.online.api.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramu.online.api.dao.RegisterDao;
import com.ramu.online.api.model.Users;

/**
 * @author Ramu
 *
 *         29-Apr-2018
 */
@Service
public class RegisterService {
	@Autowired
	RegisterDao dao;

	/**
	 * @param fname
	 * @param lname
	 * @param username
	 * @param email
	 * @param password
	 * @param birthDay
	 * @param birthyear
	 * @param birthMonth
	 * @param gender
	 * @param phone
	 * @return
	 */
	public Users saveUser(String fname, String lname, String username,
			String email, String password, String birthDay, String birthyear,
			String birthMonth, String gender, String phone) {
		Users user = new Users();
		user.setUsername(username);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setDateOfBirth(birthDay + "/" + birthMonth + "/" + birthyear);
		user.setGender(gender);
		user.setEmail(email);
		user.setMobile(phone);
		user.setPassword(password);
		Users isSaved = dao.save(user);
		return isSaved;
	}

	/**
	 * @param name
	 * @param email
	 * @return
	 */
	public Boolean IsValidUser(String name, String email) {
		Users user = dao.isValidUser(name, email);
		if(user!=null){
			return true;
		}
 		return false;
	}

}
