package asst4Prob3;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class MyTestCase {

	@Test
	public void test() {
		Car c=new Car(1102,"XUV","Brown");
		Assert.assertTrue(c.color=="Brown"); //4
		
		Driver d=new Driver();
		c.gasTank=new GasTank();
		
		
		
		d.addGas(c, 40.5);  
		Assert.assertTrue(Driver.drive(c)==true);
		c.gasTank.useGas(32.5);
		Assert.assertTrue(c.gasTank.getGasLevel()==8.0);
	}

}
