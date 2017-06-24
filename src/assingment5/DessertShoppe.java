package assingment5;

public class DessertShoppe {

	public static final float TAX_RATE=6.5f;
	public static final String STORE="MY Desert Shoppe";
	public static final int ITEM_LENGTH=25;
	public static final int WIDTH=30;
	
	static String cent2DollarsAndCent(int cents){
		float cent2Dollars=cents/100.0f;
		return String.valueOf(cent2Dollars);
	}
}
