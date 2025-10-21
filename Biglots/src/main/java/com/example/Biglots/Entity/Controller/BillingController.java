package com.example.Biglots.Entity.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Biglots.Repository.FoodRepo;
import com.example.Biglots.Repository.HotelRepo;
import com.example.Biglots.Service.BillingService;
import com.example.Biglots.Service.FoodService;
import com.example.Biglots.Service.HotelService;
import com.example.Biglots.biglotEntity.Billing;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;

@Controller
public class BillingController {

	// Autowire the repositories directly
	@Autowired
	private FoodRepo foodrepo;
	@Autowired
	private HotelRepo hotelrepo;
	@Autowired
	private BillingService billingservice;

	@GetMapping("/billing")
	public String Indexbill(@RequestParam("foodId") int foodId, @RequestParam("hotelId") int hotelId, Model model) {

		// 1. Fetch the actual Food object from the database using its ID
		Optional<Food> foodOptional = foodrepo.findById(foodId);
		if (!foodOptional.isPresent()) {
			model.addAttribute("error", "Food record not found!");
			return "errorPage";
		}
		Food food = foodOptional.get();

		// 2. Fetch the actual Hotel object from the database using its ID
		Optional<Hotel> hotelOptional = hotelrepo.findById(hotelId);
		if (!hotelOptional.isPresent()) {
			model.addAttribute("error", "Hotel record not found!");
			return "errorPage";
		}
		Hotel hotel = hotelOptional.get();

		// 3. Create the new billing object
		Billing billing = new Billing();

		// 4. Call the service to perform the calculation and save the data
		billingservice.billCalculation(billing, food, hotel);

		// 5. Add the populated objects to the model for display on the front-end
		model.addAttribute("food", food);
		model.addAttribute("hotel", hotel);
		model.addAttribute("billing", billing);

		System.out.println("Getting details from Billing page");

		return "orderConformation"; // Make sure your HTML file is named 'bill.html'
	}
}
