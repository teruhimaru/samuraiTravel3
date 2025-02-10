package com.example.samuraiTravel3.service;

import org.springframework.stereotype.Service;

import com.example.samuraiTravel3.entity.House;
import com.example.samuraiTravel3.form.HouseRegisterForm;
import com.example.samuraiTravel3.repository.HouseRepository;

@Service
public class HouseService {
	private HouseRepository houseRepository;
	
	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}
	
	public void create(HouseRegisterForm houseRegisterForm) {
		House house = new House();
		house.setName(houseRegisterForm.getName());
		house.setImageName(houseRegisterForm.getImageFile());
		house.setDescription(houseRegisterForm.getDescription());
		house.setPrice(houseRegisterForm.getPrice());
		house.setCapacity(houseRegisterForm.getCapacity());
		house.setPostalCode(houseRegisterForm.getPostalCode());
		house.setAddress(houseRegisterForm.getAddress());
		house.setPhoneNumber(houseRegisterForm.getPhoneNumber());
		
		houseRepository.save(house);
	}
}
