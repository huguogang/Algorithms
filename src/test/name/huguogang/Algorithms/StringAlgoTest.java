package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static name.huguogang.Algorithms.StringAlgo.*;

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

}
