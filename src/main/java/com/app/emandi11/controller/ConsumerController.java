package com.app.emandi11.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.Pojos.FarmerPojo;
import com.app.emandi11.Pojos.FarmerProduct;
import com.app.emandi11.service.ConsumerService;
import com.app.emandi11.service.ConsumerToFormerService;
@RestController
public class ConsumerController {
	@Autowired
	ConsumerService cservice;
	
	@Autowired
	private ConsumerToFormerService consumerToFormerService;
	
	@RequestMapping("/getFarmerWithProducts/{consumerId}")
	public Map<FarmerPojo,List<FarmerProduct>> farmerProducts(@PathVariable int consumerId) {
		return consumerToFormerService.getFarmerWithProductsByConsumer(consumerId);
	}
	
	
	@RequestMapping(value = "/authenticateConsumer", method = RequestMethod.POST)
	public ResponseEntity<?> m1(@RequestBody ConsumerPojo consumer)
	{
		
		
		ConsumerPojo temp = cservice.authenticateConsumer(consumer);
		System.out.println(consumer);
		if(temp!=null)
		{
			
			return new ResponseEntity<ConsumerPojo>(temp,HttpStatus.OK);

		}
		return new ResponseEntity<String>("Consumer not Authenticated",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerConsumer", method = RequestMethod.POST)
	public ResponseEntity<?> m2(@RequestBody ConsumerPojo consumer)
	{
		cservice.registerConsumer(consumer);

		return new ResponseEntity<String>("Consumer created successfully",HttpStatus.OK);
		
	}

	
}
