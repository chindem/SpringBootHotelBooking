package com.example.Biglots.Service;

import java.util.Optional;

import com.example.Biglots.biglotEntity.Billing;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;

public interface BillingService {
	
	

	public void billCalculation(Billing billing, Food food, Hotel hotel);
	

	

}
