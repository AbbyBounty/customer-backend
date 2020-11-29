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

import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ServiceRepository;


@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private OrderRepository orderRepository;

	// -----------------------------------------------------------------------------------------
	// ---------------------------- SERVICES
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------
	@GetMapping("/services")
	public ResponseEntity<List<Service_Taken_Vendor>> getServices() {
		return new ResponseEntity<>(serviceRepository.findAll(), HttpStatus.OK);
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
	// ---------------------------- VEHICLE
	// ----------------------------------------------
	// -----------------------------------------------------------------------------------------

	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>> getVehicle() {
		return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/vehicle/add")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {

		return new ResponseEntity<>(vehicleRepository.save(vehicle), HttpStatus.OK);
	}

	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
		Vehicle vehicle1 = vehicleRepository.findById( id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
	
		vehicle1.setV_company_name(vehicle.getV_company_name());
	    vehicle1.setV_model(vehicle.getV_model());
        vehicle1.setV_reg_no(vehicle.getV_reg_no());
       
	   Vehicle updatedVehicle = vehicleRepository.save(vehicle1);

		return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);

	}
	
	@DeleteMapping("/vehicle/{id}")
	public String  deleteVehicle(@PathVariable int id) {
		
		try {
			vehicleRepository.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return "deleted";
		
		
		//return new ResponseEntity<Object>(, HttpStatus.OK);
	}

	// -----------------------------------------------------------------------------------------
		// ---------------------------- Order
		// ----------------------------------------------
		// -----------------------------------------------------------------------------------------

		@GetMapping("/order")
		public ResponseEntity<List<Order>> getOrder() {
			return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
		}

		@PostMapping("/order/add")
		public ResponseEntity<Order> addOrder(@RequestBody Order order) {
      
			Vehicle vehicle=order.getO_vehicle();
			System.out.println(vehicle.getV_id()); 
        
			return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
		}

		@PutMapping("/order/{id}")
		public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
			Order order1 = orderRepository.findById( id)
					.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
		
			order1.setO_start_time(order.getO_start_time());
			order1.setO_offer(order.getO_offer());
			order1.setO_date(order.getO_date());
	       
		   Order updatedOrder = orderRepository.save(order1);

			return new ResponseEntity<>(updatedOrder, HttpStatus.OK);

		}
		

	
}
