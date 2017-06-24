package asst4Prob3;

public class Driver {
	static boolean drive(Car c){
		return c.drive();
	}
	static void addGas(Car c,double amount){
		c.gasTank.addGas(amount);
	}
}
