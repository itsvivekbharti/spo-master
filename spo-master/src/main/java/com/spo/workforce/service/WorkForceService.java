package com.spo.workforce.service;

import org.springframework.stereotype.Service;

import com.spo.workforce.model.request.WorkOrder;
import com.spo.workforce.model.response.WorkForceResponse;

/**
 * Service class for the Work Force related process
 *
 */
@Service
public interface WorkForceService {

	/**
	 * Returns the optimized work force list based on the work order Logic is to
	 * find the nearest number divisible greater than the number of rooms and
	 * capturing the dividends
	 * 
	 * @param workOrder
	 * @return
	 */
	public WorkForceResponse getOptimizedWorkForceList(WorkOrder workOrder);

}
