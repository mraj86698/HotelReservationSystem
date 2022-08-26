package com.java.maven.HotelReservationSystem;

public class Hotel {

	public String hotelName;
	public int rate_regular;
	public String cust_type="regular";
	//Constructor
	public Hotel(String hotelName, int rate_regular, String cust_type) {
		this.hotelName = hotelName;
		this.rate_regular = rate_regular;
		this.cust_type = cust_type;
	}

	@Override
	public String toString() {
		return "Hotel Object "+hotelName+" created";
	}

	public void display() {

		System.out.println("------------------------------------------------------");
		System.out.println("Hotel Name: "+hotelName);
		System.out.println("Regular Rate: "+rate_regular);
		System.out.println("Customer Type: "+cust_type);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
}
