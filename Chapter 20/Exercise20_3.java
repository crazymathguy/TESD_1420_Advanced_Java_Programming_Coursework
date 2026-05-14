/**
 * Author: Sean Briggs
 * Date: 2026-05-14
 * 
 * Description: State capitals guessing game
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise20_3 {
	public static void main(String[] args) {
		String[][] capitalsList = {
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
		};
		ArrayList<String[]> stateCapitals = new ArrayList<>(List.of(capitalsList));
		Collections.shuffle(stateCapitals);

		int correctCount;
		try (Scanner input = new Scanner(System.in)) {
			correctCount = 0;
			for (String[] stateCapital : stateCapitals) {
				// Prompt the user with a question
				System.out.print("What is the capital of " + stateCapital[0] + "? ");
				String capital = input.nextLine().trim().toLowerCase();
				
				if (capital.toLowerCase().equals(stateCapital[1].toLowerCase())) {
					System.out.println("Your answer is correct");
					correctCount++;
				}
				else {
					System.out.println("The correct answer should be " + stateCapital[1]);
				}
			}
		}

		System.out.println("The correct count is " + correctCount);
	}
}
