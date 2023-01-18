package com.hotel.app.advanced.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.app.advanced.model.Hotel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {

    @Query("{ $and [{'price' : {$gte : ?0}} , {'price' : {$lte : ?1}}]}")
    public List<Hotel> findByPriceBetween(int priceGt, int priceLt);


    @Query("{'address.city' : ?0 }")
    public List<Hotel> findByCity(String cityName);

    @Query("{'rating' : ?0 }")
    public List<Hotel> findByRating(String rating);


	
	
}
