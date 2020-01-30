package com.app.emandi11.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.Pojos.ConsumerRequirement;

@Repository
public interface IconsumerRequirementDao extends JpaRepository<ConsumerRequirement, Integer> 
{

	
	
	//@Query
	//List<ConsumerRequirement> findAllConsumerRequirements(Integer c_Id);
 
	//public List<ConsumerRequirement> findByConsumerId(Integer c_Id);
}