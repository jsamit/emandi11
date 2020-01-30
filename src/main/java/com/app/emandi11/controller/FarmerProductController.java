package com.app.emandi11.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.emandi11.Pojos.FarmerPojo;
import com.app.emandi11.Pojos.FarmerProduct;
import com.app.emandi11.service.FarmerProductService;
import java.util.*;

@RestController
public class FarmerProductController 
{
	@Autowired
	private FarmerProductService fpservice;
	
	/*
	 * @RequestMapping("/farmer/{f_Id}/farmerproduct") public List<FarmerProduct>
	 * getAllFarmerProduct() { return fpservice.getAllProduct();
	 */
		
	
      @RequestMapping("/farmer/{f_Id}")	
	 public List<FarmerProduct> getFarmerProduct(@PathVariable Integer f_Id)
	    {
	    	return fpservice.getFarmerProducts(f_Id);
	    	
	    }
	    @RequestMapping(method = RequestMethod.POST, value="/farmer/{f_Id}/farmerproduct")
	    public void addFarmerProduct(@RequestBody FarmerProduct fproduct,@PathVariable Integer f_Id)
	    {
	    	fproduct.setFarmer(new FarmerPojo(f_Id));
	    	fpservice.addFarmerProduct(fproduct);
	    	
	    	
	    }
	    @RequestMapping(method = RequestMethod.PUT , value="/farmerproduct/{f_Id}")
	    public void updateFarmerProduct(@RequestBody FarmerProduct fproduct,@PathVariable Integer f_Id )
	    {
	    	//fproduct.setFarmer(new FarmerPojo(f_Id));
	    	fpservice.updateFarmerProduct(f_Id, fproduct);
	    }
	    
	    @RequestMapping(method = RequestMethod.DELETE , value="/delete/{f_Id}")
	    public void deleteFarmerProduct(@RequestBody FarmerProduct fproduct,@PathVariable Integer f_Id)
	    {
	    	fpservice.deleteFarmerProduct(f_Id);
	    	
	    }
	    
	
	
	
	
	
	

}
