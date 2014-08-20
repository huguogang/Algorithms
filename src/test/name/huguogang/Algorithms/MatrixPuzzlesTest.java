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
        
        matrix = new int[][] { 
                { 3, 12, 13, 4 }, 
                { 5, 11, 7, 8 },
                { 16, 10, 9, 15 }, 
                { 2, 14, 1, 6 } };
        expected = 5;
        ret = findLongestSequence(matrix);
        assertEquals(expected, ret);

        matrix = new int[][] {};
        expected = 0;
        ret = findLongestSequence(matrix);
        assertEquals(expected, ret);

        matrix = new int[][] { 
                { 1, 2, 3, 4 }, 
                { 8, 7, 6, 5 },
                { 9, 10, 11, 12 },
                { 16, 15, 14, 13 } };
        expected = 16;
        ret = findLongestSequence(matrix);
        assertEquals(expected, ret);
    }
    
    @Test
    public void findBestSpotTest() {
        int[][] matrix;
        int expected;
        int ret;
        
        matrix = new int[][] {};
        expected = Integer.MAX_VALUE;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
        
        matrix = new int[][] {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        expected = 2;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
        
        matrix = new int[][] {
                {0, 1, 0},
                {0, 0, 1},
                {0, 1, 0}
        };
        expected = 3;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
     
        matrix = new int[][] {
                {0, 1, 0},
                {0, 2, 1},
                {0, 1, 0}
        };
        expected = Integer.MAX_VALUE;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
        
        matrix = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        expected = 7;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
        
        matrix = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        expected = 0;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
        
        matrix = new int[][] {
                {0, 1, 0, 2, 0},
                {0, 0, 2, 0, 0},
                {0, 2, 0, 0, 2},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
        };
        expected = 9;
        ret = findBestSpot(matrix);
        assertEquals(expected, ret);
    }
    @Test
    public void rotate90Test() {
        int[][] matrix;
        
        matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate90(matrix);
        dumpMatrix(matrix);
        
        matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate90(matrix);
        dumpMatrix(matrix);
    }
}
