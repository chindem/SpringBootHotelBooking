package com.example.Biglots.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biglots.biglotEntity.Hotel;




@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

	



	

}
