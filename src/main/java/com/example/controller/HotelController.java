package com.example.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService service;

	@RequestMapping("")
	public String index() {
		return "hotel/input";
	}

	@RequestMapping("/search")
	public String toDetail(Integer price, Model model) {
		if (Objects.isNull(price)) {
			model.addAttribute("hotelList", service.showAll());
		} else {
			model.addAttribute("hotelList", service.showList(price));
		}
		return index();
	}
}
