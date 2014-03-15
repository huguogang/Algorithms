package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import static name.huguogang.Algorithms.Median.*;

public class MedianTest {

    @Test
    public void selectMedianTest() {
        int[] data;
        int ret;
        int expected;

        data = new int[] { 5, 4, 3, 2, 1 };
        expected = 3;
        ret = selectMedian(data);
        assertEquals(expected, ret);

        data = new int[] { 5, 3, 2, 4, 1 };
        expected = 3;
        ret = selectMedian(data);
        assertEquals(expected, ret);
    }

    @Test
    public void findMeidanTest() {
        int[] arr1, arr2;
        int actual;
        int expected;
        
        arr1 = new int[] {1, 3, 5, 7, 9};
        arr2 = new int[] {2, 4, 6, 8, 10};
        expected = 5;
        actual = findMedian1(arr1, arr2);
        assertEquals(expected, actual);
        
        arr1 = new int[] {1, 3, 5, 7, 9};
        arr2 = new int[] {2, 6, 8, 10, 12, 13, 15};
        expected = 7;
        actual = findMedian1(arr1, arr2);
        assertEquals(expected, actual);
        
        arr1 = new int[] {1, 3, 5, 7, 9};
        arr2 = new int[] {2, 6, 8, 10, 12, 13, 15, 16, 17, 18, 19, 20, 21, 22};
        expected = 12;
        actual = findMedian1(arr1, arr2);
        assertEquals(expected, actual);
    }
}
