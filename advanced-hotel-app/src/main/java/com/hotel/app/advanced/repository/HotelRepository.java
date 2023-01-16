package com.hotel.app.advanced.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.app.advanced.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {
	
	
}
