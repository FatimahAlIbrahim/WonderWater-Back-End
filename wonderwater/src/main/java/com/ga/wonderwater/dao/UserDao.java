package com.ga.wonderwater.dao;

import org.springframework.data.repository.CrudRepository;
import com.ga.wonderwater.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	
	public User findByEmailAddress(String emailAddress);
	
}
