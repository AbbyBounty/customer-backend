package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
import com.example.demo.model.Service_Taken_Vendor;
import com.example.demo.model.Vehicle;







@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
