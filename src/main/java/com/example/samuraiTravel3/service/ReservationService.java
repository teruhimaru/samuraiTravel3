package com.example.samuraiTravel3.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraiTravel3.entity.House;
import com.example.samuraiTravel3.entity.Reservation;
import com.example.samuraiTravel3.entity.User;
import com.example.samuraiTravel3.form.ReservationRegisterForm;
import com.example.samuraiTravel3.repository.HouseRepository;
import com.example.samuraiTravel3.repository.ReservationRepository;
import com.example.samuraiTravel3.repository.UserRepository;

@Service
public class ReservationService {
	private final HouseRepository houseRepository;
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;
	
	public ReservationService(HouseRepository houseRepository,
			ReservationRepository reservationRepository,
			UserRepository userRepository
			) {
		this.houseRepository = houseRepository;
		this.reservationRepository = reservationRepository;
		this.userRepository = userRepository;
		
	}
	
	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
	
	public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		int amount = price * (int)numberOfNights;
		return amount;
	}
	
	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		House house = houseRepository.getReferenceById(reservationRegisterForm.getHouseId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
		LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());
		
		reservation.setHouse(house);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
		reservation.setAmount(reservationRegisterForm.getAmount());
		
		reservationRepository.save(reservation);
	}
	
}
