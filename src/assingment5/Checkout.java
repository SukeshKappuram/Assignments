package assingment5;

import java.util.*;

public class Checkout {

	int totalCost=0;
	Set<DessertItem> items=new HashSet<>();
	
	public Checkout() {
		// TODO Auto-generated constructor stub
	}
	
	public int numberOfItems(){
		return items.size();
	}
	
	public void enterItem(DessertItem dessertItem){
		items.add(dessertItem);
	}
	
	public void clear(){
		items.clear();
	}
	
	public int totalCost(){
		totalCost=0;
		for(DessertItem d:items){
			totalCost+=d.getCost();
		}
		return totalCost;
	}
	
	public int totalTax(){
		float f=totalCost()*(DessertShoppe.TAX_RATE/100);
		return (int)f;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		

		StringBuilder sb = new StringBuilder(500);

		int len=DessertShoppe.WIDTH-DessertShoppe.STORE.length();
		len/=2;
		len+=DessertShoppe.STORE.length();
		sb.append(String.format("%"+len+"s",DessertShoppe.STORE)).append("\n");
		String u="";
		for(int i=0;i<DessertShoppe.STORE.length();i++){
			u+="-";
		}
		sb.append(String.format("%"+len+"s",u));
		for(DessertItem d:items){
			String str="";
			if(d.getName().length()<=DessertShoppe.ITEM_LENGTH){
				str=String.format("%-"+DessertShoppe.ITEM_LENGTH+"s", "\n"+d.getName());
			}
			else{
				int i=0,k=d.getName().length(),j=0;
				do{
					j=i+DessertShoppe.ITEM_LENGTH;
					j=(j>k)?k:i+DessertShoppe.ITEM_LENGTH;
					int l=j-1;
					if(d.getName().charAt(l)==' '){
						str+=String.format("%-"+DessertShoppe.ITEM_LENGTH+"s", "\n"+d.getName().substring(i,j));
						i+=DessertShoppe.ITEM_LENGTH;
					}else if(j!=k){
						String s=d.getName().substring(i,j);
						j=s.lastIndexOf(' ');
						
						str+=String.format("%-"+DessertShoppe.ITEM_LENGTH+"s", "\n"+d.getName().substring(i,j));
						i+=j+1;
					}else{
						str+=String.format("%-"+DessertShoppe.ITEM_LENGTH+"s", "\n"+d.getName().substring(i,j));
					}
					
				}while(j<d.getName().length());
			}
			str+=String.format("%5s", DessertShoppe.cent2DollarsAndCent(d.getCost()));
			sb.append(str);
		}
		sb.append(String.format("%-"+DessertShoppe.ITEM_LENGTH+"s","\nTax"));
		sb.append(String.format("%5s",DessertShoppe.cent2DollarsAndCent(totalTax())));
		sb.append(String.format("%-"+DessertShoppe.ITEM_LENGTH+"s","\nTotal Cost"));
		sb.append(String.format("%5s",DessertShoppe.cent2DollarsAndCent(totalCost()+totalTax())));
		
		
		 
		 return sb.toString();
	}
}
