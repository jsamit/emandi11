package com.app.emandi11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.Pojos.ConsumerRequirement;
import com.app.emandi11.Pojos.FarmerPojo;
import com.app.emandi11.Pojos.FarmerProduct;
import com.app.emandi11.dao.IfarmerProductDao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class FarmerProductService 
{
	@PersistenceContext
	private EntityManager mgr;

	@Autowired
    private IfarmerProductDao fpdao ;
   

	/*
	 * public List<FarmerProduct> getAllProduct() { List <FarmerProduct> fproduct =
	 * new ArrayList<>(); fpdao.findAll() .forEach(fproduct::add); return fproduct;
	 * }
	 */
    
    public List<FarmerProduct> getFarmerProducts( Integer f_Id)
    {
    	
    	String jpql = "select u from FarmerProduct u where u.farmer.f_Id=:fid";
    	
    
    	return mgr.unwrap(org.hibernate.Session.class).createQuery(jpql,FarmerProduct.class).setParameter("fid", f_Id).getResultList();
    	
    	
    	
    }
    
    public void addFarmerProduct(FarmerProduct fproduct)
    {
    	fpdao.save(fproduct);
    	
    }
    
    public void updateFarmerProduct(Integer f_Id,FarmerProduct fproduct)
    {
    	//fpdao.save(fproduct);
    	mgr.unwrap(org.hibernate.Session.class).update(fproduct);
    }
    public void deleteFarmerProduct(Integer f_Id)
    {
		//crdao.deleteById(c_requirement_id); 
    	
    		//mgr.unwrap(org.hibernate.Session.class).delete(crequirement);
    	Optional<FarmerProduct> optional=fpdao.findById(f_Id);
    	FarmerPojo temp=optional.get().getFarmer();
    	temp.deleteFarmerProduct(optional.get());
    	fpdao.deleteById(f_Id);
    		
    	}
    
	/*
	 * public void deleteFarmerProduct(Integer f_id) { fpdao.deleteById(f_id);
	 * 
	 * }
	 */
    
} 
    









