package com.example.Biglots.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biglots.Repository.FoodRepo;
import com.example.Biglots.Repository.HotelRepo;
import com.example.Biglots.biglotEntity.Food;
import com.example.Biglots.biglotEntity.Hotel;


@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepo hotelRepos;
	
	
	

	@Override
	public void HotelHomePage(Hotel hotel) {
		// TODO Auto-generated method stub
		System.out.println("Saving hotel booking detail from service class");
		RoomType(hotel,null);
		System.out.println();
		hotelRepos.save(hotel);
	}

	@Override
	public void RoomType(Hotel hotel, Food food) {
		// TODO Auto-generated method stub

		int roomPrice = 0; // Initialize
		int roomAmount = 0; // Initialize
		int roomRent = 0;
		 int totalAmount = 0;

		if (hotel.getTypeOfRoom().equals("Standard")) {
			roomPrice = 2500;
		} else if (hotel.getTypeOfRoom().equals("Deluxe")) {
			roomPrice = 3500;
		} else if (hotel.getTypeOfRoom().equals("Cottage")) {
			roomPrice = 5500;
		}

		
			roomAmount = roomPrice * hotel.getNoOfDaysofStay();
			
			totalAmount = roomAmount*1;
			hotel.setRoomAmount(roomAmount);
			hotel.setRoomPrice(roomPrice);
			hotel.setTotalAmount(totalAmount);
			System.out.println("room Price"+roomPrice+"total charge for hotel " + roomAmount);

	}

}

	

	
