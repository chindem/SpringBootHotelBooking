package com.example.Biglots.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biglots.biglotEntity.Food;



@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

}
