package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class BookingFlight1 {
	@Id
	private String  pnr;
	private String status; // Pending/Booked/Cancelled
	private Integer noOfSeatsBooked;
	private Long flightid;
	private String username;
	private String email;
	private String mobileNo;
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}
	public void setNoOfSeatsBooked(Integer noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}
	public Long getFlightid() {
		return flightid;
	}
	public void setFlightid(Long flightid) {
		this.flightid = flightid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "BookingFlight1 [pnr=" + pnr + ", status=" + status + ", noOfSeatsBooked=" + noOfSeatsBooked
				+ ", flightid=" + flightid + ", username=" + username + ", email=" + email + ", mobileNo=" + mobileNo
				+ "]";
	}

	

}
