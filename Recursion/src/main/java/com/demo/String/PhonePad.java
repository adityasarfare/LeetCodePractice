package com.demo.String;

import java.util.ArrayList;

public class PhonePad {

	public static void main(String[] args) {
		
//		pad("", "12");
		
//		ArrayList<String>  n = padArrayList();
		System.out.println(padArrayList("", "12"));
		
		System.out.println(padCount("", "12"));
	}
	
	static void pad(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return ;
		}
		
		
		int digit= up.charAt(0) -'0';
		
		for(int i=(digit -1)*3; i<(digit*3); i++) {
			
			char ch= (char)('a'+i);
			
			pad(p+ch, up.substring(1));
		}
	}
	
	static ArrayList<String> padArrayList(String p, String up) {
		if(up.isEmpty()) {

	         ArrayList<String> list = new ArrayList<>();
	           list.add(p);
				return list ;
			}
		
		int digit= up.charAt(0) - '0';
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=(digit -1)*3; i<digit*3; i++) {
			
			char ch= (char)('a' + i);
			
			list.addAll(padArrayList(p+ ch, up.substring(1)));
			
		} 
		return list;
	}
	
	
	static int padCount(String p, String up) {
		if(up.isEmpty()){
				return 1 ;
			}
		
		int digit= up.charAt(0) - '0';
		
		int count=0;
		
		for(int i=(digit -1)*3; i<digit*3; i++) {
			
			char ch= (char)('a' + i);
			
			 count = count + (padCount(p+ ch, up.substring(1)));
			
		} 
		return count;
	}
}
