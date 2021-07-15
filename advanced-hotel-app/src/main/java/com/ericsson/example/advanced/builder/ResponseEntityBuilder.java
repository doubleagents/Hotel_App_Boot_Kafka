package com.ericsson.example.advanced.builder;

import org.springframework.http.ResponseEntity;

/**
 * @author Sandipan Chakraborty
 * 
 * Purpose: This is a generic ResponseEntity builder class
 *
 */
public class ResponseEntityBuilder {
	
	/**
	 * Private Constructor for ResponseEntityBuilder class
	 */
	private ResponseEntityBuilder() {
		
	}

	@SuppressWarnings("unchecked")
	public static <T> ResponseEntity<T> buildAndReturnOkResponse(final Object body) {
		return (ResponseEntity<T>) ResponseEntity.ok().body(body);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> ResponseEntity<T> buildAndReturnAcceptedResponse(final Object body) {
		return (ResponseEntity<T>) ResponseEntity.accepted().body(body);
	}
}
