/**
 * 
 */
package com.spo.workforce.service.implementation;

import org.junit.Assert;
import org.junit.Test;

import com.spo.workforce.model.request.WorkOrder;
import com.spo.workforce.model.response.WorkForceResponse;

/**
 * This class is to test the WorkForceServiceImplementation class
 *
 */
public class WorkForceServiceImplementationTest extends WorkForceServiceImplementation {

	
	WorkForceServiceImplementation WorkForceService = new WorkForceServiceImplementation();
	
	/**
	 * Checks corner cases 1 and 100 number of rooms
	 */
	@Test
	public void getOptimizedWorkForceListCornerTest() {
		int[] rooms = {1, 100};
		WorkOrder workOrder = WorkOrder.builder().rooms(rooms).senior(10).junior(6).build();
		WorkForceResponse workForceResponse = WorkForceService.getOptimizedWorkForceList(workOrder);
		Assert.assertNotNull(workForceResponse);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().size()>0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(0).getSenior() == 1 && workForceResponse.getAssignedWorkForceList().get(0).getJunior() == 0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(1).getSenior() == 10 && workForceResponse.getAssignedWorkForceList().get(1).getJunior() == 0);
	}
	
	/**
	 * Checks the random values falling in between the corner cases
	 */
	@Test
	public void getOptimizedWorkForceListRandomTest() {
		int[] rooms = {5, 10, 22, 24, 21, 49, 73};
		WorkOrder workOrder = WorkOrder.builder().rooms(rooms).senior(10).junior(6).build();
		WorkForceResponse workForceResponse = WorkForceService.getOptimizedWorkForceList(workOrder);
		Assert.assertNotNull(workForceResponse);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().size()>0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(0).getSenior() == 1 && workForceResponse.getAssignedWorkForceList().get(0).getJunior() == 0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(1).getSenior() == 1 && workForceResponse.getAssignedWorkForceList().get(1).getJunior() == 0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(2).getSenior() == 1 && workForceResponse.getAssignedWorkForceList().get(2).getJunior() == 2);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(3).getSenior() == 2 && workForceResponse.getAssignedWorkForceList().get(3).getJunior() == 1);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(4).getSenior() == 1 && workForceResponse.getAssignedWorkForceList().get(4).getJunior() == 2);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(5).getSenior() == 5 && workForceResponse.getAssignedWorkForceList().get(5).getJunior() == 0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(6).getSenior() == 5 && workForceResponse.getAssignedWorkForceList().get(6).getJunior() == 4);
	}
	
	/**
	 * Check for 0 and negative values
	 */
	@Test
	public void getOptimizedWorkForceListZeroRoomsTest() {
		int[] rooms = {0,-2};
		WorkOrder workOrder = WorkOrder.builder().rooms(rooms).senior(2).junior(1).build();
		WorkForceResponse workForceResponse = WorkForceService.getOptimizedWorkForceList(workOrder);
		Assert.assertNotNull(workForceResponse);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().size()>0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(0).getSenior() == 0 && workForceResponse.getAssignedWorkForceList().get(0).getJunior() == 0);
		Assert.assertTrue(workForceResponse.getAssignedWorkForceList().get(1).getSenior() == 0 && workForceResponse.getAssignedWorkForceList().get(1).getJunior() == 0);
	}

}
