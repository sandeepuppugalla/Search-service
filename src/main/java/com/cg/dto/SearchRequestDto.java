package com.cg.dto;



import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequestDto {
		
	@NotNull
	private Date journeyDate;
	
	@NotNull
	private String fromCity;
	
	@NotNull
	private String toCity;
}
