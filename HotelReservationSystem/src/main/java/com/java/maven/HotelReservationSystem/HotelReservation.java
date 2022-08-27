package com.java.maven.HotelReservationSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	public boolean addHotel(String hotelName, int rateWeekdayRegular,int rateWeekendRegular,int rateWeekdayReward,int rateWeekendReward, int rating) {

		Hotel hotel = new Hotel(hotelName,rateWeekdayRegular);
		hotel.setWeekendRates(rateWeekendRegular);
		hotel.addRewardRate(rateWeekdayReward, rateWeekendReward);
		hotel.addRating(rating);
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


	public Date[] stringDateConvereter(String start_date, String end_date) {
		try {
			Date dateArr[]=new Date[2];
			dateArr[0]= new SimpleDateFormat("DD.MM.yyyy").parse(start_date);
			dateArr[1]= new SimpleDateFormat("DD.MM.yyyy").parse(end_date);
			return dateArr;
		}catch(ParseException exception){
			exception.printStackTrace();
		}
		return null;
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
	public int daysRented(Date startDate, Date endDate) {

		long time_diff = startDate.getTime() - endDate.getTime();
		return (int) (1+(time_diff / (1000 * 60 * 60 * 24)));
	}
	public int[] checkWeekdayWeekend(Date startDate, Date endDate) {

		//Converting to cal
		int weekArr[] = {0,0};
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		if (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}else System.out.println("Incorrect format.");
		do {
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				weekArr[0]++;
			}else weekArr[1]++;
			startCal.add(Calendar.DAY_OF_MONTH, 1);
		} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());
		return weekArr;
	}
	public Customer bestRatedHotel(String type,String start_date, String end_date) {

		Customer cust=new Customer("", 0, 0);
		Date dateArr[]=stringDateConvereter(start_date, end_date);
		Date startDate= dateArr[0];
		Date endDate= dateArr[1];

		int daysStayed=daysRented(startDate, endDate);
		int noOfWeekdays=checkWeekdayWeekend(startDate, endDate)[0];
		int noOfWeekends=checkWeekdayWeekend(startDate, endDate)[1];
		for(Hotel hotel: hotelList) {
			cust.setCustType(type, hotel);
			int totalBill = noOfWeekdays*cust.rateWeekday+noOfWeekends*cust.rateWeekend;
			cust.setCustType(type, hotel);
			hotel.totalBill=totalBill;
		}

		Optional<Hotel> cheapestHotelOpt = hotelList.stream().max((Comparator
				.comparingInt(Hotel::getRating))
				);

		Hotel cheapestHotel = cheapestHotelOpt.get();
		cust.bill=cheapestHotel.totalBill;
		cust.setHotelName(cheapestHotel.hotelName);
		cust.setDaysStayed(daysStayed);

		return cust;
	}
	/**
	 * Ability to find the Cheapest Hotel for given date range
	 * @param start_date
	 * @param end_date
	 * @return
	 */

	public Customer findCheapestHotel(String type,String start_date, String end_date) {

		Customer cust=new Customer("", 0, 0);
		Date dateArr[]=stringDateConvereter(start_date, end_date);
		Date startDate= dateArr[0];
		Date endDate= dateArr[1];

		int daysStayed=daysRented(startDate, endDate);
		int noOfWeekdays=checkWeekdayWeekend(startDate, endDate)[0];
		int noOfWeekends=checkWeekdayWeekend(startDate, endDate)[1];

		for(Hotel hotel: hotelList) {
			cust.setCustType(type, hotel);
			int totalBill = noOfWeekdays*cust.rateWeekday+noOfWeekends*cust.rateWeekend;
			cust.setCustType(type, hotel);
			hotel.totalBill=totalBill;
		}

		Optional<Hotel> cheapestHotelOpt = hotelList.stream().min((Comparator.comparingInt(
				Hotel::getTotalBill)
				.thenComparing(Hotel::getRating))
				);

		Hotel cheapestHotel = cheapestHotelOpt.get();
		cust.bill=cheapestHotel.totalBill;
		cust.setHotelName(cheapestHotel.hotelName);
		cust.setDaysStayed(daysStayed);

		return cust;
	}


	public static void main(String[] args) {

		/**
		 * Default Entries Weekly and WeekEnd Rates per day
		 */
		HotelReservation obj = new HotelReservation();
		obj.addHotel("Lakewood", 110,90,80,80,3);
		obj.addHotel("Bridgewood", 160,50,110,50,4);
		obj.addHotel("Ridgewood", 220,150,100,40,5);
		while(true) {

			System.out.println( "Welcome to Hotel Reservation Program" );

			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println();

			System.out.println("What do you want to do?");
			System.out.println("1. Add Hotel Entry.");
			System.out.println("2. Find Cheapest Hotel.");
			System.out.println("3. Find Best Rated Hotel.");
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
				System.out.print("Enter Weekend rate of rooms: ");
				int rateWeekendRegular = sc.nextInt();
				System.out.print("Enter reward Weekday rate of rooms: ");
				int rateWeekdayReward = sc.nextInt();
				System.out.print("Enter reward Weekend rate of rooms: ");
				int rateWeekendReward = sc.nextInt();
				System.out.print("Enter Rating of Hotel: ");
				int rating = sc.nextInt();

				obj.addHotel(hotelName, rateWeekdayRegular, rateWeekendReward,rateWeekdayRegular,rateWeekendReward, rating);
				break;
			}
			case "2": {
				System.out.println("Please enter Customer Type-Reward/Regular");
				String type = sc.next().toLowerCase();
				System.out.println("Enter date range to find hotel in format(DD.MM.yyyy)");
				System.out.println("Enter Check-In date: ");
				String start_date = sc.next();
				System.out.println("Enter Check-Out date: ");
				String end_date = sc.next();
				Customer cust = obj.findCheapestHotel(type,start_date,end_date);

				cust.showBill();
				break;
			}
			case "3": {
				System.out.println("Please enter Customer Type-Reward/Regular");
				String type = sc.next().toLowerCase();
				System.out.println("Enter date range to find hotel in format(DD.MM.yyyy)");
				System.out.println("Enter Check-In date: ");
				String start_date = sc.next();
				System.out.println("Enter Check-Out date: ");
				String end_date = sc.next();
				Customer cust = obj.bestRatedHotel(type,start_date,end_date);

				cust.showBill();
				break;
			}
			default:
				System.out.println("Unknown input.");
			}
		}
	}
}
