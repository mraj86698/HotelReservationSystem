package com.java.maven.HotelReservationSystem;

public class Customer extends Hotel {

	public String cust_type="regular";
	public int DaysStayed;
	public int bill;

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

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
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