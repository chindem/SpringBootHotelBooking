package com.example.Biglots.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biglots.Repository.FoodRepo;
import com.example.Biglots.Repository.HotelRepo;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;



@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepo foodrepo;
    @Autowired
	private HotelRepo hotelRepos;
    
    
    @Autowired
    private HotelService hotelservice;
    
    



	@Override
	public void FoodHomePage(Food food) {
		// TODO Auto-generated method stub

		System.out.println("saving the food details");
		
		FoodType(food,null);
		
        

	}

	@Override
	public void FoodType(Food food ,Hotel hotel) {

		int foodAmount=0;
		int foodPrice =0;
		int foodAndHotelTotalAmount =0;

		//Hotel hotel =new Hotel();

		if (food.getTypeOfFood().equals("Breakfast")) {
			foodPrice = 129;
		} else if (food.getTypeOfFood().equals("Lunch")) {
			foodPrice = 499;
		} else if (food.getTypeOfFood().equals("Dinner")) {
			foodPrice = 599;
		}
		else if (food.getTypeOfFood().equals("DayPack")) {
			foodPrice = 799;
		}


		 foodAmount = foodPrice * food.getNoOfDaysToServeFood();
		    if (hotel != null) {
		        foodAndHotelTotalAmount = hotel.getTotalAmount()+ foodAmount;
		        hotel.setRoomAmount(foodAndHotelTotalAmount); // <--- only do this if hotel is not null
		    } else {
		        foodAndHotelTotalAmount = foodAmount; // Or handle as needed
		    }
		
		System.out.println("total food amount");
		food.setFoodAmount(foodAmount);
		food.setFoodPrice(foodPrice);
		food.setFoodAndHotelTotalAmount(foodAndHotelTotalAmount);
		//hotel.setRoomAmount(foodAndHotelTotalAmount);
		
		
		System.out.println("your total food charges are "+ foodAmount);
	}
}


