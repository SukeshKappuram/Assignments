package assessment4;


public class Customer {
	int id;
	String name;
	String mailId;
	String mobileNo;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int id, String name, String mailId, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
	}

	Book[] cart;
	
	void purchaseBooks(Book[] books){ //test case 1
		cart=books;
	}
	
	
	public float totalPrice(){ //test case 2
		float total=0;
		for(int i=0;i<cart.length;i++){
			if(cart[i]!=null){
				total+=cart[i].price;
			}
		}
		
		return total;
	}
	
	
	public static void main(String[] arg){
		Customer c=new Customer();
		
		//System.out.println(totalPrice);
	}
}
