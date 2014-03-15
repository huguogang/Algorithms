package name.huguogang.Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
     * words. For example, given s = “leetcode”, dict = ["leet", "code"].
     * 
     * Return true because “leetcode” can be segmented as “leet code”.
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
}