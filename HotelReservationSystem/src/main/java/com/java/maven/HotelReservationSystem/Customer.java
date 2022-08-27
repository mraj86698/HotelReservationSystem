package com.java.maven.HotelReservationSystem;

public class Customer extends Hotel {

	public String custType;
	public int DaysStayed;
	public int bill;
	public int rateWeekday;
	public int rateWeekend;
	/**
	 * To Creating Parameterised Constructor
	 * @param hotelName
	 * @param DaysStayed
	 * @param bill
	 * super()- is a reference variable that is used to refer parent class constructors.
	 */

	public Customer(String hotelName,int DaysStayed, int bill) {
		super(hotelName);
		this.DaysStayed=DaysStayed;
		this.bill = bill;
	}
	/**
	 * Method for Displaying Bill Details
	 */
	public void showBill() {
		System.out.println("Hotel Found: "+hotelName);
		System.out.println("Days Stayed: "+DaysStayed);
		System.out.println("Total Bill: "+bill);
	}
	/**
	 * Getter Setter Method for cust_type,daysStayed and bill
	 * @return
	 */

	public String getCustType() {
		return custType;
	}

	public void setCustType(String type, Hotel hotel) {
		if (type=="regular") {
			this.custType="Regular";
			this.rateWeekday=hotel.rateWeekdayRegular;
			this.rateWeekendRegular=hotel.rateWeekendRegular;
		}
		else if(type=="reward") {
			this.custType="Reward";
			this.rateWeekday=hotel.rateWeekdayReward;
			this.rateWeekendReward=hotel.rateWeekendReward;
		}
	}


	public int getDaysStayed() {
		return DaysStayed;
	}

	public void setDaysStayed(int daysStayed) {
		DaysStayed = daysStayed;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
}