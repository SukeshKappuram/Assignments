package assingment5;

public class Candy extends DessertItem{
	
	float weight;
	float price;
	
	public Candy(String name,float weight,float price) {
		super(weight+" lbs. @ "+DessertShoppe.cent2DollarsAndCent((int)price)+" /lb. "+name);
		this.weight=weight;
		this.price=price;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int)(weight*price);
	}

}
