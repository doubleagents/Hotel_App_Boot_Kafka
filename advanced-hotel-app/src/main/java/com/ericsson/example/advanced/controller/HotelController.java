/**
 * 
 */
package com.ericsson.example.advanced.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.example.advanced.builder.ResponseEntityBuilder;
import com.ericsson.example.advanced.model.Hotel;
import com.ericsson.example.advanced.service.HotelRepositoryService;

/**
 * @author Sandipan Chakraborty
 *
 * Purpose : This is the RestController class of the Hotel application.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepositoryService hotelRepositoryService;

	@GetMapping("/all")
	public ResponseEntity<?> listAllHotels() {
		final List<Hotel> findAllHotel = hotelRepositoryService.findAllHotels();

		return ResponseEntityBuilder.buildAndReturnOkResponse(findAllHotel);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findHotelByID(@PathVariable("id") String id) {

		final Optional<Hotel> findById = hotelRepositoryService.findHotelById(id);

		return ResponseEntityBuilder.buildAndReturnOkResponse(findById);
	}

	@PutMapping
	public ResponseEntity<?> insert(@RequestBody Hotel hotel) {
		hotelRepositoryService.addNewHotel(hotel);

		return ResponseEntityBuilder.buildAndReturnAcceptedResponse("Hotel Details Saved");
					
	}

	@PostMapping("/{update-details}")
	public ResponseEntity<?> update(@RequestBody Hotel hotel) {
		hotelRepositoryService.updateHotelDetails(hotel);

		return ResponseEntityBuilder.buildAndReturnAcceptedResponse("Hotel Details Updated");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		this.hotelRepositoryService.deleteHotelById(id);

		return ResponseEntityBuilder.buildAndReturnAcceptedResponse("Hotel Details Deleted");
	}
}
