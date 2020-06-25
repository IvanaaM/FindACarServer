package com.ftn.dto;


public class VehiclePhotoDTO {
	
	private long id;
	private String path;
	
	public VehiclePhotoDTO() {
		super();
	}

	public VehiclePhotoDTO(long id, String path) {
		super();
		this.id = id;
		this.path = path;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	

}
