package com.carrental.rateshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrental.rateshop.Rate;

public interface RateDao extends JpaRepository<Rate, String> {

	

}
