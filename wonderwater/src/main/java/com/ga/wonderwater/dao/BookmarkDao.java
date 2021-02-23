package com.ga.wonderwater.dao;

import org.springframework.data.repository.CrudRepository;
import com.ga.wonderwater.model.Bookmark;
import com.ga.wonderwater.model.User;

public interface BookmarkDao extends CrudRepository<Bookmark, Integer>{
	
	public Iterable<Bookmark> findByUser(User user);

}
