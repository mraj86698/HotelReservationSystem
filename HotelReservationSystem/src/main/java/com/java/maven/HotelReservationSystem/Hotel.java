package com.java.maven.HotelReservationSystem;

public class Hotel {

	public String hotelName;				//Obj Attributes
	public int rating;
	public int rateWeekdayRegular;
	public int rateWeekendRegular;
	public int rateWeekdayReward;
	public int rateWeekendReward;
	public int totalBill=0;


	/**
	 * Create a Parameterised Constructor
	 * @param hotelName
	 * @param rate_regular
	 */
	public Hotel(String hotelName, int rate_regular) {
		this.hotelName = hotelName;
		this.rateWeekdayRegular = rate_regular;
	}
	public Hotel(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * It Returns the value into String Format
	 */
	@Override
	public String toString() {
		return "Hotel  "+hotelName+" created";
	}

	public void addRating(int rating) {
		this.rating=rating;
		System.out.println("Rating "+rating+" stars added.");
	}
	public void addRewardRate(int rateWeekdayReward,int rateWeekendReward) {
		this.rateWeekdayReward=rateWeekdayReward;
		this.rateWeekendReward=rateWeekendReward;
		System.out.println("Reward Weekday/Weekend Rates Updated");
	}
	public int getRating() {
		return (-1)*rating;
	}

	public void display() {

		System.out.println("------------------------------------------------------");
		System.out.println("Hotel Name: "+hotelName);
		System.out.println("Regular Weekday Rate: "+rateWeekdayRegular);
		System.out.println("Regular Weekend Rate: "+rateWeekendRegular);
		System.out.println("Reward Weekday Rate: "+rateWeekdayReward);
		System.out.println("Reward Weekend Rate: "+rateWeekendReward);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setWeekendRates(int rateWeekend) {
		this.rateWeekendRegular=rateWeekend;
		System.out.println("Weekend Rates Updated");
	}

	public int getrateWeekdayRegular() {
		return rateWeekdayRegular;
	}

	public void setrateWeekdayRegular(int rate_regular) {
		this.rateWeekdayRegular = rate_regular;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	public int getTotalBill() {
		return totalBill;
	}


	public int getRateWeekdayReward() {
		return rateWeekdayReward;
	}
	public void setRateWeekdayReward(int rateWeekdayReward) {
		this.rateWeekdayReward = rateWeekdayReward;
	}
	public int getRateWeekendReward() {
		return rateWeekendReward;
	}
	public void setRateWeekendReward(int rateWeekendReward) {
		this.rateWeekendReward = rateWeekendReward;
	}

}
