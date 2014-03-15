package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;
import name.huguogang.Algorithms.ArrayAlgo;

import org.junit.Test;

public class ArrayAlgoTest {

    @Test
    public void removeDupFromSortedTest() {
        int[] array;
        int ret;
        int expected;

        System.out.println("-- removeDupFromSortedIITest --");

        array = new int[] {};
        expected = 0;
        ret = ArrayAlgo.removeDupFromSorted(array);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        expected = 1;
        ret = ArrayAlgo.removeDupFromSorted(array);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSorted(array);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSorted(array);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);
    }

    @Test
    public void removeDupFromSortedIITest() {
        int[] array;
        int ret;
        int expected;

        System.out.println("-- removeDupFromSortedIITest --");

        array = new int[] {};
        expected = 0;
        ret = ArrayAlgo.removeDupFromSortedII(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        expected = 1;
        ret = ArrayAlgo.removeDupFromSortedII(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedII(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedII(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 3, 3, 5 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedII(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] {};
        expected = 0;
        ret = ArrayAlgo.removeDupFromSortedII(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        expected = 1;
        ret = ArrayAlgo.removeDupFromSortedII(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedII(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 4 };
        expected = 6;
        ret = ArrayAlgo.removeDupFromSortedII(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 3, 3, 5 };
        expected = 6;
        ret = ArrayAlgo.removeDupFromSortedII(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 3, 3, 5 };
        expected = 7;
        ret = ArrayAlgo.removeDupFromSortedII(array, 3);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);
    }

    @Test
    public void removeDupFromSortedIISolution2Test() {
        int[] array;
        int ret;
        int expected;

        System.out.println("-- removeDupFromSortedIISolution2Test --");

        array = new int[] {};
        expected = 0;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        expected = 1;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 3, 3, 5 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] {};
        expected = 0;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        expected = 1;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        expected = 4;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 4 };
        expected = 6;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 3, 3, 5 };
        expected = 6;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 2, 3, 3, 3, 3, 5 };
        expected = 7;
        ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 3);
        System.out.println("Output Length: " + ret);
        ArrayAlgo.printArray(array);
        assertEquals(expected, ret);
    }

    @Test
    public void searchRoatedSortedNoDupesTest() {
        int[] array;
        int val;
        int ret;
        int expected;

        System.out.println("-- searchRoatedSortedTest --");

        array = new int[] {};
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        val = 1;
        expected = 0;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        val = 1;
        expected = 0;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        val = 4;
        expected = 3;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4, 5 };
        val = 5;
        expected = 4;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 1;
        expected = 4;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 2;
        expected = 5;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 3;
        expected = 0;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 4;
        expected = 1;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 5;
        expected = 2;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);

        array = new int[] { 3, 4, 5, 6, 1, 2 };
        val = 6;
        expected = 3;
        ret = ArrayAlgo.searchRotatedSortedNoDupes(array, val);
        assertEquals(expected, ret);
    }
    
    @Test
    public void searchRoatedSortedTest() {
        int[] array;
        int val;
        int ret;
        int expected;

        System.out.println("-- searchRoatedSortedTest --");

        array = new int[] {};
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSorted(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSorted(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1 };
        val = 1;
        expected = 0;
        ret = ArrayAlgo.searchRotatedSorted(array, val);
        assertEquals(expected, ret);

        array = new int[] { 1, 2, 3, 4 };
        val = 0;
        expected = -1;
        ret = ArrayAlgo.searchRotatedSorted(array, val);
        assertEquals(expected, ret);
        
        array = new int[] { 1, 2, 2, 2, 2, 2, 3, 4 };
        val = 3;
        expected = 6;
        ret = ArrayAlgo.searchRotatedSorted(array, val);
        assertEquals(expected, ret);
        
        array = new int[] { 2, 2, 3, 4, 1, 2, 2, 2};
        val = 3;
        expected = 2;
        ret = ArrayAlgo.searchRotatedSorted(array, val);
        assertEquals(expected, ret);
    }
}
