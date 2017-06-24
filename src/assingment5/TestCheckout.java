package assingment5;

import java.util.*;

public class TestCheckout {
	public static void main(String[] arg) {
		Checkout c=new Checkout();
		c.enterItem(new IceCream("Strawberry Ice Cream",145));
		c.enterItem(new Sundae("Caramel Sundae with Vanilla Ice Cream",145,10));
		c.enterItem(new Candy("Gummy Worms", 1.33f,89f));
		c.enterItem(new Cookie("Chocolate Chip Cookies", 4,399));
		c.enterItem(new Candy("Salt Water Taffy", 1.50f,209));
		c.enterItem(new Candy("Candy Corn", 3.00f,109));
		System.out.println(c.toString());
	}
}