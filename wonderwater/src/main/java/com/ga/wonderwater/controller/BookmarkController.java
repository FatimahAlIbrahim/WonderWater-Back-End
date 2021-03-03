package com.ga.wonderwater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.wonderwater.dao.BookmarkDao;
import com.ga.wonderwater.model.Bookmark;

@CrossOrigin(origins = "https://pages.git.generalassemb.ly/fatimah-al-ibrahim/WonderWater-Front-End/")
@RestController
public class BookmarkController {
	
	@Autowired
	BookmarkDao bookmarkDao;
	
	@GetMapping("/bookmark/find")
	public Iterable<?> bookmarkDetails(@RequestParam int id) {
		var it = bookmarkDao.findAllByUser(id);
		return it;
	}
	
	@PostMapping("/bookmark/add")
	public Bookmark addBookmark(@RequestBody Bookmark bookmark) {
		bookmarkDao.save(bookmark);
		return bookmark;
	}
	
	@DeleteMapping("/bookmark/delete")
	public boolean deleteBookmark(@RequestParam int id) {
		bookmarkDao.deleteById(id);
		return true;
	}
	
	

}
