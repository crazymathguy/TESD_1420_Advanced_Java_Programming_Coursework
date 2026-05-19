/**
 * Author: Sean Briggs
 * Date: 2026-05-19
 * 
 * Description: Search for the maximum consecutive increasingly ordered substring in a string
 * 
 * Time complexity analysis of maxSubstring():
 * 	length of string is n
 * 	loop runs n times
 * 	each loop iteration runs in constant time
 * 	T(n) of loop is n * O(1) = O(n)
 * 	last check runs in constant time
 * 	T(n) of maxSubstring() is O(n) + O(1) = O(n)
 * Time complexity: O(n)
 */

import java.util.Scanner;

public class Exercise22_01 {
	public static void main(String[] args) throws Exception {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter a string: ");
			String message = input.next();
			System.out.println("Maximum consecutive substring is " + maxSubstring(message));
		}
	}

	public static String maxSubstring(String message) {
		int lastStart = 0;
		int lastLength = 0;
		int currentStart = 0;
		int currentLength = 1;
		for (int i = 1; i < message.length(); i++) {
			if (message.charAt(i) <= message.charAt(i - 1)) {
				if (currentLength > lastLength) {
					lastLength = currentLength;
					lastStart = currentStart;
				}
				currentStart = i;
				currentLength = 0;
			}
			currentLength++;
		}
		if (currentLength > lastLength) {
			lastLength = currentLength;
			lastStart = currentStart;
		}
		return message.substring(lastStart, lastStart + lastLength);
	}
}
