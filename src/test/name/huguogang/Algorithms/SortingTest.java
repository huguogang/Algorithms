package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import static name.huguogang.Algorithms.Sorting.*;

public class SortingTest {

    @Test
    public void quickSortTest() {
        int[] input;
        int[] expected;

        input = new int[] {};
        expected = new int[] {};
        quickSort(input);
        assertArrayEquals(expected, input);

        input = new int[] {1, 2, 3, 4};
        expected = new int[] {1, 2, 3, 4};
        quickSort(input);
        assertArrayEquals(expected, input);
        
        input = new int[] {4, 3, 2, 1};
        expected = new int[] {1, 2, 3, 4};
        quickSort(input);
        assertArrayEquals(expected, input);
        
        input = new int[] {3, 1, 4, 2};
        expected = new int[] {1, 2, 3, 4};
        quickSort(input);
        assertArrayEquals(expected, input);
    }

}
