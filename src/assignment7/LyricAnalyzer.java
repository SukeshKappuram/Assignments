package assignment7;

import java.io.*;
import java.util.*;

public class LyricAnalyzer {
	public static void add(HashMap<String,ArrayList<Integer>> map, String lyricWord, int wordPosition) {
		ArrayList<Integer> l;
		if(map.containsKey(lyricWord)){
			l=map.get(lyricWord);
			l.add(wordPosition);
		}
		else{
			l=new ArrayList<Integer>();
			l.add(wordPosition);
			map.put(lyricWord,l);
		}
	}
	
	public static void displayWords(HashMap<String, ArrayList<Integer>> map){
		List<String> ts=new ArrayList<>(map.keySet());
		Collections.sort(ts);
		for(String t:ts){
			System.out.println(t+": "+Arrays.toString(map.get(t).toArray()).replace("[", "").replace("]", ""));
		}
	}
	
	public static void displayLyrics(HashMap<String, ArrayList<Integer>> map){
		int size = 0;
		for(String s:map.keySet()){size+=map.get(s).size();}
		String[] str=new String[size+1];
		for(String s:map.keySet()){
			ArrayList<Integer> l=map.get(s);
			for(int i:l){
				if(i>0){str[i]=s+" ";}
				else{str[-i]=s+"\n";}
			}
		}
		for(String s:str){
			if(s!=null)
				System.out.print(s);
		}
		System.out.println();
	}
	
	public static int count(HashMap<String, ArrayList<Integer>> map) {
		return map.size();
	}
	
	public static String mostFrequentWord(HashMap<String, ArrayList<Integer>> map) {
		int max=0;
		String x="";
		for(String s:map.keySet()){
			if(max<map.get(s).size()){
				max=map.get(s).size();
				x=s;
			}
		}
		return x;
	}
	
	public static void main(String[] args) throws Exception {
		HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
		int position = 1;  //word position index start from 1
		String pathname = "D:/Dump/test1.txt"; 
		File f = new File(pathname); 
		BufferedReader br = new BufferedReader(new InputStreamReader (new 
		FileInputStream(f))); 
		String line = ""; 
		while (true) { 
			line = br.readLine(); 
			if (line == null || line.length() == 0) { 
				break;
			}
			String[] arr = line.trim().split(" "); 
			
			for (int i = 0; i < arr.length; i++) {
				if (i != arr.length - 1) {
					add(map, arr[i].toUpperCase(), position++); 
					} 
				else { 
					add(map, arr[i].toUpperCase(), (-1) * position); 
					position++; 
				}
			} 

		}
		br.close(); 
		displayLyrics(map); 
		displayWords(map); 
		System.out.println(); 
		System.out.println("The number of unique words in the lyric is: " + count(map));
		System.out.println();
		System.out.println("Most frequent word: " + mostFrequentWord(map));
	}
}
