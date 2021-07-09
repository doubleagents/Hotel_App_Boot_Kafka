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

import com.ericsson.example.advanced.model.Hotel;
import com.ericsson.example.advanced.repository.HotelRepository;
import com.ericsson.example.advanced.service.HotelRepositoryService;

/**
 * @author ezhsanc
 *
 *Purpose : This is the RestController class of the Hotel application.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepositoryService hotelRepositoryService;

	@GetMapping("/all")
	public <T> ResponseEntity<T> listAllHotels() {
		final List<Hotel> findAllHotel = hotelRepositoryService.findAllHotels();

		return (ResponseEntity<T>) ResponseEntity.ok(findAllHotel);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Hotel>> findHotelByID(@PathVariable("id") String id) {

		final Optional<Hotel> findById = hotelRepositoryService.findHotelById(id);

		return ResponseEntity.ok().body(findById);
	}

	@PutMapping
	public ResponseEntity<? extends String> insert(@RequestBody Hotel hotel) {
		hotelRepositoryService.addNewHotel(hotel);

		return ResponseEntity.ok().body("Hotel Stored");
	}

	@PostMapping
	public ResponseEntity<? extends String> update(@RequestBody Hotel hotel) {
		hotelRepositoryService.updateHotelDetails(hotel);

		return ResponseEntity.ok().body("Hotel details updated");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<? extends String> delete(@PathVariable("id") String id) {
		this.hotelRepositoryService.deleteHotelById(id);

		return ResponseEntity.ok().body("Hotel details deleted");
	}
}
