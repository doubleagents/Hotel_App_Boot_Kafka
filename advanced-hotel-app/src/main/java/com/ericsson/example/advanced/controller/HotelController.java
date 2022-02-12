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

	/**
	 * This API returns List of the hotels available in the Database
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<?> listAllHotels() {
		final List<Hotel> findAllHotel = hotelRepositoryService.findAllHotels();

		return ResponseEntityBuilder.buildAndReturnOkResponse(findAllHotel);
	}

	/**
	 * This API returns the hotel corresponding to the the ID supplied to it
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> findHotelByID(@PathVariable("id") String id) {

		final Optional<Hotel> findById = hotelRepositoryService.findHotelById(id);

		return ResponseEntityBuilder.buildAndReturnOkResponse(findById);
	}

	/**
	 * This API inserts a new Hotel details in the Database
	 * 
	 * @param hotel
	 * @return
	 */
	@PutMapping
	public ResponseEntity<?> insert(@RequestBody Hotel hotel) {
		hotelRepositoryService.addNewHotel(hotel);

		return ResponseEntityBuilder.buildAndReturnAcceptedResponse("Hotel Details Saved");
					
	}

	/**
	 * This API updates the details of an existing hotel in the Database
	 * 
	 * @param hotel
	 * @return
	 */
	@PostMapping("/{update-details}")
	public ResponseEntity<?> update(@RequestBody Hotel hotel) {
		hotelRepositoryService.updateHotelDetails(hotel);

		return ResponseEntityBuilder.buildAndReturnAcceptedResponse("Hotel Details Updated");
	}

	/**
	 * This API deletes Hotel details corresponding to the supplied hotel ID
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		this.hotelRepositoryService.deleteHotelById(id);

		return ResponseEntityBuilder.buildAndReturnAcceptedResponse("Hotel Details Deleted");
	}
}
