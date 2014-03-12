package name.huguogang.Algorithms;
/**
 * several 2D matrix based puzzles
 * 
 * @author Guogang Hu
 *
 */
public class MatrixPuzzles {

	/**
	 * Given a matrix filled by number 1 - N*N, find longest sequence
	 * 
	 * e.g. 
	 *   3  12 13 4
	 *   5  11 7  8
	 *   16 10 9  15
	 *   2  14 1  6
	 * Longest sequence is: 9, 10, 11, 12, 13
	 *   
	 * @param matrix
	 * @return length of the longest sequence
	 */
	public static int findLongestSequence(int[][] matrix) {
		//matrix is marked as visited by adding len * len to it
		int maxLen = 0;
		int len = matrix.length; //assuming square matrix
		for(int row = 0; row < len; row++) {
			for(int col = 0; col < len; col++) {
				if(matrix[row][col] <= len * len) {
					//new value, search for sequence
					int seqLen = 1;
					int val = matrix[row][col];
					matrix[row][col] += len * len; //mark visited
					//the first number may go two directions
					seqLen += searchR(matrix, val, row, col + 1);
					seqLen += searchR(matrix, val, row, col - 1);
					seqLen += searchR(matrix, val, row + 1, col);
					seqLen += searchR(matrix, val, row - 1, col);
					if(seqLen > maxLen) {
						maxLen = seqLen;
					}
				}
			}
		}
		return maxLen;
	}
	
	private static int searchR(int[][] matrix, int val, int row, int col) {
		int len = matrix.length;
		if(row < 0 || row >= len || col < 0 || col >= len) {
			return 0;
		}
		int myVal = matrix[row][col];
		if(myVal > len * len || Math.abs(myVal - val) != 1) {
			return 0;
		}
		matrix[row][col] += len * len;
		return 1 + searchR(matrix, myVal, row, col - 1) +
				searchR(matrix, myVal, row, col + 1) +
				searchR(matrix, myVal, row - 1, col) +
				searchR(matrix, myVal, row + 1, col);
	}
}
