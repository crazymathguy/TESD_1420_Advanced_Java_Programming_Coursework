/*
Author: Sean Briggs
Date: 2026-05-08

Description: Remove duplicates from an ArrayList using generics
 */
import java.util.ArrayList;

public class Exercise19_03 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);
		list.add(25);
		list.add(25);
		
		ArrayList<Integer> newList = removeDuplicates(list);
		
		System.out.print(newList);
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<E>();

		for (int i = 0; i < list.size(); i++) {
			boolean match = false;
			for (int j = 0; j < newList.size(); j++) {
				if (list.get(i) == newList.get(j)) {
					match = true;
				}
			}
			if (!match) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}
}