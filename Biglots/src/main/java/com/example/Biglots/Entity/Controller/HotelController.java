package com.example.Biglots.Entity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Biglots.Service.HotelService;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;



@Controller
public class HotelController {

	@Autowired
	private HotelService hotelservice;

	@GetMapping("/")
	public String index(Model model) {
		Hotel hotel = new Hotel();
		model.addAttribute("hotel", hotel);
		System.out.println("gettig details from Hotel page");
		return "Hotel";

	}

	
	
	@PostMapping("/hotelBookingPage")
	public String HotelBookingPage(@ModelAttribute("hotel") Hotel hotel, Model model) {

		model.addAttribute("hotel", hotel);
		System.out.println(hotel);
		System.out.println("posting the hotel booking details");
		hotelservice.HotelHomePage(hotel);
		model.addAttribute("customerName", hotel.getCustomerName());
		model.addAttribute("noOfExtraPersons", hotel.getNoOfExtraPersons());
		model.addAttribute("noOfDaysofStay", hotel.getNoOfDaysofStay());
		model.addAttribute("typeOfRoom", hotel.getTypeOfRoom());
		model.addAttribute("roomAmount", hotel.getRoomAmount());
		model.addAttribute("roomPrice", hotel.getRoomPrice());
		
		return "Index";
	
	}
	
	@PostMapping("/HotelToFood")
	public String FoodBookingSection( Model model ) {
		Food food = new Food(); // Create a new Food object
		System.out.println("navigating to food ordering page");
        model.addAttribute("food", food);
       
		return "foodIndex";
	}
	
}

