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
    public void testMaximumGap() {
        int[] num;
        int expected;
        
        num = new int[] {1};
        expected = 0;
        assertEquals(expected, solution.maximumGap(num));
        
        
        num = new int[] {5, 1, 4, 2, 6};
        expected = 2;
        assertEquals(expected, solution.maximumGap(num));
        
    }
}
