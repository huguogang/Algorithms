package test.name.huguogang.Algorithms.LeetCode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListList;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import name.huguogang.Algorithms.LeetCode.Solution;
import name.huguogang.Algorithms.LeetCode.Solution.BSTIterator;
import name.huguogang.Algorithms.LeetCode.TreeNode;

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

		A = new int[] { 1, 2, 3 };
		expected = 2;
		assertEquals(expected, solution.jump(A));

		A = new int[] { 0, 0, 1 };
		expected = 0;
		assertEquals(expected, solution.jump(A));

		A = new int[] { 0, 1, 1 };
		expected = 0;
		assertEquals(expected, solution.jump(A));

		A = new int[] { 2, 3, 1, 1, 4 };
		expected = 2;
		assertEquals(expected, solution.jump(A));

		A = new int[] { 2, 1 };
		expected = 1;
		assertEquals(expected, solution.jump(A));

		A = new int[] { 2000, 1 };
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
		while (i.hasNext()) {
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

		A = new int[] { 1, 3, 5, 9 };
		B = new int[] { 2, 3, 6 };
		expected = 3;
		assertEquals(expected, solution.findMedianSortedArrays(A, B), epsilon);

		A = new int[] { 1, 3, 4, 9 };
		B = new int[] { 2, 3, 6, 8 };
		expected = 3.5;
		assertEquals(expected, solution.findMedianSortedArrays(A, B), epsilon);
	}

	@Test
	public void testIsUgly() {
		int num;
		boolean expected;

		num = 1;
		expected = true;
		assertEquals(expected, solution.isUgly(num));

		num = 2;
		expected = true;
		assertEquals(expected, solution.isUgly(num));

		num = 3;
		expected = true;
		assertEquals(expected, solution.isUgly(num));

		num = 5;
		expected = true;
		assertEquals(expected, solution.isUgly(num));

		num = 6;
		expected = true;
		assertEquals(expected, solution.isUgly(num));

		num = 8;
		expected = true;
		assertEquals(expected, solution.isUgly(num));

		num = 14;
		expected = false;
		assertEquals(expected, solution.isUgly(num));

		num = -1;
		expected = false;
		assertEquals(expected, solution.isUgly(num));

		num = 0;
		expected = false;
		assertEquals(expected, solution.isUgly(num));
	}

	@Test
	public void testMissingNumberTest() {
		int[] nums;
		int expected;

		nums = new int[] { 0, 1, 2 };
		expected = 3;
		assertEquals(expected, solution.missingNumber(nums));

		nums = new int[] { 3, 1, 2 };
		expected = 0;
		assertEquals(expected, solution.missingNumber(nums));
	}

	@Test
	public void testIsIsomorphic() {
		String s;
		String t;

		s = "foo";
		t = "bar";
		assertFalse(solution.isIsomorphic(s, t));

		s = "paper";
		t = "title";
		assertTrue(solution.isIsomorphic(s, t));

		s = "egg";
		t = "add";
		assertTrue(solution.isIsomorphic(s, t));

		s = "ab";
		t = "aa";
		assertFalse(solution.isIsomorphic(s, t));
	}

	@Test
	public void testContainsDuplicate() {
		int[] nums;
		boolean expected;

		nums = new int[] {};
		assertFalse(solution.containsDuplicate(nums));

		nums = new int[] { 0 };
		assertFalse(solution.containsDuplicate(nums));

		nums = new int[] { 1, 1 };
		assertTrue(solution.containsDuplicate(nums));

		nums = new int[] { 2, 1 };
		assertFalse(solution.containsDuplicate(nums));

		nums = new int[] { -5, 5 };
		assertFalse(solution.containsDuplicate(nums));

		nums = new int[] { -1, 0, 3 };
		assertFalse(solution.containsDuplicate(nums));

		nums = new int[] { 3, 3, 3 };
		assertTrue(solution.containsDuplicate(nums));
	}

	@Test
	public void testContainsNearbyAlmostDuplicate() {
		int[] nums;
		int k, t;

		nums = new int[] { -1, 2147483647 };
		k = 1;
		t = 2147483647;
		assertFalse(solution.containsNearbyAlmostDuplicate(nums, k, t));
	}

	@Test
	public void testCalculate() {
		String s;
		int expected, actual;

		s = "1+1";
		expected = 2;
		actual = solution.calculate(s);
		assertEquals(expected, actual);

		s = " 2-1 + 2 ";
		expected = 3;
		actual = solution.calculate(s);
		assertEquals(expected, actual);

		s = "(1+(4+5+2)-3)+(6+8)";
		expected = 23;
		actual = solution.calculate(s);
		assertEquals(expected, actual);

		s = "(7) - (0) + (4)";
		expected = 11;
		actual = solution.calculate(s);
		assertEquals(expected, actual);
	}

	/**
	 * Test for Majority Element II
	 */
	@Test
	public void testMajorityElementII() {
		int[] input;
		ArrayList<Integer> expected;
		
		input = new int[] {1, 1, 3, 3};
		assertEquals(solution.majorityElement(input), Arrays.asList(1, 3));
	}
}