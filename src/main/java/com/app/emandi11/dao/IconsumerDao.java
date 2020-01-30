package com.app.emandi11.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.emandi11.Pojos.ConsumerPojo;


	
	@Repository
	public interface IconsumerDao extends JpaRepository<ConsumerPojo, Integer>
	{
		
	}



