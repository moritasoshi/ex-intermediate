package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {
	@Autowired
	private ClothesService service;

	@RequestMapping("")
	public String index() {
		return "clothes/clothes";
	}
	
	@RequestMapping("/search")
	public String search(Integer gender, String color, Model model) {
		model.addAttribute("clothesList", service.findByGenderAndColor(gender, color));
		return "clothes/clothes";
	}
	
}
