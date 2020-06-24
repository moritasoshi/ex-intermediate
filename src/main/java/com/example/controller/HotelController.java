package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService service;

	@ModelAttribute
	public HotelForm setUp() {
		return new HotelForm();
	}

	@RequestMapping("")
	public String index() {
		return "hotel/input";
	}

	@RequestMapping("/search")
	public String toDetail(@Validated HotelForm hotelForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "hotel/input";
		}
		if (hotelForm.getPrice() == "") {
			model.addAttribute("hotelList", service.showAll());
		} else {
			model.addAttribute("hotelList", service.showList(hotelForm.getIntPrice()));
		}
		return index();
	}
}
