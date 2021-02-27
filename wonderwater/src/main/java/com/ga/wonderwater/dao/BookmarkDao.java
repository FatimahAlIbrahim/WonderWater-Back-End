package com.ga.wonderwater.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ga.wonderwater.model.Bookmark;
import com.ga.wonderwater.model.User;

public interface BookmarkDao extends CrudRepository<Bookmark, Integer>{
	
	@Query( value = "SELECT water_body.*, bookmark.bookmark_id \r\n"
			+ "FROM water_body\r\n"
			+ "INNER JOIN bookmark ON bookmark.fk_water_body_id = water_body.water_body_id where bookmark.fk_user_id = :id"
			,nativeQuery = true)
	public Iterable<?> findAllByUser(int id);

}
