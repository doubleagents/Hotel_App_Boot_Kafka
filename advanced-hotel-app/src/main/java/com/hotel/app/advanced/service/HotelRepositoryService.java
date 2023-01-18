/**
 * 
 */
package com.hotel.app.advanced.service;

import java.util.List;
import java.util.Optional;

import com.hotel.app.advanced.kafka.producer.KafkaProducerService;
import com.hotel.app.advanced.model.Amenities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.app.advanced.model.Hotel;
import com.hotel.app.advanced.repository.HotelRepository;

/**
 * @author Sandipan Chakraborty
 * 
 * This is a Service bean for Hotel Repository services
 *
 */

@Service
public class HotelRepositoryService {

	private HotelRepository hotelRepository;

	private KafkaProducerService kafkaService;

	@Autowired
	public HotelRepositoryService(HotelRepository hotelRepository,KafkaProducerService kafkaService) {
		this.hotelRepository = hotelRepository;
		this.kafkaService = kafkaService;
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
		Hotel returnHotelData = this.hotelRepository.insert(hotel);

		this.kafkaService.pushToTopic(returnHotelData);


	}

	public Optional<List<Hotel>> findHotelByCity(String city) {

		return Optional.of(this.hotelRepository.findByCity(city));
	}

	public Optional<List<Hotel>> findHotelByRating(String rating) {

		return Optional.of(this.hotelRepository.findByRating(rating));
	}

	public Optional<List<Hotel>> findHotelByPriceRange(String startprice, String limitprice) {

		return Optional.of(this.hotelRepository.findByPriceBetween
				(Integer.parseInt(startprice),Integer.parseInt(limitprice)));
	}

	/*public Optional<List<Hotel>> findHotelByAmenities(Amenities amenities) {

		return null;
	}*/
}
