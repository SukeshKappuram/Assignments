package assignment6;

public class TestClass {
	public static void main(String[] arg){
		Cat c=new Cat("Tom", "Bob", "black" , "short");
		c.setSex(Pet.SPAYED);
		System.out.println(c.toString());
		c.setBoardStart(2, 1, 2017);
		c.setBoardEnd(2, 15, 2017);
		System.out.println("Is Boarding "+c.boarding(2, 10, 2017));
		System.out.println("Is Boarding "+c.boarding(2, 20, 2017));
		
		Dog d=new Dog("Spot", "Susan", "black and white" , "Medium");
		d.setSex(Pet.MALE);
		System.out.println(d.toString());
		d.setBoardStart(2, 13, 2017);
		d.setBoardEnd(2, 29, 2017);
		System.out.println("Is Boarding "+d.boarding(2, 5, 2017));
		System.out.println("Is Boarding "+d.boarding(2, 23, 2017));
	}
}
