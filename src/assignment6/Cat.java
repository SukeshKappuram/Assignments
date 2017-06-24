package assignment6;

import java.util.Calendar;

public class Cat extends Pet implements Boardable{
	
	private String hairLength; 
	public Calendar startDate=Calendar.getInstance();
	public Calendar  endDate=Calendar.getInstance();
	
	public Cat(String name, String ownerName, String color, String hairLength){
		super(name, ownerName, color);
		this.hairLength=hairLength;
	} 

	@Override
	public void setBoardStart(int month, int day, int year) {
		// TODO Auto-generated method stub
		startDate.set(year, month, day);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		// TODO Auto-generated method stub
		endDate.set(year, month, day);
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		// TODO Auto-generated method stub
		Calendar boardDate=Calendar.getInstance();
		boardDate.set(year, month, day);
		if(boardDate.getTimeInMillis()>startDate.getTimeInMillis() && boardDate.getTimeInMillis()<endDate.getTimeInMillis()){
			return true;
		}
		return false;
	}

	public String getHairLength(){
		return hairLength;
	}
	public String toString(){
		return "CAT:\n"+super.toString()+"\nHair: "+getHairLength();
	} 

}
