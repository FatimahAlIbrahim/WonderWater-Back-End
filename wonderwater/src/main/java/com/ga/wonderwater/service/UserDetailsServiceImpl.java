package com.ga.wonderwater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ga.wonderwater.dao.UserDao;
import com.ga.wonderwater.model.User;
import com.ga.wonderwater.model.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		User user = userDao.findByEmailAddress(emailAddress);

		if (user == null) {
			throw new UsernameNotFoundException("Not found");
		}

		UserDetailsImpl obj = new UserDetailsImpl(user);
		return obj;
	}
	
}
