package spell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SpellCorrectorTest {

    private SpellCorrector spell;

    @BeforeEach
    public void setUp() {
        spell = new SpellCorrector();
    }

    private void loadTestDictionary() {
        try {
            spell.useDictionary("test-dict.txt");
        } catch (IOException e) {
            Assertions.fail("Failed to load test dictionary");
        }
    }


    //      test suggestSimilarWord()

    @Test
    public void suggestFromEmptyDictionary() {
        String str = spell.suggestSimilarWord("hello");
        Assertions.assertNull(str);
    }

    @Test
    public void suggestFromEmptyWordEmptyDictionary() {
        String str = spell.suggestSimilarWord("");
        Assertions.assertNull(str);
    }

    @Test
    public void suggestFromEmptyWordNonemptyDictionary() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("");
        Assertions.assertNull(str);
    }

    @Test
    public void suggestFromCorrectlySpelledWord() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hello");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_FirstCharIsAnExtraChar() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hhello");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_ContainsAnExtraChar() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("heello");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_LastCharIsAnExtraChar() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("helloo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_FirstCharIsMissing() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("ello");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_MiddleCharIsMissing() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("helo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_LastCharIsMissing() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hell");
        // "hell" is not in the test dictionary. It's meant to be
        // a misspelling of "hello."
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_FirstCharIsDifferent() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("jello");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_MiddleCharIsDifferent() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("helpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_LastCharIsDifferent() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hellp");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_First2CharsSwapped() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("ehllo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_Middle2CharsSwapped() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hlelo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromOneError_Last2CharsSwapped() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("helol");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Addition_Addition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzekllo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Addition_Deletion() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzelo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Addition_Replacement() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hezlpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Addition_Transposition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hezlol");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Deletion_Addition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hllpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Deletion_Deletion() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hlo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Deletion_Replacement() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hlpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Deletion_Transposition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hlol");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Replacement_Addition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hallpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Replacement_Deletion() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hnll");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Replacement_Replacement() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hnlpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Replacement_Transposition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzlol");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Transposition_Addition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hlelko");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Transposition_Deletion() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("ehlo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Transposition_Replacement() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hlelk");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromTwoErrors_Transposition_Transposition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hleol");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromThreeErrors_Addition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzekllpo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromThreeErrors_Deletion() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzekll");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromThreeErrors_Replacement() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzekllp");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void suggestFromThreeErrors_Transposition() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hzeklol");
        Assertions.assertEquals("hello", str);
    }


    // Test input cleaning

    @Test
    public void cleanWithCapitalLetters() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hElLo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithPunctuationAndCapitalLetters() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("h!El?Lo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithFirstCharacterPunctuation() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("!hello");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithMiddleCharPunctuation() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hel?lo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithLastCharPunctuation() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hello.");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithAdjacentPunctuationMarks() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("hel()lo");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithManyPunctuationMarks() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("-h!e?l.l,o;");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithDoubleQuotationMarks() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("he\"ll\"o");
        Assertions.assertEquals("hello", str);
    }

    @Test
    public void cleanWithSingleQuotationMarks() {
        loadTestDictionary();
        String str = spell.suggestSimilarWord("he'll'o");
        Assertions.assertEquals("hello", str);
    }

}