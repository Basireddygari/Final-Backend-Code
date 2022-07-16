package com.flight.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entity.FlightEntity333;
@Repository
public interface FlightRepo extends JpaRepository<FlightEntity333, Long> {

	List<FlightEntity333> findByOrigin(String origin);

	List<FlightEntity333> findAllByDestination(String destination);

	List<FlightEntity333> findAllByOriginAndDestination(String origin, String destination);

	
}
