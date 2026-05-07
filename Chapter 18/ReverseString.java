import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to reverse: ");
		String s = input.nextLine();
		input.close();

		System.out.println(reverseDisplay(s));
	}

	public static String reverseDisplay(String value) {
		if (value.length() == 1) {
			return value;
		} else {
			return reverseDisplay(value.substring(1, value.length())) + value.charAt(0);
		}
	}
}
