package com.spo.workforce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spo.workforce.model.request.WorkOrder;
import com.spo.workforce.model.response.WorkForceResponse;
import com.spo.workforce.service.WorkForceService;

/**
 * Controller class for Work force manipulation
 *
 */
@RestController
public class WorkForceController {

	@Autowired
	WorkForceService WorkForceService;

	/**
	 * Rest end point to get the optimized workforce calculated based on work order
	 * 
	 * @param workOrder
	 * @return
	 */
	@RequestMapping(value = "/workforce", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<WorkForceResponse> getWorkForce(@Valid @RequestBody final WorkOrder workOrder) {
		WorkForceResponse workForceResponse = WorkForceService.getOptimizedWorkForceList(workOrder);
		return new ResponseEntity<>(workForceResponse, HttpStatus.FOUND);
	}
}
