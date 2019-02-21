package com.spo.workforce.model.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WorkForceResponseTest {

	  @Test
	  public void testWorkForceResponse_HappyCase() {
		  
		 List<WorkForceTeam> workForceTeamList = new ArrayList<WorkForceTeam>();
		 workForceTeamList.add(new WorkForceTeam(10, 6));
		 workForceTeamList.add(new WorkForceTeam(5, 2));
		 WorkForceResponse workForceResponse = WorkForceResponse.builder().assignedWorkForceList(workForceTeamList).build();
	    assertNotNull(workForceResponse);
	    assertEquals(2, workForceResponse.getAssignedWorkForceList().size());
	  }
}
