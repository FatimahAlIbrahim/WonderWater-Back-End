package com.ga.wonderwater.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Comment")
public class Comment {
	
	@Id
	@GeneratedValue
	private int commentId;
	
	@Column(columnDefinition = "text")
	private String commentBody;
	
	private String userName;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "FK_userId")
	private User user;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "FK_waterBodyId")
	private WaterBody waterBody;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WaterBody getWaterBody() {
		return waterBody;
	}

	public void setWaterBody(WaterBody waterBody) {
		this.waterBody = waterBody;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	
}
