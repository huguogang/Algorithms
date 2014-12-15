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
}