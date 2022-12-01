package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadData;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.utility.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService; 
	/* Above, We have used autowired anotation to create the object 
	 * using spring boot if i did not use component anotation in EmailServiceImpl
	 * then we can not import autowired anotation here.. so after that we will
	 * have to create object like EmailServiceImpl emp = new EmailServiceImpl();
	 * so in this case we does not have use of spring boot
	 * spring boot secure and manage all file in proper way 
	 */
	
	@RequestMapping("/viewLeadPage")
	public String viewSaveLeadPage() {
		return "new_lead";
	}
	
/* There are three way to read the data */
	
		//1st Way
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") long mobile) {
//		Lead l = new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		return "new_lead";
//	}
		
	//2nd Way
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		emailService.sendSimpleMessage("rishmishra681@gmail.com", "Test", "Lead is saved!!");
		/* emailService.sendSimpleMessage("rishmishra681@gmail.com", "Test", "L"); 
		 * if you want to send email present in the form data --
		 * then use => lead.getEmail() at the place of "rishmishra681@gmail.com"
		 * */
		model.addAttribute("msg", "Lead is saved!");
		return "new_lead";
	}
	
	@RequestMapping("/listall")
	public String listAll(ModelMap model){
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
	//We have done this feature using RequestDispatcher but here we are doing in another manner using ModelMap from below codes..
	@RequestMapping("/delete")
	public String deleteOneLocation(@RequestParam("id") long id, ModelMap model) {
	leadService.deleteLead(id);
	List<Lead> leads = leadService.getLeads();
	model.addAttribute("leads", leads);
	return "lead_search_result";
	
	}
	
	@RequestMapping("/update")
	public String updateOneLocation(@RequestParam("id") long id, ModelMap model) {
	Lead lead = leadService.findOneLead(id);
	model.addAttribute("lead", lead);
	return "update_lead";
	}
	
	@RequestMapping("/updateLead")
//	public String updateLead(@ModelAttribute Lead lead, ModelMap model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Lead is Updated!");
	
/*    This above ModelAttribute method is creating new record
 *  instead of update the record so we are going to use DTO object */
		
	public String updateLead(LeadData lead, ModelMap model) {
		Lead l = new Lead();
		l.setId(lead.getId());
		l.setFirstName(lead.getFirstName());
		l.setLastName(lead.getLastName());
		l.setEmail(lead.getEmail());
		l.setMobile(lead.getMobile());
		
		leadService.saveLead(l);
		model.addAttribute("msg", "Lead is updated!!");
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
//	@RequestMapping("/listAlll")
//	public String listAl(ModelMap model) {
//		List<Lead> l = leadService.getLead();
//		model.addAttribute("leads", l);
//		return "search";
//	}
	
	//3rd Way
	// DataTransfar Object

//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData leadData) {// DTO
//		Lead l = new Lead();
//		l.setFirstName(leadData.getFirstName());
//		l.setLastName(leadData.getLastName());
//		l.setEmail(leadData.getEmail());
//		l.setMobile(leadData.getMobile());
//		leadService.saveLead(l);
//		return "new_lead";
//	}
	
	
}
