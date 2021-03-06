package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;

	public List<Hotel> showList(Integer price) {
		return repository.findByPrice(price);
	}

	public List<Hotel> showAll() {
		return repository.findAll();
	}

}
