package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static test.name.huguogang.Algorithms.LeetCode.Util.printArray;
import static test.name.huguogang.Algorithms.LeetCode.Util.printLinkedList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListArray;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printTreeByLevel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import name.huguogang.Algorithms.LeetCode.ListNode;
import name.huguogang.Algorithms.LeetCode.RandomListNode;
import name.huguogang.Algorithms.LeetCode.SolutionArchive;
import name.huguogang.Algorithms.LeetCode.TreeLinkNode;
import name.huguogang.Algorithms.LeetCode.TreeNode;

import org.junit.Test;

@SuppressWarnings("unused")
public class SolutionArchiveTest {
    private SolutionArchive solution = new SolutionArchive();

    @Test
    public void testRemoveDuplicates() {
        {
            int[] A = {};
            int len = solution.removeDuplicates(A);
            assertEquals(0, len);
        }
        {
            int[] A = { 1 };
            int len = solution.removeDuplicates(A);
            assertEquals(1, len);
        }
        {
            int[] A = { 1, 2, 3, 4, 5, 6 };
            int len = solution.removeDuplicates(A);
            assertEquals(6, len);
        }
        {
            int[] A = { 1, 1, 1, 1, 1 };
            int len = solution.removeDuplicates(A);
            assertEquals(1, len);
        }
        {
            int[] A = { 1, 2, 2, 3, 3, 3, 3, 3, 3 };
            int len = solution.removeDuplicates(A);
            assertEquals(3, len);
        }
        {
            int[] A = { 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 5, 6 };
            int len = solution.removeDuplicates(A);
            assertEquals(6, len);
        }
    }

    @Test
    public void testatoi() {
        String str;
        int ret, expected;

        str = "1";
        expected = 1;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "34567";
        expected = 34567;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "-345";
        expected = -345;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "   345adfdsb";
        expected = 345;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "2147483649";
        expected = Integer.MAX_VALUE;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "";
        expected = 0;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "  +dsafsa";
        expected = 0;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "  -+1";
        expected = 0;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "  -2147483648";
        expected = Integer.MIN_VALUE;
        ret = solution.atoi(str);
        assertEquals(expected, ret);

        str = "  -2147483647";
        expected = -2147483647;
        ret = solution.atoi(str);
        assertEquals(expected, ret);
    }

    @Test
    public void testSubsets() {
        {
            int[] S = {};
            List<List<Integer>> ret;

            ret = solution.subsets(S);
            printListList(ret);
        }

        {
            int[] S = { 1 };
            List<List<Integer>> ret;

            ret = solution.subsets(S);
            printListList(ret);
        }

        {
            int[] S = { 1, 2, 3, 4 };
            List<List<Integer>> ret;

            ret = solution.subsets(S);
            printListList(ret);
        }
        {
            // OJ expected output:
            // [],[0,],[1,],[4,],[0,1,],[0,4,],[1,4,],[0,1,4,]
            int[] S = { 4, 1, 0 };
            List<List<Integer>> ret;

            ret = solution.subsets(S);
            printListList(ret);
        }
    }

    @Test
    public void testSubsetsI() {
        System.out.println("Test subsetsI");
        {
            int[] S = {};
            List<List<Integer>> ret;

            ret = solution.subsetsI(S);
            printListList(ret);
        }

        {
            int[] S = { 1 };
            List<List<Integer>> ret;

            ret = solution.subsetsI(S);
            printListList(ret);
        }

        {
            int[] S = { 1, 2, 3, 4 };
            List<List<Integer>> ret;

            ret = solution.subsetsI(S);
            printListList(ret);
        }
        {
            // OJ expected output:
            // [],[0,],[1,],[4,],[0,1,],[0,4,],[1,4,],[0,1,4,]
            int[] S = { 4, 1, 0 };
            List<List<Integer>> ret;

            ret = solution.subsetsI(S);
            printListList(ret);
        }
    }

    @Test
    public void testReverseWords() {
        String s;
        String ret;
        String expected;

        s = "the sky is blue";
        expected = "blue is sky the";
        ret = solution.reverseWords(s);
        assertEquals(expected, ret);

        s = "               the sky   \r\n is  blue  ";
        expected = "blue is sky the";
        ret = solution.reverseWords(s);
        assertEquals(expected, ret);
    }

    @Test
    public void testSingleNumber() {
        {
            int[] A = { 3, 2, 1, 2, 3 };
            int expected = 1;
            int ret = solution.singleNumber(A);
            assertEquals(expected, ret);
        }

        {
            int[] A = { -3, -2, -1, -2, -3 };
            int expected = -1;
            int ret = solution.singleNumber(A);
            assertEquals(expected, ret);
        }

        {
            int[] A = { -3, 2, 1, 2, -3 };
            int expected = 1;
            int ret = solution.singleNumber(A);
            assertEquals(expected, ret);
        }
        {
            int[] A = { 3, -2, 0, -2, 3 };
            int expected = 0;
            int ret = solution.singleNumber(A);
            assertEquals(expected, ret);
        }
    }

    @Test
    public void testPostorderTraversal() {
        System.out.println("testPostorderTraversal");
        List<Integer> l;
        TreeNode n;
        n = null;
        l = solution.postorderTraversal(n);
        printList(l);

        n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);
        l = solution.postorderTraversal(n);
        printList(l);

        n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);
        n.left = new TreeNode(4);
        l = solution.postorderTraversal(n);
        printList(l);
    }

    @Test
    public void testPostorderTraversalI() {
        System.out.println("testPostorderTraversalI");
        List<Integer> l;
        TreeNode n;
        n = null;
        l = solution.postorderTraversalI(n);
        printList(l);

        n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);
        l = solution.postorderTraversalI(n);
        printList(l);

        n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);
        n.left = new TreeNode(4);
        l = solution.postorderTraversalI(n);
        printList(l);
    }

    @Test
    public void testTrap() {
        {
            int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
            int expected = 6;
            int ret = solution.trap(A);
            assertEquals(expected, ret);
        }

        {
            int[] A = {};
            int expected = 0;
            int ret = solution.trap(A);
            assertEquals(expected, ret);
        }

        {
            int[] A = { 1 };
            int expected = 0;
            int ret = solution.trap(A);
            assertEquals(expected, ret);
        }
    }

    @Test
    public void testNumDecodings() {
        System.out.println("testNumDecodings");
        String s;
        int ret, expected;

        s = "110";
        expected = 1;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "";
        expected = 0;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "1";
        expected = 1;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "0";
        expected = 0;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "12";
        expected = 2;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "13";
        expected = 2;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "30";
        expected = 0;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);

        s = "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565";
        expected = 5898240;
        ret = solution.numDecodings(s);
        assertEquals(expected, ret);
    }

    @Test
    public void testDivide() {
        int dividend, divisor, result, expected;

        dividend = Integer.MIN_VALUE;
        divisor = -1;
        // expected behavior matching underflow error
        // by Java runtime?
        expected = Integer.MIN_VALUE;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);

        dividend = -1010369383;
        divisor = -2147483648;
        expected = 0;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);

        dividend = 2147483647;
        divisor = 1;
        expected = 2147483647;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);

        dividend = 12;
        divisor = 3;
        expected = 4;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);

        dividend = 14;
        divisor = 3;
        expected = 4;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);

        dividend = -12;
        divisor = 3;
        expected = -4;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);

        dividend = 12;
        divisor = -3;
        expected = -4;
        result = solution.divide(dividend, divisor);
        assertEquals(expected, result);
    }

    @Test
    public void testMergeTwoLists() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);

        l1.next = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode ret = solution.mergeTwoLists(l1, l2);
    }

    @Test
    public void testLevelOrder() {
        System.out.print("Test levelOrder\r\n");
        TreeNode root = null;
        List<List<Integer>> ret;

        ret = solution.levelOrder(root);
        printListList(ret);

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ret = solution.levelOrder(root);
        printListList(ret);
    }

    @Test
    public void testSumNumbers() {
        System.out.print("Test SumNumbers\r\n");
        TreeNode root = null;
        int ret, expected;

        ret = solution.sumNumbers(root);
        expected = 0;
        assertEquals(expected, ret);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        expected = 25;
        ret = solution.sumNumbers(root);
        assertEquals(expected, ret);
    }

    @Test
    public void testPow() {
        double x, ret, expected;
        int n;
        double epsilon = 1e-10;

        x = 2;
        n = 1;
        expected = 2;
        ret = solution.pow(x, n);
        assertEquals(expected, ret, epsilon);

        x = 2;
        n = -1;
        expected = 0.5;
        ret = solution.pow(x, n);
        assertEquals(expected, ret, epsilon);

        x = 2;
        n = 0;
        expected = 1;
        ret = solution.pow(x, n);
        assertEquals(expected, ret, epsilon);

        x = 2;
        n = 5;
        expected = 32;
        ret = solution.pow(x, n);
        assertEquals(expected, ret, epsilon);

        x = 2;
        n = -5;
        expected = 1 / 32.0;
        ret = solution.pow(x, n);
        assertEquals(expected, ret, epsilon);
    }

    @Test
    public void testIsSymmetric() {
        TreeNode root = null;
        boolean ret, expected;

        expected = true;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        ret = solution.isSymmetric(root);
        assertEquals(expected, ret);

        // {1,2,2,#,3,#,3}
        expected = false;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        ret = solution.isSymmetric(root);
        assertEquals(expected, ret);
    }

    @Test
    public void testEvalRPN() {
        String[] tokens;
        int ret, expected;

        tokens = new String[] { "2", "1", "+", "3", "*" };
        ret = solution.evalRPN(tokens);
        expected = 9;
        assertEquals(expected, ret);

        tokens = new String[] { "4", "13", "5", "/", "+" };
        ret = solution.evalRPN(tokens);
        expected = 6;
        assertEquals(expected, ret);
    }

    @Test
    public void testGetPermutation() {
        int n, k;
        String ret, expected;

        n = 3;
        k = 5;
        expected = "312";
        ret = solution.getPermutation(n, k);
        assertEquals(expected, ret);
    }

    @Test
    public void testCopyRandomList() {
        System.out.println("Test copyRandomList");
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;

        RandomListNode ret;
        ret = solution.copyRandomList(head);
        System.out.println(ret.label);

        head.random = null;
        ret = solution.copyRandomList(head);
        System.out.println(ret.label);
    }

    @Test
    public void testIsvalid() {
        String s;
        boolean ret, expected;

        s = "{(([][]()))}";
        expected = true;
        ret = solution.isValid(s);
        assertEquals(expected, ret);
    }

    @Test
    public void testSearchRange() {
        {
            // [2,2], 3
            int[] A = { 2, 2 };
            int target = 3;
            int[] expected = { -1, -1 };
            int[] ret = solution.searchRange(A, target);
            assertArrayEquals(expected, ret);

        }
        {
            int[] A = { 5, 7, 7, 8, 8, 10 };
            int target = 8;
            int[] expected = { 3, 4 };
            int[] ret = solution.searchRange(A, target);
            assertArrayEquals(expected, ret);

            target = 0;
            expected = new int[] { -1, -1 };
            ret = solution.searchRange(A, target);
            assertArrayEquals(expected, ret);
        }
        {
            int[] A = {};
            int target = 8;
            int[] expected = { -1, -1 };
            int[] ret = solution.searchRange(A, target);
            assertArrayEquals(expected, ret);
        }
        {
            int[] A = { 5 };
            int target = 5;
            int[] expected = { 0, 0 };
            int[] ret = solution.searchRange(A, target);
            assertArrayEquals(expected, ret);
        }
    }

    @Test
    public void testCountAndSay() {
        int n;
        String ret, expected;

        n = 1;
        expected = "1";
        ret = solution.countAndSay(n);
        assertEquals(expected, ret);

        n = 3;
        expected = "21";
        ret = solution.countAndSay(n);
        assertEquals(expected, ret);

        n = 8;
        expected = "1113213211";
        ret = solution.countAndSay(n);
        assertEquals(expected, ret);
    }

    @Test
    public void testIsPalindromeString() {
        String s;
        boolean ret, expected;

        s = "A man, a plan, a canal: Panama";
        expected = true;
        ret = solution.isPalindrome(s);
        assertEquals(expected, ret);

        s = "race a car";
        expected = false;
        ret = solution.isPalindrome(s);
        assertEquals(expected, ret);
    }

    @Test
    public void testHasPathSum() {
        TreeNode root;
        int sum;
        boolean ret, expected;

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        sum = 9;
        ret = solution.hasPathSum(root, sum);
        expected = true;
        assertEquals(expected, ret);

        sum = 3;
        ret = solution.hasPathSum(root, sum);
        expected = false;
        assertEquals(expected, ret);
    }

    @Test
    public void testConvert() {
        String s, ret, expected;
        int nRows;

        s = "";
        nRows = 1;
        expected = "";
        ret = solution.convert(s, nRows);
        assertEquals(expected, ret);

        s = "a";
        nRows = 1;
        expected = "a";
        ret = solution.convert(s, nRows);
        assertEquals(expected, ret);

        s = "abcdefghi";
        nRows = 2;
        expected = "acegibdfh";
        ret = solution.convert(s, nRows);
        assertEquals(expected, ret);

        s = "abcd";
        nRows = 10;
        expected = "abcd";
        ret = solution.convert(s, nRows);
        assertEquals(expected, ret);

        s = "PAYPALISHIRING";
        nRows = 3;
        expected = "PAHNAPLSIIGYIR";
        ret = solution.convert(s, nRows);
        assertEquals(expected, ret);
    }

    @Test
    public void testReverse() {
        int x, ret, expected;

        x = 123;
        expected = 321;
        ret = solution.reverse(x);
        assertEquals(expected, ret);

        x = -123;
        expected = -321;
        ret = solution.reverse(x);
        assertEquals(expected, ret);

        x = 0;
        expected = 0;
        ret = solution.reverse(x);
        assertEquals(expected, ret);

        x = Integer.MAX_VALUE;
        expected = 0;
        ret = solution.reverse(x);
        assertEquals(expected, ret);

        x = Integer.MIN_VALUE;
        expected = 0;
        ret = solution.reverse(x);
        assertEquals(expected, ret);
    }

    @Test
    public void testIsPalindromeNumber() {
        int x;
        boolean expected;

        x = 1000000001;
        expected = true;
        assertEquals(expected, solution.isPalindrome(x));

        x = 1000021;
        expected = false;
        assertEquals(expected, solution.isPalindrome(x));

        x = 10;
        expected = false;
        assertEquals(expected, solution.isPalindrome(x));

        x = 123;
        expected = false;
        assertEquals(expected, solution.isPalindrome(x));

        x = -1;
        expected = false;
        assertEquals(expected, solution.isPalindrome(x));

        x = 121;
        expected = true;
        assertEquals(expected, solution.isPalindrome(x));

        x = 0;
        expected = true;
        assertEquals(expected, solution.isPalindrome(x));

        x = 1234321;
        expected = true;
        assertEquals(expected, solution.isPalindrome(x));

        x = 123321;
        expected = true;
        assertEquals(expected, solution.isPalindrome(x));

        x = Integer.MAX_VALUE;
        expected = false;
        assertEquals(expected, solution.isPalindrome(x));

        x = Integer.MIN_VALUE;
        expected = false;
        assertEquals(expected, solution.isPalindrome(x));
    }

    @Test
    public void testRemoveNthFromEnd() {
        ListNode head, ret;
        int n;

        head = new ListNode(1);
        n = 1;
        ret = solution.removeNthFromEnd(head, n);
        printLinkedList(head);
        ;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        n = 2;
        ret = solution.removeNthFromEnd(head, n);
        printLinkedList(head);
        ;

    }

    @Test
    public void testLongestConsecutive() {
        int[] num;
        int expected;

        num = new int[] { 100, 4, 200, 1, 3, 2 };
        expected = 4;
        assertEquals(expected, solution.longestConsecutive(num));

        num = new int[] {};
        expected = 0;
        assertEquals(expected, solution.longestConsecutive(num));
    }

    @Test
    public void testFlatter() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        solution.flatten(root);
    }

    @Test
    public void testExist() {
        char[][] board;
        String word;
        boolean expected;

        board = new char[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        word = "ABCCED";
        expected = true;
        assertEquals(expected, solution.exist(board, word));

        word = "SEE";
        expected = true;
        assertEquals(expected, solution.exist(board, word));

        word = "ABCB";
        expected = false;
        assertEquals(expected, solution.exist(board, word));
    }

    @Test
    public void testLongestCommonPrefix() {
        String[] strs;
        String expected;

        strs = new String[] {};
        expected = "";
        assertEquals(expected, solution.longestCommonPrefix(strs));

        strs = new String[] { "123" };
        expected = "123";
        assertEquals(expected, solution.longestCommonPrefix(strs));

        strs = new String[] { "123", "123" };
        expected = "123";
        assertEquals(expected, solution.longestCommonPrefix(strs));

        strs = new String[] { "1235", "1234" };
        expected = "123";
        assertEquals(expected, solution.longestCommonPrefix(strs));
    }

    @Test
    public void testGetIntersectionNode() {
        ListNode headA, headB, expected;

        headA = new ListNode(1);
        headB = new ListNode(2);
        headB.next = new ListNode(4);
        headB.next.next = new ListNode(6);
        expected = null;
        assertEquals(expected, solution.getIntersectionNode(headA, headB));

        headA = new ListNode(1);
        headB = new ListNode(3);
        expected = null;
        assertEquals(expected, solution.getIntersectionNode(headA, headB));

        headA = headB = null;
        expected = null;
        assertEquals(expected, solution.getIntersectionNode(headA, headB));

        headA = new ListNode(1);
        headA.next = expected = new ListNode(2);
        headB = new ListNode(3);
        headB.next = expected;
        expected.next = new ListNode(4);
        assertEquals(expected, solution.getIntersectionNode(headA, headB));
    }

    @Test
    public void testRomanToInt() {
        String s;
        int expected;

        s = "VI";
        expected = 6;
        assertEquals(expected, solution.romanToInt(s));

        s = "IV";
        expected = 4;
        assertEquals(expected, solution.romanToInt(s));

        s = "V";
        expected = 5;
        assertEquals(expected, solution.romanToInt(s));

        s = "MLXVI";
        expected = 1066;
        assertEquals(expected, solution.romanToInt(s));

        s = "MCMLIV";
        expected = 1954;
        assertEquals(expected, solution.romanToInt(s));

    }

    @Test
    public void testGenerate() {
        int n;
        List<List<Integer>> ret;

        n = 5;
        ret = solution.generate(n);
        printListList(ret);
    }

    @Test
    public void testGetRow() {
        int rowIndex;
        List<Integer> ret;

        rowIndex = 5;
        ret = solution.getRow(rowIndex);
        printList(ret);
    }

    @Test
    public void testMinDepth() {
        int expected;

        expected = 3;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        assertEquals(expected, solution.minDepth(root));
    }

    @Test
    public void testNumTrees() {
        int n, expected;

        n = 3;
        expected = 5;
        assertEquals(expected, solution.numTrees(n));

        n = 4;
        expected = 14;
        assertEquals(expected, solution.numTrees(n));
    }

    @Test
    public void testCanJump() {
        int[] A;
        boolean expected;

        A = new int[] { 2, 3, 1, 1, 4 };
        expected = true;
        assertEquals(expected, solution.canJump(A));

        A = new int[] { 3, 2, 1, 0, 4 };
        expected = false;
        assertEquals(expected, solution.canJump(A));
    }

    @Test
    public void testIsBalance() {
        TreeNode root;
        boolean expected;

        expected = false;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        assertEquals(expected, solution.isBalanced(root));

        expected = true;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        assertEquals(expected, solution.isBalanced(root));

    }

    @Test
    public void testMaxDepth() {
        TreeNode root;
        int expected;

        expected = 3;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        assertEquals(expected, solution.maxDepth(root));

        expected = 3;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        assertEquals(expected, solution.maxDepth(root));
    }

    @Test
    public void testPlusOne() {
        int[] digits;
        int[] expected;

        digits = new int[] { 9 };
        expected = new int[] { 1, 0 };
        assertArrayEquals(expected, solution.plusOne(digits));

        digits = new int[] { 1, 0 };
        expected = new int[] { 1, 1 };
        assertArrayEquals(expected, solution.plusOne(digits));

        digits = new int[] { 9, 9, 9 };
        expected = new int[] { 1, 0, 0, 0 };
        assertArrayEquals(expected, solution.plusOne(digits));

        digits = new int[] { 1, 2, 9, 9 };
        expected = new int[] { 1, 3, 0, 0 };
        assertArrayEquals(expected, solution.plusOne(digits));
    }

    @Test
    public void testHasCycle() {
        ListNode head, temp;
        boolean expected;

        expected = true;
        head = new ListNode(1);
        head.next = temp = new ListNode(2);
        temp.next = new ListNode(3);
        temp.next.next = temp;
        assertEquals(expected, solution.hasCycle(head));
    }

    @Test
    public void testRemoveElement() {
        int[] A;
        int elem;
        int expected;

        expected = 0;
        A = new int[] {};
        elem = 0;
        assertEquals(expected, solution.removeElement(A, elem));
        printArray(A);

        expected = 0;
        A = new int[] { 0 };
        elem = 0;
        assertEquals(expected, solution.removeElement(A, elem));
        printArray(A);

        expected = 0;
        A = new int[] { 0, 0, 0, 0 };
        elem = 0;
        assertEquals(expected, solution.removeElement(A, elem));
        printArray(A);

        expected = 4;
        A = new int[] { 0, 1, 0, 0, 2, 3, 0, 3 };
        elem = 0;
        assertEquals(expected, solution.removeElement(A, elem));
        printArray(A);
    }

    @Test
    public void testConnect() {
        TreeLinkNode root;
        root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        solution.connect(root);
    }

    @Test
    public void testSearchInsert() {
        int[] A;
        int target, expected;

        A = new int[] { 1, 3, 5, 6 };
        target = 5;
        expected = 2;
        assertEquals(expected, solution.searchInsert(A, target));

        A = new int[] { 1, 3, 5, 6 };
        target = 2;
        expected = 1;
        assertEquals(expected, solution.searchInsert(A, target));

        A = new int[] { 1, 3, 5, 6 };
        target = 7;
        expected = 4;
        assertEquals(expected, solution.searchInsert(A, target));

        A = new int[] { 1, 3, 5, 6 };
        target = 0;
        expected = 0;
        assertEquals(expected, solution.searchInsert(A, target));
    }

    @Test
    public void testMerge() {
        int[] A, B;
        int m, n;

        A = new int[] { -11, 20, 30, 0, 0, 0, 0 };
        m = 3;
        B = new int[] { -1, 11, 33, 55 };
        n = 4;
        solution.merge(A, m, B, n);
        printArray(A);

        A = new int[] { 1, 20, 30, 0, 0, 0, 0 };
        m = 3;
        B = new int[] { -1, 11, 33, 55 };
        n = 4;
        solution.merge(A, m, B, n);
        printArray(A);
    }

    @Test
    public void testLevelOrderBottom() {
        System.out.print("Test levelOrder\r\n");
        TreeNode root = null;
        List<List<Integer>> ret;

        ret = solution.levelOrderBottom(root);
        printListList(ret);

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ret = solution.levelOrderBottom(root);
        printListList(ret);
    }

    @Test
    public void testAddBinary() {
        String a, b, expected;

        a = "0";
        b = "101";
        expected = "101";
        assertEquals(expected, solution.addBinary(a, b));

        a = "11";
        b = "111";
        expected = "1010";
        assertEquals(expected, solution.addBinary(a, b));

        a = "1";
        b = "111";
        expected = "1000";
        assertEquals(expected, solution.addBinary(a, b));
    }

    @Test
    public void testStrStr() {
        String haystack, needle;
        int expected;

        haystack = "";
        needle = "";
        expected = 0;
        assertEquals(expected, solution.strStr(haystack, needle));

        haystack = "";
        needle = "123";
        expected = -1;
        assertEquals(expected, solution.strStr(haystack, needle));

        haystack = "123";
        needle = "";
        expected = 0;
        assertEquals(expected, solution.strStr(haystack, needle));

        haystack = "12345";
        needle = "234";
        expected = 1;
        assertEquals(expected, solution.strStr(haystack, needle));

        haystack = "1234567";
        needle = "8";
        expected = -1;
        assertEquals(expected, solution.strStr(haystack, needle));

    }

    @Test
    public void testLengthOfLastWord() {
        String s;
        int expected;

        s = "";
        expected = 0;
        assertEquals(expected, solution.lengthOfLastWord(s));

        s = "Hello world  ";
        expected = 5;
        assertEquals(expected, solution.lengthOfLastWord(s));
    }

    @Test
    public void testTwoSum() {
        int[] numbers;
        int target;
        int[] expected;

        numbers = new int[] { 2, 7, 11, 15 };
        target = 9;
        expected = new int[] { 1, 2 };
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    @Test
    public void testIsValidBST() {
        TreeNode root;
        boolean expected;

        expected = true;
        root = new TreeNode(Integer.MIN_VALUE);
        assertEquals(expected, solution.isValidBST(root));

        expected = true;
        root = new TreeNode(Integer.MAX_VALUE);
        assertEquals(expected, solution.isValidBST(root));

        expected = true;
        root = new TreeNode(1);
        assertEquals(expected, solution.isValidBST(root));

        expected = false;
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        assertEquals(expected, solution.isValidBST(root));
    }

    @Test
    public void testLadderLength() {
        Set<String> dict;
        String start, end;
        int expected;
        String[] array;

        expected = 5;
        dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        start = "hit";
        end = "cog";
        assertEquals(expected, solution.ladderLength(start, end, dict));

        expected = 6;
        array = new String[] { "dose", "ends", "dine", "jars", "prow", "soap",
                "guns", "hops", "cray", "hove", "ella", "hour", "lens", "jive",
                "wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull",
                "york", "ruts", "lily", "vamp", "bask", "peer", "boat", "dens",
                "lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx",
                "mows", "toke", "soto", "dork", "nape", "mans", "loin", "jots",
                "male", "sits", "minn", "sale", "pets", "hugo", "woke", "suds",
                "rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh",
                "sulk", "vice", "clod", "iowa", "gibe", "shad", "carl", "huns",
                "coot", "sera", "mils", "rose", "orly", "ford", "void", "time",
                "eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt",
                "rung", "rich", "saga", "lust", "yews", "rode", "many", "cods",
                "rape", "last", "tile", "nosy", "take", "nope", "toni", "bank",
                "jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins",
                "cult", "hart", "wuss", "tale", "sing", "lake", "bogy", "wigs",
                "kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns",
                "will", "tart", "drug", "gale", "mold", "disk", "spay", "hows",
                "naps", "puss", "gina", "kara", "zorn", "boll", "cams", "boas",
                "rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs",
                "ohio", "nibs", "cuts", "pups", "data", "kate", "rump", "hews",
                "mary", "stow", "fang", "bolt", "rues", "mesh", "mice", "rise",
                "rant", "dune", "jell", "laws", "jove", "bode", "sung", "nils",
                "vila", "mode", "hued", "cell", "fies", "swat", "wags", "nate",
                "wist", "honk", "goth", "told", "oise", "wail", "tels", "sore",
                "hunk", "mate", "luke", "tore", "bond", "bast", "vows", "ripe",
                "fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair",
                "tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy",
                "siva", "oops", "toed", "bale", "hutu", "jolt", "rife", "darn",
                "tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems",
                "bill", "cord", "pert", "type", "kroc", "ucla", "albs", "yoko",
                "silt", "pock", "drub", "puny", "fads", "mull", "pray", "mole",
                "talc", "east", "slay", "jamb", "mill", "dung", "jack", "lynx",
                "nome", "leos", "lade", "sana", "tike", "cali", "toge", "pled",
                "mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs",
                "race", "toss", "mild", "tops", "maze", "city", "sadr", "bays",
                "poet", "volt", "laze", "gold", "zuni", "shea", "gags", "fist",
                "ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo",
                "hume", "yowl", "craw", "pied", "toga", "lobs", "love", "lode",
                "duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe",
                "pele", "suez", "nina", "ring", "okra", "warm", "lyle", "gape",
                "bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope",
                "hang", "made", "fobs", "gamy", "fort", "peak", "gill", "dino",
                "dina", "tier" };
        dict.clear();
        for (String s : array) {
            dict.add(s);
        }
        start = "nape";
        end = "mild";
        assertEquals(expected, solution.ladderLength(start, end, dict));
    }

    @Test
    public void testLetterCombinations() {
        String digits;
        List<String> ret;

        digits = "23";
        ret = solution.letterCombinations(digits);
        printList(ret);

        digits = "";
        ret = solution.letterCombinations(digits);
        printList(ret);

        digits = "234";
        ret = solution.letterCombinations(digits);
        printList(ret);
    }

    @Test
    public void testbuildTreeInorderPostorder() {
        int[] inorder, postorder;
        TreeNode root;

        inorder = new int[] { 3, 2, 1, 5, 4, 6 };
        postorder = new int[] { 3, 2, 5, 6, 4, 1 };
        root = solution.buildTreeInorderPostorder(inorder, postorder);
        printTreeByLevel(root);

        inorder = new int[] {};
        postorder = new int[] {};
        root = solution.buildTreeInorderPostorder(inorder, postorder);
        printTreeByLevel(root);
    }

    @Test
    public void testbuildTreePreorderInorder() {
        int[] inorder, preorder;
        TreeNode root;

        inorder = new int[] { 3, 2, 1, 5, 4, 6 };
        preorder = new int[] { 1, 2, 3, 4, 5, 6 };
        root = solution.buildTreePreorderInorder(preorder, inorder);
        printTreeByLevel(root);

        inorder = new int[] {};
        preorder = new int[] {};
        root = solution.buildTreePreorderInorder(preorder, inorder);
        printTreeByLevel(root);
    }

    @Test
    public void testMergeKLists() {
        List<ListNode> lists;
        ListNode head;
        ListNode ret;

        lists = new ArrayList<ListNode>();
        ret = solution.mergeKLists(lists);
        printLinkedList(ret);

        head = new ListNode(10);
        head.next = new ListNode(100);

        lists.add(head);

        head = new ListNode(5);
        lists.add(head);

        lists.add(null);

        head = new ListNode(40);
        head.next = new ListNode(45);
        lists.add(head);

        ret = solution.mergeKLists(lists);
        printLinkedList(ret);
    }

    @Test
    public void testMaxProfitII() {
        int[] prices;
        int expected;

        prices = new int[] { 1 };
        expected = 0;
        assertEquals(expected, solution.maxProfitII(prices));

        prices = new int[] { 1, 2, 3, 5, 4, 5, 6, 0, 10 };
        expected = 16;
        assertEquals(expected, solution.maxProfitII(prices));

        prices = new int[] { 1, 2, 3, 4, 5, 6 };
        expected = 5;
        assertEquals(expected, solution.maxProfitII(prices));

        prices = new int[] { 5, 4, 3, 2, 1 };
        expected = 0;
        assertEquals(expected, solution.maxProfitII(prices));
    }

    @Test
    public void testMaxSubArray() {
        int[] A;
        int expected;

        A = new int[] { -10 };
        expected = -10;
        assertEquals(expected, solution.maxSubArray(A));

        A = new int[] { 4, -1, 2, 1 };
        expected = 6;
        assertEquals(expected, solution.maxSubArray(A));

        A = new int[] { Integer.MAX_VALUE };
        expected = Integer.MAX_VALUE;
        assertEquals(expected, solution.maxSubArray(A));

        A = new int[] { Integer.MIN_VALUE };
        expected = Integer.MIN_VALUE;
        assertEquals(expected, solution.maxSubArray(A));
    }

    @Test
    public void testSwapPairs() {
        ListNode head;
        ListNode ret;

        head = null;
        ret = solution.swapPairs(head);
        printLinkedList(ret);

        head = new ListNode(1);
        ret = solution.swapPairs(head);
        printLinkedList(ret);

        head = new ListNode(1);
        head.next = new ListNode(2);
        ret = solution.swapPairs(head);
        printLinkedList(ret);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ret = solution.swapPairs(head);
        printLinkedList(ret);

    }

    @Test
    public void testSolveNQueen() {
        int n;
        List<String[]> ret;
        int expected;

        n = 4;
        expected = 2;
        ret = solution.solveNQueens(n);
        printListArray(ret);
        assertEquals(expected, ret.size());
    }

    @Test
    public void testtotalNQueens() {
        int n;
        int expected;

        n = 4;
        expected = 2;
        assertEquals(expected, solution.totalNQueens(n));
    }

    @Test
    public void testSingleNumberII() {
        int[] A;
        int expected;

        A = new int[] { 1 };
        expected = 1;
        assertEquals(expected, solution.singleNumberII(A));

        A = new int[] { 1, 5, 5, 5 };
        expected = 1;
        assertEquals(expected, solution.singleNumberII(A));
    }

    @Test
    public void testSingleNumberIIV1() {
        int[] A;
        int expected;

        A = new int[] { 1 };
        expected = 1;
        assertEquals(expected, solution.singleNumberIIV1(A));

        A = new int[] { 1, 5, 5, 5 };
        expected = 1;
        assertEquals(expected, solution.singleNumberIIV1(A));
    }

    @Test
    public void testIntToRoman() {
        String expected;
        int num;

        expected = "VI";
        num = 6;
        assertEquals(expected, solution.intToRoman(num));

        expected = "IV";
        num = 4;
        assertEquals(expected, solution.intToRoman(num));

        expected = "V";
        num = 5;
        assertEquals(expected, solution.intToRoman(num));

        expected = "MLXVI";
        num = 1066;
        assertEquals(expected, solution.intToRoman(num));

        expected = "MCMLIV";
        num = 1954;
        assertEquals(expected, solution.intToRoman(num));

    }

    @Test
    public void testConnectII() {
        TreeLinkNode root;
        root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);

        solution.connect(root);
    }

    @Test
    public void testSortedListToBST() {
        ListNode head;
        TreeNode ret;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ret = solution.sortedListToBST(head);
    }

    @Test
    public void testReverseBetween() {
        ListNode head, ret;
        int m, n;

        head = new ListNode(1);
        m = 1;
        n = 1;
        ret = solution.reverseBetween(head, m, n);
        printLinkedList(ret);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        m = 2;
        n = 4;
        ret = solution.reverseBetween(head, m, n);
        printLinkedList(ret);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        m = 1;
        n = 4;
        ret = solution.reverseBetween(head, m, n);
        printLinkedList(ret);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        m = 1;
        n = 6;
        ret = solution.reverseBetween(head, m, n);
        printLinkedList(ret);

    }
}
