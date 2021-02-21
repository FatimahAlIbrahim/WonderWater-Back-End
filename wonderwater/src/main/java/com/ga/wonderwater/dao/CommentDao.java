package com.ga.wonderwater.dao;

import org.springframework.data.repository.CrudRepository;
import com.ga.wonderwater.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Integer>{

}
