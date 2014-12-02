package com.rbena;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Id;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class ImageDetail {
	
	@Id
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String blobKey;

	public ImageDetail(String blobKey, String blobPath, String imgName,
			String latLong, String make) {
		super();
		this.blobKey = blobKey;
		this.blobPath = blobPath;
		this.imgName = imgName;
		this.latLong = latLong;
		this.make = make;
	}

	public String getBlobKey() {
		return blobKey;
	}

	public void setBlobKey(String blobKey) {
		this.blobKey = blobKey;
	}

	public String getBlobPath() {
		return blobPath;
	}

	public void setBlobPath(String blobPath) {
		this.blobPath = blobPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Persistent
	private String blobPath;

	@Persistent
	private String imgName;

	@Persistent
	private String latLong;

	@Persistent
	private String make;

}
