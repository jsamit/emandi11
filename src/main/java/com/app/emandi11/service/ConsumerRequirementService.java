package com.app.emandi11.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.emandi11.Pojos.ConsumerPojo;
import com.app.emandi11.Pojos.ConsumerRequirement;
import com.app.emandi11.dao.IconsumerDao;
import com.app.emandi11.dao.IconsumerRequirementDao;

@Service
@Transactional
public class ConsumerRequirementService 
{
	@Autowired
    private IconsumerRequirementDao crdao ;

	@PersistenceContext
	private EntityManager mgr;
	
	/*
	 * public List<ConsumerRequirement> getAllConsumerRequirements(Integer c_Id) {
	 * List<ConsumerRequirement> crequirement = new ArrayList<>(); crdao.findAll()
	 * .forEach(crequirement::add);
	 * 
	 * List<ConsumerRequirement> crequirementById = new ArrayList<>();
	 * 
	 * for(ConsumerRequirement temp:crequirement) { if(temp.getConsumer().getC_Id()
	 * == c_Id) { crequirementById.add(temp); } } return crequirementById;
	 * 
	 * 
	 * }
	 */
	/*
	 * public List<ConsumerRequirement> getAllConsumerRequirementById(Integer c_Id)
	 * { return crequirements.stream().filter(t ->
	 * t.getC_Id().equals(c_Id)).findAll().get(); }
	 * 
	 */
   

	
	/*
	 * public List<ConsumerRequirement> getAllConsumerRequirement() {
	 * List<ConsumerRequirement> crequirement = new ArrayList<>(); crdao.findAll()
	 * .forEach(crequirement::add); return crequirement; }
	 * 
	 */
	/*
	 * public List<ConsumerRequirement> getAllConsumerRequirements(Integer c_Id) {
	 * ConsumerPojo temp=new ConsumerPojo(); temp.setC_Id(c_Id);
	 * Example<ConsumerPojo> exampleconsumer=Example.of(temp);
	 * Optional<ConsumerPojo> optional=cdao.findOne(exampleconsumer); return
	 * crdao.findAllConsumerRequirements(optional.get());
	 * 
	 * 
	 * 
	 * }
	 */
	/*
	 * public List<ConsumerRequirement> getAllConsumerRequirement() {
	 * 
	 * String jpql = "select c from ConsumerRequirement c"; return
	 * mgr.unwrap(org.hibernate.Session.class).createQuery(jpql,
	 * ConsumerRequirement.class).getResultList(); }
	 */
	
    public List<ConsumerRequirement> getConsumerRequirement( Integer c_Id)
    {
    	
    	String jpql = "select u from ConsumerRequirement u where u.consumer.c_Id=:cid";
    	
    
    	return mgr.unwrap(org.hibernate.Session.class).createQuery(jpql,ConsumerRequirement.class).setParameter("cid", c_Id).getResultList();
    	
    	
    	
    }
   
    public void addConsumerRequirement(ConsumerRequirement crequirement)
    {
    	crdao.save(crequirement);
    	
    }
    
	
	/*
	 * public void updateConsumerRequirement(Integer
	 * c_requirement_id,ConsumerRequirement crequirement) {
	 * 
	 * ConsumerRequirement crequirement
	 * 
	 * crdao.save(crequirement);
	 * 
	 * }
	 */
    
	/*
	 * public void updateConsumerRequirement(ConsumerRequirement crequirement) {
	 * ConsumerRequirement cr=new ConsumerRequirement();
	 * cr.setC_pcategory(crequirement.getC_pcategory());
	 * cr.setC_pname(crequirement.getC_pname());
	 * cr.setC_pquality(crequirement.getC_pquality());
	 * cr.setC_pquantity(crequirement.getC_pquantity());
	 * cr.setC_expected_date(crequirement.getC_expected_date());
	 * Example<ConsumerRequirement> exampleconsumer=Example.of(cr);
	 * Optional<ConsumerRequirement> optional= crdao.findOne(exampleconsumer);
	 * if(optional.isPresent()) { updateConsumerRequirement(crequirement); } }
	 */
    public void updateConsumerRequirement(Integer c_requirement_id,ConsumerRequirement crequirement)
    {
		//mgr.unwrap(Service.class).update(crequirement);
		mgr.unwrap(org.hibernate.Session.class).update(crequirement);
	}
	 
    
    public void deleteConsumerRequirement(Integer c_requirement_id)
    {
		//crdao.deleteById(c_requirement_id); 
    	
    		//mgr.unwrap(org.hibernate.Session.class).delete(crequirement);
    	Optional<ConsumerRequirement> optional=crdao.findById(c_requirement_id);
    	ConsumerPojo temp=optional.get().getConsumer();
    	temp.deleteconsumerrequirement(optional.get());
    	crdao.deleteById(c_requirement_id);
    		
    	}
    }


