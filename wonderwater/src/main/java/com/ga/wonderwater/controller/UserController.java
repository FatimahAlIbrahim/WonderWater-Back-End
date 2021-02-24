package com.ga.wonderwater.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ga.wonderwater.config.JwtUtil;
import com.ga.wonderwater.dao.UserDao;
import com.ga.wonderwater.model.JwtResponse;
import com.ga.wonderwater.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	UserDetailsService userDetailService;

	@PostMapping("/user/registration")
	public HashMap<String, String> registration(@RequestBody User user) {

		HashMap<String, String> response = new HashMap<String, String>();

		var usersList = userDao.findAll();
		for (User dbUser : usersList) {
			if (dbUser.getEmailAddress().equals(user.getEmailAddress())) {
				response.put("message", "User already exists");
				return response;
			}
		}

		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String newPassword = bCrypt.encode(user.getPassword());
		user.setPassword(newPassword);

		userDao.save(user);

		response.put("message", "User registered successfully");
		return response;
	}

	@PostMapping("/user/authentication")
	public ResponseEntity<?> authenticate(@RequestBody User user) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));
		} catch (BadCredentialsException e) {
			String response = "Incorrect username or password";
			return ResponseEntity.ok(response);
		}

		UserDetails userDetails = userDetailService.loadUserByUsername(user.getEmailAddress());

		String jwtToken = jwtUtil.generateToken(userDetails);
		System.out.println(jwtToken);
		return ResponseEntity.ok(new JwtResponse(jwtToken));
	}
	
	@GetMapping("/user/userInfo")
	public User userInfo(@RequestParam String email) {
		User user = userDao.findByEmailAddress(email);
		return user;
	}
	
	@PostMapping("/user/checkPassword")
	public boolean checkPassword(@RequestBody HashMap<String, String> userInfo) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		User user = userDao.findById(Integer.parseInt(userInfo.get("id")));
		return bCrypt.matches(userInfo.get("password"), user.getPassword());
	}
	
	@PutMapping("/user/edit")
	public User editUser(@RequestBody User user) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String newPassword = bCrypt.encode(user.getPassword());
		user.setPassword(newPassword);
		userDao.save(user);
		return user;
	}

}
