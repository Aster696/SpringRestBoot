package com.company.SpringRestBoot2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.SpringRestBoot2.dao.CustomerDAO;
import com.company.SpringRestBoot2.model.CustomerModel;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
// 	Normal url
//	@GetMapping("/")
//	public String HelloSpringBoot() {
//		System.out.println("Hello Spring Boot");
//		return "Hello Spring Boot";
//	}
	
	@GetMapping("/")
	public ResponseEntity<String> HelloSpringBoot(){
		return new ResponseEntity<String>("HelloSpringBoot", HttpStatus.OK);
	}
	
//	adding data
//	@RequestMapping("/addCust")
//	public String AddCustomer() {
//		CustomerModel customers = new CustomerModel(101, "Chotu", "mail@gamil.com", "Andheri");
//		CustomerModel cust = customerDAO.save(customers);
//		
//		if(cust!=null) {
//			System.out.println(cust);
//			return "record Added........ "+cust;
//		}else
//			return "Failed.....";
//	}
	
//	adding data using ResponseEntity
//	@PostMapping("/addCust")
//	public ResponseEntity<String> AddCustomer() {
//		CustomerModel customers = new CustomerModel(101, "Chintu", "mail@gamil.com", "Andheri");
//		CustomerModel cust = customerDAO.save(customers);
//		
//		if(cust!=null) {
//			System.out.println("record Added........ \n"+cust);
//			return new ResponseEntity<String>("record Added........ \n"+cust, HttpStatus.CREATED);
//		}else
//			return new ResponseEntity<String>("Failed..... ", HttpStatus.CONFLICT);
//	}
	
//	adding data using ResponseEntity in Postman
	@PostMapping("/addCust")
	public ResponseEntity<HttpStatus> AddCustomer(@RequestBody CustomerModel customer) {
		CustomerModel cm = customerDAO.save(customer);
		
		if(cm!=null) {
			System.out.println("record Added........ \n"+cm);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
//	@GetMapping("/displayCust")
//	public List<CustomerModel> displayCostomers(){
//		
//		List<CustomerModel> custList = (List<CustomerModel>)customerDAO.findAll();
//		
//		if(custList!=null) {
//			System.out.println(custList);
//			return custList;
//		}else {
//			System.out.println("List Empty");
//			return null;
//		}
//	}
	
	@GetMapping("/displayCust")
	public ResponseEntity<List<CustomerModel>> displayCostomers(){
		
		List<CustomerModel> custList = (List<CustomerModel>)customerDAO.findAll();
		
		if(custList!=null) {
			System.out.println(custList);
			return new ResponseEntity<List<CustomerModel>>(custList, HttpStatus.OK);
		}else {
			System.out.println("List Empty");
			return new ResponseEntity<List<CustomerModel>>(HttpStatus.NO_CONTENT);
		}
	}
	
//	@GetMapping("/displayCustId/{id}")
//	public String displayCustomerById(@PathVariable("id") int id){
//		
//		Optional<CustomerModel> custid = (Optional<CustomerModel>)customerDAO.findById(id);
//		
//		if(custid.isPresent()) {
//			System.out.println(custid);
//			return custid.toString();
//		}else
//			return "ID don't exist";	
//	}
	
	@GetMapping("/displayCustId/{custId}")
	public ResponseEntity<Optional<CustomerModel>> displayCustomerById(@PathVariable("custId") int custId){
		
		Optional<CustomerModel> custid = (Optional<CustomerModel>)customerDAO.findById(custId);
		
		if(custid.isPresent()) {
			System.out.println("Found \n"+custid);
			return new ResponseEntity<Optional<CustomerModel>>(custid, HttpStatus.OK);
		}else
			return new ResponseEntity<Optional<CustomerModel>>(HttpStatus.NOT_FOUND);	
	}
	
	@PutMapping("/updateCust")
	public ResponseEntity<HttpStatus> updateCustomer(@RequestBody CustomerModel customer){
		CustomerModel cust = customerDAO.save(customer);
		if(cust != null) {
			System.out.println("Updated Customer....\n"+cust);
			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		}else {
			System.out.println("Error occur while updating.... \n"+cust);
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteCust/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id){
		Optional<CustomerModel> cust = (Optional<CustomerModel>)customerDAO.findById(id);
		if(cust.isPresent()) {
			customerDAO.deleteById(id);
			System.out.println("Customer Deleted ....\n"+cust);
			return new ResponseEntity<HttpStatus>(HttpStatus.GONE);
		}else {
			System.out.println("Falied to Delete ....\n"+cust);
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
	}
	
}
