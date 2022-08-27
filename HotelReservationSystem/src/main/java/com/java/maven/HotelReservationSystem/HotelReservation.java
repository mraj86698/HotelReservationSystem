package com.java.maven.HotelReservationSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class HotelReservation {

	/**
	 * Global Scanner
	 */
	static Scanner sc = new Scanner(System.in);

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
	 * Ability to  add WeekDay and each WeekEnd Rates for each Hotel
	 *
	 * @param hotelName
	 * @param rate_regular
	 * @return
	 */
	public boolean addHotel(String hotelName, int rateWeekdayRegular,int rateWeekendRegular) {

		Hotel hotel = new Hotel(hotelName,rateWeekdayRegular);
		hotel.setWeekendRates(rateWeekendRegular);
		addToList(hotel);
		return true;
	}

	/**
	 * Display Hotel List
	 */
	public void display() {
		for (Hotel hotel : hotelList) {
			hotel.display();
		}
	}
	/**
	 * getTime() method, representing the number of milliseconds since January 1st 1970, 00:00
	 * 1000 is used here just for converting seconds to milliseconds.
	 * Number of seconds in a day = 24 * 60 * 60 = 86400 seconds.
	 * So after calculating the expression, the result is in milliseconds.
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int daysRented(String start_date, String end_date) {

		try {
			Date startDate = new SimpleDateFormat("DD.MM.yyyy").parse(start_date);
			Date endDate = new SimpleDateFormat("DD.MM.yyyy").parse(end_date);
			long time_diff = startDate.getTime() - endDate.getTime();
			return (int) (2 + (time_diff / (1000 * 60 * 60 * 24)));
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	/**
	 * Ability to find the Cheapest Hotel for given date range
	 * Input:10/09/2020,Output:11
	 * @param start_date
	 * @param end_date
	 * @return
	 */

	public Customer findCheapestHotel(String start_date, String end_date) {

		int daysStayed = daysRented(start_date, end_date);
		Optional<Hotel> cheapestHotelOpt = hotelList.stream()
				.min(Comparator.comparing(Hotel::getrateWeekdayRegular));

		Hotel cheapestHotel = cheapestHotelOpt.get();
		int bill = daysStayed * cheapestHotel.getrateWeekdayRegular();

		return new Customer(cheapestHotel.hotelName, daysStayed, bill);
	}

	public static void main(String[] args) {

		/**
		 * Default Entries Weekly and WeekEnd Rates per day
		 */
		HotelReservation obj = new HotelReservation();
		obj.addHotel("Lakewood", 110,90);
		obj.addHotel("Bridgewood", 160,50);
		obj.addHotel("Ridgewood", 220,150);
		while(true) {

		 System.out.println( "Welcome to Hotel Reservation Program" );

	        System.out.println();
	        System.out.println("------------------------------------------------------");
	        System.out.println();

	        System.out.println("What do you want to do?");
	        System.out.println("1. Add Hotel Entry.");
	        System.out.println("2. Find Cheapest Hotel.");
	        String user_input=sc.next();

	        //Initializing main program
	        switch(user_input) {

	        case "1": {
	        	System.out.println("Please add hotel.");
	            System.out.println();
	            System.out.print("Enter hotel name: ");
	            String hotelName = sc.next();
	            System.out.print("Enter regular rate of rooms: ");
	            int rateWeekdayRegular = sc.nextInt();
	            System.out.print("Enter WeekDay rate of rooms: ");
	            int rateWeekday = sc.nextInt();
	            System.out.print("Enter Weekend rate of rooms: ");
	            int rateWeekendRegular = sc.nextInt();

	            obj.addHotel(hotelName, rateWeekdayRegular,rateWeekendRegular);
	            if(true)
	            	System.out.println("Added Hotel");
	            else
	            	System.out.println("Invalid value");
	            break;
	        }
	        case "2": {
	        	System.out.println("Enter date range to find hotel in format(DD.MM.yyyy)");
	            System.out.println("Enter Check-In date: ");
	            String start_date = sc.next();
	            System.out.println("Enter Check-Out date: ");
	            String end_date = sc.next();
	            Customer cust = obj.findCheapestHotel(start_date,end_date);

	            cust.showBill();
	            break;
	        }
	        default:
	        	System.out.println("Unknown input.");
	        }
	    }
	}
}
