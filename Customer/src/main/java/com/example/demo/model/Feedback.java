package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	int f_id;		
	private String description;	
//	
//	@ManyToOne
//	@JoinColumn(name="o_id")
//	@JsonBackReference
//	private Order	o_order;
//	
//	
//	@ManyToOne
//	@JoinColumn(name="u_id")
//	@JsonBackReference
//	private User	u_user;		
//	
//	
//	@ManyToOne
//	@JoinColumn(name="ven_id")
//	@JsonBackReference
//	private Vendor	ven_vendor;


	public int getF_id() {
		return f_id;
	}


	public void setF_id(int f_id) {
		this.f_id = f_id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Feedback [f_id=" + f_id + ", description=" + description + "]";
	}

//
//	public Order getO_id() {
//		return o_order;
//	}
//
//
//	public void setO_id(Order o_id) {
//		this.o_order = o_id;
//	}
//
//
//	public User getU_id() {
//		return u_user;
//	}
//
//
//	public void setU_id(User u_id) {
//		this.u_user = u_id;
//	}
//
//
//	public Vendor getVen_id() {
//		return ven_vendor;
//	}
//
//
//	public void setVen_id(Vendor ven_id) {
//		this.ven_vendor = ven_id;
//	}

	
	
	
	
	

}
