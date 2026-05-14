/*
Author: Sean Briggs
Date: 2026-05-14

Description: Sort a list of geometric objects using the selection sort algorithm
*/
import java.util.Comparator;

public class Exercise20_21 {
	public static void main(String[] args) {
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};

		/* Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
			new Circle(5), new Circle(6), new Circle(1), new Circle(2),
			new Circle(3), new Circle(14), new Circle(12)}; */
		selectionSort(list, new GeometricObjectComparator());
		for (GeometricObject shape : list) {
			System.out.println(shape.getArea() + " ");
		}
	}

	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		for (int i = 0; i < list.length - 1; i++) {
			E minItem = list[i];
			int minItemIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (comparator.compare(list[j], minItem) < 0) {
					minItem = list[j];
					minItemIndex = j;
				}
			}
			list[minItemIndex] = list[i];
			list[i] = minItem;
		}
	}
}