package com.app.emandi11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.emandi11.Pojos.FarmerPojo;
import com.app.emandi11.service.FarmerService;
@RestController
public class FarmerController {
	@Autowired
	FarmerService fservice;
	
	@RequestMapping(value = "/authenticateFarmer", method = RequestMethod.POST)
	public ResponseEntity<FarmerPojo> m1(@RequestBody FarmerPojo farmer)
	{
		System.out.println(farmer);
		FarmerPojo temp = fservice.authenticateFarmer(farmer);
		System.out.println(farmer);
		if(temp!=null)
		{
			return new ResponseEntity<FarmerPojo>(temp,HttpStatus.OK);

		}
		return new ResponseEntity<FarmerPojo>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerFarmer", method = RequestMethod.POST)
	public ResponseEntity<?> m2(@RequestBody FarmerPojo farmer)
	{
		fservice.registerFarmer(farmer);

		return new ResponseEntity<String>("Farmer created successfully",HttpStatus.OK);
		
	}

}
