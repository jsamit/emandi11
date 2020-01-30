package com.app.emandi11.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.app.emandi11.Pojos.FarmerPojo;
import com.app.emandi11.dao.IfarmerDao;
@Service
public class FarmerService
{
	@Autowired
	IfarmerDao fdao;
	
	public FarmerPojo authenticateFarmer(FarmerPojo farmer) {
		FarmerPojo temp = new FarmerPojo();
		temp.setF_email(farmer.getF_email());
		temp.setF_password(farmer.getF_password());
	
		Example<FarmerPojo> exampleFarmerPojo = Example.of(temp);
		
		Optional<FarmerPojo> optional = fdao.findOne(exampleFarmerPojo);
		//select * from ConsumerPojo c where c.C_email='' and c.C_password=''
		
		if(optional.isPresent())
		{
			return optional.get();
		}		
		return null;
	}
	
      public boolean registerFarmer(FarmerPojo farmer) {
		
		
		fdao.save(farmer);
		return false;
	}


}
