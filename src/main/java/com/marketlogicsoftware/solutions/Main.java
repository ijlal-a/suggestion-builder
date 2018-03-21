package com.marketlogicsoftware.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// set of stop words
		Set<String> stopWords = new HashSet<String>();
		for (String s : Arrays.asList("is", "a", "can", "the")) {
			stopWords.add(s.toLowerCase());
		}

		// Token stream
		List<String> tokens = Arrays.asList("The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I",
				"like", "chewing", "gum", ".");

		// MAX_COMBINED_TOKENS
		int macCombinedToken = 3;

		SuggestionBuilder sb = new SuggestionBuilder(stopWords, macCombinedToken);
		List<String> suggestions = sb.buildSugestion(tokens);

		for(String s: suggestions) {
			System.out.println(s);
		}

	}

}
