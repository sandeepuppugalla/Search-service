package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.dto.ReponseModel;
import com.cg.dto.SearchRequestDto;
import com.cg.dto.SearchResponseDto;
import com.cg.entity.Flight;

@Service
public interface ISearchService {
	List<Flight> getFlightDetails();
	List<SearchResponseDto> getScheduledFlights(SearchRequestDto request);
	ReponseModel getScheduledFlightsV1(SearchRequestDto request);
}
