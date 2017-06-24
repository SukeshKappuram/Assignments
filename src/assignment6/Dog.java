package assignment6;

import java.util.Calendar;

public class Dog extends Pet implements Boardable {
	private String size;
	public Calendar startDate=Calendar.getInstance();
	public Calendar  endDate=Calendar.getInstance();
	
	public Dog (String name, String ownerName, String color, String size){
		super(name, ownerName, color);
		this.size=size;
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
	
	public String getSize(){
		return size;
	}
	public String toString(){
		return "DOG:\n"+super.toString()+"\nSize: "+getSize();
	} 

}
