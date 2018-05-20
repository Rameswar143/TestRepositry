/**
 * 
 */
package com.ramu.online.api.dao;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramu.online.api.model.Users;

/**
 * @author Ramu
 *
 *         29-Apr-2018
 */
@Repository
public class RegisterDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	// Avoid duplicate session creation
	private Session getSession() {
		Session session = sessionFactory.openSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	/**
	 * @param user
	 * @return
	 */
	public Users save(Users user) {
		Session session = getSession();
		session.beginTransaction().begin();
		int use = (int) session.save(user);
		session.beginTransaction().commit();
		System.out.println(use);
		return user;
	}

	/**
	 * @param name
	 * @param email
	 * @return
	 */
	public Users isValidUser(String name, String email) {
		try{
		Session session = getSession();
		Query qery = session
				.createQuery(
						"from Users where username = :userName and email = :email")
				.setParameter("userName", name).setParameter("email", email);
		Users user = (Users) qery.uniqueResult();
		System.out.println(user);
		return user;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

}
