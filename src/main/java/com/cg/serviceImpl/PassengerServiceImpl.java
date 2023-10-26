package com.cg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.dto.PassengerRequestDto;
import com.cg.dto.PassengerResponseDto;
import com.cg.entity.Passenger;
import com.cg.feignClient.BookingFeignclient;
import com.cg.repository.IPassengerRepository;
import com.cg.service.IPassengerService;

@Service
public class PassengerServiceImpl implements IPassengerService {

	@Autowired
	private IPassengerRepository repository;
	
	@Autowired
	private BookingFeignclient bookingFeignclient;
	
	@Autowired
	RestTemplate template;

	@Override
	public Passenger savePassenger(PassengerRequestDto request) {
		Passenger passenger = Passenger.builder().firstName(request.getFirstName()).lastName(request.getLastName())
				.phoneNo(request.getPhoneNo()).email(request.getEmail()).build();

		return repository.save(passenger);

	}

//	@Override
//	public Passenger getPassengerById(Long id) {
//
//		return repository.findById(id)
//				.orElseThrow(() -> new NoSuchElementException("record does not exist for userId: " + id.toString()));
//	}
	
	@Override
	public PassengerResponseDto getPassengerById(Long id) {
		
		return bookingFeignclient.getPassengerById(id);
		
//		return template.getForObject("http://localhost:8002/Passenger/getPassenger/{userId}",Passenger.class , id);
	}

	@Override
	public PassengerResponseDto getAllPassengers() {
		return bookingFeignclient.getAllPassengers();
//		return template.getForObject("http://localhost:8002/Passenger/getAllPassengers",PassengerResponseDto.class);
	}

}
