/**
 * Author: Sean Briggs
 * Date: 2026-05-18
 * 
 * Description: State capital guessing game using a map
 */

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise21_09 {
	public static void main(String[] args) {
		Map<String, String> stateCapital = Stream.of(new String[][] {
			{"Alabama", "Montgomery"},
			{"Alaska", "Juneau"},
			{"Arizona", "Phoenix"},
			{"Arkansas", "Little Rock"},
			{"California", "Sacramento"},
			{"Colorado", "Denver"},
			{"Connecticut", "Hartford"},
			{"Delaware", "Dover"},
			{"Florida", "Tallahassee"},
			{"Georgia", "Atlanta"},
			{"Hawaii", "Honolulu"},
			{"Idaho", "Boise"},
			{"Illinois", "Springfield"},
			{"Indiana", "Indianapolis"},
			{"Iowa", "Des Moines"},
			{"Kansas", "Topeka"},
			{"Kentucky", "Frankfort"},
			{"Louisiana", "Baton Rouge"},
			{"Maine", "Augusta"},
			{"Maryland", "Annapolis"},
			{"Massachusettes", "Boston"},
			{"Michigan", "Lansing"},
			{"Minnesota", "Saint Paul"},
			{"Mississippi", "Jackson"},
			{"Missouri", "Jefferson City"},
			{"Montana", "Helena"},
			{"Nebraska", "Lincoln"},
			{"Nevada", "Carson City"},
			{"New Hampshire", "Concord"},
			{"New Jersey", "Trenton"},
			{"New York", "Albany"},
			{"New Mexico", "Santa Fe"},
			{"North Carolina", "Raleigh"},
			{"North Dakota", "Bismarck"},
			{"Ohio", "Columbus"},
			{"Oklahoma", "Oklahoma City"},
			{"Oregon", "Salem"},
			{"Pennsylvania", "Harrisburg"},
			{"Rhode Island", "Providence"},
			{"South Carolina", "Columbia"},
			{"South Dakota", "Pierre"},
			{"Tennessee", "Nashville"},
			{"Texas", "Austin"},
			{"Utah", "Salt Lake City"},
			{"Vermont", "Montpelier"},
			{"Virginia", "Richmond"},
			{"Washington", "Olympia"},
			{"West Virginia", "Charleston"},
			{"Wisconsin", "Madison"},
			{"Wyoming", "Cheyenne"}
		}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

		try (Scanner input = new Scanner(System.in)) {
			int correctCount = 0;

			for (Map.Entry<String, String> entry : stateCapital.entrySet()) {
				// Prompt the user with a question
				System.out.print("What is the capital of " + entry.getKey() + "? ");
				String capital = input.nextLine().trim().toLowerCase();
				
				if (capital.toLowerCase().equals(entry.getValue().toLowerCase())) {
					System.out.println("Your answer is correct");
					correctCount++;
				}
				else
					System.out.println("The correct answer should be " + entry.getValue());
			}

			System.out.println("The correct count is " + correctCount);
		}
	}
}
