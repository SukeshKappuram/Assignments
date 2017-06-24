package asst4Prob3;

public class GasTank {
	double amount;
	
	void addGas(double amount){
		this.amount+=amount;
	}
	void useGas(double amount){
		this.amount-=amount;
	}
	double getGasLevel(){
		return amount;
	}
}
class MainClass{
	public static void main(String[] arg) {
		GasTank g=new GasTank();
		g.addGas(40.5);
		g.useGas(32.8);
		System.out.println(g.getGasLevel());
	}
}
