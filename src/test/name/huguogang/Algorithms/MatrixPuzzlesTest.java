package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import static name.huguogang.Algorithms.MatrixPuzzles.*;

public class MatrixPuzzlesTest {

    @Test
    public void findLongestSequenceTest() {
        int[][] matrix;
        int expected;
        int ret;

        matrix = new int[][] { { 3, 12, 13, 4 }, { 5, 11, 7, 8 },
                { 16, 10, 9, 15 }, { 2, 14, 1, 6 } };
        expected = 5;
        ret = findLongestSequence(matrix);
        assertEquals(expected, ret);

        matrix = new int[][] {};
        expected = 0;
        ret = findLongestSequence(matrix);
        assertEquals(expected, ret);

        matrix = new int[][] { { 1, 2, 3, 4 }, { 8, 7, 6, 5 },
                { 9, 10, 11, 12 }, { 16, 15, 14, 13 } };
        expected = 16;
        ret = findLongestSequence(matrix);
        assertEquals(expected, ret);
    }

}
