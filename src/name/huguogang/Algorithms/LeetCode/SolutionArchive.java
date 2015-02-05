package name.huguogang.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Archive of completed problems
 * 
 * @author ghu
 *
 */
public class SolutionArchive {
    /**
     * Given a sorted array, remove the duplicates in place such that each
     * element appear only once and return the new length.
     * 
     * Do not allocate extra space for another array, you must do this in place
     * with constant memory.
     * 
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        int len = 0;
        for (int i = 0; i < A.length; ++i) {
            if (len == 0) {
                len++;
                continue;
            }
            if (A[len - 1] == A[i]) {
                // duplicate, skip
                continue;
            }
            A[len++] = A[i];
        }
        return len;
    }

    /**
     * Implement atoi to convert a string to an integer.
     * 
     * Detailed spec based on research: - Discard all leading white spaces
     * (0x20, 0x09, 0x0A, 0x0B, 0x0C, 0x0D) - Optional leading +, - - Then as
     * many number as possible - Return 0 for invalid input - out of range,
     * return INT max or min
     * 
     * @param str
     * @return
     */
    public int atoi(String str) {
        long ret = 0;
        int sign = 1;
        int state = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (state == 0
                    && (c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r')) {
                continue; // skip leading whitespace
            }
            if (state == 0 && (c == '+')) {
                state = 1;
                continue;
            }
            if (state == 0 && (c == '-')) {
                state = 1;
                sign = -1;
                continue;
            }
            if (c >= '0' && c <= '9') {
                state = 1;
                ret = ret * 10 + (c - '0');
                // catch here: MAX and MIN are not symmetry, must compare
                // separately
                // min: -2147483648
                // max: 2147483647
                if (sign > 0 && ret >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign < 0 && (ret * sign <= Integer.MIN_VALUE)) {
                    return Integer.MIN_VALUE;
                }
                continue;
            }
            break; // error state
        }
        return (int) ret * sign;
    }

    /**
     * Given a set of distinct integers, S, return all possible subsets.
     * Note:
     * - Elements in a subset must be in non-descending order.
     * (implication based on OJ feedbacks
     * = Within a set, numbers are ordered non-descending
     * = Shorter sets are smaller
     * = Sets of same size, compare each number left to right
     * )
     * - The solution set must not contain duplicate subsets.
     * 
     * @param S
     * @return
     */
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        for (int i : S) {
            int len = ret.size();
            for (int idx = 0; idx < len; idx++) {
                List<Integer> set = ret.get(idx);
                ArrayList<Integer> s = new ArrayList<Integer>(set);
                s.add(i);
                ret.add(s);
            }
        }
        Collections.sort(ret, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> set1, List<Integer> set2) {
                int ret = set1.size() - set2.size();
                if (ret != 0) {
                    // shorter ones are smaller
                    return ret;
                }
                // same size, compare number by number
                for (int i = 0; i < set1.size(); ++i) {
                    ret = set1.get(i) - set2.get(i);
                    if (ret != 0) {
                        return ret;
                    }
                }
                return ret;
            }
        });

        return ret;
    }

    public List<List<Integer>> subsetsI(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetsIR(S, path, 0, ret);
        return ret;
    }

    @SuppressWarnings("unchecked")
    private void subsetsIR(int[] S, ArrayList<Integer> path, int step,
            List<List<Integer>> ret) {
        if (step == S.length) {
            ret.add((List<Integer>) path.clone());
            return;
        }
        subsetsIR(S, path, step + 1, ret);
        path.add(S[step]);
        subsetsIR(S, path, step + 1, ret);
        path.remove(path.size() - 1);
    }

    /**
     * Given an input string, reverse the string word by word.
     *
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     * 
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = s.length() - 1;
        // skip space at the end
        while (idx >= 0 && Character.isWhitespace(s.charAt(idx))) {
            idx--;
        }
        boolean hasSpace = false;
        int insertPoint = 0;
        while (idx >= 0) {
            char c = s.charAt(idx);
            if (Character.isWhitespace(c)) {
                hasSpace = true;
            } else {
                if (hasSpace) {
                    sb.append(' ');
                    hasSpace = false;
                    insertPoint = sb.length();
                }
                sb.insert(insertPoint, c);
            }
            idx--;
        }
        return sb.toString();
    }

    /**
     * Given an array of integers, every element appears twice except for one.
     * Find that single one.
     * 
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int ret = 0;
        for (int i : A) {
            ret = ret ^ i;
        }
        return ret;
    }

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        postorderR(path, root);
        return path;
    }

    private void postorderR(ArrayList<Integer> path, TreeNode node) {
        if (node == null) {
            return;
        }
        postorderR(path, node.left);
        postorderR(path, node.right);
        path.add(node.val);
    }

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * 
     * This is the iterative version
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalI(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root == null) {
            return path;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.empty()) {
            TreeNode n = s.peek();
            if (n.left == null && n.right == null) {
                path.add(n.val);
                s.pop();
            }
            else if (n.left != null) {  // left not null
                s.push(n.left);
                n.left = null; // mark visited
            }
            else { // right not null
                s.push(n.right);
                n.right = null; // mark visited
            }
        }
        return path;
    }

    /**
     * Given n non-negative integers representing an elevation map where the
     * width of each bar is 1, compute how much water it is able to trap after
     * raining.
     *
     * For example,
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     * 
     * @param A
     * @return
     */
    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int len = A.length;
        int[] waterTable = new int[len];
        int peak = 0;
        for (int i = 0; i < len; ++i) {
            if (A[i] > peak) {
                peak = A[i];
            }
            waterTable[i] = peak;
        }
        peak = 0;
        int ret = 0;
        for (int i = len - 1; i >= 0; --i) {
            if (A[i] > peak) {
                peak = A[i];
            }
            if (peak < waterTable[i]) {
                waterTable[i] = peak;
            }
            ret += waterTable[i] - A[i];
        }
        return ret;
    }

    /**
     * A message containing letters from A-Z is being encoded to numbers using
     * the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of
     * ways to decode it.
     *
     * For example,
     * Given encoded message "12", it could be decoded as "AB" (1 2) or "L"
     * (12).
     *
     * The number of ways decoding "12" is 2.
     * 
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int c_1 = 0;    // count of strings up to i - 2
        int c = 1;      // count of strings up to i - 1
        int prevVal = 0;// char value at i - 1
        for (int i = 0; i < s.length(); ++i) {
            int val = s.charAt(i) - '0';
            int currentCount = 0;
            if (val != 0) {
                // the current char is legit, add count of strings upto i - 1
                currentCount += c;
            }
            if (prevVal > 0) {
                int val1 = prevVal * 10 + val;
                if (val1 >= 1 && val1 <= 26) {
                    // current char combine with i - 1 is legit, add count of
                    // strings up to i - 2
                    currentCount += c_1;
                }
            }
            c_1 = c;
            c = currentCount;
            prevVal = val;
        }
        return c;
    }

    // this version is inefficient, got "Time Limit Exceeded"
    public int numDecodingsInefficient(String s) {
        return countNumDecodings(s, 0, 0);
    }

    /**
     * 
     * @param s
     * @param pos
     * @param carry
     *            Carry from previous digit, 0: no carry, otherwise: 1, 2
     * @return
     */
    private int countNumDecodings(String s, int pos, int carry) {
        if (pos >= s.length()) {
            return carry == 0 ? 1 : 0;
        }
        int me = s.charAt(pos) - '0';
        int c = me + 10 * carry;
        if (c < 1 || c > 26) {
            // dead end
            return 0;
        }
        int count = countNumDecodings(s, pos + 1, 0);
        if (c <= 2) {
            count += countNumDecodings(s, pos + 1, me);
        }
        return count;
    }

    /**
     * Divide two integers without using multiplication, division and mod
     * operator.
     * 
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor cannot be zero");
        }
        // rectify to all non-negative
        // negative and positive range is not symmetry, use long to make abs value
        long lDividend;
        long lDivisor;
        int sign = 1;
        lDividend = dividend;
        if (lDividend < 0) {
            lDividend = -lDividend;
            sign = -sign;
        }
        lDivisor = divisor;
        if (lDivisor < 0) {
            sign = -sign;
            lDivisor = -lDivisor;
        }
        DivideResult r = new DivideResult();
        divideR(lDividend, lDivisor, r);
        return (sign > 0 ? (int) r.quotient : (int) -r.quotient);
    }

    private class DivideResult {
        long quotient = 0;
        long remainder = 0;
    }

    /**
     * Notice: divisor has to be 64 bit long, otherwise 2147483647/1 will
     * underflow to negative number, and cause the algorithm to stuck
     * 
     * @param dividend
     * @param divisor
     * @param r
     */
    private void divideR(long dividend, long divisor, DivideResult r) {
        if (dividend < divisor) {
            r.remainder = dividend;
            return;
        }
        divideR(dividend, divisor + divisor, r);
        r.quotient = r.quotient << 1;
        if (r.remainder >= divisor) {
            ++r.quotient;
            r.remainder -= divisor;
        }
        return;
    }

    /**
     * Merge two sorted linked lists and return it as a new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // note if both null, we will correctly return null in the first branch
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ret = new ListNode(0); // trick, reduce separate logic for head
                                        // element
        ListNode prev = ret;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            }
            else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        else {
            prev.next = l2;
        }
        return ret.next;
    }

    /**
     * Given a binary tree, return the level order traversal of its nodes'
     * values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     * 3
     * / \
     * 9 20
     * / \
     * 15 7
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        while (currentLevel.size() > 0) {
            List<Integer> row = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode n : currentLevel) {
                // add numbers to return
                row.add(n.val);
                // scan for next level
                if (n.left != null) {
                    nextLevel.add(n.left);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }
            ret.add(row);
            currentLevel = nextLevel;
        }
        return ret;
    }

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     *
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * Find the total sum of all root-to-leaf numbers.
     *
     * For example,
     *
     * 1
     * / \
     * 2 3
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     *
     * Return the sum = 12 + 13 = 25.
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<Integer> allNumbers = new ArrayList<Integer>();
        findNumbers(root, allNumbers, 0);
        int sum = 0;
        for (int n : allNumbers) {
            sum += n;
        }
        return sum;
    }

    private void findNumbers(TreeNode node, List<Integer> allNumbers,
            int parentNumber) {
        if (node == null) {
            return;
        }
        int number = parentNumber * 10 + node.val;
        if (node.left == null && node.right == null) {
            allNumbers.add(number);
            return;
        }
        findNumbers(node.left, allNumbers, number);
        findNumbers(node.right, allNumbers, number);
    }

    /**
     * Implement pow(x, n).
     * 
     * @param x
     * @param n
     * @return
     */
    public double pow(double x, int n) {
        int e = (n > 0) ? n : -n;
        double ret = 1;
        while (e > 0) {
            if (e % 2 == 1) {
                ret *= x;
            }
            x = x * x;
            e = e >> 1;
        }
        if (n < 0) {
            return 1 / ret;
        }
        return ret;
    }

    public boolean isSymmetricR(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // iterative
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> level = new LinkedList<TreeNode>();
        level.add(root.left);
        level.add(root.right);
        while (!level.isEmpty()) {
            TreeNode left, right;
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            int listIndex = 0, leftIdx = 0, rightIdx = level.size() - 1;
            while (leftIdx < rightIdx) {
                left = level.get(leftIdx);
                right = level.get(rightIdx);
                if (left == null && right == null) {
                    ++leftIdx;
                    --rightIdx;
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                nextLevel.add(listIndex, right.right);
                nextLevel.add(listIndex, right.left);
                nextLevel.add(listIndex, left.right);
                nextLevel.add(listIndex, left.left);
                listIndex += 2;
                ++leftIdx;
                --rightIdx;
            }
            level = nextLevel;
        }
        return true;
    }

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * 
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * 
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     * 
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String operators = "+-*/";
        for (String str : tokens) {
            if (operators.indexOf(str) < 0) {
                stack.push(Integer.parseInt(str));
            }
            else {
                int op1 = stack.pop(), op2 = stack.pop();
                switch (str) {
                case "+":
                    stack.push(op2 + op1);
                    break;
                case "-":
                    stack.push(op2 - op1);
                    break;
                case "*":
                    stack.push(op2 * op1);
                    break;
                case "/":
                    stack.push(op2 / op1);
                    break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * Given two binary trees, write a function to check if they are equal or not.
     * 
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeR(p, q);
    }

    private boolean isSameTreeR(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return (isSameTreeR(p.left, q.left) && isSameTreeR(p.right, q.right));
        }

        return false;
    }

    /**
     * The set [1,2,3,�,n] contains a total of n! unique permutations.
     * 
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3):
     * 
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * 
     * Note: Given n will be between 1 and 9 inclusive.
     * 
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        LinkedList<Character> charList = new LinkedList<Character>();
        for (char i = 1; i <= n; i++) {
            charList.add((char) (i + '0'));
        }
        int factorial = 1;
        for (int i = 2; i <= n - 1; ++i) {
            factorial *= i;
        }
        k = k - 1;
        int digit = n;
        String s = "";
        while (k > 0) {
            int offset = k / factorial;
            s += charList.get(offset);

            charList.remove(offset);
            k = k % factorial;
            --digit;
            factorial /= digit;
        }
        // the rest are in order
        for (char c : charList) {
            s += c;
        }
        return s;
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
     * valid.
     * 
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                left.push(c);
            }
            else {
                if (left.isEmpty()) {
                    return false;
                }
                char cLeft = left.pop();
                if (!((cLeft == '(' && c == ')') || (cLeft == '[' && c == ']') || (cLeft == '{' && c == '}'))) {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in
     * the list or null.
     * 
     * Return a deep copy of the list.
     * 
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode ret;
        RandomListNode n = head;
        while (n != null) {
            RandomListNode newNode = new RandomListNode(n.label);
            newNode.next = n.next;
            n.next = newNode;
            n = newNode.next;
        }
        ret = head.next;
        // fix random
        n = head;
        while (n != null) {
            if (n.random != null) {
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }
        // restore both lists
        n = head;
        while (n != null) {
            RandomListNode newNode = n.next;
            n.next = newNode.next;
            if (n.next != null) {
                newNode.next = n.next.next;
            }
            n = n.next;
        }
        return ret;
    }

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * 
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * 
     * If the target is not found in the array, return [-1, -1].
     * 
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     * 
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {
        int[] fail = { -1, -1 };
        if (A == null || A.length == 0) {
            return fail;
        }
        int start = 0, end = A.length - 1, mid = (start + end) / 2;
        while (start < end) {
            if (A[mid] < target) {
                start = mid + 1;
            }
            else if (A[mid] > target) {
                end = mid - 1;
            }
            else {
                break;
            }
            mid = (start + end) / 2;
        }
        if (A[mid] == target) {
            start = mid - 1;    // find 1 position before region
            end = mid + 1;      // find 1 position after region
            while (start >= 0 && A[start] == target) {
                --start;
            }
            while (end <= A.length - 1 && A[end] == target) {
                ++end;
            }
            return new int[] { start + 1, end - 1 };
        }
        else {
            return fail;
        }
    }

    /**
     * Valid Palindrome
     * 
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * 
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * 
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * 
     * For the purpose of this problem, we define empty string as valid palindrome.
     * 
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            char cHead = convertChar(s.charAt(head));
            if (cHead == 0) {
                ++head;
                continue;
            }
            char cTail = convertChar(s.charAt(tail));
            if (cTail == 0) {
                --tail;
                continue;
            }
            if (cHead != cTail) {
                return false;
            }
            ++head;
            --tail;
        }
        return true;
    }

    /**
     * 
     * @param c
     * @return If c is alphanumeric, return upper case, else 0
     */
    private char convertChar(char c) {
        char diff = (char) ('A' - 'a');
        if (c >= '0' && c <= '9') {
            return c;
        }
        if (c >= 'a' && c <= 'z') {
            return (char) (c + diff);
        }
        if (c >= 'A' && c <= 'Z') {
            return c;
        }
        return 0;
    }

    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * 1, 11, 21, 1211, 111221, ...
     * 
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth sequence.
     * 
     * Note: The sequence of integers will be represented as a string.
     * 
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        // brute force
        String s = "1";
        for (int i = 2; i <= n; i++) {
            String next = "";
            char c = s.charAt(0);
            int count = 1;
            for (int sIdx = 1; sIdx < s.length(); ++sIdx) {
                char c1 = s.charAt(sIdx);
                if (c1 == c) {
                    ++count;
                }
                else {
                    next += Integer.toString(count);
                    next += c;
                    c = c1;
                    count = 1;
                }
            }
            next += Integer.toString(count);
            next += c;
            s = next;
        }
        return s;
    }

    /**
     * ZigZag Conversion
     * 
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
     * display this pattern in a fixed font for better legibility)
     * 
     * P A H N
     * A P L S I I G
     * Y I R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * 
     * string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     * 
     * @param s
     * @param nRows
     * @return
     */
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        // brute force, simulate zig zag
        int nCols = (s.length() + 1) / 2;
        char[][] buffer = new char[nRows][];
        for (int i = 0; i < nRows; ++i) {
            buffer[i] = new char[nCols];
        }
        int row = -1;
        int col = 0;
        int dir = 0; // 0: down, 1: up
        for (int i = 0; i < s.length(); i++) {
            if (row == (nRows - 1) && dir == 0) {
                dir = 1;
            }
            else if (row == 0 && dir == 1) {
                dir = 0;
            }
            if (dir == 0) {
                // straight down
                buffer[++row][col] = s.charAt(i);
            }
            else {
                // zigzag back up
                buffer[--row][++col] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (row = 0; row < nRows; ++row) {
            for (col = 0; col < nCols; ++col) {
                char c = buffer[row][col];
                if (c == '\0') {
                    continue;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
     * along the path equals the given sum.
     * 
     * For example:
     * Given the below binary tree and sum = 22,
     * 5
     * / \
     * 4 8
     * / / \
     * 11 13 4
     * / \ \
     * 7 2 1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     * 
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumR(root, sum, 0);
    }

    private boolean hasPathSumR(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }
        int mySum = sum + root.val;
        if (root.left == null && root.right == null) {
            return (target == mySum);
        }
        return hasPathSumR(root.left, target, mySum)
                || hasPathSumR(root.right, target, mySum);
    }

    /**
     * Reverse digits of an integer.
     * 
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     * 
     * @param x
     * @return
     */
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        // Abs of Integer.MIN_VALUE does not map to integer range
        long num = x < 0 ? -((long) x) : x;
        long ret = 0;
        while (num > 0) {
            ret = ret * 10 + (num % 10);
            num = num / 10;
            if (ret > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (ret * sign);
    }

    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     * 
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int topDivider = 1;
        int tmp = x / 10;
        while (tmp > 0) {
            tmp = tmp / 10;
            topDivider *= 10;
        }
        // single digit is palindrome
        // This shortcut does not work, think test case 1000021
        // while (x >= 10) {
        while (topDivider > 1) {
            int lsd = x % 10;
            int msd = x / topDivider;
            if (lsd != msd) {
                return false;
            }
            // remove lsd and msd
            x = (x % topDivider) / 10;
            topDivider /= 100; // 2 digits shorter
        }
        return true;
    }

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * 
     * For example,
     * 
     * Given linked list: 1->2->3->4->5, and n = 2.
     * 
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // head itself might be deleted
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode front = head, back = tmp;
        for (int i = 1; i <= n; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return tmp.next;
    }

    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * 
     * For example,
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     * 
     * Your algorithm should run in O(n) complexity.
     * 
     * @param num
     * @return
     */
    public int longestConsecutive(int[] num) {
        int ret = 0;
        Hashtable<Integer, Boolean> lookup = new Hashtable<Integer, Boolean>();
        for (int i : num) {
            lookup.put(i, false); // not visited yet
        }
        for (int i : num) {
            int length = 1;
            if (lookup.get(i)) {
                continue; // skip visited
            }
            int j = i - 1;
            while (lookup.containsKey(j)) {
                lookup.put(j, true);
                --j;
                ++length;
            }
            j = i + 1;
            while (lookup.containsKey(j)) {
                lookup.put(j, true);
                ++j;
                ++length;
            }
            ret = (ret >= length) ? ret : length;
        }
        return ret;
    }

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * 
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                if (node.right != null) {
                    // move right to the rightmost descendent of left tree
                    TreeNode attachPoint = node.left;
                    while (attachPoint.right != null) {
                        attachPoint = attachPoint.right;
                    }
                    attachPoint.right = node.right;
                }
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    /**
     * Word Search
     * 
     * Given a 2D board and a word, find if the word exists in the grid.
     * 
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
     * horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * 
     * For example,
     * Given board =
     * 
     * [
     * ["ABCE"],
     * ["SFCS"],
     * ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     * 
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null
                || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        int row = 0;
        int col = 0;
        // assuming rectangle
        boardHeight = board.length;
        boardWidth = board[0].length;
        visited = new boolean[boardHeight][boardWidth];
        for (boolean[] aRow : visited) {
            for (int i = 0; i < aRow.length; ++i) {
                aRow[i] = false;
            }
        }
        for (row = 0; row < boardHeight; ++row) {
            for (col = 0; col < boardWidth; ++col) {
                if (existR(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int boardWidth;
    private int boardHeight;
    private boolean[][] visited;

    private boolean existR(char[][] board, String word, int wordIdx, int row,
            int col) {
        if (wordIdx >= word.length()) {
            return true;
        }
        if (row < 0 || row >= boardHeight || col < 0 || col >= boardWidth   // out of bound
                || board[row][col] != word.charAt(wordIdx)                  // no match
                || visited[row][col]) {                                     // visited
            return false;
        }
        ++wordIdx;
        visited[row][col] = true;
        boolean ret = (existR(board, word, wordIdx, row + 1, col) ||
                existR(board, word, wordIdx, row - 1, col) ||
                existR(board, word, wordIdx, row, col + 1) || existR(board,
                word, wordIdx, row, col - 1));
        visited[row][col] = false;
        return ret;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ret = "";
        for (int len = 0; len < strs[0].length(); ++len) {
            char c = strs[0].charAt(len);
            for (String s : strs) {
                if (len >= s.length()) {
                    return ret;
                }
                if (s.charAt(len) != c) {
                    return ret;
                }
            }
            ret += c;
        }
        return ret;
    }

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * 
     * Notes:
     * 
     * - If the two linked lists have no intersection at all, return null.
     * - The linked lists must retain their original structure after the function returns.
     * - You may assume there are no cycles anywhere in the entire linked structure.
     * - Your code should preferably run in O(n) time and use only O(1) memory.
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // O(n) time, O(1) space solution:
        // * link headB to tailA
        // * find start of the cycle
        if (headA == null || headB == null) {
            return null;
        }

        ListNode slow1, slow2, fast, tailA;
        slow1 = slow2 = fast = headA;
        tailA = null;
        boolean hasCycle = false;
        // detect cycle
        while (tailA == null || (fast != null && fast.next != null)) {
            // link B to A
            if (tailA == null && fast.next == null) {
                tailA = fast;
                tailA.next = headB;
            }
            else if (tailA == null && fast.next.next == null) {
                tailA = fast.next;
                tailA.next = headB;
            }

            slow1 = slow1.next;
            fast = fast.next.next;

            if (slow1 == fast) {
                hasCycle = true;
                break;
            }
        }
        // identify start
        if (hasCycle) {
            while (slow1 != slow2) {
                slow1 = slow1.next;
                slow2 = slow2.next;
            }
        }
        else {
            slow1 = null;
        }
        // restore structure
        tailA.next = null;
        return slow1;
    }

    /**
     * Given a roman numeral, convert it to an integer.
     * 
     * Input is guaranteed to be within the range from 1 to 3999.
     * 
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Hashtable<Character, Integer> letterLookup = new Hashtable<Character, Integer>();
        letterLookup.put('I', 1);
        letterLookup.put('V', 5);
        letterLookup.put('X', 10);
        letterLookup.put('L', 50);
        letterLookup.put('C', 100);
        letterLookup.put('D', 500);
        letterLookup.put('M', 1000);

        // scan from right to left, if the number is smaller then previous, then substract
        int previousNum = 0;
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            int num = letterLookup.get(c);
            if (num < previousNum) {
                ret -= num;
            }
            else {
                ret += num;
            }
            previousNum = num;
        }
        return ret;
    }

    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     * 
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return ret;
        }
        List<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        ret.add(lastRow);
        // TODO: can exploit symmetry to cut calculation for the right half
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 0; j < lastRow.size() - 1; ++j) {
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            ret.add(row);
            lastRow = row;
        }
        return ret;
    }

    /**
     * Given an index k, return the kth row of the Pascal's triangle.
     * 
     * For example, given k = 3,
     * Return [1,3,3,1].
     * 
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     * 
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row;
        row = new ArrayList<Integer>(rowIndex + 1);
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
        }
        for (int rowNum = 1; rowNum <= rowIndex; ++rowNum) {
            for (int col = rowNum; col > 0; --col) {
                row.set(col, row.get(col - 1) + row.get(col));
            }
        }
        return row;
    }

    /**
     * Given a binary tree, find its minimum depth.
     * 
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf
     * node.
     * 
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(
                root.left == null ? Integer.MAX_VALUE : minDepth(root.left),
                root.right == null ? Integer.MAX_VALUE : minDepth(root.right)) + 1;
    }

    /**
     * Unique Binary Search Trees
     * 
     * Given n, how many structurally unique BST's (binary search trees) that
     * store values 1...n?
     * 
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // f(0) = 1, f(1) = 1;
        // f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + ... + f(n - 1) * f(0)
        if (n <= 1) {
            return 1;
        }
        List<Integer> numbers = new ArrayList<Integer>(n + 1);
        numbers.add(1); // f(0)
        numbers.add(1); // f(1)
        for (int i = 2; i <= n; ++i) {
            // calculate f(i)
            int numI = 0;
            for (int j = 0; j <= (i - 1) / 2; ++j) {
                int tmp = numbers.get(j) * numbers.get(i - 1 - j);
                if (j * 2 == (i - 1)) {
                    numI += tmp;
                }
                else {
                    numI += 2 * tmp;
                }
            }
            numbers.add(numI);
        }
        return numbers.get(n);
    }

    /**
     * Binary Tree Inorder Traversal
     * 
     * Recursive version
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalR(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        inorderR(root, ret);
        return ret;
    }

    private void inorderR(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderR(node.left, result);
        result.add(node.val);
        inorderR(node.right, result);
    }

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * 
     * Each element in the array represents your maximum jump length at that position.
     * 
     * Determine if you are able to reach the last index.
     * 
     * For example:
     * A = [2,3,1,1,4], return true.
     * 
     * A = [3,2,1,0,4], return false.
     * 
     * @param A
     * @return
     */
    public boolean canJump(int[] A) {
        int maxEnd = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > maxEnd) {
                return false;
            }
            int end = i + A[i];
            maxEnd = Math.max(end, maxEnd);
            if (maxEnd >= A.length - 1) {
                return true;
            }
        }
        return true;
    }

    /**
     * Given a binary tree, determine if it is height-balanced.
     * 
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
     * subtrees of every node never differ by more than 1.
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getBalanceTreeDepth(root) >= 0;
    }

    /**
     * if the subtree is balanced, return depth, else -1
     * 
     * @param node
     * @return
     */
    private int getBalanceTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = getBalanceTreeDepth(node.left);
        int right = getBalanceTreeDepth(node.right);
        if (left < 0 || right < 0) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * Given a binary tree, find its maximum depth.
     * 
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf
     * node.
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * Given a non-negative number represented as an array of digits, plus one to the number.
     * 
     * The digits are stored such that the most significant digit is at the head of the list.
     * 
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length;
        int n = digits[len - 1] + 1;
        digits[len - 1] = n % 10;
        carry = n / 10;
        for (int digit = digits.length - 2; digit >= 0 && carry > 0; --digit) {
            n = digits[digit] + carry;
            digits[digit] = n % 10;
            carry = n / 10;
        }
        if (carry > 0) {
            // need a new array
            int[] ret = new int[len + 1];
            ret[0] = carry;
            for (int digit = 0; digit < len; ++digit) {
                ret[digit + 1] = digits[digit];
            }
            return ret;
        }
        else {
            return digits;
        }
    }

    /**
     * Given a linked list, determine if it has a cycle in it.
     * 
     * Follow up:
     * Can you solve it without using extra space?
     * 
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Binary Tree Preorder Traveral
     * 
     * Recursive version
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalR(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        preorderR(root, ret);
        return ret;
    }

    private void preorderR(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderR(node.left, result);
        preorderR(node.right, result);
    }

    /**
     * Binary Tree Preorder Traveral
     * 
     * Iterative version
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            ret.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return ret;
    }

    /**
     * Remove Element
     * 
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * 
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * 
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int head = 0;
        int tail = len - 1;
        while (head <= tail) {
            if (A[head] == elem) {
                A[head] = A[tail];
                --tail;
                --len;
            }
            else {
                ++head;
            }
        }
        return len;
    }

    /**
     * Populating Next Right Pointers in Each Node
     * 
     * Given a binary tree
     * 
     * struct TreeLinkNode {
     * TreeLinkNode *left;
     * TreeLinkNode *right;
     * TreeLinkNode *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
     * should be set to NULL.
     * 
     * Initially, all next pointers are set to NULL.
     * 
     * Note:
     * 
     * You may only use constant extra space.
     * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two
     * children).
     * 
     * @param root
     */
    public void connect(TreeLinkNode root) {
        // O(1) space

        // left most node of the next level
        TreeLinkNode left = null;
        // current visiting node
        TreeLinkNode current = root;
        while (current != null || left != null) {
            if (current == null) {
                current = left;
                left = null;
                continue;
            }

            if (left == null) {
                left = current.left;
            }
            if (current.left != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
            }
            current = current.next;
        }
    }

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where
     * it would be if it were inserted in order.
     * 
     * You may assume no duplicates in the array.
     * 
     * @param A
     * @param target
     * @return
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // binary search
        int left = 0, right = A.length - 1, mid = (left + right) / 2;
        while (left <= right) {
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                left = mid + 1;
            }
            else {
                // >
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return left;
    }

    /**
     * Given two sorted integer arrays A and B, merge B into A as one sorted array.
     * 
     * Note:
     * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from
     * B. The number of elements initialized in A and B are m and n respectively.
     * 
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        int idxA = m - 1, idxB = n - 1, idxResult = m + n - 1;
        // scan from right to left
        while (idxResult > idxA      // if equal, we can stop, because array B is all merged
                && idxA >= 0) {
            if (A[idxA] > B[idxB]) {
                A[idxResult] = A[idxA];
                --idxA;
            }
            else {
                A[idxResult] = B[idxB];
                --idxB;
            }
            --idxResult;
        }
        // merge the rest of B
        for (; idxB >= 0; --idxB) {
            A[idxB] = B[idxB];
        }
    }

    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
     * level by level from leaf to root).
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> current, next;
        current = new ArrayList<TreeNode>();
        current.add(root);
        while (!current.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            next = new ArrayList<TreeNode>();
            for (TreeNode n : current) {
                row.add(n.val);
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            current = next;
            ret.add(0, row);
        }
        return ret;
    }

    /**
     * Given two binary strings, return their sum (also a binary string).
     * 
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        // ensure a is the longer string
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        char zero = '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int idxA;
        int idxB;
        for (idxA = a.length() - 1, idxB = b.length() - 1; idxA >= 0; --idxA, --idxB) {
            int digitA = a.charAt(idxA) - zero;
            int digitB = idxB >= 0 ? (b.charAt(idxB) - zero) : 0;
            int n = digitA + digitB + carry;
            sb.insert(0, (char) (n % 2 + zero));
            carry = n / 2;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] answers = new int[n + 1];
        answers[0] = 1;
        answers[1] = 1;
        for (int i = 2; i <= n; ++i) {
            answers[i] = answers[i - 1] + answers[i - 2];
        }
        return answers[n];
    }

    /**
     * Implement strStr().
     * 
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int lenHS = haystack.length();
        int lenND = needle.length();
        if (lenND == 0) {
            return 0;
        }
        for (int i = 0; i <= lenHS - lenND; ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isMatch = true;
                // start comparison
                for (int j = 1; j < lenND; ++j) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Remove Duplicates from Sorted List
     * 
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * 
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode n = head;
        while (n != null) {
            ListNode next = n.next;
            if (next != null && next.val == n.val) {
                n.next = n.next.next;
            }
            else {
                n = next;
            }
        }
        return head;
    }

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
     * word in the string.
     * 
     * If the last word does not exist, return 0.
     * 
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * 
     * For example,
     * Given s = "Hello World",
     * return 5.
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int ret = 0;
        int idx = s.length() - 1;
        while (idx >= 0) {
            if (s.charAt(idx) != ' ') {
                break;
            }
            --idx;
        }
        while (idx >= 0 && s.charAt(idx) != ' ') {
            ++ret;
            --idx;
        }
        return ret;
    }

    /**
     * Valid Sudoku
     * 
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules (link:
     * http://sudoku.com.au/TheRules.aspx).
     * 
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     * 
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            if (!isValidSudokuUnit(getSudokuBlock(board, i))) {
                return false;
            }
            if (!isValidSudokuUnit(getSudokuCol(board, i))) {
                return false;
            }
            if (!isValidSudokuUnit(getSudokuRow(board, i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * given 9 piece on board, verify they are unique
     * 
     * @return
     */
    private boolean isValidSudokuUnit(char[] cells) {
        int flag = 0;
        char zero = '0';
        for (char c : cells) {
            if (c == '.') {
                continue;
            }
            int myFlag = 1 << (c - zero);

            if ((flag & myFlag) > 0) {
                return false;
            }
            flag |= myFlag;
        }
        return true;
    }

    private char[] getSudokuRow(char[][] board, int rowNumber) {
        return board[rowNumber];
    }

    private char[] getSudokuCol(char[][] board, int colNumber) {
        char[] ret = new char[9];
        for (int row = 0; row < 9; ++row) {
            ret[row] = board[row][colNumber];
        }
        return ret;
    }

    /**
     * get 3X3 block, top left is block 0, block number goes row by row
     * 
     * @param board
     * @param rowNumber
     * @return
     */
    private char[] getSudokuBlock(char[][] board, int blockNumber) {
        char[] ret = new char[9];
        int topRow = (blockNumber / 3) * 3;
        int leftCol = (blockNumber % 3) * 3;
        int counter = 0;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                ret[counter] = board[topRow + row][leftCol + col];
                ++counter;
            }
        }
        return ret;
    }

    /**
     * Two Sum
     * 
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * 
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
     * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * 
     * You may assume that each input would have exactly one solution.
     * 
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // lookup from remainder to index1
        Hashtable<Integer, Integer> lookup = new Hashtable<Integer, Integer>();
        for (int idx = 0; idx < numbers.length; ++idx) {
            int n = numbers[idx];
            if (lookup.containsKey(n)) {
                return new int[] { lookup.get(n) + 1, idx + 1 };
            }
            int remainder = target - numbers[idx];
            lookup.put(remainder, idx);
        }
        return null;
    }

    /**
     * Validate Binary Search Tree
     * 
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * 
     * Assume a BST is defined as follows:
     * 
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    /**
     * helpder for isValidBST
     * 
     * @param node Root of a sub-tree
     * @param bound Lower, upper bound of the sub-tree
     * @return True if sub-tree is BST
     */
    private boolean isValidBSTHelper(TreeNode node, Integer lowerBound,
            Integer upperBound) {
        if (node == null) {
            return true;
        }
        if ((lowerBound != null && node.val <= lowerBound) ||
                (upperBound != null && node.val >= upperBound)) {
            return false;
        }
        return isValidBSTHelper(node.left, lowerBound, node.val) &&
                isValidBSTHelper(node.right, node.val, upperBound);
    }

    /**
     * Word Ladder
     * 
     * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start
     * to end, such that:
     * 
     * Only one letter can be changed at a time
     * Each intermediate word must exist in the dictionary
     * For example,
     * 
     * Given:
     * start = "hit"
     * end = "cog"
     * dict = ["hot","dot","dog","lot","log"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * 
     * Note:
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * 
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // breadth first search
        int depth = 1;
        List<String> currentLevel = new ArrayList<String>();
        currentLevel.add(start);
        // remove <--> mark visited
        dict.remove(start);
        dict.remove(end);
        while (!currentLevel.isEmpty()) {
            depth++;
            List<String> nextLevel = new ArrayList<String>();
            for (String s : currentLevel) {
                char[] arrChar = s.toCharArray();
                // find distance 1 words that are remaining in the dictionary
                for (int i = 0; i < s.length(); ++i) {
                    char oldChar = s.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == oldChar) {
                            continue;
                        }
                        arrChar[i] = c;
                        String newStr = new String(arrChar);
                        if (newStr.equals(end)) {
                            return depth;
                        }
                        if (dict.contains(newStr)) {
                            nextLevel.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                    arrChar[i] = oldChar;
                }
            }
            currentLevel = nextLevel;
        }
        return 0;
    }

    /**
     * This is the old version of ladderLength that causes time limit error.
     * 
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLengthTLE(String start, String end, Set<String> dict) {
        // breadth first search
        int depth = 1;
        List<String> currentLevel = new ArrayList<String>();
        currentLevel.add(start);
        dict.remove(start);
        // ensure end is in the set
        dict.add(end);
        while (!currentLevel.isEmpty()) {
            depth++;
            List<String> nextLevel = new ArrayList<String>();
            for (String s : currentLevel) {
                // try to find distance 1 words in dictionary
                // this algorithm is too slow when dictionary is large
                // instead, loop a - z over each character will need only about
                // s.length * 25 searchs
                for (String sDict : dict) {
                    int distance = 0;
                    // assuming strings are same length
                    for (int i = 0; i < s.length(); ++i) {
                        if (s.charAt(i) != sDict.charAt(i)) {
                            ++distance;
                            if (distance > 1) {
                                // too far, no need to go further
                                break;
                            }
                        }
                    }
                    if (distance == 1) {
                        if (sDict == end) {
                            return depth;
                        }
                        nextLevel.add(sDict);
                    }
                }
                // since we only care about min distance we can remove next level from dict already
                for (String nextS : nextLevel) {
                    dict.remove(nextS);
                }
            }
            currentLevel = nextLevel;
        }
        return 0;
    }

    /**
     * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
     * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int n1 = 0, n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int number = n1 + n2 + carry;
            node.next = new ListNode(number % 10);
            carry = number / 10;

            node = node.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return head.next;
    }

    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * 
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * 
     * 
     * 
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     * 
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        char[] buffer = new char[digits.length()];
        letterComboHelper(digits, 0, result, buffer);
        return result;
    }

    private char[][] keyboard = new char[][] {
            { ' ' }, {}, // 0, 1
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    private void letterComboHelper(String digits, int index,
            List<String> result, char[] buffer) {
        if (index == digits.length()) {
            result.add(new String(buffer));
            return;
        }
        int digit = digits.charAt(index) - '0';
        if (digit == 1) {
            throw new IllegalArgumentException("Number 1 has not character");
        }
        char[] candidates = keyboard[digit];
        for (char c : candidates) {
            buffer[index] = c;
            letterComboHelper(digits, index + 1, result, buffer);
        }
    }

    /**
     * Best Time to Buy and Sell Stock
     * 
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * 
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            int profit = price - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, price);
        }
        return maxProfit;
    }

    /**
     * Construct Binary Tree from Inorder and Postorder Traversal
     * 
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * 
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder) {
        // rightmost node is root
        return buildTreeInorderPostorderHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeInorderPostorderHelper(int[] inorder,
            int inorderStart, int inorderEnd,
            int[] postorder, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootVal);
        if (inorderStart < inorderEnd) {
            int rootIdx;
            for (rootIdx = inorderStart; rootIdx <= inorderEnd; ++rootIdx) {
                if (inorder[rootIdx] == rootVal) {
                    break;
                }
            }
            int leftLen = rootIdx - inorderStart;
            if (leftLen > 0) {
                root.left = buildTreeInorderPostorderHelper(inorder,
                        inorderStart, rootIdx - 1, postorder, postorderStart,
                        postorderStart + leftLen - 1);
            }
            int rightLen = inorderEnd - rootIdx;
            if (rightLen > 0) {
                root.right = buildTreeInorderPostorderHelper(inorder,
                        rootIdx + 1, inorderEnd, postorder, postorderEnd
                                - rightLen,
                        postorderEnd - 1);
            }
        }
        return root;
    }

    /**
     * Construct Binary Tree from Preorder and Inorder Traversal
     * 
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * 
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreePreorderInorder(int[] preorder, int[] inorder) {
        return buildTreePreorderInorderHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreePreorderInorderHelper(int[] preorder,
            int preorderStart,
            int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx;
        for (rootIdx = inorderStart; rootIdx <= inorderEnd; ++rootIdx) {
            if (inorder[rootIdx] == rootVal) {
                break;
            }
        }
        int leftLen = rootIdx - inorderStart;
        if (leftLen > 0) {
            root.left = buildTreePreorderInorderHelper(preorder,
                    preorderStart + 1, preorderStart + leftLen, inorder,
                    inorderStart,
                    rootIdx - 1);
        }
        int rightLen = inorderEnd - rootIdx;
        if (rightLen > 0) {
            root.right = buildTreePreorderInorderHelper(preorder,
                    preorderEnd - rightLen + 1, preorderEnd, inorder,
                    rootIdx + 1,
                    inorderEnd);
        }
        return root;
    }

    /**
     * Merge k Sorted Lists
     * 
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode n1, ListNode n2) {
                        return n1.val - n2.val;
                    }
                });
        ListNode head = new ListNode(0);
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        ListNode current = head;
        while (!q.isEmpty()) {
            ListNode n = q.remove();
            if (n.next != null) {
                q.add(n.next);
            }
            current.next = n;
            current = n;
        }
        return head.next;
    }

    /**
     * Swap Nodes in Pairs
     * 
     * Given a linked list, swap every two adjacent nodes and return its head.
     * 
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode a = current.next;
            current.next = a.next;
            a.next = current.next.next;
            current.next.next = a;

            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * Convert Sorted Array to Binary Search Tree
     * 
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * 
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] num, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return null;
        }
        int mid = (leftIdx + rightIdx) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHelper(num, leftIdx, mid - 1);
        root.right = sortedArrayToBSTHelper(num, mid + 1, rightIdx);
        return root;
    }

    /**
     * Best Time to Buy and Sell Stock II
     * 
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * 
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
     * and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same
     * time (ie, you must sell the stock before you buy again).
     * 
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if (prices == null | prices.length < 2) {
            return 0;
        }
        int buyPrice, previousPrice, profit;
        buyPrice = -1;
        previousPrice = prices[0];
        profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            int price = prices[i];
            if (price > previousPrice && buyPrice < 0) {
                // price going up and no position, buy
                buyPrice = previousPrice;
            }
            else if (price < previousPrice && buyPrice >= 0) {
                // price going down and in position, sell
                profit += (previousPrice - buyPrice);
                buyPrice = -1;
            }
            previousPrice = price;
        }
        if (buyPrice >= 0) {
            profit += (prices[prices.length - 1] - buyPrice);
        }
        return profit;
    }

    /**
     * Maximum Subarray
     * 
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * 
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        int maxSum = A[0];
        int sum = 0;
        for (int i : A) {
            sum += i;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                // sum up to here is less than 0, we can reset sum
                sum = 0;
            }
        }
        return maxSum;
    }

    /**
     * N-Queens
     * 
     * The n-queens puzzle is the problem of placing n queens on an n�n chessboard such that no two queens attack each
     * other.
     * 
     * 
     * 
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * 
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
     * a queen and an empty space respectively.
     * 
     * @param n
     * @return
     */
    public List<String[]> solveNQueens(int n) {
        int[] positions = new int[n]; // queen position on each row
        List<String[]> result = new ArrayList<String[]>();
        solveNQueensHelper(n, positions, result, 0);
        return result;
    }

    private void solveNQueensHelper(int n, int[] positions,
            List<String[]> result,
            int row) {
        if (row >= n) {
            // found one solution, assemble result
            String[] arr = new String[n];
            for (int rowNum = 0; rowNum < n; ++rowNum) {
                char[] buffer = new char[n];
                int pos = positions[rowNum];
                for (int col = 0; col < n; ++col) {
                    buffer[col] = (col == pos) ? 'Q' : '.';
                }
                arr[rowNum] = new String(buffer);
            }
            result.add(arr);
        }
        for (int col = 0; col < n; ++col) {
            boolean isValid = true;
            // only need to incremental validate against previous rows
            for (int i = 0; i < row; ++i) {
                int pos = positions[i];
                if (pos == col) { // same column
                    isValid = false;
                    break;
                }
                if (Math.abs(pos - col) == Math.abs(i - row)) { // diagonal
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                positions[row] = col;
                solveNQueensHelper(n, positions, result, row + 1);
            }
        }
    }

    /**
     * N-Queens II
     * 
     * Follow up for N-Queens problem.
     * 
     * Now, instead outputting board configurations, return the total number of distinct solutions.
     * 
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        int[] positions = new int[n]; // queen position on each row
        int count = totalNQueensHelper(n, positions, 0);
        return count;
    }

    private int totalNQueensHelper(int n, int[] positions, int row) {
        if (row >= n) {
            // found one solution
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; ++col) {
            boolean isValid = true;
            // only need to incremental validate against previous rows
            for (int i = 0; i < row; ++i) {
                int pos = positions[i];
                if (pos == col) { // same column
                    isValid = false;
                    break;
                }
                if (Math.abs(pos - col) == Math.abs(i - row)) { // diagonal
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                positions[row] = col;
                count += totalNQueensHelper(n, positions, row + 1);
            }
        }
        return count;
    }

    /**
     * Single Number II
     * 
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * 
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * 
     * @param A
     * @return
     */
    public int singleNumberII(int[] A) {
        // idea is sum%3 will give the answer
        // but if number is greater than 3, the remainder is not telling much
        // if we can guarantee that each number is in the range of 0 - 2, the it is valid

        // similar to v1, but 32 counters are replaced by two 32 bit integers
        // zero record bit 0 of remainder of 3 for each bit
        // one record bit 1 of remainder of 3 for each bit
        int zero = 0; // bit zero of counter
        int one = 0; // bit 1 of counter
        for (int i : A) {
            // carry from bit 0
            one = one ^ (zero & i);
            // new bit 0
            zero = zero ^ i;
            // remainder of 3, i.e. 11 -> 0
            int tmp = ~(one & zero);
            one = one & tmp;
            zero = zero & tmp;
        }
        return zero; // we are told there is only a single number, no worries of one
    }

    public int singleNumberIIV1(int[] A) {
        // idea is sum%3 will give the answer
        // but if number is greater than 3, the remainder is not telling much
        // if we can guarantee that each number is in the range of 0 - 2, the it is valid
        int[] count = new int[32]; // is this extra memory?
        for (int i : A) {
            for (int bit = 0; bit < 32; ++bit) {
                count[bit] += (i >> bit) & 1;
            }
        }
        int ret = 0;
        for (int bit = 0; bit < 32; ++bit) {
            ret |= (count[bit] % 3) << bit;
        }
        return ret;
    }

    /**
     * Integer to Roman
     * 
     * Given an integer, convert it to a roman numeral.
     * 
     * Input is guaranteed to be within the range from 1 to 3999.
     * 
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        char[][] letterLookup = new char[][] {
                { 'I', 'V' }, // 1*10^0 -> I, 5*10^0->V
                { 'X', 'L' },
                { 'C', 'D' },
                { 'M' }
        };
        String result = "";
        int divider = 1000;
        int digit = 4;
        while (num > 0) {
            // value for this digit
            int n = num / divider;

            // prep for next step
            num = num % divider;
            divider /= 10;
            --digit;

            // generate roman for this digit
            if (n == 0) {
                continue;
            }
            else if (n < 4) {
                // 1+
                for (int i = 0; i < n; ++i) {
                    result += letterLookup[digit][0];
                }
            }
            else if (n == 4) {
                // 5-1
                result = result + letterLookup[digit][0]
                        + letterLookup[digit][1];
            }
            else if (n == 9) {
                // 10-1
                result = result + letterLookup[digit][0]
                        + letterLookup[digit + 1][0];
            }
            else {
                // 5+
                result += letterLookup[digit][1];
                for (int i = 6; i <= n; ++i) {
                    result += letterLookup[digit][0];
                }
            }
        }
        return result;
    }

    /**
     * Populating Next Right Pointers in Each Node II
     * 
     * Follow up for problem "Populating Next Right Pointers in Each Node".
     * 
     * What if the given tree could be any binary tree? Would your previous solution still work?
     * 
     * @param root
     */
    public void connectII(TreeLinkNode root) {
        TreeLinkNode current = root; // current parent we are visiting
        TreeLinkNode head = null; // head of the next level
        TreeLinkNode previous = new TreeLinkNode(0); // most recent node of next level
        while (current != null) {
            if (current.left != null) {
                previous.next = current.left;
                previous = current.left;
                if (head == null) {
                    head = current.left;
                }
            }
            if (current.right != null) {
                previous.next = current.right;
                previous = current.right;
                if (head == null) {
                    head = current.right;
                }
            }
            current = current.next;
            if (current == null) {
                // start on next row
                current = head;
                head = null;
                previous = new TreeLinkNode(0);
            }
        }
    }

    /**
     * Convert Sorted List to Binary Search Tree
     * 
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     * 
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            ++len;
            p = p.next;
        }
        currentNode = head;
        return sortedListToBSTHelper(len);
    }

    private ListNode currentNode;

    /**
     * Build a balanced BST from "currentNode" to length
     * 
     * @param head
     * @param len
     * @return
     */
    private TreeNode sortedListToBSTHelper(int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode node = sortedListToBSTHelper(len / 2);
        TreeNode root = new TreeNode(currentNode.val);
        currentNode = currentNode.next;
        root.left = node;
        node = sortedListToBSTHelper(len - len / 2 - 1);
        root.right = node;
        return root;
    }

    /**
     * Reverse Linked List II
     * 
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * 
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * 
     * return 1->4->3->2->5->NULL.
     * 
     * Note:
     * Given m, n satisfy the following condition:
     * 1 <= m <= n <= length of list.
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int counter = 1;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode previous = dummyHead;
        ListNode nodem = null;
        while (head != null) {
            ListNode next = head.next;

            if (counter == m) {
                nodem = head;
                nodem.next = previous; // borrow this pointer to save previous position
            }
            else if (counter > m && counter < n) {
                head.next = previous;
            }
            // m could be the same as n
            if (counter == n) {
                head.next = previous;
                nodem.next.next = head;
                nodem.next = next;
                break;
            }

            ++counter;
            previous = head;
            head = next;
        }
        return dummyHead.next;
    }

    /**
     * Anagrams
     * 
     * Given an array of strings, return all groups of strings that are anagrams.
     * 
     * Note: All inputs will be in lower-case.
     * 
     * @param strs
     * @return
     */
    public List<String> anagrams(String[] strs) {
        List<String> ret = new ArrayList<String>();
        if (strs == null) {
            return ret;
        }

        HashMap<String, List<String>> group = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> val;
            if (group.containsKey(key)) {
                val = group.get(key);
            }
            else {
                val = new ArrayList<String>();
                group.put(key, val);
            }
            val.add(s);
        }

        for (List<String> lst : group.values()) {
            if (lst.size() > 1) {
                ret.addAll(lst);
            }
        }
        return ret;
    }

    /**
     * Find Peak Element
     * 
     * A peak element is an element that is greater than its neighbors.
     * 
     * Given an input array where num[i] <> num[i+1], find a peak element and return its index.
     * 
     * You may imagine that num[-1] = num[n] = -infinity.
     * 
     * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
     * 
     * @param num
     * @return
     */
    public int findPeakElement(int[] num) {
        // assuming our goal is to find any peak, we can use binary search, thus achieve log complexity
        if (num == null || num.length == 0) {
            return -1; // no peak
        }
        int len = num.length;
        return findPeakElementHelper(num, 0, len - 1);
    }

    private int findPeakElementHelper(int[] num, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int len = num.length;
        boolean biggerThanPrevious = (mid == 0 || num[mid] > num[mid - 1]);
        boolean biggerThanFollowing = (mid == len - 1 || num[mid] > num[mid + 1]);
        if (biggerThanFollowing && biggerThanPrevious) {
            return mid;
        }
        if (biggerThanFollowing && !biggerThanPrevious) {
            // on the down slope, peak is on our left
            return findPeakElementHelper(num, start, mid - 1);
        }
        else if (!biggerThanFollowing && biggerThanPrevious) {
            // on the up slop, peak is on the right
            return findPeakElementHelper(num, mid + 1, end);
        }
        else {
            // in the valley, we will have peak on either side, just pick left side here
            return findPeakElementHelper(num, start, mid - 1);
        }
    }

    public int findPeakElementSlow(int[] num) {
        if (num == null || num.length == 0) {
            return -1; // no peak
        }
        int len = num.length;
        for (int i = 0; i < len; ++i) {
            boolean biggerThanPrevious = (i == 0 || num[i] > num[i - 1]);
            boolean biggerThanFollowing = (i == len - 1 || num[i] > num[i + 1]);
            if (biggerThanFollowing && biggerThanPrevious) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Triangle
     * 
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the
     * row below.
     * 
     * For example, given the following triangle
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * 
     * Note:
     * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the
     * triangle.
     * 
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // search bottom up, code can be a lot simpler if we are allowed to modify triangle
        int len = triangle.size();
        int[] minCurrent = new int[len]; // min path sum of the current row
        int[] minLower = new int[len]; // min path sum of lower row
        for (int level = len - 1; level >= 0; --level) {
            List<Integer> row = triangle.get(level);
            for (int col = 0; col < row.size(); ++col) {
                if (level == len - 1) {
                    minCurrent[col] = row.get(col);
                }
                else {
                    minCurrent[col] = row.get(col)
                            + Math.min(minLower[col], minLower[col + 1]);
                }
            }

            // exchange
            int[] tmp = minCurrent;
            minCurrent = minLower;
            minLower = tmp;
        }
        return minLower[0];
    }

    /**
     * Sort Colors
     * 
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
     * adjacent, with the colors in the order red, white and blue.
     * 
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * 
     * @param A
     */
    public void sortColors(int[] A) {
        if (A == null) {
            return;
        }
        int len = A.length;
        int red = 0;
        int blue = len - 1;
        for (int i = 0; i <= blue;) {
            if (A[i] == 0) {
                A[i] = A[red];
                A[red] = 0;
                ++red;
                ++i;
            }
            else if (A[i] == 2) {
                A[i] = A[blue];
                A[blue] = 2;
                --blue;
            }
            else {
                ++i;
            }
        }
    }

    /**
     * Reorder List
     * 
     * Given a singly linked list L: L0->L1->�->Ln-1->Ln,
     * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->�
     * 
     * You must do this in-place without altering the nodes' values.
     * 
     * For example,
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     * 
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // idea: reverse second half, then merge
        int len = 1;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            ++len;
        }

        int mid = (len + 1) / 2;
        // go to the node right before mid node
        node = head;
        for (int i = 0; i < mid - 1; ++i) {
            node = node.next;
        }
        ListNode midNode = node.next;
        node.next = null;

        midNode = reverseLinkedList(midNode);

        head = zipLists(head, midNode);
    }

    /**
     * reverse linked list
     * 
     * @param head
     * @return Head of reversed list
     */
    public ListNode reverseLinkedList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }

        return dummy.next;
    }

    /**
     * Interleave two linked lists. Head 1 starts first
     * 
     * Assumption: head1 is not null
     * 
     * @param head1
     * @param head2
     * @return
     */
    public ListNode zipLists(ListNode head1, ListNode head2) {
        ListNode head = head1;
        while (head1 != null && head2 != null) {
            ListNode tmp = head1.next;
            head1.next = head2;
            head1 = tmp;

            tmp = head2.next;
            head2.next = head1;
            head2 = tmp;
        }
        return head;
    }

    /**
     * Container With Most Water
     * 
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
     * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
     * with x-axis forms a container, such that the container contains the most water.
     * 
     * Note: You may not slant the container.
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int len = height.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            // the shorter side won't be able to form a bigger container
            if (height[left] <= height[right]) {
                ++left;
            }
            else {
                --right;
            }
        }
        return max;
    }

    /**
     * Rotate Image
     * 
     * You are given an n x n 2D matrix representing an image.
     * 
     * Rotate the image by 90 degrees (clockwise).
     * 
     * Follow up:
     * Could you do this in-place?
     * 
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        // in-place 90 degree clockwise
        // clockwise 90 degree (x, y) -> (size - 1 - y, x)
        // we will rotate layer by layer, starting from outside
        int size = matrix.length;
        for (int layer = 0; layer < size / 2; ++layer) {
            // loop top edge of the layer
            for (int x = layer; x <= size - 1 - layer - 1; ++x) {
                int tmp = matrix[layer][x];
                matrix[layer][x] = matrix[size - 1 - x][layer];
                matrix[size - 1 - x][layer] = matrix[size - 1 - layer][size - 1
                        - x];
                matrix[size - 1 - layer][size - 1 - x] = matrix[x][size - 1
                        - layer];
                matrix[x][size - 1 - layer] = tmp;
            }
        }
    }

    /**
     * Unique Paths
     * 
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * 
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
     * corner of the grid (marked 'Finish' in the diagram below).
     * 
     * How many possible unique paths are there?
     * 
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        // should be same of (m + n - 2) choose (m - 1)

        int[] count = new int[m];
        for (int i = 0; i < m; ++i) {
            count[i] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                count[j] += count[j - 1];
            }
        }
        return count[m - 1];
    }

    /**
     * Linked List Cycle II
     * 
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * 
     * Follow up:
     * Can you solve it without using extra space?
     * 
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow1, slow2, fast;
        slow1 = slow2 = fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow1 = slow1.next;
            if (fast == slow1) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        while (slow1 != slow2) {
            slow1 = slow1.next;
            slow2 = slow2.next;
        }
        return slow1;
    }

    /**
     * Partition List
     * 
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
     * equal to x.
     * 
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * 
     * For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     * 
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode partition = dummy; // point where smaller node can be inserted
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val < x) {
                if (current == partition) {
                    // already in the right place
                    current = partition = partition.next;

                }
                else {
                    // move next to the next of partition
                    ListNode smallNode = current.next;
                    current.next = current.next.next;
                    smallNode.next = partition.next;
                    partition.next = smallNode;
                    partition = smallNode;
                }
                // move to next
            }
            else {
                // move to next
                current = current.next;
            }
        }
        return dummy.next;
    }

    /**
     * Search a 2D Matrix
     * 
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
     * properties:
     * 
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     * 
     * Consider the following matrix:
     * 
     * [
     * [1, 3, 5, 7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * Given target = 3, return true.
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        nRows = matrix.length;
        nCols = matrix[0].length;
        int size = nRows * nCols;
        return binarySearchMatrix(matrix, 0, size - 1, target);
    }

    private int nRows;
    private int nCols;

    private Coord getCoord(int n) {
        Coord ret = new Coord();
        ret.row = n / nCols;
        ret.col = n % nCols;
        return ret;
    }

    private boolean binarySearchMatrix(int[][] matrix, int start, int end,
            int target) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        Coord coord = getCoord(mid);
        int num = matrix[coord.row][coord.col];
        if (num == target) {
            return true;
        }
        if (num < target) {
            return binarySearchMatrix(matrix, mid + 1, end, target);
        }
        else {
            // num > target
            return binarySearchMatrix(matrix, start, mid - 1, target);
        }
    }

    /**
     * Edit Distance
     * 
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each
     * operation is counted as 1 step.)
     * 
     * You have the following 3 operations permitted on a word:
     * 
     * a) Insert a character
     * b) Delete a character
     * c) Replace a character
     * 
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[] previous = new int[len2 + 1]; // min distance of word2 from empty to full, to word1 substring
        int[] current = new int[len2 + 1];
        for (int i = 0; i < len2 + 1; ++i) {
            previous[i] = i; // word2 min distance against empty string
        }
        for (int idx1 = 1; idx1 <= len1; ++idx1) {
            current[0] = idx1; // word1 min distance against empty string
            for (int idx2 = 1; idx2 <= len2; ++idx2) {
                int d1 = 1 + previous[idx2];
                int d2 = 1 + current[idx2 - 1];
                int d3 = previous[idx2 - 1];
                if (word1.charAt(idx1 - 1) != word2.charAt(idx2 - 1)) {
                    ++d3;
                }
                current[idx2] = Math.min(d1, d2);
                current[idx2] = Math.min(current[idx2], d3);
            }
            int[] tmp = current;
            current = previous; // reuse array
            previous = tmp;
        }
        return previous[len2];
    }

    /**
     * Binary Tree Zigzag Level Order Traversal
     * 
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
     * right to left for the next level and alternate between).
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<TreeNode> previousLevel = new ArrayList<TreeNode>();
        if (root != null) {
            previousLevel.add(root);
        }
        int direction = 0; // 0: left to right, 1: right to left
        while (!previousLevel.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<Integer>();
            List<TreeNode> currentLevel = new ArrayList<TreeNode>();
            for (TreeNode n : previousLevel) {
                // store to return
                if (direction == 0) {
                    level.add(n.val);
                }
                else {
                    level.addFirst(n.val);
                }
                if (n.left != null) {
                    currentLevel.add(n.left);
                }
                if (n.right != null) {
                    currentLevel.add(n.right);
                }
            }
            ret.add(level);
            // prepare for next iteration
            direction = direction ^ 1;
            previousLevel = currentLevel;
        }
        return ret;
    }

    /**
     * Restore IP Addresses
     * 
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * 
     * For example:
     * Given "25525511135",
     * 
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     * 
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        String[] ip = new String[4];
        restoreIPAddressHelper(s, 0, 0, ret, ip);
        return ret;
    }

    private void restoreIPAddressHelper(String s, int segment, int start,
            List<String> ret, String[] ip) {
        if (segment == 4) {
            if (start == s.length()) {
                ret.add(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
            }
            else {
                return;
            }
        }
        if (segment == 3 && (s.length() - start > 3)) {
            return;
        }

        int number = 0;
        for (int i = start; i <= start + 3 && i < s.length(); ++i) {
            number = number * 10 + s.charAt(i) - '0';
            if (number <= 255) {
                String ipStr = s.substring(start, i + 1);
                ip[segment] = ipStr;
                restoreIPAddressHelper(s, segment + 1, i + 1, ret, ip);
            }
            if (number == 0) {
                // based on OJ feedback 000.000.000.000 is illegal format
                return;
            }
        }
    }

    /**
     * Find Minimum in Rotated Sorted Array
     * 
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * 
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * 
     * Find the minimum element.
     * 
     * You may assume no duplicate exists in the array.
     * 
     * @param num
     * @return
     */
    public int findMin(int[] num) {
        int left = 0, right = num.length - 1;
        int mid;
        int numLeft, numRight, numMid;
        while (left < right) {
            numLeft = num[left];
            numRight = num[right];
            if (numLeft < numRight) {
                break; // no rotation
            }
            mid = (left + right) / 2;
            numMid = num[mid];
            if (numLeft > numMid) {
                // rotation on the left side
                left = left + 1;
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return num[left];
    }

    public int findMin1(int[] num) {
        return findMinHelper(num, 0, num.length - 1);
    }

    private int findMinHelper(int[] num, int left, int right) {
        int numLeft = num[left];
        int numRight = num[right];
        if (numLeft < numRight || left == right) {
            return numLeft;
        }
        if (right - left == 1) {
            return Math.min(numLeft, numRight);
        }
        // has rotation in the section
        int mid = (left + right) / 2;
        int numMid = num[mid];
        if (numMid < numRight) {
            // rotation on the left side
            return findMinHelper(num, left + 1, mid);
        }
        else {
            return findMinHelper(num, mid + 1, right);
        }
    }

    /**
     * Remove Duplicates from Sorted Array II
     * 
     * Follow up for �Remove Duplicates�: What if duplicates are allowed at most twice?
     * For example, Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3]
     * 
     * @param A
     * @return
     */
    public int removeDuplicatesII(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length <= 2) {
            return A.length;
        }

        int resultLen = 2;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] == A[resultLen - 2]) {
                continue;
            }
            if (resultLen < i) {
                A[resultLen] = A[i];
            }
            ++resultLen;
        }
        return resultLen;
    }

    /**
     * Search in Rotated Sorted Array
     * 
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     * 
     * @param A
     * @param target
     * @return
     */
    public int search(int[] A, int target) {
        return searchHelper(A, 0, A.length - 1, target);
    }

    private int searchHelper(int[] A, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (A[mid] == target) {
            return mid;
        }
        if (A[left] <= A[mid]) {
            // left side is not rotated
            if (A[left] <= target && A[mid] > target) {
                return searchHelper(A, left, mid - 1, target);
            }
            else {
                // right side could be rotated and might have a chance
                return searchHelper(A, mid + 1, right, target);
            }
        }
        else {
            // left side is rotated
            // rigth side won't be roated
            if (A[mid] < target && A[right] >= target) {
                return searchHelper(A, mid + 1, right, target);
            }
            else {
                return searchHelper(A, left, mid - 1, target);
            }
        }
    }

    /**
     * Majority Element
     * 
     * Given an array of size n, find the majority element. The majority element is the element that appears more than
     * n/2 times.
     * 
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * 
     * @param num
     * @return
     */
    public int majorityElement(int[] num) {
        // Moore's voting algorithm http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
        // Faster than majorityElementII
        int count = 1;
        int element = num[0];
        for (int i = 1; i < num.length; ++i) {
            int n = num[i];
            if (n == element) {
                ++count;
            }
            else {
                if (count > 0) {
                    --count;
                }
                else {
                    element = n;
                }
            }
        }
        return element;
    }

    /**
     * Majority Element
     * 
     * Given an array of size n, find the majority element. The majority element is the element that appears more than
     * n/2 times.
     * 
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * 
     * @param num
     * @return
     */
    public int majorityElementII(int[] num) {
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        int threshold = num.length / 2;
        for (int i : num) {
            if (!lookup.containsKey(i)) {
                lookup.put(i, 0);
            }
            lookup.put(i, lookup.get(i) + 1);
        }
        for (int key : lookup.keySet()) {
            if (lookup.get(key) > threshold) {
                return key;
            }
        }
        throw new IllegalArgumentException(
                "Input does not have majority element");
    }

    /**
     * Gray Code
     * 
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * 
     * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray
     * code. A gray code sequence must begin with 0.
     * 
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * 
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * Note:
     * For a given n, a gray code sequence is not uniquely defined.
     * 
     * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
     * 
     * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     * 
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> ret = new ArrayList<Integer>(size);
        for (int i = 0; i < size; ++i) {
            ret.add(i ^ (i >> 1));
        }
        return ret;
    }

    /**
     * Generate Parentheses
     * 
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * For example, given n = 3, a solution set is:
     * 
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        char[] buffer = new char[n * 2];
        generateParenthesisHelper(ret, buffer, 0, 0);
        return ret;
    }

    private void generateParenthesisHelper(List<String> ret, char[] buffer,
            int pos, int leftTotal) {
        if (pos >= buffer.length) {
            if (leftTotal == 0) {
                // balanced pairs
                ret.add(new String(buffer));
            }
            return;
        }
        if (leftTotal + pos > buffer.length) {
            // prune
            return;
        }
        buffer[pos] = '(';
        generateParenthesisHelper(ret, buffer, pos + 1, leftTotal + 1);

        if (leftTotal > 0) {
            // we have an option for right parenthesis
            buffer[pos] = ')';
            generateParenthesisHelper(ret, buffer, pos + 1, leftTotal - 1);
        }
    }

    /**
     * Permutations
     * 
     * Given a collection of numbers, return all possible permutations.
     * 
     * For example,
     * [1,2,3] have the following permutations:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     * 
     * @param num
     * @return
     */
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return ret;
        }
        List<Integer> one = new ArrayList<Integer>();
        one.add(num[0]);
        ret.add(one);
        permuteHelper(ret, num, 1);
        return ret;
    }

    /**
     * build permutation recursively. N - 1 -> N, by inserting the new element in all positions
     * of the previous permutations
     * 
     * @param retVal
     * @param num
     * @param pos
     */
    @SuppressWarnings("unchecked")
    private void permuteHelper(List<List<Integer>> retVal, int[] num, int pos) {
        if (pos >= num.length) {
            return;
        }
        // length of N - 1
        int len = retVal.size();
        for (int i = 0; i < pos; ++i) {
            for (int j = 0; j < len; ++j) {
                retVal.add((List<Integer>) ((ArrayList<Integer>) retVal.get(j))
                        .clone());
            }
        }
        for (int i = 0; i <= pos; ++i) { // insert position
            for (int j = 0; j < len; ++j) { // iterate permutation of N - 1
                retVal.get(i * len + j).add(i, num[pos]);
            }
        }
        permuteHelper(retVal, num, pos + 1);
    }

    /**
     * Minimum Path Sum
     * 
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
     * the sum of all numbers along its path.
     * 
     * Note: You can only move either down or right at any point in time.
     * 
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int[] buffer = new int[nCols];
        buffer[0] = grid[0][0];
        for (int i = 1; i < nCols; ++i) {
            buffer[i] = buffer[i - 1] + grid[0][i];
        }

        for (int i = 1; i < nRows; ++i) {
            buffer[0] = buffer[0] + grid[i][0];
            for (int j = 1; j < nCols; ++j) {
                buffer[j] = Math.min(buffer[j] + grid[i][j], buffer[j - 1]
                        + grid[i][j]);
            }
        }
        return buffer[nCols - 1];
    }

    /**
     * Sqrt(x)
     * 
     * Implement int sqrt(int x).
     * 
     * Compute and return the square root of x.
     * 
     * @param x
     * @return
     */
    public int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException(
                    "Cannot compute square root of negative number");
        }
        return (int) searchSqrt(x, 0, x);
    }

    private long searchSqrt(long x, long min, long max) {
        if (min == max) {
            return min;
        }
        if (min == (max - 1)) {
            // handle this one separately
            long max2 = max * max;
            if (max2 == x) {
                return max;
            }
            return min; // leet code expect the floor of sqrt
        }
        /*
         * pick the closest. but obviously leet code expect the smaller one
         * if(min == (max - 1)) {
         * long min2 = min * min;
         * long max2 = max * max;
         * return (x - min2 > max2 - x ? max : min);
         * }
         */
        long mid = (min + max) / 2;
        long mm = mid * mid;
        if (mm == x) {
            return mid;
        }
        else if (mm > x) {
            // answer is on the left half
            return searchSqrt(x, min, mid);
        }
        else {
            // answer is on the right half
            return searchSqrt(x, mid, max);
        }
    }

    /**
     * Word Break
     * 
     * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
     * of one or more dictionary words.
     * 
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     * 
     * Return true because "leetcode" can be segmented as "leet code".
     * 
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // flag set to true if s.substring(0, idx - 1) is wordbreak
        boolean isWordBreak[] = new boolean[s.length() + 1];
        isWordBreak[0] = true; // empty string considered true
        for (int i = 0; i < s.length(); i++) { // loop string
            for (int j = 0; j <= i; ++j) { // increment from all previous wordbreak
                if (isWordBreak[j] && dict.contains(s.substring(j, i + 1))) {
                    isWordBreak[i + 1] = true;
                    break;
                }
            }
        }
        return isWordBreak[s.length()];
    }

    /**
     * Excel Sheet Column Number
     * 
     * Related to question Excel Sheet Column Title
     * 
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     * 
     * For example:
     * 
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     * 
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int ret = 0;
        for (char c : s.toCharArray()) {
            int n = c - 'A' + 1;
            ret = ret * 26 + n;
        }
        return ret;
    }

    /**
     * Factorial Trailing Zeroes
     * 
     * Given an integer n, return the number of trailing zeroes in n!.
     * 
     * Note: Your solution should be in logarithmic time complexity.
     * 
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        // just need to count factors of 5
        int ret = 0;
        while (n >= 5) {
            ret += n / 5;
            n = n / 5;
        }
        return ret;
    }

    /**
     * Longest Substring Without Repeating Characters
     * 
     * Given a string, find the length of the longest substring without repeating characters. For example, the longest
     * substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest
     * substring is "b", with the length of 1.
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (lookup.get(c) != null) {
                int len = i - left;
                if (len > maxLen) {
                    maxLen = len;
                }
                left = Math.max(lookup.get(c) + 1, left);
            }
            lookup.put(c, i);
        }
        maxLen = Math.max(maxLen, s.length() - left);
        return maxLen;
    }

    /**
     * Sudoku Solver
     * 
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * 
     * Empty cells are indicated by the character '.'.
     * 
     * You may assume that there will be only one unique solution.
     * 
     * @param board
     */
    public void solveSudoku(char[][] board) {
        ArrayList<Coord> unknowns = new ArrayList<Coord>();
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] == '.') {
                    unknowns.add(new Coord(row, col));
                }
            }
        }
        // assuming there is always one unique solution. no error checking here
        solver(board, unknowns, 0);
    }

    private class Coord {
        public int row;
        public int col;

        public Coord() {

        }

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean solver(char[][] board, ArrayList<Coord> unknowns, int pos) {
        if (pos >= unknowns.size()) {
            return true;
        }
        Coord coord = unknowns.get(pos);
        // TODO: should prune this loop based on known, should cut at least 50% runtime
        for (char c = '1'; c <= '9'; ++c) {
            board[coord.row][coord.col] = c;
            if (validateCoord(board, coord)) {
                if (solver(board, unknowns, pos + 1)) {
                    return true;
                }
            }
        }
        board[coord.row][coord.col] = '.';
        return false;
    }

    /**
     * validate sudoku rules for a single coordinate, check if row, col and block of that coordinate
     * has any duplicates
     * 
     * @param board
     * @param coord
     */
    private boolean validateCoord(char[][] board, Coord coord) {
        return validateSudokuCol(board, coord.col) &&
                validateSudokuRow(board, coord.row) &&
                validateSudokuBlock(board, coord);
    }

    private char ZERO = '0';

    private boolean validateSudokuRow(char[][] board, int row) {
        int flag = 0;
        for (char c : board[row]) {
            if (c == '.') {
                continue;
            }
            int myFlag = 1 << (c - ZERO);

            if ((flag & myFlag) > 0) {
                return false;
            }
            flag |= myFlag;
        }
        return true;
    }

    private boolean validateSudokuCol(char[][] board, int col) {
        int flag = 0;
        for (int row = 0; row < 9; ++row) {
            char c = board[row][col];
            if (c == '.') {
                continue;
            }
            int myFlag = 1 << (c - ZERO);

            if ((flag & myFlag) > 0) {
                return false;
            }
            flag |= myFlag;
        }
        return true;
    }

    /**
     * get 3X3 block, top left is block 0, block number goes row by row
     * 
     * @param board
     * @param rowNumber
     * @return
     */
    private boolean validateSudokuBlock(char[][] board, Coord coord) {
        int flag = 0;
        int topRow = (coord.row / 3) * 3;
        int leftCol = (coord.col / 3) * 3;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                char c = board[topRow + row][leftCol + col];
                if (c == '.') {
                    continue;
                }
                int myFlag = 1 << (c - ZERO);

                if ((flag & myFlag) > 0) {
                    return false;
                }
                flag |= myFlag;
            }
        }
        return true;
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
     * Combinations
     * 
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * 
     * For example,
     * If n = 4 and k = 2, a solution is:
     * 
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> combo = new ArrayList<Integer>();
        combineHelper(result, combo, n, k, 1);
        return result;
    }

    @SuppressWarnings("unchecked")
    private void combineHelper(List<List<Integer>> result,
            ArrayList<Integer> combo, int n, int k, int current) {
        if (combo.size() == k) {
            result.add((ArrayList<Integer>) combo.clone());
            return;
        }
        if (n - current + 1 < k - combo.size()) {
            return; // prune
        }
        combo.add(current);
        combineHelper(result, combo, n, k, current + 1);
        combo.remove(combo.size() - 1);
        combineHelper(result, combo, n, k, current + 1);
    }

    /**
     * Unique Paths II
     * 
     * Follow up for "Unique Paths":
     * 
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * 
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * 
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * 
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * 
     * Note: m and n will be at most 100.
     * 
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nRows = obstacleGrid.length;
        int nCols = obstacleGrid[0].length;
        int[] buffer = new int[nCols];
        buffer[0] = 1;
        for (int i = 0; i < nRows; ++i) {
            for (int j = 0; j < nCols; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    buffer[j] = 0;
                }
                else {
                    if (j > 0) {
                        buffer[j] = buffer[j - 1] + buffer[j];
                    }
                }
            }
        }
        return buffer[nCols - 1];
    }

    /**
     * Search in Rotated Sorted Array II
     * 
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * 
     * Would this affect the run-time complexity? How and why?
     * 
     * Write a function to determine if a given target is in the array.
     * 
     * @param A
     * @param target
     * @return
     */
    public boolean searchII(int[] A, int target) {
        return searchIIHelper(A, 0, A.length - 1, target);
    }

    private boolean searchIIHelper(int[] A, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (A[mid] == target) {
            return true;
        }
        else if (A[left] > A[mid]) {
            // pivot on the left side
            if (A[mid] < target && A[right] >= target) {
                return searchIIHelper(A, mid + 1, right, target);
            }
            else {
                return searchIIHelper(A, left, mid - 1, target);
            }
        }
        else if (A[left] < A[mid]) {
            // rotation pivot on right side, or does not exist
            if (A[left] <= target && A[mid] > target) {
                return searchIIHelper(A, left, mid - 1, target);
            }
            else {
                return searchIIHelper(A, mid + 1, right, target);
            }

        }
        else {
            // left equal to middle
            return searchIIHelper(A, left + 1, right, target);
        }
    }

    /**
     * Largest Number
     * 
     * Given a list of non negative integers, arrange them such that they form the largest number.
     * 
     * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
     * 
     * Note: The result may be very large, so you need to return a string instead of an integer.
     * 
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     * 
     * @param num
     * @return
     */
    public String largestNumber(int[] num) {
        String[] s = new String[num.length];
        for (int i = 0; i < num.length; ++i) {
            s[i] = Integer.toString(num[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String a1 = s1 + s2;
                String a2 = s2 + s1;
                return a2.compareTo(a1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; ++i) {
            sb.append(s[i]);
        }
        String ret = sb.toString();
        // remove leading zeroes
        int pos = -1;
        int i = 0;
        while (i < ret.length()) {
            if (ret.charAt(i) != '0') {
                break;
            }
            pos = i;
            ++i;
        }
        if (pos == ret.length() - 1) {
            return "0";
        }
        if (pos > 0) {
            return ret.substring(pos);
        }
        return ret;
    }

    /**
     * Spiral Matrix II
     * 
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * 
     * For example,
     * Given n = 3,
     * 
     * You should return the following matrix:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     * 
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int start = 1;
        for (int layer = 0; layer < (n + 1) / 2; ++layer) {
            start = fillCircle(ret, n, layer, start);
        }
        return ret;
    }

    /**
     * fill a circle, return the next number
     * 
     * @param matrix
     * @param n
     * @param layer Layer number, start from 0
     * @param start
     * @return
     */
    private int fillCircle(int[][] matrix, int n, int layer, int start) {
        // boundaries of layer n
        int left = layer;
        int top = layer;
        int bottom = n - 1 - layer;
        int right = n - 1 - layer;
        if (left == right) {
            matrix[left][top] = start++;
            return start;
        }
        // go left
        for (int i = left; i < right; ++i) {
            matrix[top][i] = start++;
        }
        // down
        for (int i = top; i < bottom; ++i) {
            matrix[i][right] = start++;
        }
        // left
        for (int i = right; i > left; --i) {
            matrix[bottom][i] = start++;
        }
        // up
        for (int i = bottom; i > top; --i) {
            matrix[i][left] = start++;
        }
        return start;
    }

    /**
     * Set Matrix Zeroes
     * 
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     * 
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        // use top row and left column for flag
        boolean topRowHasZero = false;
        boolean leftColHasZero = false;
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        for (int i = 0; i < nCols; ++i) {
            if (matrix[0][i] == 0) {
                topRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < nRows; ++i) {
            if (matrix[i][0] == 0) {
                leftColHasZero = true;
                break;
            }
        }
        for (int row = 0; row < nRows; ++row) {
            for (int col = 0; col < nCols; ++col) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < nRows; ++row) {
            for (int col = 1; col < nCols; ++col) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (topRowHasZero) {
            for (int col = 0; col < nCols; ++col) {
                matrix[0][col] = 0;
            }
        }
        if (leftColHasZero) {
            for (int row = 0; row < nRows; ++row) {
                matrix[row][0] = 0;
            }
        }
    }

    /**
     * Combination Sum
     * 
     * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the
     * candidate numbers sums to T.
     * 
     * The same repeated number may be chosen from C unlimited number of times.
     * 
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 <= a2 <= � <= ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 2,3,6,7 and target 7,
     * A solution set is:
     * [7]
     * [2, 2, 3]
     * 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // candidates to sorted set
        SortedSet<Integer> c = new TreeSet<Integer>();
        for (int i : candidates) {
            c.add(i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> intermediate = new ArrayList<Integer>();
        Integer[] i = c.toArray(new Integer[0]);
        combinationSumHelper(ret, i, intermediate, target, 0);
        return ret;
    }

    @SuppressWarnings("unchecked")
    private void combinationSumHelper(List<List<Integer>> result,
            Integer[] candidates,
            ArrayList<Integer> intermediate, int target, int startIdx) {
        if (target == 0) {
            ArrayList<Integer> solution = (ArrayList<Integer>) intermediate
                    .clone();
            result.add(solution);
        }
        for (int i = startIdx; i < candidates.length; ++i) {
            int n = candidates[i];
            if (n > target) {
                return; // sorted, no need to search further
            }
            intermediate.add(n);
            combinationSumHelper(result, candidates, intermediate, target - n,
                    i);
            intermediate.remove(intermediate.size() - 1);
        }
    }

    /**
     * Fraction to Recurring Decimal
     * 
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string
     * format.
     * 
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     * 
     * For example,
     * 
     * Given numerator = 1, denominator = 2, return "0.5".
     * Given numerator = 2, denominator = 1, return "2".
     * Given numerator = 2, denominator = 3, return "0.(6)".
     * Credits:
     * Special thanks to @Shangrila for adding this problem and creating all test cases.
     * 
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        // normalize the calculation
        int sign = (int) (Math.signum(numerator) * Math.signum(denominator));
        long numeratorL = numerator;
        long denominatorL = denominator;
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);
        long intPart = numeratorL / denominatorL;
        numeratorL = numeratorL % denominatorL;
        String fractionPart = "";
        // remainder lookup. key: reminder, value: position
        HashMap<Long, Integer> lookup = new HashMap<Long, Integer>();
        int counter = 0;
        int repeatPos = -1;
        while (numeratorL > 0) {
            numeratorL = numeratorL * 10;
            if (lookup.containsKey(numeratorL)) {
                repeatPos = lookup.get(numeratorL);
                break;
            }
            fractionPart += Long.toString(numeratorL / denominatorL);

            lookup.put(numeratorL, counter);
            numeratorL = numeratorL % denominatorL;
            counter++;
        }
        String result = "";
        if (sign < 0) {
            result = "-";
        }
        result += Long.toString(intPart);

        if (fractionPart.length() > 0) {
            result += ".";
            if (repeatPos >= 0) {
                result = result
                        + fractionPart.substring(0, repeatPos)
                        + "("
                        +
                        fractionPart
                                .substring(repeatPos, fractionPart.length())
                        + ")";
            }
            else {
                result += fractionPart;
            }
        }
        return result;
    }

    /**
     * Word Break II
     * 
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a
     * valid dictionary word.
     * 
     * Return all such possible sentences.
     * 
     * For example, given
     * s = "catsanddog",
     * dict = ["cat", "cats", "and", "sand", "dog"].
     * 
     * A solution is ["cats and dog", "cat sand dog"].
     * 
     * @param s
     * @param dict
     * @return
     */
    public List<String> wordBreakII(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        // flag, if false, we know the right substring after i has no solution
        // true just mean it is worthwhile to search down the road
        boolean isWordBreak[] = new boolean[s.length()];
        for (int i = 0; i < isWordBreak.length; ++i) {
            isWordBreak[i] = true;
        }
        String sentence = "";
        findAllSolutions(result, s, dict, 0, sentence, isWordBreak);
        return result;
    }

    private boolean findAllSolutions(List<String> result, String s,
            Set<String> dict, int pos, String sentence, boolean[] isWordBreak) {
        if (pos == s.length()) {
            // found a solution
            result.add(sentence.substring(0, sentence.length() - 1));
            return true;
        }
        if (!isWordBreak[pos]) {
            return false; // the right sub string has no solution
        }
        boolean hasSolution = false;
        for (int i = pos + 1; i <= s.length(); ++i) {
            String tmp = s.substring(pos, i);
            if (dict.contains(tmp)) {
                isWordBreak[pos] = findAllSolutions(result, s, dict, i,
                        sentence + tmp + " ", isWordBreak);
                hasSolution |= isWordBreak[pos];
            }
        }
        return hasSolution;
    }

    /**
     * Word Ladder II
     * 
     * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to
     * end, such that:
     * 
     * Only one letter can be changed at a time
     * Each intermediate word must exist in the dictionary
     * For example,
     * 
     * Given:
     * start = "hit"
     * end = "cog"
     * dict = ["hot","dot","dog","lot","log"]
     * Return
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * Note:
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * 
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        // -- 1. find shorted ladder length
        // intermediate result, list of layers, each layer is a lookup of possbile word
        // in this layer, and their parents in the previous layer
        List<HashMap<String, List<String>>> layers = new ArrayList<HashMap<String, List<String>>>();
        HashMap<String, List<String>> currentLevel = new HashMap<String, List<String>>();
        currentLevel.put(start, new ArrayList<String>());
        layers.add(currentLevel);
        int depth = 0;
        boolean foundLadder = false;
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        visited.put(start, depth);
        while (!currentLevel.isEmpty() && !foundLadder) {
            ++depth;
            HashMap<String, List<String>> nextLevel = new HashMap<String, List<String>>();
            for (String parentWord : currentLevel.keySet()) {
                char[] arrChar = parentWord.toCharArray();
                for (int i = 0; i < parentWord.length(); ++i) {
                    char oldChar = arrChar[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == oldChar) {
                            continue;
                        }
                        arrChar[i] = c;
                        String newStr = new String(arrChar);
                        if (visited.containsKey(newStr)
                                && visited.get(newStr) < depth) {
                            // already visited in previous layer
                            continue;
                        }
                        if (newStr.equals(end)) {
                            foundLadder = true;
                        }
                        if (newStr.equals(end) || dict.contains(newStr)) {
                            visited.put(newStr, depth);
                            List<String> parents;
                            if (nextLevel.containsKey(newStr)) {
                                parents = nextLevel.get(newStr);
                            }
                            else {
                                parents = new ArrayList<String>();
                                nextLevel.put(newStr, parents);
                            }
                            parents.add(parentWord);
                        }
                    }
                    arrChar[i] = oldChar;
                }
            }
            layers.add(nextLevel);
            currentLevel = nextLevel;
        }
        ;
        if (foundLadder) {
            ArrayList<String> path = new ArrayList<String>();
            path.add(end);
            findLaddersHelper(layers, path, depth, end, result);
        }
        return result;
    }

    private void findLaddersHelper(List<HashMap<String, List<String>>> layers,
            ArrayList<String> path,
            int depth, String word, List<List<String>> result) {
        if (depth == 0) {
            // reverse and add to result
            ArrayList<String> ladder = new ArrayList<String>();
            for (int i = path.size() - 1; i >= 0; --i) {
                ladder.add(path.get(i));
            }
            result.add(ladder);
            return;
        }
        List<String> parents = layers.get(depth).get(word);
        for (String s : parents) {
            path.add(s);
            findLaddersHelper(layers, path, depth - 1, s, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * First Missing Positive
     * 
     * Given an unsorted integer array, find the first missing positive integer.
     * 
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * 
     * Your algorithm should run in O(n) time and uses constant space.
     * 
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            while (A[i] <= len && A[i] >= 1  // A[i] could be part of the consecurity positive number
                    && A[i] != i + 1        // A[i] is not in it's right place
                    && A[A[i] - 1] != A[i] // the right place has a different number
            ) {
                // swap A[i] with A[A[i]]
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < len; ++i) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    /**
     * Insertion Sort List
     * 
     * Sort a linked list using insertion sort.
     * 
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode iterator = head;
        while (iterator != null) {
            ListNode insertPos = newHead;
            while (insertPos.next != null && insertPos.next.val < iterator.val) {
                insertPos = insertPos.next;
            }
            ListNode tmp = insertPos.next;
            insertPos.next = iterator;
            iterator = iterator.next;
            insertPos.next.next = tmp;
        }
        return newHead.next;
    }

    /**
     * Remove Duplicates from Sorted List II
     * 
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
     * original list.
     * 
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        ListNode left = head;
        while (left != null) {
            if (left.next == null || left.next.val != left.val) {
                newTail.next = left;
                newTail = left;
                left = left.next;
            }
            else {
                // skip all the duplicated values
                ListNode right = left.next;
                while (right != null && right.val == left.val) {
                    right = right.next;
                }
                left = right;
            }
        }
        newTail.next = null;
        return newHead.next;
    }

    /**
     * Combination Sum II
     * 
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
     * candidate numbers sums to T.
     * 
     * Each number in C may only be used once in the combination.
     * 
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 <= a2 <= � <= ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
     * A solution set is:
     * [1, 7]
     * [1, 2, 5]
     * [2, 6]
     * [1, 1, 6]
     * 
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        combinationSum2DFS(num, target, path, result, 0);
        return result;
    }

    @SuppressWarnings("unchecked")
    private void combinationSum2DFS(int[] num, int target,
            ArrayList<Integer> path,
            List<List<Integer>> result, int startIdx) {
        if (target == 0) {
            result.add((ArrayList<Integer>) path.clone());
            return;
        }
        if (target < 0 || startIdx >= num.length) {
            return;
        }
        int previous = -1;
        for (int i = startIdx; i < num.length; ++i) {
            if (num[i] == previous) {
                // repeating number only check once at this depth
                // otherwise, we will see duplicated result sets
                continue;
            }
            path.add(num[i]);
            combinationSum2DFS(num, target - num[i], path, result, i + 1);
            path.remove(path.size() - 1);
            previous = num[i];
        }
    }
}
