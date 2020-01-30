package com.app.emandi11.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.emandi11.Pojos.FarmerProduct;

public interface ProductsRepository extends JpaRepository<FarmerProduct, Integer>{
	
	
	@Query("select p from FarmerProduct p where p.prodName = :name and p.pQuality = :quality")
	public List<FarmerProduct> findbyNameAndQuality(String name,String quality);
}
