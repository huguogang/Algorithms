package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import static name.huguogang.Algorithms.Misc.*;

public class MiscTest {
    @Test
    public void inPlaceSwapTest() {
        int a = 100;
        int b = 30;
        inPlaceSwap(a, b);
    }
    
    @Test
    public void reverseStringTest() {
        StringBuffer in = new StringBuffer("I'm OK");
        reverseString(in);
        assertEquals("KO m'I", in.toString());
    }
    
    @Test
    public void atoiTest() {
        String in;
        int expected;

        in = "";
        expected = 0;
        assertEquals(expected, atoi(in));

        in = "  +2344i";
        expected = 2344;
        assertEquals(expected, atoi(in));
        System.out.println(atoi(in));

        in = "-100.003";
        expected = -100;
        assertEquals(expected, atoi(in));

        in = "+-09994";
        expected = 0;
        assertEquals(expected, atoi(in));

        in = null;
        expected = 0;
        assertEquals(expected, atoi(in));

        in = "      ";
        expected = 0;
        assertEquals(expected, atoi(in));

        in = "      -";
        expected = 0;
        assertEquals(expected, atoi(in));
    }
    
    @Test
    public void isSubstringTest() {
        String str, pattern;

        str = "I can do it";
        pattern = "n do ";
        assertTrue(pattern, isSubstring(str, pattern));

        //str = "I can do it";
        pattern = "can di";
        assertFalse(pattern, isSubstring(str, pattern));
        
        pattern = "";
        assertTrue(pattern, isSubstring(str, pattern));
    }
    
    @Test
    public void find2CharSubStringTest() {
        String in, expected;
        
        in = "aabacccaba";
        expected = "accca";
        assertEquals(expected, find2CharSubString(in));
        
        in = "";
        expected = "";
        assertEquals(expected, find2CharSubString(in));
        
        in = "ababaaabbbbbaa";
        expected = "ababaaabbbbbaa";
        assertEquals(expected, find2CharSubString(in));
        
        in = "aaaaaaaa";
        expected = "aaaaaaaa";
        assertEquals(expected, find2CharSubString(in));
        
        in = "abcdefghijklasvbdsfsfsfsfsfwiasdfasdadsasdjljljds";
        expected = "sfsfsfsfsf";
        assertEquals(expected, find2CharSubString(in));
    }
    
    @Test
    public void findSquareTest() {
        int a, b, expected;
        
        a = -1;
        b = 100;
        expected = 0;
        assertEquals(expected, findSquare(a, b));
        
        a = 7;
        b = 8;
        expected = -1;
        assertEquals(expected, findSquare(a, b));
        
        a = -2;
        b = -1;
        expected = -1;
        assertEquals(expected, findSquare(a, b));
        
        a = 1;
        b = 100;
        expected = 1;
        assertEquals(expected, findSquare(a, b));
    }
    
    @Test
    public void findMinRangeTest() {
        int[][] series;
        int expected;
        int actual;
        
        series = new int[][] {
                {2, 3, 5, 10, 11},
                {1, 2, 3, 4, 5, 6},
                {9, 18, 30}
        };
        actual = findMinRange(series);
        expected = 4;
        assertEquals(expected, actual);
    }
}
