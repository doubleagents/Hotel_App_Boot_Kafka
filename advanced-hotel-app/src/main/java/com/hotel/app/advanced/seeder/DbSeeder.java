package com.hotel.app.advanced.seeder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hotel.app.advanced.model.Amenities;
import com.hotel.app.advanced.model.Address;
import com.hotel.app.advanced.model.Hotel;
import com.hotel.app.advanced.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hotel.app.advanced.model.Review;

@Component
public class DbSeeder implements CommandLineRunner {

	private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Mumbai", "India"),
                Arrays.asList(
                        new Review("Sandipan C", 8, false),
                        new Review("Sandipan M", 7, true)
                ),
                new Amenities(true,true,true,true,true)
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("London", "United Kingdom"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                ),
                new Amenities(true,true,false,true,false)
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>(),
                new Amenities(true,false,false,true,true)
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.saveAll(hotels);
    }
}
