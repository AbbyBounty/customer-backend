package com.example.demo.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



//Already Input Data Into The Database
@Entity
@Table(name="vehicle")
public class Vehicle {
	
	private int v_id;
	private	String v_company_name;			//Vehicle Name		--> [YAMAHA,HERO,HONDA] 
	private	String v_model;					//Vehicle Model 	-->	[FZ-SFI,SZ,ACTIVA,UNICORN]
	private String v_regNo;					//Vehicle Reg Number
	private User v_user;
	
	
	

	public Vehicle() {
		System.out.println("In The Default Constructor of Vehicle"+this.v_id);
	}
	
	
	public Vehicle(int v_id) {
		System.out.println("\n\nVehicle With ID Constructor Server\n\n");
	}

	
	public Vehicle(String v_company_name, String v_model, String v_regNo) {
		super();
		this.v_company_name = v_company_name;
		this.v_model = v_model;
		this.v_regNo = v_regNo;
	}
	

	
	public Vehicle(String v_company_name, String v_model, String v_regNo, User v_user) {
		super();
		this.v_company_name = v_company_name;
		this.v_model = v_model;
		this.v_regNo = v_regNo;
		this.v_user = v_user;
	}
	
	
	
	
	
	public Vehicle(int v_id, String v_company_name, String v_model, String v_regNo, User v_user) {
		super();
		this.v_id = v_id;
		this.v_company_name = v_company_name;
		this.v_model = v_model;
		this.v_regNo = v_regNo;
		this.v_user = v_user;
	}






	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	
	@Column(length=30)
	public String getV_company_name() {
		return v_company_name;
	}
	public void setV_company_name(String v_company_name) {
		this.v_company_name = v_company_name;
	}

	@Column(length=30)
	public String getV_model() {
		return v_model;
	}
	public void setV_model(String v_model) {
		this.v_model = v_model;
	}
	
	@Column(length=20,unique=true)
	public String getV_regNo() {
		return v_regNo;
	}
	public void setV_regNo(String v_regNo) {
		this.v_regNo = v_regNo;
	}


	@ManyToOne/*(fetch=FetchType.EAGER)*/
	@JoinColumn(name="u_id")
	@JsonBackReference
	public User getV_user() {
		return v_user;
	}
	public void setV_user(User v_user) {
		this.v_user = v_user;
	}


@Override
	public String toString() {
		return "Vehicle [v_id=" + v_id + ", v_company_name=" + v_company_name + ", v_model=" + v_model + ", v_regNo="
				+ v_regNo + "]";
	}
	
	
	}
