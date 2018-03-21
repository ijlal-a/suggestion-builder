package com.marketlogicsoftware.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author Ijlal Ansari
 *
 */
public class SuggestionBuilder {

	private int maxCombinedToken;
	private static final String SPACE = " ";
	private Set stopWords;

	public SuggestionBuilder(Set stopWords, int maxCombinedToken) {
		this.stopWords = stopWords;
		this.maxCombinedToken = maxCombinedToken;
	}

	public List<String> buildSugestion(List<String> tokens) {

		List<String> suggestionList = new ArrayList<String>();

		for (int i = 0; i < tokens.size(); i++) {
			if (isStopWord(tokens.get(i)) || isSingleChar(tokens.get(i))) {
				continue;
			} else {
				String suggestion = "";
				int suggestionLength = 0;

				for (int j = 0; suggestionLength < maxCombinedToken && i + j < tokens.size(); j++) {
					if (isStopWord(tokens.get(i + j)) || isSingleChar(tokens.get(i + j))) {
						break;
					} else {
						suggestion = suggestion + SPACE + tokens.get(i + j);
						suggestionLength++;
						suggestionList.add(suggestion.trim());
					}
				}
			}
		}

		return suggestionList;

	}

	private boolean isStopWord(String token) {
		return this.stopWords.contains(token.toLowerCase());
	}

	private boolean isSingleChar(String token) {
		return token.length() == 1;
	}

	

}
