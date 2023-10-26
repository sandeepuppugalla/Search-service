package com.cg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.ReponseModel;
import com.cg.dto.SearchRequestDto;
import com.cg.dto.SearchResponseDto;
import com.cg.entity.Flight;
import com.cg.entity.FlightSchedules;
import com.cg.repository.IFlightRepository;
import com.cg.repository.IFlightScheduleRepository;
import com.cg.service.ISearchService;

@Service
public class SearchServiceImpl implements ISearchService {

	@Autowired
	private IFlightRepository repository;

	@Autowired
	private IFlightScheduleRepository scheduleRepository;

	@Override
	public List<Flight> getFlightDetails() {
		return repository.findAll();

	}

	@Override
	public List<SearchResponseDto> getScheduledFlights(SearchRequestDto request) {

		List<FlightSchedules> list = scheduleRepository.findFlights(request.getFromCity(), request.getToCity(),
				request.getJourneyDate());
		List<SearchResponseDto> res = new ArrayList<>();

		for (FlightSchedules l : list) {
			if (l.getSeatsAvailble() <= l.getTotalNumberOfSeats()) {
				res.add(SearchResponseDto.builder().flightName(l.getFlightName()).fromCity(l.getFromCity())
						.toCity(l.getToCity()).departureDate(l.getDepartureDate()).departureTime(l.getDepartureTime())
						.flightFare(l.getFlightFare()).seatsAvailble(l.getSeatsAvailble()).build());
			}
		}
		return res;

	}

	@Override
	public ReponseModel getScheduledFlightsV1(SearchRequestDto request) {

		return ReponseModel.builder().flightSchedules(scheduleRepository.findFlights(request.getFromCity(), request.getToCity(),
				request.getJourneyDate())).build();

	}

}
