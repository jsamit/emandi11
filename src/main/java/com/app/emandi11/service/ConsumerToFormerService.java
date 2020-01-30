package com.app.emandi11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.Pojos.ConsumerRequirement;
import com.app.emandi11.Pojos.FarmerPojo;
import com.app.emandi11.Pojos.FarmerProduct;
import com.app.emandi11.repository.ConsumerRespository;
import com.app.emandi11.repository.ProductsRepository;

@Service
@Transactional
public class ConsumerToFormerService {

	@Autowired
	private ConsumerRespository consumerRespository; 
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	public Map<FarmerPojo,List<FarmerProduct>> getFarmerWithProductsByConsumer(Integer consumerId) {
		Optional<ConsumerPojo> consumerOptional = consumerRespository.findById(consumerId);
		
		ConsumerPojo consumer;
		Map<FarmerPojo,List<FarmerProduct>> map = new HashMap<>();
		
		if(consumerOptional.isPresent()) {
			consumer = consumerOptional.get();
			

			for(ConsumerRequirement requirement : consumer.getRequirements()) {
				List<FarmerProduct> products = productsRepository
						.findbyNameAndQuality(requirement.getC_pname(),requirement.getC_pquality());
				
				for(FarmerProduct product:products) {
					if(!map.containsKey(product.getFarmer()))
						map.put(product.getFarmer(), product.getFarmer().getProducts());
				}
			}
		}
		return map;
	}
	
}
