package com.example.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.ClothesForm;
import com.example.service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {
	@Autowired
	private ClothesService service;
	
	@ModelAttribute
	public ClothesForm setUp() {
		return new ClothesForm();
	}

	@RequestMapping("")
	public String index(Model model) {
		Map<Integer, String> genderMap = new HashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		Map<String, String> colorMap = new LinkedHashMap<>();
		colorMap.put("赤", "赤");
		colorMap.put("青", "青");
		colorMap.put("白", "白");
		colorMap.put("黄", "黄");
		model.addAttribute("genderMap", genderMap);
		model.addAttribute("colorMap", colorMap);
		return "clothes/clothes";
	}

	@RequestMapping("/search")
	public String search(ClothesForm clothesForm, Model model) {
		model.addAttribute("clothesForm", clothesForm);
		model.addAttribute("clothesList",
				service.findByGenderAndColor(clothesForm.getGender(), clothesForm.getColor()));
		return index(model);
	}

}
