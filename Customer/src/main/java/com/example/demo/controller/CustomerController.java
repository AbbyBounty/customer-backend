package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Feedback;
import com.example.demo.model.Mechanic;
import com.example.demo.model.Offer;
import com.example.demo.model.Order;
import com.example.demo.model.Service_Taken_Vendor;
import com.example.demo.model.Vendor;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.MechanicRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.VendorRepository;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
	private VendorRepository vendorRepository;

//	@Autowired
//	private OrderRepository orderRepository;
	
	
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	

	// -----------------------------------------------------------------------------------------
	// ---------------------------- SERVICES
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------
	@GetMapping("/shop/{id}")
	public ResponseEntity<List<Service_Taken_Vendor>> getService(@PathVariable int id) {
	
	
	
	 List<Service_Taken_Vendor> services = 	vendorRepository.getService();
	 
	

	
	
			
		return new ResponseEntity<>(services, HttpStatus.OK);
	}

	@PostMapping("/services/create/")
	public ResponseEntity<Service_Taken_Vendor> createService(@RequestBody Service_Taken_Vendor service_Taken_Vendor) {

		return new ResponseEntity<>(serviceRepository.save(service_Taken_Vendor), HttpStatus.OK);
	}

	@PutMapping("/services/{id}")
	public ResponseEntity<Service_Taken_Vendor> updateService(@PathVariable int id,
			@RequestBody Service_Taken_Vendor service_Taken_Vendor) {
		Service_Taken_Vendor service = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		service.setStv_name(service_Taken_Vendor.getStv_name());
		service.setStv_price(service_Taken_Vendor.getStv_price());

		Service_Taken_Vendor updatedService = serviceRepository.save(service);

		return new ResponseEntity<>(updatedService, HttpStatus.OK);

	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- MECHANIC
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/mechanic")
	public ResponseEntity<List<Mechanic>> getMechanic() {
		return new ResponseEntity<>(mechanicRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/mechanic/create")
	public ResponseEntity<Mechanic> addMechanic(@RequestBody Mechanic mechanic) {

		return new ResponseEntity<>(mechanicRepository.save(mechanic), HttpStatus.OK);
	}

	@PutMapping("/mechanic/{id}")
	public ResponseEntity<Mechanic> updateMechanic(@PathVariable int id, @RequestBody Mechanic mechanic) {
		Mechanic mechanic1 = mechanicRepository.findById( id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		mechanic1.setMech_first_name(mechanic.getMech_first_name());
		mechanic1.setMech_last_name(mechanic.getMech_last_name());
		mechanic1.setMech_mobile(mechanic.getMech_mobile());

		Mechanic updatedMechanic = mechanicRepository.save(mechanic1);

		return new ResponseEntity<>(updatedMechanic, HttpStatus.OK);

	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- OFFERS
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/offer")
	public ResponseEntity<List<Offer>> getOffer() {
		return new ResponseEntity<>(offerRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/offer/create")
	public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {

		return new ResponseEntity<>(offerRepository.save(offer), HttpStatus.OK);
	}

	@PutMapping("/offer/{id}")
	public ResponseEntity<Offer> updateOffer(@PathVariable int id, @RequestBody Offer offer) {
		Offer offer1 = offerRepository.findById( id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		offer1.setOfr_code(offer.getOfr_code());
		offer1.setOfr_discount(offer.getOfr_discount());
		offer1.setOfr_validity(offer.getOfr_validity());
		offer1.setOfr_name(offer.getOfr_name());

		Offer updatedOffer = offerRepository.save(offer1);

		return new ResponseEntity<>(updatedOffer, HttpStatus.OK);

	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- ORDERS
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

//	@GetMapping("/orders")
//	public ResponseEntity<List<Order>> getOrder() {
//		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
//	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- FEEDBACK
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Object> getFeedbackById(@PathVariable int id) {
		
		return new ResponseEntity<Object>(feedbackRepository.findById(id), HttpStatus.OK);
	}

	
	// -----------------------------------------------------------------------------------------
		// ---------------------------- SHOPS
		// ----------------------------------------------
		// -----------------------------------------------------------------------------------------

	@GetMapping("/shop")
	public ResponseEntity<List<String>> getshop() {
		
		List<Vendor>shops=vendorRepository.findAll();
		List<String> shopName=new ArrayList<String>();
		for (Vendor vendor : shops) {
			shopName.add(vendor.getVen_shop_name());
		}
		return new ResponseEntity<>(shopName, HttpStatus.OK);
	}
	    
}
