/**
 * Author: Sean Briggs
 * Date: 2026-05-19
 * 
 * Description: Finds the first index of a substring
 * 
 * Time complexity analysis of indexOfSubstring():
 * 	length of string is n
 * 	loop runs n times
 * 	main.charAt(), substring.charAt(), and substring.length() run in constant time
 * 	therefore each iteration of the loop runs in constant time
 * 	T(n) of loop is n * O(1) = O(n)
 * Time complexity of indexOfSubstring(): O(n)
 */

import java.util.Scanner;

public class Exercise22_03 {
	public static void main(String[] args) throws Exception {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter a string s1: ");
			String s1 = input.nextLine();
			System.out.print("Enter a string s2: ");
			String s2 = input.nextLine();
			System.out.println("matched at index " + indexOfSubstring(s1, s2));
		}
	}

	public static int indexOfSubstring(String main, String substring) {
		if (substring.length() == 0) return -1;
		int index = 0;
		int substringIndex = 0;
		for (int i = 0; i <= main.length(); i++) {
			if (main.charAt(i) == substring.charAt(substringIndex)) {
				substringIndex++;
				if (substringIndex == substring.length()) {
					return index;
				}
			}
			else {
				substringIndex = 0;
				index = i + 1;
			}
		}
		return -1;
	}
}
