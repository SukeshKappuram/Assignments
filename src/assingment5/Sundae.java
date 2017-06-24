package assingment5;

public class Sundae extends IceCream{

	float toppingCost;
	
	public Sundae(String name,float cost,float toppingCost) {
		super(name,cost);
		this.toppingCost=toppingCost;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int)(super.getCost()+toppingCost);
	}
}
