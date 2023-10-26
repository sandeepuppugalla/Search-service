package com.cg.feignClient;

import java.sql.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.dto.PassengerResponseDto;
import com.cg.dto.ReponseModel;
import com.cg.dto.ReservationResponseDto;
import com.cg.dto.SearchResponseDto;

//@FeignClient(name = "${feign.name}", url = "${feign.url}")
@FeignClient(name = "Booking", url = "http://localhost:8002")
public interface BookingFeignclient {
	
	@GetMapping(value="/Passenger/getPassenger/{userId}")
	PassengerResponseDto getPassengerById(@PathVariable Long userId);
	
	@GetMapping(value="/Passenger/getAllPassengers")
	PassengerResponseDto getAllPassengers();
	
	@GetMapping("/FlightSchedules/getScheduledFlights")
	List<SearchResponseDto> getScheduledFlights(@RequestParam String fromCity,@RequestParam String toCity,@RequestParam Date journeyDate);
	
	@GetMapping("/FlightSchedules/v1/getScheduledFlights")
	ReponseModel getScheduledFlightsv1(@RequestParam String fromCity,@RequestParam String toCity,@RequestParam Date journeyDate);
	
	@GetMapping("/Reservation/getReservationById/{reservationId}")
	ReservationResponseDto getReservationById(@PathVariable Long reservationId);
	
	
}
