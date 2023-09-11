package spell;

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
        // TODO implement findInSet()
        return;
    }

}
