package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="mechanic")
public class Mechanic {
	int mech_id;					//auto generated 	-->	@Id
	String mech_first_name;			//Enter By Vendor 	--> First Name Of Mechanic 	-->[ABC]
	String mech_last_name;			//Enter By Vendor 	--> Last Name Of Mechanic 	-->[XYZ]
	String mech_mobile;				//Enter By Vendor
	Vendor mech_vendor;				//Enter By Vendor 	--> unique
	//byte[] img;					//For Mechanic's Picture

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMech_id() {
		return mech_id;
	}
	public void setMech_id(int mech_id) {
		this.mech_id = mech_id;
	}
	
	@Column(length=15)
	public String getMech_first_name() {
		return mech_first_name;
	}
	public void setMech_first_name(String mech_first_name) {
		this.mech_first_name = mech_first_name;
	}
	
	@Column(length=15)
	public String getMech_last_name() {
		return mech_last_name;
	}
	public void setMech_last_name(String mech_last_name) {
		this.mech_last_name = mech_last_name;
	}
	
	@Column(length=11)
	public String getMech_mobile() {
		return mech_mobile;
	}
	
	public void setMech_mobile(String mech_mobile) {
		this.mech_mobile = mech_mobile;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="ven_id")
	@JsonBackReference
	public Vendor getMech_vendor() {
		return mech_vendor;
	}
	public void setMech_vendor(Vendor mech_vendor) {
		this.mech_vendor = mech_vendor;
	}
	
	
	@Override
	public String toString() {
		return "Mechanic [mech_id=" + mech_id + ", mech_first_name=" + mech_first_name + ", mech_last_name="
				+ mech_last_name + ", mech_mobile=" + mech_mobile + "]";
	}
	
	

	
	
	
}