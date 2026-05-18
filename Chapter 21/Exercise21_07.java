/**
 * Author: Sean Briggs
 * Date: 2026-05-18
 * 
 * Description: Sort word occurences in text in ascending order
 */

import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a HashMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();
		ArrayList<WordOccurence> occurences = new ArrayList<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (String word : words) {
			String key = word.toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		map.forEach((k, v) -> occurences.add(new WordOccurence(k, v)));
		Collections.sort(occurences);

		occurences.forEach(o -> System.out.println(o.getWord() + "\t" + o.getCount()));
	}
}

class WordOccurence implements Comparable<WordOccurence> {
	private final String word;
	private final int count;

    public WordOccurence(String word, int count) {
		this.word = word;
		this.count = count;
    }

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int compareTo(WordOccurence other) {
		return count - other.getCount();
	}
}