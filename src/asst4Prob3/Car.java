package asst4Prob3;

public class Car {
	int modelNum;
	String modelName;
	String color;
	GasTank gasTank;
	
	
	public Car(int modelNum, String modelName, String color) {
		super();
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.color = color;
	}


	public int getModelNum() {
		return modelNum;
	}


	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	boolean drive(){
		if(gasTank.getGasLevel()>0){
			System.out.println("Car has Started");
			return true;
		}else{
			System.out.println("Car has very low gas level please fill");
			return false;
		}
		
	}
}
