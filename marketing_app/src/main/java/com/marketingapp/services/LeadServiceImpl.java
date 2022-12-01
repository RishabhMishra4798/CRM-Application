package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	// Here we will do database Implementation
	
	@Autowired
	private LeadRepository leadRepo;
	
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}


	@Override
	public List<Lead> getLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}


//	@Override
//	public List<Lead> getLead() {
//		List<Lead> lead = leadRepo.findAll();
//		return lead;
//	}


	@Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);
	}

//  Here we create Lead Method because We are returning Lead object after finding that
	@Override
	public Lead findOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}


}
