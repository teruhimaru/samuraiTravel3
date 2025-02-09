package com.example.samuraiTravel3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.samuraiTravel3.entity.House;
import com.example.samuraiTravel3.repository.HouseRepository;

@Controller
@RequestMapping("/admin/houses")
public class AdminHouseController {
	private final HouseRepository houseRepository;
	
	public AdminHouseController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}
	
	@GetMapping
	public String index(Model model) {
		List<House> houses = houseRepository.findAll();
		
		model.addAttribute("houses", houses);
		return "admin/houses/index";
	}
}
