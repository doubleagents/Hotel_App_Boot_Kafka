/**
 * 
 */
package com.ericsson.example.advanced.controller;

import java.util.List;
import java.util.Optional;

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

/**
 * @author ezhsanc
 *
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	private HotelRepository hotelRepository;
	
	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@GetMapping("/all")
	public List<Hotel> listAllHotels(){
		return this.hotelRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Hotel>> findHotelByID(@PathVariable("id") String id) {
		
		 final Optional<Hotel> findById = this.hotelRepository.findById(id);
		 
		 return ResponseEntity.ok().body(findById);
	}
	
	@PutMapping
	public ResponseEntity<? extends String> insert(@RequestBody Hotel hotel) {
		this.hotelRepository.insert(hotel);
		return  ResponseEntity.ok().body("Hotel Stored");
	}
	
	@PostMapping
	public ResponseEntity<? extends String> update(@RequestBody Hotel hotel){
		this.hotelRepository.save(hotel);
		return  ResponseEntity.ok().body("Hotel details updated");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<? extends String> delete(@PathVariable("id") String id){
		this.hotelRepository.deleteById(id);
		return  ResponseEntity.ok().body("Hotel details deleted");
	}
}
