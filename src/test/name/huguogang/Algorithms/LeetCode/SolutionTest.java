package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.*;
import static test.name.huguogang.Algorithms.LeetCode.Util.printArray;
import static test.name.huguogang.Algorithms.LeetCode.Util.printLinkedList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printTreeByLevel;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListArray;
import static test.name.huguogang.Algorithms.LeetCode.Util.printMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import name.huguogang.Algorithms.LeetCode.*;
import name.huguogang.Algorithms.LeetCode.*;
import name.huguogang.Algorithms.LeetCode.Solution.BSTIterator;

@SuppressWarnings("unused")
public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void testMaxProduct() {
        int[] A;
        int ret, expected;

        A = new int[] { 2, 3, -2, 4 };
        expected = 6;
        ret = solution.maxProduct(A);
        assertEquals(expected, ret);

        A = new int[] { 2 };
        expected = 2;
        ret = solution.maxProduct(A);
        assertEquals(expected, ret);

        A = new int[] { -2 };
        expected = -2;
        ret = solution.maxProduct(A);
        assertEquals(expected, ret);
    }

    @Test
    public void testMaximumGap() {
        int[] num;
        int expected;

        num = new int[] { 1 };
        expected = 0;
        assertEquals(expected, solution.maximumGap(num));

        num = new int[] { 5, 1, 4, 2, 6 };
        expected = 2;
        assertEquals(expected, solution.maximumGap(num));
    }

    @Test
    public void testJump() {
        int[] A;
        int expected;

        A = new int[] {1, 2, 3};
        expected = 2;
        assertEquals(expected, solution.jump(A));
        
        A = new int[] {0, 0, 1};
        expected = 0;
        assertEquals(expected, solution.jump(A));
        
        A = new int[] {0, 1, 1};
        expected = 0;
        assertEquals(expected, solution.jump(A));

        A = new int[] { 2, 3, 1, 1, 4 };
        expected = 2;
        assertEquals(expected, solution.jump(A));
        
        A = new int[] { 2, 1};
        expected = 1;
        assertEquals(expected, solution.jump(A));
        
        A = new int[] { 2000, 1};
        expected = 1;
        assertEquals(expected, solution.jump(A));
    }
    
    @Test
    public void testPartition() {
        String s;
        List<List<String>> ret;
        
        s = "aab";
        ret = solution.partition(s);
        printListList(ret);
        
        s = "abadccd";
        ret = solution.partition(s);
        printListList(ret);
    }
    
    @Test
    public void testBSTIterator() {
        BSTIterator i;
        TreeNode root;
        
        root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        i = new BSTIterator(root);
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }
    
    @Test
    public void testLongestPalindrome() {
        String s;
        String expected;
        
        s = "abcdefgfedcba";
        expected = "abcdefgfedcba";
        assertEquals(expected, solution.longestPalindrome(s));
        
        s = "iuyabcdefgfedcbaops";
        expected = "abcdefgfedcba";
        assertEquals(expected, solution.longestPalindrome(s));
        
        s = "abb";
        expected = "bb";
        assertEquals(expected, solution.longestPalindrome(s));
    }
    @Test
    public void testPathSum() {
        TreeNode root;
        int sum;
        List<List<Integer>> result;
        
        root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        sum = 13;
        result = solution.pathSum(root, sum);
        printListList(result);
    }
    @Test
    public void testFindMedianSortedArray() {
        int A[], B[];
        double expected;
        double epsilon = 1e-20;
        
        A = new int[] {1, 3, 5, 9};
        B = new int[] {2, 3, 6};
        expected = 3;
        assertEquals(expected, solution.findMedianSortedArrays(A, B), epsilon);
   
        A = new int[] {1, 3, 4, 9};
        B = new int[] {2, 3, 6, 8};
        expected = 3.5;
        assertEquals(expected, solution.findMedianSortedArrays(A, B), epsilon);
    }
}