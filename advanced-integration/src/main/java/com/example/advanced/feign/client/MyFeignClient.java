package com.example.advanced.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url="http://127.0.0.1:8080/hotels/",name="advanced-hotel-app")
public interface MyFeignClient {
	
	
	@GetMapping("/all")
	public <T> List<T> retrieveAllHotels() ;
}
