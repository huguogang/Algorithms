package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static test.name.huguogang.Algorithms.LeetCode.Util.printArray;
import static test.name.huguogang.Algorithms.LeetCode.Util.printLinkedList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListArray;
import static test.name.huguogang.Algorithms.LeetCode.Util.printListList;
import static test.name.huguogang.Algorithms.LeetCode.Util.printMatrix;
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

        s = "VII";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "LXV";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "CCLI";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
     
        s = "XXIV";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "XCIX";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "DCCC";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "LXXXIII";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "MCCLVII";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
        s = "MMDXXXIV";
        System.out.printf("%s = %d\n", s, solution.romanToInt(s));
        
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
        
        num = 8;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        	
        num = 16;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 75;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));

        num = 134;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 528;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 947;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 692;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 1_368;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 2_251;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 11;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 2004;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 16;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 803;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
        
        num = 258;
        System.out.printf("%d = %s\n", num, solution.intToRoman(num));
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

    @Test
    public void testAnagrams() {
        String[] strs;
        List<String> ret;

        strs = new String[] {};
        ret = solution.anagrams(strs);
        printList(ret);

        strs = new String[] { "", "" };
        ret = solution.anagrams(strs);
        printList(ret);

        strs = new String[] { "ab", "ba", "abc", "cba" };
        ret = solution.anagrams(strs);
        printList(ret);

    }

    @Test
    public void testFindPeakElement() {
        int[] num;
        int expected;

        num = new int[] {};
        expected = -1;
        assertEquals(expected, solution.findPeakElement(num));

        num = new int[] { 1 };
        expected = 0;
        assertEquals(expected, solution.findPeakElement(num));

        num = new int[] { 1, 2, 3, 1 };
        expected = 2;
        assertEquals(expected, solution.findPeakElement(num));

        num = new int[] { 1, 2, 3 };
        expected = 2;
        assertEquals(expected, solution.findPeakElement(num));

        num = new int[] { 3, 2, 1 };
        expected = 0;
        assertEquals(expected, solution.findPeakElement(num));
    }

    @Test
    public void testMinimumTotal() {
        List<List<Integer>> triangle;
        List<Integer> row;
        int expected;

        expected = -10;
        triangle = new ArrayList<List<Integer>>();
        row = new ArrayList<Integer>();
        row.add(-10);
        triangle.add(row);
        assertEquals(expected, solution.minimumTotal(triangle));

        expected = -20;
        row = new ArrayList<Integer>();
        row.add(-10);
        row.add(0);
        triangle.add(row);
        assertEquals(expected, solution.minimumTotal(triangle));
    }

    @Test
    public void testSortColors() {
        int[] A;

        A = null;
        solution.sortColors(A);
        // printArray(A);
        assertEquals(null, A);

        A = new int[] {};
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 1 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 2 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 0 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 0, 0, 0 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 1, 1, 1 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 2, 2, 2 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 0, 1, 2 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 2, 1, 0 };
        solution.sortColors(A);
        printArray(A);

        A = new int[] { 0, 2, 1 };
        solution.sortColors(A);
        printArray(A);
    }

    @Test
    public void testReverseLinkedList() {
        ListNode head, ret;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ret = solution.reverseLinkedList(head);
        printLinkedList(ret);
    }

    @Test
    public void testZipLists() {
        ListNode head1, head2, ret;

        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);
        ret = solution.zipLists(head1, head2);
        printLinkedList(ret);
    }

    @Test
    public void testReorderList() {
        ListNode head1, head2;

        head1 = null;
        solution.reorderList(head1);
        printLinkedList(head1);

        head1 = new ListNode(1);
        solution.reorderList(head1);
        printLinkedList(head1);

        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        solution.reorderList(head1);
        printLinkedList(head1);

        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = head2 = new ListNode(3);
        head2.next = new ListNode(4);
        solution.reorderList(head1);
        printLinkedList(head1);

        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        solution.reorderList(head1);
        printLinkedList(head1);
    }

    @Test
    public void testMaxArea() {
        int[] height;
        int expected;

        height = new int[] { 2, 1 };
        expected = 1;
        assertEquals(expected, solution.maxArea(height));

        height = new int[] {};
        expected = 0;
        assertEquals(expected, solution.maxArea(height));

        height = new int[] { 2, 3, 4, 1, 9 };
        expected = 9;
        assertEquals(expected, solution.maxArea(height));
    }

    @Test
    public void testRotate() {
        int[][] matrix;

        matrix = new int[][] {
                { 1 }
        };
        solution.rotate(matrix);
        printMatrix(matrix);

        matrix = new int[][] {
                { 1, 2 },
                { 3, 4 }
        };
        solution.rotate(matrix);
        printMatrix(matrix);

        matrix = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        solution.rotate(matrix);
        printMatrix(matrix);
    }

    @Test
    public void testUniquePaths() {
        int m, n, expected;

        m = 1;
        n = 3;
        expected = 1;
        assertEquals(expected, solution.uniquePaths(m, n));

        m = 2;
        n = 3;
        expected = 3;
        assertEquals(expected, solution.uniquePaths(m, n));

        m = 3;
        n = 5;
        expected = 15;
        assertEquals(expected, solution.uniquePaths(m, n));
    }

    @Test
    public void testPartition() {
        ListNode head, ret;
        int x;

        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        x = 3;
        ret = solution.partition(head, x);
        printLinkedList(ret);
    }

    @Test
    public void testMinDistance() {
        String word1, word2;
        int expected;

        word1 = word2 = "Hello World";
        expected = 0;
        assertEquals(expected, solution.minDistance(word1, word2));

        word1 = "World";
        word2 = "Word";
        expected = 1;
        assertEquals(expected, solution.minDistance(word1, word2));

        word1 = "World";
        word2 = "Words";
        expected = 2;
        assertEquals(expected, solution.minDistance(word1, word2));
    }

    @Test
    public void testRestoreIPAddress() {
        String s;
        List<String> ret;

        s = "25525511135";
        ret = solution.restoreIpAddresses(s);
        printList(ret);

        s = "0000";
        ret = solution.restoreIpAddresses(s);
        printList(ret);

        s = "010010";
        ret = solution.restoreIpAddresses(s);
        printList(ret);

    }

    @Test
    public void findMinTest() {
        int[] num;
        int expected;

        num = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        expected = 0;
        assertEquals(expected, solution.findMin(num));

        num = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        expected = 0;
        assertEquals(expected, solution.findMin(num));
    }

    @Test
    public void testRemoveDuplicatesII() {
        int[] A;
        int expected;

        A = new int[] { 1, 1, 1, 2, 2, 3 };
        expected = 5;
        assertEquals(expected, solution.removeDuplicatesII(A));

        A = new int[] {};
        expected = 0;
        assertEquals(expected, solution.removeDuplicatesII(A));
    }

    @Test
    public void testSearch() {
        int[] A;
        int target, expected;

        A = new int[] {};
        target = 0;
        expected = -1;
        assertEquals(expected, solution.search(A, target));

        A = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 8;
        expected = -1;
        assertEquals(expected, solution.search(A, target));

        A = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 6;
        expected = 2;
        assertEquals(expected, solution.search(A, target));
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

    @Test
    public void testLengthOfLongestSubstring() {
        String s;
        int expected;

        s = "bbb";
        expected = 1;
        assertEquals(expected, solution.lengthOfLongestSubstring(s));

        s = "abcabcbb";
        expected = 3;
        assertEquals(expected, solution.lengthOfLongestSubstring(s));

        s = "abcdefghijklmnopqrstuvwxyz";
        expected = 26;
        assertEquals(expected, solution.lengthOfLongestSubstring(s));

        s = "abcabcbbcdefghijklmnopklmnopqrstuvwxyz";
        expected = 16;
        assertEquals(expected, solution.lengthOfLongestSubstring(s));

        s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        expected = 12;
        assertEquals(expected, solution.lengthOfLongestSubstring(s));
    }

    @Test
    public void testSolveSudoku() {
        char[][] board;

        board = new char[][] {
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }
        };
        solution.solveSudoku(board);
        printBoard(board);

        board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },

                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },

                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solution.solveSudoku(board);
        printBoard(board);
    }

    private void printBoard(char[][] board) {
        System.out.println("---------------------");
        for (char[] row : board) {
            System.out.println(row);
        }
        System.out.println("---------------------");
    }

    @Test
    public void testSqrt() {
        int x;
        int expected;

        x = 0;
        expected = 0;
        assertEquals(expected, solution.sqrt(x));

        x = 1;
        expected = 1;
        assertEquals(expected, solution.sqrt(x));

        x = 2;
        expected = 1;
        assertEquals(expected, solution.sqrt(x));

        x = 3;
        expected = 1;
        assertEquals(expected, solution.sqrt(x));

        x = 4;
        expected = 2;
        assertEquals(expected, solution.sqrt(x));

        x = 5;
        expected = 2;
        assertEquals(expected, solution.sqrt(x));

        x = 2147395599;
        expected = 46339;
        assertEquals(expected, solution.sqrt(x));
    }

    @Test
    public void testWordBreak() {
        Set<String> dict = new HashSet<String>();
        String s;
        boolean expected;

        dict.add("leet");
        dict.add("code");
        s = "leetcode";
        expected = true;
        assertEquals(expected, solution.wordBreak(s, dict));

        s = "leetcode1";
        expected = false;
        assertEquals(expected, solution.wordBreak(s, dict));

        s = "leetcod";
        expected = false;
        assertEquals(expected, solution.wordBreak(s, dict));
    }

    @Test
    public void testTitleToNumber() {
        String s;
        int expected;

        s = "AB";
        expected = 28;
        assertEquals(expected, solution.titleToNumber(s));

        s = "A";
        expected = 1;
        assertEquals(expected, solution.titleToNumber(s));

        s = "Z";
        expected = 26;
        assertEquals(expected, solution.titleToNumber(s));

    }

    @Test
    public void testTrailingZeroes() {
        int n;
        int expected;

        n = 5;
        expected = 1;
        assertEquals(expected, solution.trailingZeroes(n));

        n = 26;
        expected = 6;
        assertEquals(expected, solution.trailingZeroes(n));
    }

    @Test
    public void testGrayCode() {
        int n;
        List<Integer> ret;

        ret = solution.grayCode(2);
        printList(ret);
    }

    @Test
    public void testGenerateParenthesis() {
        int n;
        List<String> ret;

        ret = solution.generateParenthesis(2);
        printList(ret);

        ret = solution.generateParenthesis(3);
        printList(ret);
    }

    @Test
    public void testPermute() {
        int[] num;
        List<List<Integer>> ret;

        num = new int[] { 0, 1, 2, 3 };
        ret = solution.permute(num);
        printListList(ret);
    }

    @Test
    public void testMinPathSum() {
        int[][] grid;
        int expected;

        grid = new int[][] {
                { 1, 2, 3, 8, 3, 0, 0 },
                { 0, 1, 15, 10, 0, 0, 20 }
        };
        expected = 37;
        assertEquals(expected, solution.minPathSum(grid));
    }

    @Test
    public void testConvertToTitle() {
        int n;
        String expected;

        n = 1;
        expected = "A";
        assertEquals(expected, solution.convertToTitle(n));

        n = 26;
        expected = "Z";
        assertEquals(expected, solution.convertToTitle(n));

        n = 27;
        expected = "AA";
        assertEquals(expected, solution.convertToTitle(n));

        n = 53;
        expected = "BA";
        assertEquals(expected, solution.convertToTitle(n));

        n = 52;
        expected = "AZ";
        assertEquals(expected, solution.convertToTitle(n));
    }

    @Test
    public void testCompareVersion() {
        String version1, version2;
        int expected;

        version1 = "0.1";
        version2 = "0.5";
        expected = -1;
        assertEquals(expected, solution.compareVersion(version1, version2));

        version1 = "0.1";
        version2 = "13.57";
        expected = -1;
        assertEquals(expected, solution.compareVersion(version1, version2));

        version1 = "0.1";
        version2 = "0.1";
        expected = 0;
        assertEquals(expected, solution.compareVersion(version1, version2));

        version1 = "010.001";
        version2 = "10.1";
        expected = 0;
        assertEquals(expected, solution.compareVersion(version1, version2));

        version1 = "010.000";
        version2 = "10";
        expected = 0;
        assertEquals(expected, solution.compareVersion(version1, version2));
    }

    @Test
    public void testCombine() {
        int n, k;
        List<List<Integer>> result;

        n = 4;
        k = 1;
        result = solution.combine(n, k);
        printListList(result);

        n = 4;
        k = 2;
        result = solution.combine(n, k);
        printListList(result);

        n = 4;
        k = 4;
        result = solution.combine(n, k);
        printListList(result);
    }

    @Test
    public void testUniquePathsWithObstacles() {
        int[][] obstacleGrid;
        int expected;

        obstacleGrid = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        expected = 2;
        assertEquals(expected, solution.uniquePathsWithObstacles(obstacleGrid));

        obstacleGrid = new int[][] {
                { 0 },
                { 0 },
                { 0 }
        };
        expected = 1;
        assertEquals(expected, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void testSearchII() {
        int[] A;
        int target;
        boolean expected;

        A = new int[] {};
        target = 0;
        expected = false;
        assertEquals(expected, solution.searchII(A, target));

        A = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 8;
        expected = false;
        assertEquals(expected, solution.searchII(A, target));

        A = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 6;
        expected = true;
        assertEquals(expected, solution.searchII(A, target));
    }

    @Test
    public void testLargestNumber() {
        int[] num;
        String expected;

        num = new int[] { 3, 30, 34, 5, 9 };
        expected = "9534330";
        assertEquals(expected, solution.largestNumber(num));

        num = new int[] { 121, 12 };
        expected = "12121";
        assertEquals(expected, solution.largestNumber(num));

        num = new int[] { 0, 0 };
        expected = "0";
        assertEquals(expected, solution.largestNumber(num));
    }

    @Test
    public void testGenerateMatrix() {
        int n;
        int[][] ret;

        n = 1;
        ret = solution.generateMatrix(n);
        printMatrix(ret);

        n = 2;
        ret = solution.generateMatrix(n);
        printMatrix(ret);

        n = 3;
        ret = solution.generateMatrix(n);
        printMatrix(ret);

        n = 4;
        ret = solution.generateMatrix(n);
        printMatrix(ret);
    }

    @Test
    public void testSetZeroes() {
        int[][] matrix;

        matrix = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        printMatrix(matrix);
        solution.setZeroes(matrix);
        printMatrix(matrix);

        matrix = new int[][] { { 9, -6, -1, -2, 5 },
                { -1, 3, 2147483647, -4, 0 }, { -3, -4, 0, 4, -2147483648 } };
        printMatrix(matrix);
        solution.setZeroes(matrix);
        printMatrix(matrix);

        matrix = new int[][] { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
                { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
        printMatrix(matrix);
        solution.setZeroes(matrix);
        printMatrix(matrix);

    }

    @Test
    public void testCombinationSum() {
        int[] candidates;
        int target;
        List<List<Integer>> ret;

        target = 7;
        candidates = new int[] { 2, 2, 3, 6, 7 };
        ret = solution.combinationSum(candidates, target);
        printListList(ret);
    }

    @Test
    public void testFractionToDecimal() {
        int numerator, denominator;
        String result, expected;

        numerator = -1;
        denominator = -2147483648;
        expected = "0.0000000004656612873077392578125";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = -2147483648;
        denominator = 1;
        expected = "-2147483648";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = 0;
        denominator = 10;
        expected = "0";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 2;
        expected = "0.5";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = 2;
        denominator = 1;
        expected = "2";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = 1;
        denominator = 3;
        expected = "0.(3)";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = 15;
        denominator = 29;
        expected = "0.(5172413793103448275862068965)";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

        numerator = -1;
        denominator = 3;
        expected = "-0.(3)";
        assertEquals(expected,
                solution.fractionToDecimal(numerator, denominator));

    }

    @Test
    public void testWordBreakII() {
        String s;
        Set<String> dict;
        List<String> result;

        dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        s = "cat";
        result = solution.wordBreakII(s, dict);
        printList(result);

        s = "catsanddog";
        result = solution.wordBreakII(s, dict);
        printList(result);

        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        dict = new HashSet<String>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        result = solution.wordBreakII(s, dict);
        printList(result);
    }

    @Test
    public void findLadders() {
        Set<String> dict;
        String start, end;
        String[] array;
        List<List<String>> result;

        array = new String[] { "hot", "cog", "dog", "tot", "hog", "hop", "pot",
                "dot" };
        start = "hot";
        end = "dog";
        dict = new HashSet<String>();
        for (String s : array) {
            dict.add(s);
        }
        result = solution.findLadders(start, end, dict);
        printListList(result);

        dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        start = "hit";
        end = "cog";
        result = solution.findLadders(start, end, dict);
        printListList(result);
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
        result = solution.findLadders(start, end, dict);
        printListList(result);
    }

    public void testFirstMissingPositive() {
        int[] A;
        int expected;

        A = new int[] { 1, 2, 0 };
        expected = 3;
        assertEquals(expected, solution.firstMissingPositive(A));

        A = new int[] { 3, 4, -1, 1 };
        expected = 2;
        assertEquals(expected, solution.firstMissingPositive(A));

        A = new int[] { 3, 4, 1, 2 };
        expected = 5;
        assertEquals(expected, solution.firstMissingPositive(A));

        A = new int[] { 1, 1 };
        expected = 2;
        assertEquals(expected, solution.firstMissingPositive(A));
    }

    @Test
    public void testInsertionSortList() {
        ListNode head;
        ListNode ret;

        head = new ListNode(10);
        head.next = new ListNode(10);
        head.next.next = new ListNode(8);
        ret = solution.insertionSortList(head);
        printLinkedList(ret);
    }

    @Test
    public void testDeleteDuplicatesII() {
        ListNode head;
        ListNode ret;

        System.out.println("List 1");
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        ret = solution.deleteDuplicatesII(head);
        printLinkedList(ret);

        System.out.println("List 2");
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ret = solution.deleteDuplicatesII(head);
        printLinkedList(ret);
    }

    @Test
    public void testCombinationSum2() {
        int[] num;
        int target;
        List<List<Integer>> result;

        num = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        target = 8;
        result = solution.combinationSum2(num, target);
        printListList(result);
    }
    

}
