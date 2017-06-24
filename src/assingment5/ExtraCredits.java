package assingment5;

import java.util.ArrayList;
import java.util.List;

public class ExtraCredits {

	public void merge(int[] num1,int m,int[] num2,int n){
		int[] result=new int[m+n];
		int i,j,k,o=m+n;
		for(i=0;i<m;i++){
			result[i]=num1[i];
		}
		
		for(n=0;i<o;i++,n++){
			result[i]=num2[n];
		} 
		
		for (i = 0; i < o; ++i)
	    {
	        for (j = i + 1; j < o; ++j)
	        {
	            if (result[i] > result[j])
	            {
	                k =  result[i];
	                result[i] = result[j];
	                result[j] = k;
	            }
	        }
	    }
		num1=new int[o];
		num1=result;
		for(i=0;i<17;i++){
			System.out.print(num1[i]+" ");
		}
	}
	
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> lst=new ArrayList<>();
		int i, k = 0, l = 0,m=matrix.length,n=matrix[0].length;
		
	    while (k < m && l < n)
	    {
	        for (i = l; i < n; ++i)
	        {
	            lst.add(matrix[k][i]);
	        }
	        k++;
	 
	        for (i = k; i < m; ++i)
	        {
	        	lst.add(matrix[i][n-1]);
	        }
	        n--;
	 
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	            	lst.add(matrix[m-1][i]);
	            }
	            m--;
	        }
	 
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	            	lst.add(matrix[i][l]);
	            }
	            l++;    
	        }        
	    }
		return lst; 
	}
	public static void main(String[] arg){
		ExtraCredits ec=new ExtraCredits();
		int [] queue1 = {2,4,7,9,12,35,48,59};
	    int [] queue2 = {3,5,6,19,41,71,81,86,99};     
		ec.merge(queue1, 8, queue2, 9);
		
		System.out.println();
		
		int[][] nums=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		for(Integer i:ec.spiralOrder(nums)){
			System.out.print(i+" ");
		}
	} 
	
}



