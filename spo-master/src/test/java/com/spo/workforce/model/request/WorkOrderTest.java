package com.spo.workforce.model.request;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorkOrderTest {

	  @Test
	  public void testWorkOrder_HappyCase() {
		  int[] rooms = {5, 10, 22, 24, 21, 49, 73};
			WorkOrder workOrder = WorkOrder.builder().rooms(rooms).senior(10).junior(6).build();

	    assertEquals(10,workOrder.getSenior());
	    assertEquals(6,workOrder.getJunior());
	    assertEquals(rooms.length,workOrder.getRooms().length);
	  }
}
