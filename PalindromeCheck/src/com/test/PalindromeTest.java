package com.test;

public class PalindromeTest {

	public static void main(String[] args) {
		String f1 = "1";
		String f2 = "1";
		System.out.println("f1 equals f2.."+f1.equals(f2));
		System.out.println("f1 == f2.."+f1==f2);
		String input = "ABC MALAYALAM EFDADU RUDADFEFDADUR. DAD IS THE BEST ABCDEFGGFEDCBA";
		palCheck(input);
	}

	private static void palCheck(String input) {
		int n = input.length();
		
		int maxLen = 1;
		int start = 0;
		int high;
		int low;
		
		for(int i = 0; i < n ; i++) {
			high = i+1;
			low = i-1;
			
			while(high < n && input.charAt(high) == input.charAt(i)) {
				high++;
			}
			while(low >= 0 && input.charAt(low) == input.charAt(i)) {
				low--;
			}
			while(low >= 0 && high < n && input.charAt(high) == input.charAt(low)) {
				high++;
				low--;
			}
			
			int len = high - low - 1;
			if(maxLen < len) {
				maxLen = len;
				start = low + 1;
			}
		}
		 System.out.println("Output is "+input.substring(start, start+maxLen));
	}
}
