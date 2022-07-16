package com.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.BookingRepo;

import com.flight.entity.BookingFlight1;
import com.flight.exception.TicketNotFoundException;


@Service
public class BookingService {
	
	@Autowired
	private BookingRepo repo;

public String bookTicket(BookingFlight1 m,Long id) {
	//System.out.println("************");
		int min=100;
		int max=1000;
		String pnr_no="PNR";
		int b = (int)(Math.random()*(max-min+1)+min);  
		pnr_no=pnr_no+b;
	m.setPnr(pnr_no);
	m.setFlightid(id);
	m.setStatus("booked");
	repo.save(m);
	return pnr_no;
	}


public List<BookingFlight1> getAllBooks(){
	return repo.findAll();
}

public BookingFlight1 getBookingDetailsByPnr(String pnr) throws TicketNotFoundException {
	Optional<BookingFlight1> optional = repo.findByPnr(pnr);
	if(optional.isEmpty()) {
		throw new TicketNotFoundException("booking with pnr: "+pnr+" not available in database");
		//return pnr+"value is in valid";
	} else {
		return optional.get();
	}
	}
	public BookingFlight1 getTicketDetailsByMail(String mail) throws TicketNotFoundException {
		Optional<BookingFlight1> optional = repo.findByEmail(mail);
		if(optional.isEmpty()) {
			throw new TicketNotFoundException("booking with mail: "+mail+" not available in database");
		} else {
			System.out.println(optional);
			return optional.get();
		}	
	
		}
	public String cancelTicket(String pnr) {
		//System.out.println("************");
		Optional<BookingFlight1> findById = repo.findByPnr(pnr);
		if(findById.isEmpty()) {
			return "invalid pnr";
		}else {
			//System.out.println("DDDDDDDDDD");
			repo.deleteByPnr(pnr);
			
			return "succesfully deleted----";
		}
	}


}
