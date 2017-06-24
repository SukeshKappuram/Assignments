package assingment5;

public abstract class DessertItem {
	private String name;
	
	public DessertItem() {
		// TODO Auto-generated constructor stub
	}
	
	public DessertItem(String name){
		this.name=name;
	}
	
	public final String getName(){
		return name;
	}
	
	public abstract int getCost();
}
