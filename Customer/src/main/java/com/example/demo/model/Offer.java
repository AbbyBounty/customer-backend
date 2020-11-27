package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Data Inputed Into The Database
@Entity
@Table(name="offer")
public class Offer {
		int ofr_id;						//auto generated 	--> @Id
		String ofr_name;				//Offer Name 		--> [Magical Monday,Wonderful Wednesday] 
		String ofr_code;				//Offer Code 		--> [GET50,FREE,FIRSTUSER] --> length(8) in Database; unique
		int ofr_discount; 				//Offer Discount 	-->
		Date ofr_validity;				//End Date Of Validity
		Vendor ofr_vendor;		//To Know Which Vendor Added The Offer 
		
		
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getOfr_id() {
			return ofr_id;
		}
		public void setOfr_id(int ofr_id) {
			this.ofr_id = ofr_id;
		}
		
		@Column(length=30)
		public String getOfr_name() {
			return ofr_name;
		}
		public void setOfr_name(String ofr_name) {
			this.ofr_name = ofr_name;
		}
		
		@Column(length=15)
		public String getOfr_code() {
			return ofr_code;
		}
		public void setOfr_code(String ofr_code) {
			this.ofr_code = ofr_code;
		}
		
		@Column(name="ofr_discount")
		public int getOfr_discount() {
			return ofr_discount;
		}
		public void setOfr_discount(int ofr_discount) {
			this.ofr_discount = ofr_discount;
		}
		
		
		@Column(name="ofr_validity")
		@Temporal(TemporalType.DATE)
		public Date getOfr_validity() {
			return ofr_validity;
		}
		public void setOfr_validity(Date ofr_validity) {
			this.ofr_validity = ofr_validity;
		}

		
		//OneToOne Relationship with Vendor
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="ven_id")
		@JsonBackReference
		public Vendor getOfr_vendor() {
			return ofr_vendor;
		}
		public void setOfr_vendor(Vendor ofr_vendor) {
			this.ofr_vendor = ofr_vendor;
		}
		
/*		@Override
		public String toString() {
			return "Offer [ofr_id=" + ofr_id + ", ofr_name=" + ofr_name + ", ofr_code=" + ofr_code + ", ofr_discount="
					+ ofr_discount + ", ofr_validity=" + ofr_validity + ", ofr_vendor=" + ofr_vendor + "]";
		}
*/		

		
		
		
}
