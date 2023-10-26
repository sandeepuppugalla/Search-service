package com.cg.dto;

import java.util.List;

import com.cg.entity.Passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponseDto {

	private List<Passenger> passengers;
}
