package project2;


	import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

	public class Util {


	    public static String read(String filePath) throws Exception{

	        File file = new File(filePath);
	        FileInputStream fileInputStream = new FileInputStream(file);
	        Integer available = fileInputStream.available();
	        byte b[] = new byte[available];
	        fileInputStream.read(b);
	        fileInputStream.close();
	        return new String(b);

	    }
            
            public static void main(String[] arg){
                try {
                   String msg=read("data/gmps-bresee");
                   String[] splits=msg.split("\n");
                   for(String s:splits){
                       StringTokenizer st=new StringTokenizer(s,"~");
                       while(st.hasMoreTokens()){
                           System.out.print(st.nextToken()+"====");
                       }
                       System.out.println();
                   }
                } catch (Exception ex) {
                }
            }

	    public static void write(String filePath,String contentToWrite) throws Exception {

	        File file = new File(filePath);
	        FileWriter fileWriter = new FileWriter(file,true);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	        bufferedWriter.write("\n"+contentToWrite);
	        bufferedWriter.close();

	    }

	    public static void addVehicleToFile(String filePath, Vehicle vehicle, Dealer dealer) throws Exception{

	        String vehicleDetails = vehicle.getId()+ "~"+ "gmps-"+ dealer.getName()+ "~"+ vehicle.toString();
	        write(filePath,vehicleDetails);

	    }

	    public static void deleteVehicleFromFile(String filePath, Vehicle vehicle) throws Exception{

	        File file = new File(filePath);
	        File temporaryFile = new File(file.getAbsolutePath()+".tmp");

	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        FileWriter fileWriter = new FileWriter(temporaryFile);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	        String line;

	        while ((line= bufferedReader.readLine())!=null){

	            if(line.contains(vehicle.getId())){
	                continue;
	            }
	            bufferedWriter.write(line+"\n");
	        }

	        bufferedReader.close();
	        bufferedWriter.close();
	        file.delete();
	        temporaryFile.renameTo(file);
	    }


	}



