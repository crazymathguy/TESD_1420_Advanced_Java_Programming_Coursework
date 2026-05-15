/**
 * Author: Sean Briggs
 * Date: 2026-05-15
 *
 * Description: Implements GenericQueue by extending LinkedList
 */

public class Exercise24_05 {
	public static void main(String[] args) {
		GenericQueue<Integer> queue = new GenericQueue<>();

		System.out.println(queue.toString());
		queue.enqueue(1);
		System.out.println(queue.toString());
		queue.enqueue(2);
		System.out.println(queue.toString());
		queue.enqueue(3);
		System.out.println(queue.toString());
		queue.enqueue(4);
		System.out.println(queue.toString());

		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
	}
}

class GenericQueue<E> extends java.util.LinkedList<E> {
	public void enqueue(E e) {
		addLast(e);
	}

	public E dequeue() {
		return removeFirst();
	}
}