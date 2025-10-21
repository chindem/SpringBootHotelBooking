package com.example.Biglots.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biglots.biglotEntity.Billing;

@Repository
public interface BillingRepo extends JpaRepository<Billing, Integer> {

}
