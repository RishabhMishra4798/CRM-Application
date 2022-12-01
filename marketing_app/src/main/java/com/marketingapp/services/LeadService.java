package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	public List<Lead> getLeads();
//	public List<Lead> getLead();
	public void deleteLead(long id);
	public Lead findOneLead(long id);
}
