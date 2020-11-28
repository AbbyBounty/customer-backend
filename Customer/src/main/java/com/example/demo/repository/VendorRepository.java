package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Service_Taken_Vendor;
import com.example.demo.model.Vendor;



@Repository
@Transactional
public interface VendorRepository extends JpaRepository<Vendor, Integer>{
	
	
	public static final SessionFactory sf = null;
	
	public default  List<Service_Taken_Vendor> getService() {
		
		
		
		 List<Service_Taken_Vendor> services = null;
			String jpql = "Select ser FROM Service_Taken_Vendor ser";		
			services = sf.getCurrentSession().createQuery(jpql,Service_Taken_Vendor.class).getResultList();
			System.out.println("\n\n\n\nlist of vendor services ==> "+services+"\n\n\n");
		
		
		
		
				
			return services;
		}
}
