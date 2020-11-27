package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

//This Table Must Be Populated and Generated Automatically When Vendor Will Select The Service
@Entity
@Table(name="service")
public class Service_Taken_Vendor {
	int stv_id;											//auto generated @Id
	String stv_name;      								//Added By Vendor	--> Checkboxes
	double stv_price;									//Added By Vendor 	--> Rs.500 
	Vendor stv_vendor;

	public Service_Taken_Vendor() {
			System.out.println("In default of Service taken vendor client");
	}

	public Service_Taken_Vendor(int stv_id) {
		this.stv_id = stv_id;
	}

	public Service_Taken_Vendor(String stv_name, double stv_price) {
		this.stv_name = stv_name;
		this.stv_price = stv_price;
	}

	public Service_Taken_Vendor(int stv_id, String stv_name, double stv_price) {
		this.stv_id = stv_id;
		this.stv_name = stv_name;
		this.stv_price = stv_price;
	}
	
	public Service_Taken_Vendor(String stv_name, double stv_price, Vendor stv_vendor) {
		this.stv_name = stv_name;
		this.stv_price = stv_price;
		this.stv_vendor = stv_vendor;
	}

	
	public Service_Taken_Vendor(int stv_id, String stv_name, double stv_price, Vendor stv_vendor) {
		this.stv_id = stv_id;
		this.stv_name = stv_name;
		this.stv_price = stv_price;
		this.stv_vendor = stv_vendor;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStv_id() {
		return stv_id;
	}
	
	public void setStv_id(int stv_id) {
		this.stv_id = stv_id;
	}

	
	@Column(length=70)
	public String getStv_name() {
		return stv_name;
	}

	public void setStv_name(String stv_name) {
		this.stv_name = stv_name;
	}

	@Column(columnDefinition="double(7,2)")
	public double getStv_price() {
		return stv_price;
	}

	public void setStv_price(double stv_price) {
		this.stv_price = stv_price;
	}
	
	@ManyToOne/*(fetch=FetchType.EAGER)*/
	@JoinColumn(name="ven_id")
	@JsonBackReference
	public Vendor getStv_vendor() {
		return stv_vendor;
	}
	
	public void setStv_vendor(Vendor stv_vendor) {
		this.stv_vendor = stv_vendor;
	}
	

	@Override
	public String toString() {
		return "Service_Taken_Vendor [stv_id=" + stv_id + ", stv_name=" + stv_name + ", stv_price=" + stv_price
				+ "]";
	}

		
}








/*





package com.app.pojos;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

//This Table Must Be Populated and Generated Automatically When Vendor Will Select The Service
@Entity
@Table(name="service_taken_vendor")
public class Service_Taken_Vendor {
	int stv_id;											  //auto generated @Id
	MasterService stv_mstservice;   				     //Services taken by Vendor
	Vendor stv_vendor;
	
	
	public Service_Taken_Vendor() {
	}

	public Service_Taken_Vendor(int stv_id) {
		this.stv_id = stv_id;
	}

	public Service_Taken_Vendor(MasterService stv_mstservice, Vendor stv_vendor) {
		this.stv_mstservice = stv_mstservice;
		this.stv_vendor = stv_vendor;
	}
	
	public Service_Taken_Vendor(int stv_id, MasterService stv_mstservice, Vendor stv_vendor) {
		super();
		this.stv_id = stv_id;
		this.stv_mstservice = stv_mstservice;
		this.stv_vendor = stv_vendor;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStv_id() {
		return stv_id;
	}
	public void setStv_id(int stv_id) {
		this.stv_id = stv_id;
	}

	
		
	public MasterService getStv_mstservice() {
		return stv_mstservice;
	}
	
	public void setStv_mstservice(MasterService stv_mstservice) {
		this.stv_mstservice = stv_mstservice;
	}
	
	
	@ManyToOne
	@JsonBackReference
	public Vendor getStv_vendor() {
		return stv_vendor;
	}
	public void setStv_vendor(Vendor stv_vendor) {
		this.stv_vendor = stv_vendor;
	}
	
	
	@Override
	public String toString() {
		return "Service_Taken_Vendor [stv_id=" + stv_id + ", stv_mstservice=" + stv_mstservice + ", stv_vendor="
				+ stv_vendor + "]";
	}
	
}




*/

/*package com.app.pojos;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

//This Table Must Be Populated and Generated Automatically When Vendor Will Select The Service
@Entity
@Table(name="service_taken_vendor")
public class Service_Taken_Vendor {
	int stv_id;												  //auto generated @Id
	List<ServicesOfVendor> sov_service;   				     //Services taken by Vendor
	Vendor stv_vendor;
	
	

	public Service_Taken_Vendor() {
		System.out.println("In Service Take Vendor Server Side POJO ");
	}

	public Service_Taken_Vendor(int stv_id) {
		this.stv_id = stv_id;
	}

	public Service_Taken_Vendor(List<ServicesOfVendor> sov_service, Vendor stv_vendor) {
		super();
		this.sov_service = sov_service;
		this.stv_vendor = stv_vendor;
	}
	
	public Service_Taken_Vendor(int stv_id, List<ServicesOfVendor> sov_service, Vendor stv_vendor) {
		super();
		this.stv_id = stv_id;
		this.sov_service = sov_service;
		this.stv_vendor = stv_vendor;
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStv_id() {
		return stv_id;
	}
	public void setStv_id(int stv_id) {
		this.stv_id = stv_id;
	}

	
	@Embedded
	public List<ServicesOfVendor> getSov_service() {
		return sov_service;
	}

	public void setSov_service(List<ServicesOfVendor> sov_service) {
		this.sov_service = sov_service;
	}

	
	@ManyToOne
	@JsonBackReference
	public Vendor getStv_vendor() {
		return stv_vendor;
	}
	public void setStv_vendor(Vendor stv_vendor) {
		this.stv_vendor = stv_vendor;
	}

	@Override
	public String toString() {
		return "Service_Taken_Vendor [stv_id=" + stv_id + ", sov_service=" + sov_service + ", stv_vendor=" + stv_vendor
				+ "]";
	}
			
}
*/





