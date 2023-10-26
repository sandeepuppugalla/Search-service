package com.cg.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.ReponseModel;
import com.cg.dto.SearchResponseDto;
import com.cg.serviceImpl.FlightSchedulesServieImpl;

@RestController
@RequestMapping(path = "/SearchFlights", produces = "application/json")
public class SearchFlightSchedulesController {

	@Autowired
	private FlightSchedulesServieImpl service;


	@GetMapping("/getScheduledFlights")
	public List<SearchResponseDto> getScheduledFlights(@RequestParam String fromCity,@RequestParam String toCity,@RequestParam Date journeyDate) {
		return service.getScheduledFlights(fromCity,toCity,journeyDate);
	}
	
	@GetMapping("/v1/getScheduledFlights")
	public ReponseModel getScheduledFlightsV1(@RequestParam String fromCity,@RequestParam String toCity,@RequestParam Date journeyDate) {
				return service.getScheduledFlightsV1(fromCity,toCity,journeyDate);
	}


}
