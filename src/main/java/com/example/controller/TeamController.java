package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

@Controller
@RequestMapping("/baseball")
public class TeamController {
	@Autowired
	private TeamService service;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("teamList", service.showList());
		return "baseball/list";
	}

	@RequestMapping("/to-detail")
	public String toDetail(Integer id, Model model) {
		model.addAttribute("team", service.showDetail(id));
		return "baseball/detail";
	}
}
