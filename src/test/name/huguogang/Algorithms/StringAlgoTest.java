package test.name.huguogang.Algorithms;

import static name.huguogang.Algorithms.StringAlgo.anagrams;
import static name.huguogang.Algorithms.StringAlgo.wordBreak;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

public class StringAlgoTest {

    @Test
    public void wordBreakTest() {
        String[] dictionary = {"leet", "code", "test", "cat", "cats", "and", "sand", "dog", "dogs", "tree", "lee"};
        String s;
        boolean expected;
        boolean actual;
        
        s = "leetcode";
        actual = wordBreak(s, dictionary);
        expected = true;
        assertEquals(expected, actual);
        
        s = "leet";
        actual = wordBreak(s, dictionary);
        expected = true;
        assertEquals(expected, actual);
        
        s = "leetworld";
        actual = wordBreak(s, dictionary);
        expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void anagramTest() {
        String[] strings = {};
        Collection<Collection<String>> result;
        
        strings = new String[]{"leet", "tea", "eat", "ate", "dormitory", "pea", 
                "ape", "top", "spot", "stop", "pot", "pots"};
        result = anagrams(strings);
        dumpAnagrams(result);
        assertEquals(6, result.size());
    }
    
    private void dumpAnagrams(Collection<Collection<String>> groups) {
        for(Collection<String> group : groups) {
            for(String s : group) {
                System.out.print(s + "    ");
            }
            System.out.print("\r\n");
        }
    }
}
