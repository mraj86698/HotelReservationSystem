package com.java.maven.HotelReservationSystem;

public class Hotel {

	public String hotelName;
	public int rate_regular;

	/**
	 * Create a Parameterised Constructor
	 * @param hotelName
	 * @param rate_regular
	 */
	public Hotel(String hotelName, int rate_regular) {
		this.hotelName = hotelName;
		this.rate_regular = rate_regular;
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

	public void display() {

		System.out.println("------------------------------------------------------");
		System.out.println("Hotel Name: "+hotelName);
		System.out.println("Regular Rate: "+rate_regular);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRate_regular() {
		return rate_regular;
	}

	public void setRate_regular(int rate_regular) {
		this.rate_regular = rate_regular;
	}
}
