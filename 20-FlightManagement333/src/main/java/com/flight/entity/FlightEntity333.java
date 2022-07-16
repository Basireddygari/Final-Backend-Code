package com.flight.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FlightEntity333 {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="originn")
	private String origin;
	
	@Column(name="destinationnnn")
	private String destination;
	
//	@Column	
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd-MM-yyyy")
//	private Date dateOfFlight;	
	
	@Column
	private int noOfSeats;
	
	@Column
	private int price;
	
	@Column	
	private String timeOfFlight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTimeOfFlight() {
		return timeOfFlight;
	}

	public void setTimeOfFlight(String timeOfFlight) {
		this.timeOfFlight = timeOfFlight;
	}

	@Override
	public String toString() {
		return "FlightEntity [id=" + id + ", origin=" + origin + ", destination=" + destination + ", noOfSeats="
				+ noOfSeats + ", price=" + price + ", timeOfFlight=" + timeOfFlight + "]";
	}
	
//
}
