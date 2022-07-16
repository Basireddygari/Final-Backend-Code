package com.flight.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flight.entity.BookingFlight1;
import com.flight.exception.TicketNotFoundException;
import com.flight.service.BookingService;

//@CrossOrigin(origins= {"http://localhost:4200","https://hoppscotch"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
@RestController
@RequestMapping("/api/v1.0/flight")
public class BookingController {
	@Autowired
	private BookingService service;
	public boolean getValue(Long idd) {
		System.out.println(idd);
	HttpHeaders h=new HttpHeaders();
	HttpEntity<String> entity=new HttpEntity<String>(h);
	RestTemplate rt=new RestTemplate();
	String url="http://localhost:9092/api/v1.0/flight/Checkingflightid/"+idd;
	//System.out.println(url);
	boolean bookresponse=rt.exchange(url,HttpMethod.GET,entity,boolean.class).getBody();
	System.out.println(bookresponse);
	return bookresponse;}


		@PostMapping("/booking/{flightid}")
		public String ticketResponse(@RequestBody BookingFlight1 t,@PathVariable Long flightid) {
			boolean value = getValue(flightid);
				if(value) {
					return service.bookTicket(t, flightid);
			}
			else {
				return "invalid flightid";
				}
			}
		
		@GetMapping("/fecthAllbookingDetails")
		public List<BookingFlight1> getALL(){
			return service.getAllBooks();
		}
		@GetMapping("/ticket/{pnr}")
		public BookingFlight1 fecthPnr(@PathVariable String pnr) throws TicketNotFoundException {
			return service.getBookingDetailsByPnr(pnr);
		}
		@GetMapping("/booking/history/{email}")
		public BookingFlight1 fecthMail(@PathVariable String email) throws TicketNotFoundException {
			return service.getTicketDetailsByMail(email);
		}
		
		@DeleteMapping("/booking/cancel/{pnr}")
		public String deletePnr(@PathVariable String pnr) throws TicketNotFoundException {
			return service.cancelTicket(pnr);
		}
}

