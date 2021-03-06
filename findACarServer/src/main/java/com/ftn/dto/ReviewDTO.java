package com.ftn.dto;

import com.ftn.model.Review;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ReviewDTO implements Serializable {
	
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

	public ReviewDTO(Review review){
        this.id = review.getId();
        this.comment = review.getComment();
        this.rating = review.getRating();
		String pattern = "yyyy-MM-dd'T'HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
        this.date = df.format(review.getDate());
        this.nameUser = review.getUser().getFirstName() + " " + review.getUser().getLastName();
    }

    public static ReviewDTO newInstance(Review review){
		if (review == null){
			return null;
		}else {
			return new ReviewDTO(review);
		}
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
