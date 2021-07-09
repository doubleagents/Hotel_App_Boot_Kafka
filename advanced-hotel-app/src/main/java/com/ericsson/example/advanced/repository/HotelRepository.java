package com.ericsson.example.advanced.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ericsson.example.advanced.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
