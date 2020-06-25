package com.ftn.dto;

public class ReviewDTO {
	
	private long id;
	private String comment;
    private float rating;
    private String date;
    private String nameUser;
    
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(long id, String comment, float rating, String date, String nameUser) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.date = date;
		this.nameUser = nameUser;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
    
    

}
