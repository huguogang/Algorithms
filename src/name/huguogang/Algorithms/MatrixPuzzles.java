package name.huguogang.Algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * several 2D matrix based puzzles
 * 
 * @author Guogang Hu
 * 
 */
public class MatrixPuzzles {
    static class Coordinate {
        public int row;
        public int col;
        
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }        
    }
    
    /**
     * Given a matrix filled by number 1 - N*N, find longest sequence
     * 
     * e.g. 3 12 13 4 5 11 7 8 16 10 9 15 2 14 1 6 Longest sequence is: 9, 10,
     * 11, 12, 13
     * 
     * @param matrix
     * @return length of the longest sequence
     */
    public static int findLongestSequence(int[][] matrix) {
        // matrix is marked as visited by adding len * len to it
        int maxLen = 0;
        int len = matrix.length; // assuming square matrix
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int seqLen = searchLongestSequenceR(matrix, matrix[row][col],
                        row, col);
                if (seqLen > maxLen) {
                    maxLen = seqLen;
                }
            }
        }
        return maxLen;
    }

    private static int searchLongestSequenceR(int[][] matrix, int val, int row,
            int col) {
        int len = matrix.length;
        if (row < 0 || row >= len || col < 0 || col >= len) {
            return 0;
        }
        int myVal = matrix[row][col];
        if (myVal > len * len || Math.abs(myVal - val) > 1) {
            return 0;
        }
        // only two conditions will lead us to here
        // * myVal == val: indicates this is the beginning of search
        // * |myVal - val| = 1: indicates this cell forms a sequence with
        // previous cell
        matrix[row][col] += len * len;
        return 1 + searchLongestSequenceR(matrix, myVal, row, col - 1)
                + searchLongestSequenceR(matrix, myVal, row, col + 1)
                + searchLongestSequenceR(matrix, myVal, row - 1, col)
                + searchLongestSequenceR(matrix, myVal, row + 1, col);
    }
    
    static int WALL = 2;
    static int PEOPLE = 1;
    static int OPEN = 0;
    /**
     * Given a matrix representing city grid. 
     *  0: open road, 
     *  1: people's home
     *  2: walls/obstacles
     * 
     * Find the best spot for a shop such that total travel distance
     * from home to the shop is minimum.
     * 
     * @param matrix
     * @return the shorted total distance for people to travel from home to shop
     */    
    public static int findBestSpot(int[][] matrix) {
        //assuming maxtrix size N*N, total K people
        //time: O(N*N*K), Space: O(N*N*K)
        int minDistance = Integer.MAX_VALUE;
        int len = matrix.length;
        
        //find all the people
        ArrayList<Coordinate> allPeople = new ArrayList<Coordinate>();
        for(int row = 0; row < len; row++) {
            for(int col = 0; col < len; col++) {
                if(matrix[row][col] == PEOPLE) {
                    allPeople.add(new Coordinate(row, col));
                }
            }
        }
        //create matrix of shortest distance for each person
        ArrayList<int[][]> distanceMatrix = new ArrayList<int[][]>();
        for(Coordinate people : allPeople) {
            distanceMatrix.add(floodMinDistance(matrix, people));
        }
        int[][] totalDist = new int[len][len];
        for(int[][] minDist : distanceMatrix) {
            for(int row = 0; row < len; row++) {
                for(int col = 0; col < len; col++) {
                    //be careful when adding MAX_VALUE, it became negative number!
                    if(totalDist[row][col] != Integer.MAX_VALUE) {
                        if(minDist[row][col] == Integer.MAX_VALUE) {
                            totalDist[row][col] = Integer.MAX_VALUE;
                        }
                        else {
                            totalDist[row][col] += minDist[row][col];
                        }
                    }
                }
            }
        }
        Coordinate minCoordinate = new Coordinate(-1, -1); //no solution
        for(int row = 0; row < len; row++) {
            for(int col = 0; col < len; col++) {
                if(totalDist[row][col] < minDistance) {
                    minDistance = totalDist[row][col];
                    minCoordinate.row = row;
                    minCoordinate.col = col;
                }
            }
        }
        System.out.println("min coordinate: " + minCoordinate.row + " " + minCoordinate.col);
        //sum up all the matrix then scan for min
        return minDistance;
    }
    /**
     * Starting from "starting point", visit immediate neighbors repeately to create
     * map of min distance to "starting point" for each cell of the matrix
     *  
     * @param matrix        Matrix with open space, walls, ...
     * @param startingPoint Coordinate of the starting point
     * @return Matrix with min distance to starting point.
     */
    private static int[][] floodMinDistance(int[][] matrix, Coordinate startingPoint) {
        int len = matrix.length;
        int[][] minDist = new int[len][len];
        for(int row = 0; row < len; row++) {
            for(int col = 0; col < len; col++) {
                minDist[row][col] = Integer.MAX_VALUE;
            }
        }
        
        //similar to Dijkstra's algorithm, queue with shorted distance cells in the front
        ArrayDeque<Coordinate> candidates = new ArrayDeque<Coordinate>();
        candidates.add(startingPoint);
        minDist[startingPoint.row][startingPoint.col] = 0;
        while(!candidates.isEmpty()) {
            Coordinate candidate = candidates.remove();
            int dist = minDist[candidate.row][candidate.col];
            updateDistance(matrix, minDist, dist + 1, 
                    new Coordinate(candidate.row, candidate.col + 1), 
                    candidates);
            updateDistance(matrix, minDist, dist + 1, 
                    new Coordinate(candidate.row, candidate.col - 1), 
                    candidates);
            updateDistance(matrix, minDist, dist + 1, 
                    new Coordinate(candidate.row + 1, candidate.col), 
                    candidates);
            updateDistance(matrix, minDist, dist + 1, 
                    new Coordinate(candidate.row - 1, candidate.col), 
                    candidates);
        }
        return minDist;
    }
    
    private static void updateDistance(int[][] matrix, int[][] minDist,
            int newDist, Coordinate point, Queue<Coordinate> candidates) {
        int len = matrix.length;
        if(point.row < 0 || point.row >= len ||
                point.col < 0 || point.col >= len ||
                matrix[point.row][point.col] != 0) {
            //unreachable, people/obstacle/out of bound
            return;
        }
        if(minDist[point.row][point.col] > newDist) {
            //update
            minDist[point.row][point.col] = newDist;
            candidates.add(point);
        }
    }
    
    /**
     * Rotate a matrix by 90 degree
     * @param matrix
     */
    public static void roate90(int[][] matrix) {
        
    }
}
