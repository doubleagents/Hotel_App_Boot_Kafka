package com.ericsson.example.advanced.controller;

import com.ericsson.example.advanced.builder.ResponseEntityBuilder;
import com.ericsson.example.advanced.model.Amenities;
import com.ericsson.example.advanced.model.Hotel;
import com.ericsson.example.advanced.service.HotelRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class PropertySearchController {

    @Autowired
    private HotelRepositoryService hotelRepositoryService;

    /*
       Search Hotel Property by City
     */
    @GetMapping("/search/{city}")
    public ResponseEntity<?> findHotelByCity(@PathVariable("city") String city) {

        final Optional<List<Hotel>> findByCity= hotelRepositoryService.findHotelByCity(city);

        return ResponseEntityBuilder.buildAndReturnOkResponse(findByCity);
    }

    @PostMapping("/search/features")
    public ResponseEntity<?> findHotelByFeatures(@RequestBody Amenities amenities) {

        final Optional<List<Hotel>> findById = hotelRepositoryService.findHotelByAmenities(amenities);

        return ResponseEntityBuilder.buildAndReturnOkResponse(findById);
    }

    @GetMapping("/search/{rating}}")
    public ResponseEntity<?> findHotelByRating(@PathVariable("rating") String rating) {

        final Optional<Hotel> findByRating = hotelRepositoryService.findHotelByRating(rating);

        return ResponseEntityBuilder.buildAndReturnOkResponse(findByRating);
    }

    @GetMapping("/search/{startprice}/{limitprice}")
    public ResponseEntity<?> findHotelByPriceRange(@PathVariable("startprice") String startprice,
                                                   @PathVariable("limitprice") String limitprice) {

        final Optional<List<Hotel>> findByPriceRange = hotelRepositoryService.findHotelByPriceRange(startprice,limitprice);

        return ResponseEntityBuilder.buildAndReturnOkResponse(findByPriceRange);
    }

}
