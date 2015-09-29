package name.huguogang.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import test.name.huguogang.Algorithms.LeetCode.Util;

/**
 * TODO: tree in/post/pre order using stack TODO: tree in/post/pre order using
 * morris TODO: (strStr) Rabin-Karp algorithm, KMP algorithm, and the Boyer-
 * Moore algorithm
 * 
 * @author ghu
 *
 */
@SuppressWarnings("unused")
public class Solution {

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 * 
	 * @param A
	 * @return
	 */
	public int maxProduct(int[] A) {
		// analysis:
		// * 0 is a breaker, no max can cross it? except when 0 itself is the
		// max
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
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 * 
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		// * all the valley bottoms (child on both sides have higher ratings)
		// must be 1
		// * peak's candy is same as max(left, right)
		// * if neighbors ratings are the same, their candy count are the same
		throw new NotImplementedException();
	}

	/**
	 * Maximum Gap
	 * 
	 * Given an unsorted array, find the maximum difference between the
	 * successive elements in its sorted form.
	 * 
	 * Try to solve it in linear time/space.
	 * 
	 * Return 0 if the array contains less than 2 elements.
	 * 
	 * You may assume all elements in the array are non-negative integers and
	 * fit in the 32-bit signed integer range.
	 * 
	 * @param num
	 * @return
	 */
	public int maximumGap(int[] num) {
		throw new NotImplementedException();
	}

	/**
	 * Word Break II
	 * 
	 * Given a string s and a dictionary of words dict, add spaces in s to
	 * construct a sentence where each word is a valid dictionary word.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given s = "catsanddog", dict = ["cat", "cats", "and",
	 * "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public List<String> wordBreakII(String s, Set<String> dict) {
		throw new NotImplementedException();
	}

	/**
	 * Dungeon Game
	 * 
	 * The demons had captured the princess (P) and imprisoned her in the
	 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms
	 * laid out in a 2D grid. Our valiant knight (K) was initially positioned in
	 * the top-left room and must fight his way through the dungeon to rescue
	 * the princess.
	 * 
	 * The knight has an initial health point represented by a positive integer.
	 * If at any point his health point drops to 0 or below, he dies
	 * immediately.
	 * 
	 * Some of the rooms are guarded by demons, so the knight loses health
	 * (negative integers) upon entering these rooms; other rooms are either
	 * empty (0's) or contain magic orbs that increase the knight's health
	 * (positive integers).
	 * 
	 * In order to reach the princess as quickly as possible, the knight decides
	 * to move only rightward or downward in each step.
	 * 
	 * 
	 * Write a function to determine the knight's minimum initial health so that
	 * he is able to rescue the princess.
	 * 
	 * For example, given the dungeon below, the initial health of the knight
	 * must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN
	 * -> DOWN.
	 * 
	 * -2 (K) -3 3 -5 -10 1 10 30 -5 (P)
	 * 
	 * Notes:
	 * 
	 * The knight's health has no upper bound. Any room can contain threats or
	 * power-ups, even the first room the knight enters and the bottom-right
	 * room where the princess is imprisoned. Credits: Special thanks
	 * to @stellari for adding this problem and creating all test cases.
	 * 
	 * @param dungeon
	 * @return
	 */
	public int calculateMinimumHP(int[][] dungeon) {
		int nRows = dungeon.length;
		int nCols = dungeon[0].length;
		List<List<RouteData>> buffer = new ArrayList<List<RouteData>>(nCols);
		RouteData d = RouteData.createRouteData(dungeon[0][0]);
		List<RouteData> list = new ArrayList<Solution.RouteData>();
		list.add(d);
		buffer.add(list);
		// first row
		throw new NotImplementedException();
	}

	public static class RouteData {
		// accumulated health point so far
		int healthPoint;
		// the required initial health
		int minInitialHealth;

		public RouteData(int healthPoint, int minInitialHealth) {
			this.healthPoint = healthPoint;
			this.minInitialHealth = minInitialHealth;
		}

		public static RouteData createRouteData(int healthPoint) {
			if (healthPoint <= 0) {
				return new RouteData(healthPoint, 1 - healthPoint);
			} else {
				return new RouteData(healthPoint, 0);
			}
		}
	}

	/**
	 * Jump Game II
	 * 
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * For example: Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 * 
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
		// init: step 1 always landed on A[0]
		int step = 1;
		// right most position that can be reached at the current step count
		int currentRight = 1;
		// right most position that the next step can reach
		int nextRight = 1;
		for (int i = 0; i < A.length - 1; ++i) {
			if (i == currentRight) {
				if (currentRight == nextRight) {
					return 0;
				}
				++step;
				currentRight = nextRight;
			}
			nextRight = Math.max(nextRight, A[i] + i + 1);

			if (nextRight >= A.length) {
				return step;
			}
		}

		return 0;
	}

	/**
	 * Jump Game II
	 * 
	 * Time limit exceeded version
	 * 
	 * @param A
	 * @return
	 */
	public int jumpTLE(int[] A) {
		int[] buffer = new int[A.length];
		for (int i = 1; i < buffer.length; ++i) {
			buffer[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < buffer.length - 1; ++i) {
			int j;
			for (j = i + 1; j <= i + A[i] && j < buffer.length; ++j) {
				buffer[j] = Math.min(buffer[j], buffer[i] + 1);
			}
			if (j == buffer.length) {
				break;
			}

		}
		return buffer[buffer.length - 1];
	}

	/**
	 * Palindrome Partitioning
	 * 
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], ["a","a","b"] ]
	 * 
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		ArrayList<String> aSolution = new ArrayList<String>();
		partitionDFS(s, aSolution, result, 0);
		return result;
	}

	@SuppressWarnings("unchecked")
	private void partitionDFS(String s, ArrayList<String> aSolution, List<List<String>> result,
			int startPos) {
		if (startPos == s.length()) {
			result.add((ArrayList<String>) aSolution.clone());
			return;
		}
		for (int i = startPos; i < s.length(); i++) {
			if (checkPalindrom(s, startPos, i)) {
				aSolution.add(s.substring(startPos, i + 1));
				partitionDFS(s, aSolution, result, i + 1);
				aSolution.remove(aSolution.size() - 1);
			}
		}
	}

	private boolean checkPalindrom(String s, int left, int right) {
		int head = left, tail = right;
		while (head <= tail) {
			if (s.charAt(head) != s.charAt(tail)) {
				return false;
			}
			++head;
			--tail;
		}
		return true;
	}

	/**
	 * Binary Search Tree Iterator
	 * 
	 * Implement an iterator over a binary search tree (BST). Your iterator will
	 * be initialized with the root node of a BST.
	 * 
	 * Calling next() will return the next smallest number in the BST.
	 * 
	 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
	 * memory, where h is the height of the tree.
	 * 
	 * Credits: Special thanks to @ts for adding this problem and creating all
	 * test cases.
	 * 
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 * 
	 * @author ghu
	 *
	 */
	public static class BSTIterator {
		private TreeNode root;
		private TreeNode current;
		private Stack<TreeNode> path;

		public BSTIterator(TreeNode root) {
			this.root = root;
			current = root;
			path = new Stack<TreeNode>();
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return current != null || !path.isEmpty();
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			while (current != null) {
				path.push(current);
				current = current.left;
			}
			current = path.pop();
			int val = current.val;
			current = current.right;
			return val;
		}
	}

	/**
	 * Longest Palindromic Substring
	 * 
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int maxLen = 1;
		// buffer, row: length of palindrome, col: true if palindrom starting at
		// the col
		boolean[][] isPalindrome = new boolean[s.length() + 1][s.length()];
		// init 0 and single char length, they are all valid palindrome
		for (int i = 0; i < s.length(); ++i) {
			isPalindrome[0][i] = true;
			isPalindrome[1][i] = true;
		}
		// check the existence of palindrome of the specified length
		for (int len = 2; len < s.length() + 1; ++len) {
			boolean hasPalindrome = false;
			for (int i = 0; i < s.length() - len + 1; ++i) {
				isPalindrome[len][i] = isPalindrome[len - 2][i + 1]
						&& (s.charAt(i) == s.charAt(i + len - 1));
				hasPalindrome = hasPalindrome || isPalindrome[len][i];
			}
			if (hasPalindrome) {
				maxLen = len;
			}
			// TODO: we can prune if two consecutive "len"s has no palindrome
		}
		for (int i = 0; i < s.length(); ++i) {
			if (isPalindrome[maxLen][i]) {
				return s.substring(i, i + maxLen);
			}
		}
		return "";
	}

	/**
	 * Gas Station
	 * 
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		throw new NotImplementedException();
	}

	/**
	 * Path Sum II
	 * 
	 * Given a binary tree and a sum, find all root-to-leaf paths where each
	 * path's sum equals the given sum.
	 * 
	 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11
	 * 13 4 / \ / \ 7 2 5 1 return [ [5,4,11,2], [5,8,4,5] ]
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		pathSumDFS(root, sum, result, path);
		return result;
	}

	@SuppressWarnings("unchecked")
	private void pathSumDFS(TreeNode node, int sum, List<List<Integer>> result,
			ArrayList<Integer> path) {
		if (node == null) {
			return;
		}
		path.add(node.val);

		int diff = sum - node.val;
		if (node.left == null && node.right == null) {
			if (diff == 0) {
				result.add((ArrayList<Integer>) path.clone());
			}
		} else {
			pathSumDFS(node.left, diff, result, path);
			pathSumDFS(node.right, diff, result, path);
		}
		path.remove(path.size() - 1);
	}

	/**
	 * Median of Two Sorted Arrays
	 * 
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len % 2 == 1) {
			return findKth(A, 0, A.length, B, 0, B.length, len / 2 + 1);
		} else {
			return (findKth(A, 0, A.length, B, 0, B.length, len / 2)
					+ findKth(A, 0, A.length, B, 0, B.length, len / 2 + 1)) / 2.0;
		}
	}

	/**
	 * Helper, find the Kth number of two sorted arrays. K = 1 will find max
	 * 
	 * @param A
	 * @param B
	 * @param k
	 * @return
	 */
	private int findKth(int A[], int aStart, int aLen, int B[], int bStart, int bLen, int k) {
		if (aLen < bLen) {
			return findKth(B, bStart, bLen, A, aStart, aLen, k);
		}
		// aLen >= bLen
		if (bLen == 0) {
			return A[k - 1 + aStart];
		}
		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}
		// # of elements to skip in each array, our target is to skip k - 2
		// elements
		int bSkip = Math.min(k / 2 - 1, bLen - 1);
		int aSkip = k - 2 - bSkip;
		int aIdx = aStart + aSkip;
		int bIdx = bStart + bSkip;
		if (A[aIdx] < B[bIdx]) {
			// we can safely remove left of A (also exclude aIdx), and right of
			// B from next search
			return findKth(A, aIdx + 1, aLen - aSkip - 1, B, bStart, bSkip + 1, k - aSkip - 1);
		} else if (A[aIdx] > B[bIdx]) {
			// we can safely remove left of B (also exclude bIdx), and right of
			// A from next search
			return findKth(A, aStart, aSkip + 1, B, bIdx + 1, bLen - bSkip - 1, k - bSkip - 1);
		} else {
			// A[aIdx] == b[bId], we got element k - 1 and element k are the
			// same, just pick either one
			return A[aIdx];
		}
	}

	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		while ((num % 2) == 0) {
			num = num / 2;
		}
		while ((num % 3) == 0) {
			num = num / 3;
		}
		while ((num % 5) == 0) {
			num = num / 5;
		}
		return num == 1;
	}

	/**
	 * Missing Number
	 * 
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	 * find the one that is missing from the array.
	 * 
	 * For example, Given nums = [0, 1, 3] return 2.
	 * 
	 * Note: Your algorithm should run in linear runtime complexity. Could you
	 * implement it using only constant extra space complexity?
	 * 
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		long sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return (int) (nums.length * (nums.length + 1) / 2 - sum);
	}

	/**
	 * Isomorphic Strings
	 * 
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings are isomorphic if the characters in s can be replaced to get
	 * t.
	 * 
	 * All occurrences of a character must be replaced with another character
	 * while preserving the order of characters. No two characters may map to
	 * the same character but a character may map to itself.
	 * 
	 * For example, Given "egg", "add", return true.
	 * 
	 * Given "foo", "bar", return false.
	 * 
	 * Given "paper", "title", return true.
	 * 
	 * Note: You may assume both s and t have the same length.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> s2t = new HashMap<>();
		HashSet<Character> tMapped = new HashSet<>();

		int len = s.length();

		for (int i = 0; i < len; ++i) {
			char si = s.charAt(i);
			char ti = t.charAt(i);
			if (s2t.containsKey(si)) {
				if (s2t.get(si) != ti) {
					return false;
				}
			} else {
				if (tMapped.contains(ti)) {
					return false;
				}
				tMapped.add(ti);
				s2t.put(si, ti);
			}
		}

		return true;
	}

	/**
	 * Number of Bits
	 * 
	 * Write a function that takes an unsigned integer and returns the number of
	 * ’1' bits it has (also known as the Hamming weight).
	 * 
	 * For example, the 32-bit integer ’11' has binary representation
	 * 00000000000000000000000000001011, so the function should return 3.
	 * 
	 * 
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			++count;
		}
		return count;
	}

	/**
	 * Contains Duplicate
	 * 
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> lookup = new HashSet<>();

		for (int n : nums) {
			if (lookup.contains(n)) {
				return true;
			}
			lookup.add(n);
		}

		return false;
	}

	/**
	 * Contains Duplicate II
	 * 
	 * Given an array of integers and an integer k, find out whether there are
	 * two distinct indices i and j in the array such that nums[i] = nums[j] and
	 * the difference between i and j is at most k.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// keep look up of last k numbers
		LinkedHashSet<Integer> recentLookup = new LinkedHashSet<>();

		for (int num : nums) {
			if (recentLookup.contains(num)) {
				return true;
			}
			recentLookup.add(num);
			if (recentLookup.size() > k) {
				// remove the first number
				int n = recentLookup.iterator().next();
				recentLookup.remove(n);
			}
		}

		return false;
	}

	/**
	 * Contains Duplicate II
	 * 
	 * Given an array of integers and an integer k, find out whether there are
	 * two distinct indices i and j in the array such that nums[i] = nums[j] and
	 * the difference between i and j is at most k.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	// this version is faster than containsNearbyDuplicate
	public boolean containsNearbyDuplicateSolution1(int[] nums, int k) {
		// lookup of most recent position of a number
		HashMap<Integer, Integer> lookup = new HashMap<>();
		int len = nums.length;
		for (int i = 0; i < len; ++i) {
			int num = nums[i];
			if (lookup.containsKey(num) && (i - lookup.get(num) <= k)) {
				return true;
			}
			lookup.put(num, i);
		}

		return false;
	}

	/**
	 * Contains Duplicate III
	 * 
	 * Given an array of integers, find out whether there are two distinct
	 * indices i and j in the array such that the difference between nums[i] and
	 * nums[j] is at most t and the difference between i and j is at most k.
	 * 
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		// Look up of last k elements
		TreeSet<Integer> lookup = new TreeSet<>();

		int len = nums.length;
		for (int i = 0; i < len; ++i) {
			int num = nums[i];

			Integer floor = lookup.floor(num);
			if (floor != null && ((long) num - floor) <= t) {
				return true;
			}

			Integer ceiling = lookup.ceiling(num);
			if (ceiling != null && (long) ((long) ceiling - num) <= t) {
				return true;
			}

			lookup.add(num);
			if (i >= k) {
				lookup.remove(nums[i - k]);
			}
		}

		return false;
	}

	/**
	 * Basic Calculator
	 * 
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string may contain open ( and closing parentheses ), the
	 * plus + or minus sign -, non-negative integers and empty spaces .
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples:
	 * 
	 * "1 + 1" = 2 " 2-1 + 2 " = 3 "(1+(4+5+2)-3)+(6+8)" = 23
	 * 
	 * Note: Do not use the eval built-in library function.
	 * 
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		Stack<String> stack = new Stack<>();

		int idx = 0;
		while (idx < s.length()) {
			if (s.charAt(idx) == ' ') {
				++idx;
				continue;
			}
			// read next symbol
			String symbol = "";

			char c = s.charAt(idx);
			if (c == '+' || c == '-' || c == '(' || c == ')') {
				symbol = String.valueOf(c);
				++idx;
			} else { // number
				while (idx < s.length()) {
					c = s.charAt(idx);
					if (c > '9' || c < '0') {
						break;
					}

					symbol += c;
					++idx;
				}
			}

			switch (symbol) {
			case "+":
			case "-":
			case "(":
				stack.push(symbol);
				break;
			case ")":
			// process all the way to "("
			{
				int result = Integer.parseInt(stack.pop());
				String operand;
				while (!(operand = stack.pop()).equals("(")) {
					if (operand.equals("+")) {
						result = Integer.parseInt(stack.pop()) + result;
					} else if (operand.equals("-")) {
						result = Integer.parseInt(stack.pop()) - result;
					}
				}
				
				symbol = String.valueOf(result);
			}
			
			// fall through, to calculate anything on the left or paren if any
			default: // numbers
				if (!stack.isEmpty()) {
					String operand = stack.peek();
					if (operand.equals("+")) {
						stack.pop();
						symbol = String
								.valueOf(Integer.parseInt(symbol) + Integer.parseInt(stack.pop()));
					} else if (operand.equals("-")) {
						stack.pop();
						symbol = String
								.valueOf(Integer.parseInt(stack.pop()) - Integer.parseInt(symbol));

					}
				}
				stack.push(symbol);
				break;
			}

		}

		return Integer.parseInt(stack.pop());
	}
}
