package mypackage;

public class MyMainClass {
	public static void main(String[] arg)
	{
		MyThirdClass m=new MyThirdClass();
		m.display();
	}
}
interface MyFirstClass{
	void display();
	
}
interface MySecondClass{
	void display();
}
class MyThirdClass implements MySecondClass,MyFirstClass{
	public void display(){
		System.out.println("Hi i am Third Display");
	}
}
