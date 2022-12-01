package com.marketingapp.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;

@RestController
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	// Whole CRUD operation is happening below..
	
	@GetMapping("listallleads")
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
/* Above code of method will give java object and it will get converted into JSON
object because we are using @GetMapping() annotation */ 

	
	
/* To save the record below we are creating one more method	*/

	@PostMapping("/saveApi")
	public void saveLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
/* @RequestBody annotation picks the JSON object content and paste into the lead
 * object 
 */
	
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable Long id) {
		leadRepo.deleteById(id);
	}
/* Instead of @ RequestParam, @PathVariable annotation uses in services layer
 *  to read the data from the url 
 */
	
	@PutMapping("/updateApi")
	public void updateLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	@GetMapping("/getApi/{id}")
	public Lead findOneLead(@PathVariable Long id) {
		try {
			Optional<Lead> lead = leadRepo.findById(id);
			Lead lead2 = lead.get();
			return lead2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
	