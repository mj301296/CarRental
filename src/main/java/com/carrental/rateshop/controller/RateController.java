package com.carrental.rateshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.rateshop.Rate;
import com.carrental.rateshop.service.RateService;


@RestController
@RequestMapping("rate")
public class RateController {
	@Autowired
	RateService rateService ;
	@GetMapping("allRates")
	public List<Rate> getAllRates() {
		
		return rateService.getAllRates();
	}

}
