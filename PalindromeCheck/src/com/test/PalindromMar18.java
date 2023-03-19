package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromMar18 {

	public static void main(String[] args) {
		String input = "INDIA IS MY COUNTRY, MY MOMDADYDADMOM SPEAK MALAYALAMFGH";
		List<String> strList = Arrays.asList(input.split(" "));
		List<String> outList = strList.stream().map(str -> palindromCheck(str)).filter(a -> a.length() > 1)
				.collect(Collectors.toList());
		System.out.println("Output string val... "+Collections.max(outList));
	}
	
	private static String palindromCheck(String input) {
		int n = input.length();
		if(n < 2) {
		  return input;
		}
		
		int maxLength = 1;
		int start = 0;
		int low;
		int high; 
		
		for(int i = 0 ; i < n ; i++) {			
			low = i - 1;
			high = i + 1;
			
			while(high < n && input.charAt(high) == input.charAt(i)) {
			  high++;	
			}
			
			while(low >= 0 && input.charAt(low) == input.charAt(i)) {
			  low--;	
			}
			
			while(low >= 0 && high < n && input.charAt(low) == input.charAt(high)) {
			  high++;
			  low--;	
			}
			
			int length = high - low - 1;
			if(maxLength < length) {
				maxLength = length;
				start = low +1;
			}
			
		}		
		return input.substring(start, start + maxLength);
	}

}
