package com.example.samuraiTravel3.form;

import lombok.Data;

@Data
public class ReservationRegisterForm {
	private Integer houseId;
	private Integer userId;
	private String checkinDate;
	private String checkoutDate;
	private Integer numberOfPeople;
	private Integer amount;
}
