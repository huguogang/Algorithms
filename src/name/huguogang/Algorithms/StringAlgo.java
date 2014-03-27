package name.huguogang.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * String manipulation
 * 
 * @author ghu
 * 
 */
public class StringAlgo {
    /**
     * Given a string s and a dictionary of words dict, determine if s can be
     * segmented into a space-separated sequence of one or more dictionary
     * words. For example, given s = "leetcode", dict = ["leet", "code"].
     * 
     * Return true because "leetcode" can be segmented as "leet code".
     * 
     * @param s
     * @param dict
     * @return
     */
    public static boolean wordBreak(String s, String[] dictionary) {
        HashSet<String> dict = new HashSet<String>();
        for(String word : dictionary) {
            dict.add(word);
        }
        return wordBreakDP(s, dict);
    }
    
    private static boolean wordBreakDP(String s, HashSet<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        dp[0] = true;
        for (int i = 1; i <= len; i++)
            for (int j = 1; j <= i; j++) {
                if (dp[i - j] && (dict.contains(s.substring(i - j, i)))) {
                    dp[i] = true;
                    break;
                }
            }
        return dp[len];
    }
    
    /**
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you can not use additional data structures?
     * 
     * @param s
     * @return
     */
    public static boolean hasDuplicates1(String s) {
        //time O(n), space O(1) (because number of chars are capped at 256 for ASCII)
        HashSet<Character> lookup = new HashSet<Character>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(lookup.contains(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Implement an algorithm to determine if a string has all unique characters. 
     * What if you can not use additional data structures?
     * 
     * @param s
     * @return
     */
    public static boolean hasDuplicates2(String s) {
        //time O(n^2), space O(1)
        //other solutions: 
        //  - inplace quick sort + linear scan Time: O(n log n), Space: 0
        //  - a 256 bit array serve as hashmap, O(1) storage, O(n) time
        int len = s.length();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Check if two strings are anagram (same character set)
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isAnagram(String s1, String s2) {
       throw new NotImplementedException(); 
    }
    
    /**
     * Check if a string is palindrome
     * 
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
       int len = str.length();
       for(int i = 0; i < len / 2; i++) {
           if(str.charAt(i) != str.charAt(len - i - 1)) {
               return false;
           }
       }
       return true;
    }
    
    /**
     * // Input  -> "I have  36 books, 40 pens2, and 1 notebook."
     * // Output -> "I evah  36 skoob, 40 2snep, dna 1 koobeton."
     * 
     * @param in
     * @return
     */
    public static String reverseString(String in) {
        //assumptions: non alpha-numerics are word breakers
        int len = in.length();
        char[] buffer = new char[len];
        //starting location for a potential string reverse
        int headLoc = 0;
        boolean isNumber = true; //all chars from headLoc to current loc are numbers
        for(int i = 0; i < len; i++) {
            char c = in.charAt(i);
            buffer[i] = c;
            boolean numeric = (c >= '0' && c <= '9');
            
            if(isNumber && numeric) {
                continue;
            }
            
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || numeric) {
                isNumber = false;
                continue;
            }
            
            //word break
            if(!isNumber) {
                reverseSub(buffer, headLoc, i - 1);
            }
            isNumber = true;
            headLoc = i + 1;
        }
        //might need to reverse the last word
        if(!isNumber) {
            reverseSub(buffer, headLoc, len - 1);
        }
        
        return new String(buffer);
    }
    
    private static void reverseSub(char[] arr, int start, int end) {
        while(start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    
    /**
     * Given s1; s2; s3, find whether s3 is formed by the interleaving of s1 and s2.
     * For example, Given: s1 = ”aabcc”, s2 = ”dbbca”,
     * When s3 = ”aadbbcbcac”, return true.
     * When s3 = ”aadbbbaccc”, return false.
     *  e.g.
     *    s1: ham, s2: shap, s3: hashmap, return true  
     * 
     * @param a
     * @param b
     * @param c
     * 
     * @return
     */
    public static boolean isInterleavingString(String a, String b, String c) {
        throw new NotImplementedException();
    }
    
    /**
     * replace all space with "%20" and return the string lenth
     * 
     * @param str
     * @return
     */
    public static int replaceSpace(char[] str) {
        int bufferLen = str.length;
        int newLen = 0;
        int strLen = 0;
        int spaceCount = 0;
        
        for(char c : str) {
            if(c == ' ') {
                spaceCount++;
            }
            else if(c == 0) {
                break;
            }
            strLen++;
        }
        newLen = strLen + 2 * spaceCount;
        
        if(newLen > bufferLen) {
            throw new IllegalArgumentException("Buffer too small");
        }
        
        int idx = strLen - 1;
        for(int i = newLen - 1; i > 0;) {
            char c = str[idx--];
            if(c == ' ') {
                str[i--] = '0';
                str[i--] = '2';
                str[i--] = '%';
            }
            else {
                str[i--] = c;
            }
        }
        return newLen;
    }
    
    /**
     * Given an array of strings, return all groups of strings that are anagrams.
     * Note: All inputs will be in lower-case.
     * 
     * @param strs
     * @return
     */
    public static Collection<Collection<String>> anagrams(String[] strs) {
        HashMap<String, Collection<String>> map = new HashMap<String, Collection<String>>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String anaRoot = new String(chars);
            ArrayList<String> anagrams;
            if((anagrams = (ArrayList<String>) map.get(anaRoot)) == null) {
                anagrams = new ArrayList<String>();
                map.put(anaRoot, anagrams);
            }
            anagrams.add(s);
        }
        return map.values();
    }
}
