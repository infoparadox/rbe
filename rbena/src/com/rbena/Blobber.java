package com.rbena;

public class Blobber {

	public Blobber(String bKey) {
		this.blobKey = bKey;
	}

	private String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBlobKey() {
		return blobKey;
	}

	public String getBlobPath() {
		return blobPath;
	}

	public void setBlobPath(String blobPath) {
		this.blobPath = blobPath;
	}

	public String getAgentDetail() {
		return agentDetail;
	}

	public void setAgentDetail(String agentDetail) {
		this.agentDetail = agentDetail;
	}

	public String getGpsCoordinate() {
		return gpsCoordinate;
	}

	public void setGpsCoordinate(String gpsCoordinate) {
		this.gpsCoordinate = gpsCoordinate;
	}

	private String blobKey;
	private String blobPath;
	private String agentDetail;
	private String gpsCoordinate;

}
