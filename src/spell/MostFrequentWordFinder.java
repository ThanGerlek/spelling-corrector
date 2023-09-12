package spell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MostFrequentWordFinder {
    private String closestWord = null;
    private Dictionary dictionary;

    public MostFrequentWordFinder(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean foundWord() {
        return closestWord != null;
    }

    public String getWord() {
        return closestWord;
    }

    public void findInSet(Set<String> potentialWords) {
        Set<String> realWords = getRealWords(potentialWords);
        if (realWords.size() == 0) {
            closestWord = null;
        } else {
            closestWord = getMostFrequentWord(realWords);
        }
    }

    private Set<String> getRealWords(Set<String> potentialWords) {
        Set<String> realWords = new HashSet<>();
        for (String word : potentialWords) {
            if (dictionary.containsWord(word)) {
                realWords.add(word);
            }
        }
        return realWords;
    }

    private String getMostFrequentWord(Set<String> words) {

        ArrayList<String> currentWinners = new ArrayList<>();
        int currentHighestCount = 0;

        for (String word : words) {
            int count = dictionary.getFrequencyCount(word);
            if (count > currentHighestCount) {
                currentWinners.clear();
                currentWinners.add(word);
                currentHighestCount = count;
            } else if (count == currentHighestCount) {
                currentWinners.add(word);
            }
        }

        return getFirstAlphabetically(currentWinners);
    }

    private String getFirstAlphabetically(ArrayList<String> words) {
        if (words.size() == 1) {
            return words.get(0);
        }
        String currentBest = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            if (words.get(i).compareTo(currentBest) < 0) {
                currentBest = words.get(i);
            }
        }
        return currentBest;
    }
}
