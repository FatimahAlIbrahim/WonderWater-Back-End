package com.ga.wonderwater.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Bookmark")
public class Bookmark {
	
	@Id
	@GeneratedValue
	private int bookmarkId;
	
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

	public int getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
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
