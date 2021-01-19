package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.example.demo.model.Vehicle;
import com.example.demo.model.Vendor;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.MechanicRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.VendorRepository;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/user")
public class customerController {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	// -----------------------------------------------------------------------------------------
	// ---------------------------- Vehicle
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	
	@PostMapping("/Vehicle/create")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<>(vehicleRepository.save(vehicle), HttpStatus.OK);
	}
	
	@GetMapping("/Vehicle/{id}")
	public ResponseEntity<Object> getVehicle(@PathVariable int id) {
		return new ResponseEntity<Object>(vehicleRepository.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/Vehicle")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/Vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
		Vehicle vehicle1 = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
		vehicle1.setV_id(vehicle.getV_id());
		vehicle1.setV_company_name(vehicle.getV_company_name());
		vehicle1.setV_model(vehicle.getV_model());
		vehicle1.setV_regNo(vehicle.getV_regNo());
		Vehicle updateVehicle = vehicleRepository.save(vehicle1);

		return new ResponseEntity<>(updateVehicle, HttpStatus.OK);

	}
	
	@DeleteMapping("/Vehicle/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable int id) {
		Vehicle vehicle1 = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
		 vehicleRepository.delete(vehicle1);
		 
		return new ResponseEntity<>( HttpStatus.OK);
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
	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- OFFERS
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/offer")
	public ResponseEntity<List<Offer>> getOffer() {
		return new ResponseEntity<>(offerRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/offer/{id}")
	public ResponseEntity<Object> getOffer(@PathVariable int id) {
		return new ResponseEntity<Object>(offerRepository.findById(id), HttpStatus.OK);
	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- ORDERS
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/order")
	public ResponseEntity<List<Order>> getOrder() {
		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
	}

	// -----------------------------------------------------------------------------------------
	// ---------------------------- FEEDBACK
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

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
}
