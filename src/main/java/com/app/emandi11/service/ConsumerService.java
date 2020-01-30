package com.app.emandi11.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.dao.IconsumerDao;

@Service
public class ConsumerService 
{
	@Autowired
	IconsumerDao cdao;
	
	
	public ConsumerPojo authenticateConsumer(ConsumerPojo consumer)
	{
		
		ConsumerPojo temp = new ConsumerPojo();
		temp.setC_email(consumer.getC_email());
		temp.setC_password(consumer.getC_password());
	
		Example<ConsumerPojo> exampleConsumerPojo = Example.of(temp);
		
		Optional<ConsumerPojo> optional = cdao.findOne(exampleConsumerPojo);
		//select * from ConsumerPojo c where c.C_email='' and c.C_password=''
	 	
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	
	public boolean registerConsumer(ConsumerPojo consumer)
	{
		cdao.save(consumer);
		return false;
	}

}
