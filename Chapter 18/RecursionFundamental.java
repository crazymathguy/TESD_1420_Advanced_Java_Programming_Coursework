import java.util.Scanner;

public class RecursionFundamental {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two integers to find the greatest common divisor.\n\t1st number: ");
		int m = input.nextInt();
		System.out.print("\t2nd number: ");
		int n = input.nextInt();
		input.close();

		System.out.println("The greatest common divisor of " + m + " and " + n + " is " + gcd(m, n) + ".");
	}

	public static int gcd(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return gcd(n, m % n);
		}
	}
}
