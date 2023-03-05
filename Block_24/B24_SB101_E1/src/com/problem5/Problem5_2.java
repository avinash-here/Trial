package com.problem5;

public class Problem5_2 {
	
	public static void main(String[] args) {
		
		CheckCharacters check = new CheckCharacters() {			
			@Override
			public boolean containsChar(String s1, String s2) {				
				for(int i = 0; i < s2.length(); i++) {
					if(s1.indexOf(s2.charAt(i)) != -1) return true;
				}				
				return false;
			}
		};
		
		System.out.println(check.containsChar("MASAI", "PUT"));
		System.out.println(check.containsChar("JAHAN", "JOE"));
	}

}
