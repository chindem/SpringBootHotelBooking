package com.example.Biglots.biglotEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Billing")
public class Billing {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private int foodTotalBill;
	private int hotelTotalBill;
	// This field will be saved to the 'total_bill' column in the database
		@Column(name = "total_bill")
		private int totalBill;
		
		
		  // Add the mapping to Hotel (ManyToOne - many billings can be for one hotel)
	    @ManyToOne
	    @JoinColumn(name = "hotel_id", referencedColumnName = "hotelId")
	    private Hotel hotel;
		
	
	
}
