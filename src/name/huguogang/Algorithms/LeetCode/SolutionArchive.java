package name.huguogang.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

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
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
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
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each
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
}
