package com.flight.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.flight.dao.FlightRepo;
import com.flight.entity.FlightEntity333;
import com.flight.exception.TicketNotFoundException;

@Service
public class FlightService {
	@Autowired
	private FlightRepo repo;

	public String update(Long id,FlightEntity333 f) throws TicketNotFoundException{
		Optional<FlightEntity333> findById = repo.findById(id);
		if(findById.isEmpty()) {
		return "succesfully  registered";
	}else {
		FlightEntity333 findById2 = repo.findById(id).get();
		findById2.setOrigin(f.getOrigin());
		findById2.setDestination(f.getDestination());
		findById2.setNoOfSeats(f.getNoOfSeats());
		repo.save(findById2);
		return "Succ";
	}
		
	}
	
	
	public String save(FlightEntity333 f){
		repo.save(f);
		return "succesfully  registered";
	}
	public List<FlightEntity333> findAllFlights(){
		return repo.findAll();
	}
	public String deleteid(Long id) {
		 repo.deleteById(id);
		return "succ";
		}
	public List<FlightEntity333> findAllByOrigin(String origin) throws TicketNotFoundException {
		List<FlightEntity333> optional = repo.findByOrigin(origin);
		return optional;
		}
	public boolean findByidd(Long idd) throws TicketNotFoundException {
		Optional<FlightEntity333> optional = repo.findById(idd);
		if(optional.isEmpty()) {
			return false;
		}else {
		return true;
		}
	}
	public List<FlightEntity333> findAllByDestinationn(String destination) throws TicketNotFoundException {
		List<FlightEntity333> optional = repo.findAllByDestination(destination);
		return optional;
		}
	public List<FlightEntity333> findAllByOriginAndDestinationn(String origin,String destination) throws TicketNotFoundException {
		List<FlightEntity333> optional = repo.findAllByOriginAndDestination(origin,destination);
		return optional;
		}

	
	
}
