package com.ga.wonderwater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.wonderwater.dao.CommentDao;
import com.ga.wonderwater.model.Comment;

//@CrossOrigin(origins = "https://pages.git.generalassemb.ly/fatimah-al-ibrahim/WonderWater-Front-End/")
@RestController
public class CommentController {
	
	@Autowired
	CommentDao commentDao;
	
	@PostMapping("/comment/add")
	public Comment addComment(@RequestBody Comment comment) {
		commentDao.save(comment);
		return comment;
	}
	
	@PutMapping("/comment/edit")
	public Comment editComment(@RequestBody Comment comment) {
		commentDao.save(comment);
		return comment;
	}
	
	@DeleteMapping("/comment/delete")
	public boolean deleteComment(@RequestParam int id) {
		commentDao.deleteById(id);
		return true;
	}

}
