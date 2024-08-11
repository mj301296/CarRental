package com.carrental.rateshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.rateshop.Rate;
import com.carrental.rateshop.dao.RateDao;

@Service
public class RateService {
	
	
	@Autowired
	RateDao rateDao;

	public List<Rate> getAllRates() {
		return rateDao.findAll();
	}

}
