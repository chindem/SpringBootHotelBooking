package com.example.Biglots.biglotEntity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
@Table(name="food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	private String typeOfFood;
	private int noOfDaysToServeFood;
	private int foodAmount;
	private int foodPrice;
	@Column(name = "food_and_hotel_total_amount")
	private int foodAndHotelTotalAmount;
	
	
	// Add mapping to Hotel (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "hotel_id") // foreign key column
    private Hotel hotel;
	

}
