package com.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.AirlineRepo;
import com.flight.entity.AirLineEntity3;
@Service
public class AirlineService {
	@Autowired
	private AirlineRepo repo;
	public String registerAirline(AirLineEntity3 a) {
		repo.save(a);
		return "Registered Successfully.";
		
	}
	public List<AirLineEntity3> findAll(){
		return repo.findAll();
		}

}
