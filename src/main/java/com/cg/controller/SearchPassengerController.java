package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.PassengerResponseDto;
import com.cg.serviceImpl.PassengerServiceImpl;

@RestController
@RequestMapping("/SearchPassenger")
public class SearchPassengerController {

	@Autowired
	private PassengerServiceImpl service;

	@GetMapping("/getPassenger/{userId}")
	public PassengerResponseDto getPassengerById(@PathVariable Long userId) {
		return service.getPassengerById(userId);
	}

	@GetMapping("/getAllPassengers")
	public ResponseEntity<PassengerResponseDto> getAllPassenger() {
		return new ResponseEntity<>(service.getAllPassengers(), HttpStatus.OK);
	}

}
