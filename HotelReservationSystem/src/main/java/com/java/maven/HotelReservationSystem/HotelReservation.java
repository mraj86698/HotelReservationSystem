package com.java.maven.HotelReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {

	/**
	 * Global Scanner
	 */
	static Scanner sc=new Scanner(System.in);

	/**
	 * Creating global list of Hotel
	 */
	private static ArrayList<Hotel> hotelList;

	public HotelReservation() {
		hotelList = new ArrayList<Hotel>();
	}

	public void addToList(Hotel hotel) {
		hotelList.add(hotel);
	}
	/**
	 * Add Hotel for HotelName,RegularRate,CustomerType
	 * @param hotelName
	 * @param rate_regular
	 * @param cust_type
	 * @return
	 */
	public boolean addHotel(String hotelName, int rate_regular, String cust_type) {

		Hotel hotel = new Hotel(hotelName,rate_regular,cust_type);
		addToList(hotel);
		return true;
	}


	public boolean addHotel(String hotelName, int rate_regular) {

		Hotel hotel = new Hotel(hotelName,rate_regular,"regular");
		addToList(hotel);
		return true;
	}
	/**
	 * Display Hotel List
	 */
    public void display() {
		for (Hotel hotel:hotelList) {
			hotel.display();
		}
	}

	public static void main( String[] args )
    {

		/**
		 * Default Entries
		 */
    	HotelReservation obj = new HotelReservation();
    	obj.addHotel("Lakewood", 110);
    	obj.addHotel("Bridgewood", 160);
    	obj.addHotel("Ridgewood", 220);

        System.out.println( "Welcome to Hotel Reservation Program" );

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();

        System.out.println("Please add hotel.");
        System.out.println();
        System.out.print("Enter hotel name: ");
        String hotelName = sc.next();
        System.out.print("Enter regular rate of rooms: ");
        int rate_regular = sc.nextInt();

        obj.addHotel(hotelName, rate_regular);

        //Showing results
        obj.display();
    }
}
