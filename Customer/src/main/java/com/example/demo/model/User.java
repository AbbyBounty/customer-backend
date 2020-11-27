package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name="user")
public class User {

private	int u_id;						//auto generated -->  @Id

//@NotEmpty(message="First Name Required")
private	String u_first_name;			//Enter By User	

//@NotEmpty(message="Last Name Required")
private	String u_last_name;				//Enter By User	

//@Email(message="Valid Email ID Required")
private	String u_email;					//Enter By User		

//@NotEmpty(message="Mobile Number is Required")
//@Range(min=10,max=11,message="Minimum 10 Digits")
private	String u_mobile;				//Enter By User	

//@NotEmpty(message="Valid Address is Required")
private	String u_address;				//Enter By User	

//@NotEmpty(message="Password is Required")
//@Range(min=3,max=30,message="Minimum 3 Letters")
private	String u_password;				//Enter By User	
//OneToMany Relationship

private List<Vehicle> u_vehicles = new ArrayList<>(); //Enter By User	

														//(Select Using Drop-Down List)-->(Take data from Vehicle Entity)	
private List<Order> u_order = new ArrayList<>();				//Previous Orders Placed By User



	public User() {
		
		
		System.out.println("In The Default Constructor of User "+this.u_id);
	}


	public User(String u_first_name, String u_last_name,String u_email,
			String u_mobile, String u_address, String u_password) 
	{
		super();
		this.u_first_name = u_first_name;
		this.u_last_name = u_last_name;
		this.u_email = u_email;
		this.u_mobile = u_mobile;
		this.u_address = u_address;
		this.u_password = u_password;
	
	}
	
	
	
	public User(int u_id, String u_first_name, String u_last_name,String u_email,
			String u_mobile, String u_address, String u_password) 
	{
		super();
		this.u_id = u_id;
		this.u_first_name = u_first_name;
		this.u_last_name = u_last_name;
		this.u_email = u_email;
		this.u_mobile = u_mobile;
		this.u_address = u_address;
		this.u_password = u_password;

	}

	
	public User(String u_first_name, String u_last_name,String u_email,
			String u_mobile, String u_address, String u_password, List<Vehicle> u_vehicles) 
	{
		super();
		this.u_first_name = u_first_name;
		this.u_last_name = u_last_name;
		this.u_email = u_email;
		this.u_mobile = u_mobile;
		this.u_address = u_address;
		this.u_password = u_password;
		this.u_vehicles = u_vehicles;
	}
	
	
	public User(int u_id, String u_first_name, String u_last_name,String u_email,
			String u_mobile, String u_address, String u_password, List<Vehicle> u_vehicles) 
	{
		super();
		this.u_id = u_id;
		this.u_first_name = u_first_name;
		this.u_last_name = u_last_name;
		this.u_email = u_email;
		this.u_mobile = u_mobile;
		this.u_address = u_address;
		this.u_password = u_password;
		this.u_vehicles = u_vehicles;
	}


	public User(String u_first_name, String u_last_name, String u_email, String u_mobile, String u_address,
			String u_password, List<Vehicle> u_vehicles, List<Order> u_order) {
		super();
		this.u_first_name = u_first_name;
		this.u_last_name = u_last_name;
		this.u_email = u_email;
		this.u_mobile = u_mobile;
		this.u_address = u_address;
		this.u_password = u_password;
		this.u_vehicles = u_vehicles;
		this.u_order = u_order;
	}

//
////	public User(int u_id, String u_first_name, String u_last_name, String u_email, String u_mobile, String u_address,
//			String u_password, List<Vehicle> u_vehicles, List<Order> u_order) {
//		super();
//		this.u_id = u_id;
//		this.u_first_name = u_first_name;
//		this.u_last_name = u_last_name;
//		this.u_email = u_email;
//		this.u_mobile = u_mobile;
//		this.u_address = u_address;
//		this.u_password = u_password;
//		this.u_vehicles = u_vehicles;
//		this.u_order = u_order;
//	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	@Column(length=30)
	public String getU_first_name() {
		return u_first_name;
	}
	public void setU_first_name(String u_first_name) {
		this.u_first_name = u_first_name;
	}

	@Column(length=30)
	public String getU_last_name() {
		return u_last_name;
	}
	public void setU_last_name(String u_last_name) {
		this.u_last_name = u_last_name;
	}
	
	@Column(length=60,unique=true)
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	
	@Column(length=11)
	public String getU_mobile() {
		return u_mobile;
	}
	public void setU_mobile(String u_mobile) {
		this.u_mobile = u_mobile;
	}

	@Column(length=100)
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	
	@Column(length=30)
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	
/*	@ElementCollection
	@CollectionTable(name = "vehicle",
	joinColumns = @JoinColumn(name = "u_id"))*/
	
	@OneToMany(mappedBy="v_user",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/)
	@JsonManagedReference
	public List<Vehicle> getU_vehicles() {
		return u_vehicles;
	}

	public void setU_vehicles(List<Vehicle> u_vehicles) {
		this.u_vehicles = u_vehicles;
	}
	
	
	@OneToMany(mappedBy="o_user",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/) 
	@JsonManagedReference
	public List<Order> getU_order() {
		return u_order;
	}

	public void setU_order(List<Order> u_order) {
		this.u_order = u_order;
	}
	
	
	public List<Vehicle> GetVehicle() {
		return this.getU_vehicles();
	}
	
	public void addVehicle(List<Vehicle> v) {
		this.setU_vehicles(v);
	}

	


	


	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_first_name=" + u_first_name + ", u_last_name=" + u_last_name + ", u_email="
				+ u_email + ", u_mobile=" + u_mobile + ", u_address=" + u_address + ", u_password=" + u_password 
				+ " u_order " + u_order +" u_vehicles " + u_vehicles +"]";
	}
	
	
	
	
	
	
	
	
	
	//Please Override the toString Method()
	//Please Write Constructors


}


