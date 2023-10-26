package com.cg.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDto {


	private Long scheduleId;

	private String flightName;

	private String fromCity;

	private String toCity;

	private Date departureDate;

	private Timestamp departureTime;

	private Long flightFare;

	private Long totalNumberOfSeats;

	private Long seatsAvailble;
}
