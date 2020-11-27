package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="vendor")
public class Vendor {
			int ven_id;									//auto generated -->  @Id
			String ven_first_name;						//Enter By Vendor	
			String ven_last_name;						//Enter By Vendor	
			String ven_shop_name;						//Enter By Vendor	
			String ven_proof;							//Enter By Vendor		
			String ven_email;							//Enter By Vendor	unique
			String ven_mobile;							//Enter By Vendor	unique
			String ven_address;							//Enter By Vendor	
			String ven_password;						//Enter By Vendor	
			List<Offer> ven_offer = new ArrayList<>();	//Enter By Vendor (May or May not have it)  
			List<Mechanic> ven_mechanic = new ArrayList<>(); //Enter By Vendor (At least One or many) not null
			//Enter By Vendor (At least One or many) not null
			List<Order> ven_order = new ArrayList<>();	//Previous Orders Received by Vendors	
			List<Service_Taken_Vendor> ven_services = new ArrayList<>(); // Services Taken from Master Table and Provided to Users 
			
			

			public Vendor() {
				System.out.println("In Vendor Default Contrusctor Server Side");
			}
			
			public Vendor( String ven_email, String ven_password) {
				this.ven_email = ven_email;
				this.ven_password = ven_password;
			}

	
			public Vendor(int ven_id) {
				this.ven_id = ven_id;
			}
	
			public Vendor(String ven_first_name, String ven_last_name, String ven_shop_name,
					String ven_proof, String ven_email, String ven_mobile, String ven_address, String ven_password,
					List<Offer> ven_offer, List<Mechanic> ven_mechanic,
					List<Order> ven_order) {
				super();
				this.ven_first_name = ven_first_name;
				this.ven_last_name = ven_last_name;
				this.ven_shop_name = ven_shop_name;
				this.ven_proof = ven_proof;
				this.ven_email = ven_email;
				this.ven_mobile = ven_mobile;
				this.ven_address = ven_address;
				this.ven_password = ven_password;
				this.ven_offer = ven_offer;
				this.ven_mechanic = ven_mechanic;
				
				this.ven_order = ven_order;
			}
			
			public Vendor(int ven_id, String ven_first_name, String ven_last_name, String ven_shop_name,
					String ven_proof, String ven_email, String ven_mobile, String ven_address, String ven_password,
					List<Offer> ven_offer, List<Mechanic> ven_mechanic,
					List<Order> ven_order) {
				super();
				this.ven_id = ven_id;
				this.ven_first_name = ven_first_name;
				this.ven_last_name = ven_last_name;
				this.ven_shop_name = ven_shop_name;
				this.ven_proof = ven_proof;
				this.ven_email = ven_email;
				this.ven_mobile = ven_mobile;
				this.ven_address = ven_address;
				this.ven_password = ven_password;
				this.ven_offer = ven_offer;
				this.ven_mechanic = ven_mechanic;
				
				this.ven_order = ven_order;
			}
			
			public Vendor(String ven_first_name, String ven_last_name, String ven_shop_name,
					String ven_proof, String ven_email, String ven_mobile, String ven_address, String ven_password,
					List<Offer> ven_offer, List<Mechanic> ven_mechanic,
					List<Order> ven_order, List<Service_Taken_Vendor> ven_services) {
				super();
				this.ven_first_name = ven_first_name;
				this.ven_last_name = ven_last_name;
				this.ven_shop_name = ven_shop_name;
				this.ven_proof = ven_proof;
				this.ven_email = ven_email;
				this.ven_mobile = ven_mobile;
				this.ven_address = ven_address;
				this.ven_password = ven_password;
				this.ven_offer = ven_offer;
				this.ven_mechanic = ven_mechanic;
				
				this.ven_order = ven_order;
				this.ven_services = ven_services;
			}
			
			public Vendor(int ven_id, String ven_first_name, String ven_last_name, String ven_shop_name,
					String ven_proof, String ven_email, String ven_mobile, String ven_address, String ven_password,
					List<Offer> ven_offer, List<Mechanic> ven_mechanic, 
					List<Order> ven_order, List<Service_Taken_Vendor> ven_services) {
				super();
				this.ven_id = ven_id;
				this.ven_first_name = ven_first_name;
				this.ven_last_name = ven_last_name;
				this.ven_shop_name = ven_shop_name;
				this.ven_proof = ven_proof;
				this.ven_email = ven_email;
				this.ven_mobile = ven_mobile;
				this.ven_address = ven_address;
				this.ven_password = ven_password;
				this.ven_offer = ven_offer;
				this.ven_mechanic = ven_mechanic;
				
				this.ven_order = ven_order;
				this.ven_services = ven_services;
			}



			
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column
			public int getVen_id() {
				return ven_id;
			}

			public void setVen_id(int ven_id) {
				this.ven_id = ven_id;
			}
			
			@Column(length=30)
			public String getVen_first_name() {
				return ven_first_name;
			}
			public void setVen_first_name(String ven_first_name) {
				this.ven_first_name = ven_first_name;
			}
			
			
			@Column(length=30)	
			public String getVen_last_name() {
				return ven_last_name;
			}
			public void setVen_last_name(String ven_last_name) {
				this.ven_last_name = ven_last_name;
			}

			
			@Column(length=30)
			public String getVen_shop_name() {
				return ven_shop_name;
			}
			public void setVen_shop_name(String ven_shop_name) {
				this.ven_shop_name = ven_shop_name;
			}

			
			@Column(length=30)
			public String getVen_proof() {
				return ven_proof;
			}
			public void setVen_proof(String ven_proof) {
				this.ven_proof = ven_proof;
			}
			
			
			@Column(length=70) 				//size might cause a problem think about it
			public String getVen_email() {
				return ven_email;
			}
			public void setVen_email(String ven_email) {
				this.ven_email = ven_email;
			}
			
			@Column(length=11)
			public String getVen_mobile() {
				return ven_mobile;
			}
			public void setVen_mobile(String ven_mobile) {
				this.ven_mobile = ven_mobile;
			}

			@Column(length=80)
			public String getVen_address() {
				return ven_address;
			}
			public void setVen_address(String ven_address) {
				this.ven_address = ven_address;
			}
			
			
			@Column(length=30)
			public String getVen_password() {
				return ven_password;
			}
			public void setVen_password(String ven_password) {
				this.ven_password = ven_password;
			}
			
			
			@OneToMany(mappedBy="o_vendor",cascade=CascadeType.ALL)
			public List<Order> getVen_order() {
				return ven_order;
			}
			public void setVen_order(List<Order> ven_order) {
				this.ven_order = ven_order;
			}
			
			
			
			@OneToMany(mappedBy="mech_vendor",cascade=CascadeType.ALL)
			@JsonManagedReference
			public List<Mechanic> getVen_mechanic() {
				return ven_mechanic;
			}
			public void setVen_mechanic(List<Mechanic> ven_mechanic) {
				this.ven_mechanic = ven_mechanic;
			}
				
						
//			@OneToMany(mappedBy="f_vendor",cascade=CascadeType.ALL)  // Write ManyToOne in Feedback POJO
//			public List<Feedback> getVen_feedback() {
//				return ven_feedback;
//			}
//
//			public void setVen_feedback(List<Feedback> ven_feedback) {
//				this.ven_feedback = ven_feedback;
//			}
			
			
		
			@OneToMany(mappedBy="ofr_vendor",cascade=CascadeType.ALL) 	// Write ManyToOne in Offer POJO
			@JsonManagedReference
			public List<Offer> getVen_offer() {
				return ven_offer;
			}
			public void setVen_offer(List<Offer> ven_offer) {
				this.ven_offer = ven_offer;
			}
			
			
			@OneToMany(mappedBy="stv_vendor",cascade=CascadeType.ALL) 	// Write ManyToOne in Service_Taken_Vendor POJO
			@JsonManagedReference
			public List<Service_Taken_Vendor> getVen_services() {
				return ven_services;
			}

			public void setVen_services(List<Service_Taken_Vendor> ven_services) {
				this.ven_services = ven_services;
			}
			

			@Override
			public String toString() {
				return "Vendor [ven_id=" + ven_id + ", ven_first_name=" + ven_first_name + ", ven_last_name="
						+ ven_last_name + ", ven_shop_name=" + ven_shop_name + ", ven_proof=" + ven_proof
						+ ", ven_email=" + ven_email + ", ven_mobile=" + ven_mobile + ", ven_address=" + ven_address
						+ ", ven_password=" + ven_password + ", ven_offer=" + ven_offer + ", ven_mechanic="
						+ ven_mechanic + ", ven_feedback="  + ", ven_order=" + ven_order
						+ ", ven_services=" + ven_services + "]";
			}

			
			
		
}
