package com.spo.workforce.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Builder;
import lombok.Getter;

/**
 * Work Order request object containing array of rooms in different sites and the work
 * capacity of senior and junior team members
 *
 */
@Getter
@Builder
public class WorkOrder {
	@NotNull
	private int[] rooms;
	@NotNull
	@Positive
	private int senior;
	@NotNull
	@Positive
	private int junior;
}
