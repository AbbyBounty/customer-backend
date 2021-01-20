package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	

	
	@Query(value="select * from vehicle where u_id=:u_id",nativeQuery=true)
	public List<Vehicle> findVehicleByuserId(@Param("u_id") int u_id);
}