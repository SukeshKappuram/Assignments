package Exam1;

import java.util.*;

public class Exam {
	
	public static void reverse(ArrayList<Integer> list) {
		int temp=list.size();
		for (int i=temp-1;i>=0;i--) {
			list.add(list.get(i));
		}
		for(int i=0;i<temp;i++){
			list.remove(0);
		}
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	public static String generateStrings(String string1,String string2){
		Set<String> sts=new TreeSet<String>();
		for(int i=0;i<string1.length();i++){
			for(int j=0;j<string2.length();j++){
				String st=String.valueOf(string1.charAt(i)+String.valueOf(string2.charAt(j)));
				sts.add(st);
			}
		}
		String st="";
		for (String string : sts) {
			st+=string+" ";
		}
		return st;
	}
	
	public static int singelNumber(int[] nums) {
		int result = 0;
		for (int a : nums)
		    result ^= a;
		return result;
	}
	
	public int[] twoSum(int[] nums,int target){
		for(int i=0;i<nums.length-1;i++){
			if((nums[i]+nums[i+1])==target){
				return new int[]{i,i+1};
			}
		}
		return new int[]{0};
	}
	
	public List<Integer> getRow(int rowIndex){
		List<ArrayList<Integer>> l=new ArrayList<>();
		ArrayList ls=new ArrayList<>();
		ls.add(1);
		l.add(ls);
		ls=new ArrayList<>();
		ls.add(1);ls.add(1);l.add(ls);
		ls=new ArrayList<>();
		ls.add(1);ls.add(2);ls.add(1);l.add(ls);
		ls=new ArrayList<>();
		ls.add(1);ls.add(3);ls.add(3);ls.add(1);l.add(ls);
		ls=new ArrayList<>();
		ls.add(1);ls.add(4);ls.add(6);ls.add(4);ls.add(1);l.add(ls);
		
		return l.get(rowIndex);
	}
	
	public static void main(String[] arg) {
		ArrayList<Integer> ls=new ArrayList<Integer>();
		ls.add(2);
		ls.add(3);
		ls.add(5);
		ls.add(8);
		Exam.reverse(ls);
		System.out.println(Exam.generateStrings("ACDC", "ABBA"));
		int[] x={2,2,5,4,5,6,4};
		System.out.println(Exam.singelNumber(x));
		ls=new ArrayList<>();
		Exam t=new Exam();
		ls.add(t.twoSum(x, 7)[0]);
		ls.add(t.twoSum(x, 7)[1]);
		System.out.println(ls);
		System.out.println(t.getRow(3));
	}
}
