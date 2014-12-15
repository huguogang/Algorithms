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
    
   
}
