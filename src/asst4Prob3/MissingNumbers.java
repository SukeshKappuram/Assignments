package asst4Prob3;

import java.util.Arrays;

public class MissingNumbers {
	public static void missingNumber(int[] arr){
		int num=arr[0];
		for(int i=0;i<arr.length;i++,num++){
			if(arr[i]!=num){
				System.out.println(num);
			}
		}
	}
	public static void main(String[] ar){
		int[] ary=new int[]{2,4,2,3,1};
		//MissingNumbers.missingNumber(ary);
		//MissingNumbers.moveZeros(ary);
		System.out.println(MissingNumbers.thirdMax(ary));
	}
	
	public static void moveZeros(int[] arr){
		int count=0,temp;
		for(int i=0;i<arr.length-2;i++){
			if(arr[i]==0){
				count++;
				if(arr[i+1]!=0){
					arr[i]=arr[i+1];
					arr[i+1]=0;
					count--;
				}
				else{
					temp=arr[i];
					arr[i]=arr[i+2];
					arr[i+2]=temp;
				}
			}
		}
		for(int j=0;j<arr.length;j++){
			System.out.println(arr[j]);
		}
	}
	public static int thirdMax(int[] arr){
		int i, j,n=1,max;

		for(i=1; i< arr.length; i++){

		   for(j=0; j< n ; j++)
		   {

		      if(arr[i] == arr[j])
		      break;
		   }

		  if (j==n )
		      arr[n++] = arr[i];
		}
		
		max=arr[0];				//2,4,3,1
		if(n<3 && (arr[1]>max)){   //2 element
			max=arr[1];
		}
		
		if(n>=3){
		int a;  // Sort 
		
		for (i = 0; i < n; ++i)
	    {
	        for (j = i + 1; j < n; ++j)
	        {
	            if (arr[i] > arr[j])
	            {
	                a =  arr[i];
	                arr[i] = arr[j];
	                arr[j] = a;
	            }
	        }
	    }
		
		
		max=arr[n-3];
		}
		return max;
	}
}

//remove Duplicates
//check length of array
//return max or 3 max
	


