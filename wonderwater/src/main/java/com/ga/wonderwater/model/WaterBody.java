package com.ga.wonderwater.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "WaterBody")
public class WaterBody {
	
	@Id
	@GeneratedValue
	private int waterBodyId;
	
	private String name;
	
	private String country;
	
	private String type;
	
	@Column(columnDefinition = "text")
	private String picture;
	
	@Column(columnDefinition = "text")
	private String video;
	
	private boolean dangerous;
	
	private boolean allowSwimming;
	
	@Column(columnDefinition = "text")
	private String descripetion;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "FK_userId")
	private User user;
	
	@OneToMany(mappedBy = "waterBody", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "waterBody", cascade = CascadeType.ALL)
	private Set<Bookmark> bookmarks;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public int getWaterBodyId() {
		return waterBodyId;
	}

	public void setWaterBodyId(int waterBodyId) {
		this.waterBodyId = waterBodyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public boolean isDangerous() {
		return dangerous;
	}

	public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}

	public boolean isAllowSwimming() {
		return allowSwimming;
	}

	public void setAllowSwimming(boolean allowSwimming) {
		this.allowSwimming = allowSwimming;
	}

	public String getDescripetion() {
		return descripetion;
	}

	public void setDescripetion(String descripetion) {
		this.descripetion = descripetion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
}
