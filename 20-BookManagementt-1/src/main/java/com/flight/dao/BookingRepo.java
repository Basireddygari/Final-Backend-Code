package com.flight.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entity.BookingFlight1;


	@Repository
	public interface BookingRepo extends JpaRepository<BookingFlight1, Integer> {

		
		Optional<BookingFlight1> findByPnr(String pnr);

		void deleteByPnr(String pnr);

		Optional<BookingFlight1> findByEmail(String mail);

		

	}

