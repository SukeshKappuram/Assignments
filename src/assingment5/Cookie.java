package assingment5;

public class Cookie extends DessertItem{
	
	int noOfCookies;
	float price;
	
	public Cookie(String name,int noOfCookies,float price) {
		super(noOfCookies+" @ "+DessertShoppe.cent2DollarsAndCent((int)price)+" /dz.   "+name);
		this.noOfCookies=noOfCookies;
		this.price=price;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return (int)(noOfCookies*(price/12));
	}

}
