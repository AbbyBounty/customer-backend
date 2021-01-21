package com.example.demo.controller;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
=======
import java.util.List;
import java.util.Optional;

>>>>>>> tuka
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> tuka
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
<<<<<<< HEAD
=======
import com.example.demo.model.User;
import com.example.demo.model.Vehicle;
>>>>>>> tuka
import com.example.demo.model.Vendor;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.MechanicRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ServiceRepository;
<<<<<<< HEAD
import com.example.demo.repository.VendorRepository;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
=======
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.VendorRepository;

@CrossOrigin(origins ="http://localhost:4200/*")
@RestController
@RequestMapping("/user")
public class customerController {
>>>>>>> tuka

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private OfferRepository offerRepository;
<<<<<<< HEAD
	
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

=======

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
		// -----------------------------------------------------------------------------------------
		// ---------------------------- Auth
		// ----------------------------------------------
		// -----------------------------------------------------------------------------------------
	
	
	@PostMapping("/auth")
	public ResponseEntity<User> authenticate(@RequestBody User user) {
		List<User> result = userRepository.findByU_emailAndU_password(user.getU_email(), user.getU_password());
		return new ResponseEntity<>(result.isEmpty()? null: result.get(0), HttpStatus.OK);
	}
	
	 
	 

	// -----------------------------------------------------------------------------------------
	// ---------------------------- Vehicle
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	 
	@PostMapping("/vehicle/create")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<>(vehicleRepository.save(vehicle), HttpStatus.OK);
	}
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Object> getVehicle(@PathVariable int id) {
		return new ResponseEntity<Object>(vehicleRepository.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/vehiclesByUserid/{id}")
	public ResponseEntity<Object> getVehicleByUserId(@PathVariable int id) {
		List<Vehicle> vehicles=vehicleRepository.findVehicleByuserId(id);
		return new ResponseEntity<>(vehicles.isEmpty()? null: vehicles, HttpStatus.OK);
	}
	
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/vehicle")
	public ResponseEntity<Vehicle> updateVehicle( @RequestBody Vehicle vehicle) {
		Vehicle vehicle1 = vehicleRepository.findById(vehicle.getV_id())
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + vehicle.getV_id()));
		vehicle1.setV_id(vehicle.getV_id());
		vehicle1.setV_company_name(vehicle.getV_company_name());
		vehicle1.setV_model(vehicle.getV_model());
		vehicle1.setV_regNo(vehicle.getV_regNo());
		Vehicle updateVehicle = vehicleRepository.save(vehicle1);

		return new ResponseEntity<>(updateVehicle, HttpStatus.OK);

	}
	
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable int id) {
		Vehicle vehicle1 = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
		 vehicleRepository.delete(vehicle1);
		 
		return new ResponseEntity<>( HttpStatus.OK);
	}
	 
	
	
	// -----------------------------------------------------------------------------------------
		// ---------------------------- SHOPS
		// ----------------------------------------------
		// -----------------------------------------------------------------------------------------
		@GetMapping("/shops")
		public ResponseEntity<List<Vendor>> getShops() { 
			return new ResponseEntity<>(vendorRepository.findAll(), HttpStatus.OK);
		}
	
	
	// -----------------------------------------------------------------------------------------
	// ---------------------------- SERVICES
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------
	@GetMapping("/services")
	public ResponseEntity<List<Service_Taken_Vendor>> getServices() {
		return new ResponseEntity<>(serviceRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/services/{id}")
	public ResponseEntity<Object> getServices(@PathVariable int id) {
		return new ResponseEntity<Object>(feedbackRepository.findById(id), HttpStatus.OK);
>>>>>>> tuka
	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- OFFERS
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/offer")
	public ResponseEntity<List<Offer>> getOffer() {
		return new ResponseEntity<>(offerRepository.findAll(), HttpStatus.OK);
	}

<<<<<<< HEAD
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

=======
	@GetMapping("/offer/{id}")
	public ResponseEntity<Object> getOffer(@PathVariable int id) {
		return new ResponseEntity<Object>(offerRepository.findById(id), HttpStatus.OK);
>>>>>>> tuka
	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- ORDERS
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

<<<<<<< HEAD
//	@GetMapping("/orders")
//	public ResponseEntity<List<Order>> getOrder() {
//		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
//	}
=======
	@GetMapping("/order")
	public ResponseEntity<List<Order>> getOrder() {
		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
	}
>>>>>>> tuka

	// -----------------------------------------------------------------------------------------
	// ---------------------------- FEEDBACK
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

<<<<<<< HEAD
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
	    
=======
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> getFeedback() {

		return new ResponseEntity<>(feedbackRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Object> getFeedback(@PathVariable int id) {
		return new ResponseEntity<Object>(feedbackRepository.findById(id), HttpStatus.OK);
	}

	@PostMapping("/feedback/create")
	public ResponseEntity<Feedback> giveFeedback(@RequestBody Feedback feedback) {

		return new ResponseEntity<>(feedbackRepository.save(feedback), HttpStatus.OK);
	}
>>>>>>> tuka
}
