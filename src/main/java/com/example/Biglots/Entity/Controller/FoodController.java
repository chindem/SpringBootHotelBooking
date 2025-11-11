package com.example.Biglots.Entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Biglots.Repository.BillingRepo;
import com.example.Biglots.Repository.FoodRepo;
import com.example.Biglots.Repository.HotelRepo;
import com.example.Biglots.Service.BillingService;
import com.example.Biglots.Service.FoodService;
import com.example.Biglots.Service.HotelService;
import com.example.Biglots.biglotEntity.Billing;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;



@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodservice;
	@Autowired
	private HotelService hotelservice;
	
	
	@Autowired
	private HotelRepo hotelRepos; 
	@Autowired
     private FoodRepo foodrepo;
	
	
	@GetMapping("/food")
	public String IndexFood(@RequestParam("hotelId") int hotelId, Model model) {
	    Hotel hotel = hotelRepos.findById(hotelId).orElse(null);
	    if (hotel == null) {
	        model.addAttribute("error", "Hotel not found");
	        return "errorPage";
	    }
	    model.addAttribute("hotel", hotel);
	    model.addAttribute("food", new Food());
	    return "foodIndex";
	 }
	
	
	
	
	@PostMapping("/foodBookingPage")
	
	public String HotelBookingPage(@RequestParam("hotelId") int hotelId, @ModelAttribute("food") Food food, Model model) {
	    Hotel hotel = hotelRepos.findById(hotelId).orElse(null);
	   
	    
	    model.addAttribute("hotel", hotel);
	    hotelservice.HotelHomePage(hotel);
	    model.addAttribute("customerName", hotel.getCustomerName());
		model.addAttribute("noOfExtraPersons", hotel.getNoOfExtraPersons());
		model.addAttribute("noOfDaysofStay", hotel.getNoOfDaysofStay());
		model.addAttribute("typeOfRoom", hotel.getTypeOfRoom());
		model.addAttribute("roomAmount",hotel.getRoomAmount());
		model.addAttribute("roomPrice",hotel.getRoomPrice());
		
		
		model.addAttribute("food",food);
		foodservice.FoodHomePage(food);
		model.addAttribute("typeOfFood", food.getTypeOfFood());
		model.addAttribute("noOfDaysToServeFood", food.getNoOfDaysToServeFood());
		model.addAttribute("foodAmount", food.getFoodAmount());
		model.addAttribute("foodPrice", food.getFoodPrice());
	    
	    
//	    if (hotel == null) {
//	        model.addAttribute("error", "Hotel not found for food booking");
//	        
//	        return "errorPage";
//	    }
	    
	    System.out.println("saving food booking details"+food);
	    food.setHotel(hotel);
	    foodrepo.save(food);
	   System.out.println("== your Order has placed successfully! == ");
	  
	    return "bill";
}
	
	
	}
