package com.cg.dto;

import java.util.List;

import com.cg.entity.FlightSchedules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReponseModel {

	private List<FlightSchedules> flightSchedules;
}
