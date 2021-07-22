package com.example.advanced.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advanced.feign.client.MyFeignClient;

import feign.FeignException.InternalServerError;

@RestController
@RequestMapping("/my-app")
public class MyController {
	

	@Autowired
	private MyFeignClient myFeignClient;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/all-hotels")
	public <T> ResponseEntity<T> getHotels(){
		List<T> retrieveAllHotels = new LinkedList<T>();
		try {
		 retrieveAllHotels = myFeignClient.retrieveAllHotels();
		 
		}catch(final Throwable reThrow) {
			final Class<? extends Throwable> exceptionClass =  reThrow.getClass();
			if(exceptionClass.isAssignableFrom(InternalServerError.class)){
				return (ResponseEntity<T>) ResponseEntity.internalServerError().body("Internal Server Error");
			}else if(exceptionClass.isAssignableFrom(NullPointerException.class)) {
				return (ResponseEntity<T>) ResponseEntity.internalServerError().body("Null Pointer Expection");
			}
		}
		return (ResponseEntity<T>) ResponseEntity.ok().body(retrieveAllHotels);
		
	}

}
