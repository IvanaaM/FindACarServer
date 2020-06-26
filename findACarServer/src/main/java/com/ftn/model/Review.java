package com.ftn.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.dto.ReviewDTO;

@Entity(name="Review")
public class Review implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@JsonIgnore
	private long id;
	
	@Column(name="Comment")
	private String comment;
	
	@Column(name="Rating")
    private float rating;
		
	@Column(name="Date")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
	
	@ManyToOne
	private User user;
	
	public Review() {
		super();

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static Collection<ReviewDTO> asReviewsDTO(Collection<Review> reviews){
		List<ReviewDTO> retVal = new ArrayList<>();
		reviews.forEach(review -> retVal.add(new ReviewDTO(review)));
		return retVal;
	}

}
