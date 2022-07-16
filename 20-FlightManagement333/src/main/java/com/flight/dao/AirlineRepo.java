package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.AirLineEntity3;

public interface AirlineRepo extends JpaRepository<AirLineEntity3, String>{

}
