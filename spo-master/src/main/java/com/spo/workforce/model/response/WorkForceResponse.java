package com.spo.workforce.model.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * WorkForce response containing list of WorkForce teams
 *
 */
@Getter
@Builder
public class WorkForceResponse {
	List<WorkForceTeam> assignedWorkForceList;
}
