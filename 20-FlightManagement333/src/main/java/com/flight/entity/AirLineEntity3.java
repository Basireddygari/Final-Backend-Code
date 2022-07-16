package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirLineEntity3 {

	@Id
	//@Column
	//@GeneratedValue(strategy = GenerationType.AUTO)
private String airlineid;
	
	private String airlinename;
		
	private String airlinelocation;

	public String getAirlineid() {
		return airlineid;
	}

	public void setAirlineid(String airlineid) {
		this.airlineid = airlineid;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public String getAirlinelocation() {
		return airlinelocation;
	}

	public void setAirlinelocation(String airlinelocation) {
		this.airlinelocation = airlinelocation;
	}

	@Override
	public String toString() {
		return "AirLineEntity3 [airlinename=" + airlinename + ", airlinelocation=" + airlinelocation + "]";
	}

	
	

}
