package com.app.emandi11.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.Pojos.ConsumerRequirement;
import com.app.emandi11.service.ConsumerRequirementService;

@RestController
public class ConsumerRequirementController {

	@Autowired
	private ConsumerRequirementService crservice;

	
	
	/*
	 * @RequestMapping("/ConsumerRequirement	") public List<ConsumerRequirement>
	 * getAllRequirement() { return crservice.getAllConsumerRequirement(); }
	 */
	 

	
	  @RequestMapping("consumer/{c_Id}") 
	  public List<ConsumerRequirement> getConsumerRequirement(@PathVariable Integer c_Id)
	   {
	  
	  return crservice.getConsumerRequirement(c_Id);
	  
	  }
	 
	    @RequestMapping(method = RequestMethod.POST, value="/consumer/{c_Id}/consumerrequirement")
	    public void addConsumerRequirement(@RequestBody ConsumerRequirement crequirement,@PathVariable Integer c_Id)
	    {
	    	crequirement.setConsumer(new ConsumerPojo(c_Id));
	    	crservice.addConsumerRequirement(crequirement);
	    	
	    	
	    }
	
	  @RequestMapping(method = RequestMethod.PUT ,value="/consumerrequirement/{c_requirement_id}")
	  public void updateConsumerRequirement(@RequestBody ConsumerRequirement crequirement,@PathVariable Integer c_requirement_id ) {
	  //crequirement.setConsumer(new ConsumerPojo(c_Id));
	  crservice.updateConsumerRequirement(c_requirement_id, crequirement);
	  }
	  
	  
	  @RequestMapping(method = RequestMethod.DELETE ,value="/delete/{c_requirement_id}") 
	  public void deleteConsumerRequirement(@RequestBody ConsumerRequirement crequirement,@PathVariable Integer c_requirement_id) 
	  {
	  crservice.deleteConsumerRequirement(c_requirement_id);
	  
	  }
	 
	    
	

}
