package assingment5;

public class IceCream extends DessertItem{
	
	float cost;
	
	public IceCream(String name,float cost) {
		super(name);
		this.cost=cost;
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int)cost;
	}

}
