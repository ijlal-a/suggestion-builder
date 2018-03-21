package com.marketlogicsoftware.solutions;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SuggestionBuilderTest {

	@Test
	public void testBuildSugestion() {
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

		assertTrue(suggestions.size() == 15);

		for (String s : Arrays.asList("beautiful", "beautiful girl", "beautiful girl from", "girl", "girl from", "from",
				"farmers", "farmers market", "market", "like", "like chewing", "like chewing gum", "chewing",
				"chewing gum", "gum")) {
			assertTrue(suggestions.contains(s));
		}

	}

}
