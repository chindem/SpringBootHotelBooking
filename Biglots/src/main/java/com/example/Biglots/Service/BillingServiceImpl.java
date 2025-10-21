package com.example.Biglots.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biglots.Repository.BillingRepo;

import com.example.Biglots.biglotEntity.Billing;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;


@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepo billingrepo;
	

	@Override
	public void billCalculation(Billing billing, Food food, Hotel hotel) {

		// Retrieve the actual amounts from the populated objects
		int hotelTotalBill = hotel.getRoomAmount();
		int foodTotalBill = food.getFoodAmount();
		

		// Calculate the total amount
		int totalBill=0;
		 totalBill = hotelTotalBill + foodTotalBill;

		
		// Set the values on the Billing object before saving
		billing.setFoodTotalBill(foodTotalBill);
		billing.setHotelTotalBill(hotelTotalBill);
		billing.setTotalBill(totalBill);
		billing.setHotel(hotel);
		System.out.println("Saving billing details...");
		System.out.println("Hotel Total: " + hotelTotalBill);
		System.out.println("Food Total: " + foodTotalBill);
		System.out.println("Grand Total: " + totalBill);
		
		
		
		// Save the billing object with all its values correctly set
		billingrepo.save(billing);
	}
}
