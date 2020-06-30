package com.ftn.dto;

import java.util.List;

public class SyncResponseDTO {
	
	    private long vehicleId;
	    private long newVersion;
	    private List<ReviewDTO> newReviews;

	    public SyncResponseDTO() {
	        super();

	    }

	    public SyncResponseDTO(long vehicleId, List<ReviewDTO> newReviews) {
	        this.vehicleId = vehicleId;
	        this.newReviews = newReviews;
	    }

	    public long getVehicleId() {
	        return vehicleId;
	    }

	    public void setVehicleId(long vehicleId) {
	        this.vehicleId = vehicleId;
	    }

	    public List<ReviewDTO> getNewReviews() {
	        return newReviews;
	    }

	    public void setNewReviews(List<ReviewDTO> newReviews) {
	        this.newReviews = newReviews;
	    }

		public long getNewVersion() {
			return newVersion;
		}

		public void setNewVersion(long newVersion) {
			this.newVersion = newVersion;
		}
	    
	    

}
