package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.dto.ReponseModel;
import com.cg.dto.SearchResponseDto;

public interface IFlightSchedulesService {

	List<SearchResponseDto> getScheduledFlights(String fromCity, String toCity, Date journeyDate);
	ReponseModel getScheduledFlightsV1(String fromCity, String toCity, Date journeyDate);
}
