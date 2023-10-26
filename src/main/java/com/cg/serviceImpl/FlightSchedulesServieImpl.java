package com.cg.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.ReponseModel;
import com.cg.dto.SearchResponseDto;
import com.cg.feignClient.BookingFeignclient;
import com.cg.service.IFlightSchedulesService;

@Service
public class FlightSchedulesServieImpl implements IFlightSchedulesService {

	@Autowired
	private BookingFeignclient bookingFeignclient;

	@Override
	public List<SearchResponseDto> getScheduledFlights( String fromCity, String toCity, Date journeyDate) {

		return bookingFeignclient.getScheduledFlights(fromCity,toCity,journeyDate);
	}

	@Override
	public ReponseModel getScheduledFlightsV1(String fromCity, String toCity, Date journeyDate) {

		return bookingFeignclient.getScheduledFlightsv1(fromCity,toCity,journeyDate);
	}

}
