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

}
