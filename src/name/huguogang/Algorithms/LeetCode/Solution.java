package name.huguogang.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * TODO: tree in/post/pre order using stack
 * TODO: tree in/post/pre order using morris
 * TODO: (strStr) Rabin-Karp algorithm, KMP algorithm, and the Boyer- Moore algorithm
 * 
 * @author ghu
 *
 */
@SuppressWarnings("unused")
public class Solution {

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
     * 
     * For example, given the array [2,3,-2,4],
     * the contiguous subarray [2,3] has the largest product = 6.
     * 
     * @param A
     * @return
     */
    public int maxProduct(int[] A) {
        // analysis:
        // * 0 is a breaker, no max can cross it? except when 0 itself is the max
        // * even number of negative numbers will product positive product
        throw new NotImplementedException();
    }

    /**
     * Binary Tree Inorder Traversal
     * 
     * Iterative version, using stack
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        throw new NotImplementedException();
    }

    /**
     * Candy
     * 
     * There are N children standing in a line. Each child is assigned a rating value.
     * 
     * You are giving candies to these children subjected to the following requirements:
     * 
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     * What is the minimum candies you must give?
     * 
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        // * all the valley bottoms (child on both sides have higher ratings) must be 1
        // * peak's candy is same as max(left, right)
        // * if neighbors ratings are the same, their candy count are the same
        throw new NotImplementedException();
    }

    /**
     * Excel Sheet Column Title
     * 
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     * 
     * For example:
     * 
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * 
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            char c = (char) ((n - 1) % 26 + 'A');
            result = c + result;
            n = (int) Math.floor((n - 1) / 26);
        }
        return result;
    }

    /**
     * Compare Version Numbers
     * 
     * Compare two version numbers version1 and version1.
     * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
     * 
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision
     * of the second first-level revision.
     * 
     * Here is an example of version numbers ordering:
     * 
     * 0.1 < 1.1 < 1.2 < 13.37
     * 
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        // notice split take a regex, need to escape "."
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.min(v1.length, v2.length);
        for (int i = 0; i < len; ++i) {
            int ver1 = strToInt(v1[i]);
            int ver2 = strToInt(v2[i]);
            if (ver1 > ver2) {
                return 1;
            }
            else if (ver1 < ver2) {
                return -1;
            }
        }
        // equal so far
        if (v1.length == v2.length) {
            return 0;
        }
        else {
            for (int i = len; i < v1.length; ++i) {
                int ver1 = strToInt(v1[i]);

                if (ver1 > 0) {
                    return 1;
                }
            }
            for (int i = len; i < v2.length; ++i) {
                int ver2 = strToInt(v2[i]);

                if (ver2 > 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private int strToInt(String s) {
        int ret = 0;
        for (char c : s.toCharArray()) {
            ret = ret * 10 + (c - '0');
        }
        return ret;
    }

    /**
     * Maximum Gap
     * 
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
     * 
     * Try to solve it in linear time/space.
     * 
     * Return 0 if the array contains less than 2 elements.
     * 
     * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
     * 
     * @param num
     * @return
     */
    public int maximumGap(int[] num) {
        throw new NotImplementedException();
    }
}