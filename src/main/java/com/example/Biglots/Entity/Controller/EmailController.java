package com.example.Biglots.Entity.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Biglots.Repository.FoodRepo;
import com.example.Biglots.Repository.HotelRepo;
import com.example.Biglots.Service.EmailService;
import com.example.Biglots.Service.FoodService;
import com.example.Biglots.Service.HotelService;
import com.example.Biglots.biglotEntity.EmailRequest;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;

@Controller
public class EmailController {
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private FoodRepo foodrepo;
	
	@Autowired
	private HotelRepo hotelRepos;
	

    @GetMapping("/email")
    public String showForm() {
        return "ordeConfirmation";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("email") String email,@RequestParam("hotelId") int hotelId, @RequestParam("foodId") int foodId, Model model) {
    	Hotel hotel = hotelRepos.findById(hotelId).orElseThrow(); // get full hotel object
    	
    	Food food =foodrepo.findById(foodId).orElseThrow();
    	
    	String subject = "Welcome! Your booking details for " + hotel.getCustomerName();
        String body = "Dear " + hotel.getCustomerName() + ",\n\n"
    	             + "Total Room Amount: ₹" + hotel.getTotalAmount() + "\n\n"
    	             +"Total Food Amount: ₹" + food.getFoodAmount() +  "\n\n"
                    + "Thank you for booking with us!";
    	
        emailService.sendEmail(email, subject,body);
        
        model.addAttribute("email", email);
        return "success";
    }


}