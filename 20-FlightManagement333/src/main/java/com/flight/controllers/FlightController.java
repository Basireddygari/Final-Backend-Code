package com.flight.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entity.AirLineEntity3;
import com.flight.entity.FlightEntity333;
import com.flight.exception.TicketNotFoundException;
import com.flight.service.AirlineService;
import com.flight.service.FlightService;

//@CrossOrigin(origins= {"http://localhost:4200","https://hoppscotch"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FlightController {
	@Autowired
	private AirlineService service;
	@Autowired
	private FlightService flightService;
	@PostMapping(path="/api/v1.0/flight/airline/register")
	public ResponseEntity<String> registerAirline(@RequestBody AirLineEntity3 airline) {
		return new ResponseEntity<String>(service.registerAirline(airline),HttpStatus.OK);		
	}
	@GetMapping(path="/api/v1.0/flight/airline/all")
	public List<AirLineEntity3> airlinesAll() {
		
	    return service.findAll();
	}
	@GetMapping(path="/api/v1.0/flight/all")
	public List<FlightEntity333> flightsAll() {
		
	    return flightService.findAllFlights();
	}
	@PostMapping(path="/api/v1.0/flight/airline/inventory/add")
	public ResponseEntity<String> saveFlightDetail(@RequestBody FlightEntity333 flight) {
		return new ResponseEntity<String>(flightService.save(flight),HttpStatus.OK);
		}
		@GetMapping(path="/api/v1.0/flight/flight-search")
	public List<FlightEntity333> flights(@RequestParam("origin") String origin, @RequestParam("destination") String destination) throws TicketNotFoundException {
		System.out.println("Parameters are there...");
		
	
		return flightService.findAllByOriginAndDestinationn(origin, destination);
		//return service.findAllByOriginDestinationAndDateOfFlight(origin, destination, dof);
	}
		@GetMapping(path="/api/v1.0/flight/Checkingflightid/{id}")
		public boolean flights(@PathVariable("id") Long id) throws TicketNotFoundException {
		
			return flightService.findByidd(id);
			//return service.findAllByOriginDestinationAndDateOfFlight(origin, destination, dof);
		}
		@DeleteMapping(path="/api/v1.0/flight/delete/{id}")
		public String deleteflights(@PathVariable("id") Long id) throws TicketNotFoundException {
		
			//flightService.deleteid(flightid);
			return flightService.deleteid(id);
			//return service.findAllByOriginDestinationAndDateOfFlight(origin, destination, dof);
		}
		@PutMapping(value="/api/v1.0/flight/update/{id}",consumes= {"application/json"})
		public String putt(@PathVariable("id") Long id,@RequestBody FlightEntity333 ttt) throws TicketNotFoundException {
		return flightService.update(id,ttt);
		}
		
}
