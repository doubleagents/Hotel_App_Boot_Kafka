/**
 * 
 */
package com.ericsson.example.advanced.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ericsson.example.advanced.model.Hotel;
import com.ericsson.example.advanced.repository.HotelRepository;

/**
 * @author Sandipan Chakraborty
 * 
 * This is a Service bean for Hotel Repository services
 *
 */

@Service
public class HotelRepositoryService {

	private HotelRepository hotelRepository;
	
	public HotelRepositoryService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	public List<Hotel> findAllHotels() {
		return this.hotelRepository.findAll();
	}
	
	public Optional<Hotel> findHotelById(final String id){
		return this.hotelRepository.findById(id);
	}

	public void deleteHotelById(final String id) {
		this.hotelRepository.deleteById(id);
		
	}

	public void updateHotelDetails(final Hotel hotel) {
		this.hotelRepository.save(hotel);
		
	}

	public void addNewHotel(Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}
}
