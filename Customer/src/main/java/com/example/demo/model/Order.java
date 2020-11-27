package com.example.demo.model;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
public class Order {

		int o_id;    					//auto generated -->  @Id
		String o_date;					//auto generated -->  current Date
		String o_start_time;			//auto generated -->  current Time
		String o_vehicle_reg_no;		//Entered By User (Vehicle --> [MH-32 S-2556])	
		User o_user;					//To Know Order belongs to which user --> (u_id)
										//(It Is A Foreign Key Of Order and User Entity) 
		Vehicle o_vehicle;					//To Know Vehicle Details Of User Like Name Model and CC Engine --> (v_id)
										//(It Is A Foreign Key Of The Order and Vehicle Entity) 
		Vendor o_vendor;				//Who is Vendor --> (Sai-Services) --> (ven_id)
										//(It Is A Foreign Key Of Order and Vendor)
		Offer o_offer;					//To Know Which offer Is Applied On The Current Order
		Service_Taken_Vendor o_s_total_fk;					//To Get The Total Amount Of Order Placed
		//List<Service_Taken_Vendor> o_st_service_fk;	//Will get to know about hoe many services has been taken by user
		
		

	
		
		
		public Order() {
			System.out.println("In Order Default Constructor");	
			
		}
	
		
		public Order(String o_date, String o_start_time, String o_vehicle_reg_no) {
			super();
			this.o_date = o_date;
			this.o_start_time = o_start_time;
			this.o_vehicle_reg_no = o_vehicle_reg_no;
		}
	
		
		public Order(int o_id, String o_date, String o_start_time, String o_vehicle_reg_no) {
			super();
			this.o_id = o_id;
			this.o_date = o_date;
			this.o_start_time = o_start_time;
			this.o_vehicle_reg_no = o_vehicle_reg_no;
		}
	
		
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getO_id() {
			return o_id;
		}
			public void setO_id(int o_id) {
			this.o_id = o_id;
		}
		
		@Column(length=30)
		public String getO_date() {
			return o_date;
		}
		public void setO_date(String o_date) {
			this.o_date = o_date;
		}
		
		
		@Column(length=30)
		public String getO_start_time() {
			return o_start_time;
		}
		public void setO_start_time(String o_start_time) {
			this.o_start_time = o_start_time;
		}
		
		
		@Column(length=30)
		public String getO_vehicle_reg_no() {
			return o_vehicle_reg_no;
		}
		public void setO_vehicle_reg_no(String o_vehicle_reg_no) {
			this.o_vehicle_reg_no = o_vehicle_reg_no;
		}
		
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="u_id")
		@JsonBackReference
		public User getO_user() {
			return o_user;
		}
		public void setO_user(User o_user) {
			this.o_user = o_user;
		}
		
		
		@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name="v_id")
		public Vehicle getO_vehicle() {
			return o_vehicle;
		}
		public void setO_vehicle(Vehicle o_vehicle) {
			this.o_vehicle = o_vehicle;
		}
		
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="ven_id")
		public Vendor getO_vendor() {
			return o_vendor;
		}
		public void setO_vendor(Vendor o_vendor) {
			this.o_vendor = o_vendor;
		}
	
		
		
		
		
	/*   
	//This is Correct Code. Just another way to get the feedback from order but not good while placing the order.
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="f_id")
		public Feedback getO_feedback() {
			return o_feedback;
		}
		public void setO_feedback(Feedback o_feedback) {
			this.o_feedback = o_feedback;
		}
	*/	
		
		
		
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="ofr_id")	
		public Offer getO_offer() {
			return o_offer;
		}
		public void setO_offer(Offer o_offer) {
			this.o_offer = o_offer;
		}
		
		
		@Override
		public String toString() {
			return "Order [o_id=" + o_id + ", o_date=" + o_date + ", o_start_time=" + o_start_time
					+ ", o_vehicle_reg_no=" + o_vehicle_reg_no +  "]";
		}
		
		
		
		/*
		@OneToOne 
		@JoinColumn(name="s_id")	
		public Service getO_s_total_fk() {
			return o_s_total_fk;
		}
		public void setO_s_total_fk(Service o_s_total_fk) {
			this.o_s_total_fk = o_s_total_fk;
		}
		
		
		@OneToMany 
		@JoinTable(joinColumns=@JoinColumn(name="o_id"),
		inverseJoinColumns=@JoinColumn(name="st_id"))
		public List<Service_Taken> getO_st_service_fk() {
			return o_st_service_fk;
		}
		public void setO_st_service_fk(List<Service_Taken> o_st_service_fk) {
			this.o_st_service_fk = o_st_service_fk;
		}
		
		
		*/
		
		}	