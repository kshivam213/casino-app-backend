package com.roulette.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AppResponse {
	
	private boolean success;
	
	private String description;

	private List<Object> result;

	private List<AppErrorResponse> errors;
	
}