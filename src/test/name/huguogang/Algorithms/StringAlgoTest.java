package test.name.huguogang.Algorithms;

import static name.huguogang.Algorithms.StringAlgo.*;
import static org.junit.Assert.assertEquals;
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
    public void reverseStringTest() {
        String in;
        String actual;
        String expected;
        
        in = "";
        expected = "";
        actual = reverseString(in);
        assertEquals(expected, actual);
        
        in = "123";
        expected = "123";
        actual = reverseString(in);
        assertEquals(expected, actual);
        
        in = "abc";
        expected = "cba";
        actual = reverseString(in);
        assertEquals(expected, actual);
        
        in = "123 abc";
        expected = "123 cba";
        actual = reverseString(in);
        assertEquals(expected, actual);
        
        in = "abc 123";
        expected = "cba 123";
        actual = reverseString(in);
        assertEquals(expected, actual);
        
        in = "I have  36 books, 40 pens2, and 1 notebook.";
        expected = "I evah  36 skoob, 40 2snep, dna 1 koobeton.";
        actual = reverseString(in);
        assertEquals(expected, actual);
        
        in = "I have  36 books, 40 pens2, and 1 notebook";
        expected = "I evah  36 skoob, 40 2snep, dna 1 koobeton";
        actual = reverseString(in);
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkString() {
        String a, b, c;
        boolean actual, expected;
        
        a = "ham";
        b = "shap";
        c = "hashmap";
        expected = true;
        actual = isInterleavingString(a, b, c);
        assertEquals(expected, actual);
    }
 
    @Test
    public void replaceSpaceTest() {
        char[] buffer;
        int len;
        String expected;
        String actual;
        
        buffer = new char[] {' ', 'a', ' ', 'c', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0};
        expected = "%20a%20c%20";
        len = replaceSpace(buffer);
        actual = new String(buffer, 0, len);
        assertEquals(expected, actual);
        
        buffer = new char[] {' ', 'a', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0, 0};
        expected = "%20a%20c";
        len = replaceSpace(buffer);
        actual = new String(buffer, 0, len);
        assertEquals(expected, actual);
        
        buffer = new char[] {'a', ' ', 'c', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0};
        expected = "a%20c%20";
        len = replaceSpace(buffer);
        actual = new String(buffer, 0, len);
        assertEquals(expected, actual);
        
        buffer = new char[] {'a', 'c', 0, 0, 0, 0, 0, 0, 0, 0, 0};
        expected = "ac";
        len = replaceSpace(buffer);
        actual = new String(buffer, 0, len);
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
