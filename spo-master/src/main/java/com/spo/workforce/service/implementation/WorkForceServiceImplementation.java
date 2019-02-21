package com.spo.workforce.service.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spo.workforce.model.request.WorkOrder;
import com.spo.workforce.model.response.WorkForceTeam;
import com.spo.workforce.model.response.WorkForceResponse;
import com.spo.workforce.service.WorkForceService;

/**
 * Service class for the Work Force related business logic
 *
 */
@Service
public class WorkForceServiceImplementation implements WorkForceService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spo.workforce.service.WorkForceService#getOptimizedWorkForceList(com.spo.
	 * workforce.model.request.WorkOrder)
	 */
	public WorkForceResponse getOptimizedWorkForceList(WorkOrder workOrder) {
		int[] capacityArray = { workOrder.getJunior(), workOrder.getSenior() };
		int[] counts = new int[capacityArray.length];
		List<WorkForceTeam> workforceList = new ArrayList<>();
		Arrays.stream(workOrder.getRooms()).forEach(rooms -> {
			WorkForceTeam assignedWorkforce = new WorkForceTeam(0, 0);
			if (rooms > 0) {
				rooms -= workOrder.getSenior();
				if (rooms > 0) {
					while (true) {
						getBestWorkForceCombination(capacityArray, counts, 0, rooms, assignedWorkforce);
						if (!(assignedWorkforce.getJunior() == 0 && assignedWorkforce.getSenior() == 0)) {
							assignedWorkforce.setSenior(assignedWorkforce.getSenior() + 1);
							workforceList.add(assignedWorkforce);
							break;
						}
						rooms++;
					}
				} else {
					assignedWorkforce.setSenior(assignedWorkforce.getSenior() + 1);
					workforceList.add(assignedWorkforce);
				}
			} else {
				workforceList.add(assignedWorkforce);
			}
		});
		return WorkForceResponse.builder().assignedWorkForceList(workforceList).build();
	}

	/**
	 * This method finds out the best combination of work force required for a given
	 * number of rooms
	 * 
	 * @param capacityArray - capacityArray are the sorted capacity in descending
	 *                      order, larger positioned more front
	 * @param counts        - counts record the number of coins at certain location
	 * @param startIndex    - start index is keep tracking of from which coin we
	 *                      start processing after choosing the larger capacity
	 * @param totalRooms    - total rooms keep track of remaining rooms left for
	 *                      processing
	 */
	private void getBestWorkForceCombination(int[] capacityArray, int[] counts, int startIndex, int totalRooms,
			WorkForceTeam assignedWorkforce) {
		if (startIndex >= capacityArray.length) {
			if (assignedWorkforce == null || (assignedWorkforce.getJunior() == 0 && assignedWorkforce.getSenior() == 0)
					|| (counts[0] + counts[1] < assignedWorkforce.getJunior() + assignedWorkforce.getSenior())) {
				assignedWorkforce.setJunior(counts[0]);
				assignedWorkforce.setSenior(counts[1]);
			}
			return;
		}
		if (startIndex == capacityArray.length - 1) {
			if (totalRooms % capacityArray[startIndex] == 0) {
				counts[startIndex] = totalRooms / capacityArray[startIndex];
				getBestWorkForceCombination(capacityArray, counts, startIndex + 1, 0, assignedWorkforce);
			}
		} else {
			for (int i = 0; i <= totalRooms / capacityArray[startIndex]; i++) {
				counts[startIndex] = i;
				getBestWorkForceCombination(capacityArray, counts, startIndex + 1,
						totalRooms - capacityArray[startIndex] * i, assignedWorkforce);
			}
		}
	}
}
