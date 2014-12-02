package com.rbena;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;

@Entity
public class MyImage {

	@PrimaryKey
	@Id
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;

	@Id
	@Persistent
	private String userName;

	@Persistent
	private String imageName;

	@Persistent
	Blob image;

	public MyImage() {
	}

	public MyImage(String userName, String imageName, Blob image) {
		this.userName = userName;
		this.imageName = imageName;
		this.image = image;
	}

	// JPA getters and setters and empty contructor
	// ...
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
}