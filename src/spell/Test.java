package spell;

import java.io.IOException;

/**
 * A simple test class for running the spelling corrector.
 */
public class Test {

    /**
     * Give the dictionary file name as the first argument and the word to correct
     * as the second argument.
     */
    public static void main(String[] args) throws IOException {

        Trie trie = new Trie();
        trie.add("hello");
        trie.add("help");
        trie.add("help");
        trie.add("helper");


        return;

//		String dictionaryFileName = args[0];
//		String inputWord = args[1];
//
//		ISpellCorrector corrector = new SpellCorrector();
//
//		corrector.useDictionary(dictionaryFileName);
//		String suggestion = corrector.suggestSimilarWord(inputWord);
//		if (suggestion == null) {
//		    suggestion = "No similar word found";
//		}
//
//		System.out.println("Suggestion is: " + suggestion);
    }

}
