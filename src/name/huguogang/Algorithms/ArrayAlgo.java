package name.huguogang.Algorithms;
/**
 * array related algorithms
 * 
 * @author ghu
 *
 */
public class ArrayAlgo {
	public static void printArray (int[] arr) {
		System.out.print("[");
		for(int ele : arr) {
			System.out.print(ele);
			System.out.print(",");
		}
		System.out.println("]");
	}
	/**
	 * remove duplicated numbers from sorted array
	 * input array will be modified by the function, such 
	 * that the leading elements are distinct values in sorted order
	 *
	 * @param arr		a sorted array
	 * @return number of distinct elements in the array
	 */
	public static int removeDupFromSorted(int arr[]) {
		//time O(n), space O(1)
		int len = arr.length;
		if(len == 0) { return 0;}
		int tail = 0; 
		for(int index = 1; index < len; index++) {
			if(arr[index] != arr[tail]) {
				tail++;
				arr[tail] = arr[index];
			}
		}
		return tail + 1;
	}
	
	/**
	 * remove duplicated numbers from sorted array Variant II
	 *  - allow up to n duplicates. 
	 * input array will be modified by the function, such 
	 * that the leading elements are distinct values in sorted order
	 * 
	 * e.g. input 	1, 2, 2, 3, 3, 3, 3, 5
	 * 		output  1, 2, 2, 3, 3, 5, (the rest don't care)
	 * @param arr		a sorted array
	 * @param nDups		maximum number of duplicated allowed. 
	 * 					1 means no duplicated are allowed.
	 * @return length of the output array
	 */
	public static int removeDupFromSortedII(int arr[], int nDups) {
		//time O(n), space O(1)
		int len = arr.length;
		if(len == 0) { return 0;}
		int tail = 0; 
		int dupCount = 0;
		for(int index = 1; index < len; index++) {
			if(arr[index] != arr[tail]) {				
				dupCount = 0;
			}
			else {
				dupCount++;
				if(dupCount >= nDups) {
					continue;
				}
			}
			
			tail++;
			if(tail != index) {
				arr[tail] = arr[index];
			}
		}
		return tail + 1;
	}
	
	/**
	 * another solution for the problem
	 * 
	 * remove duplicated numbers from sorted array Variant II
	 *  - allow up to n duplicates. 
	 * input array will be modified by the function, such 
	 * that the leading elements are distinct values in sorted order
	 * 
	 * e.g. input 	1, 2, 2, 3, 3, 3, 3, 5
	 * 		output  1, 2, 2, 3, 3, 5, (the rest don't care)
	 * @param arr		a sorted array
	 * @param nDups		maximum number of duplicated allowed. 
	 * 					1 means no duplicated are allowed.
	 * @return length of the output array
	 */
	public static int removeDupFromSortedIISolution2(int arr[], int nDups) {
		//time O(n), space O(1)
		int len = arr.length;
		if(len <= nDups) { return len;}
		int tail = nDups - 1; 
		for(int index = nDups; index < len; index++) {
			if(arr[index] != arr[index - nDups]) {				
				tail++;
				arr[tail] = arr[index];
				if(tail != index) {
					arr[tail] = arr[index];
				}
			}
		}
		return tail + 1;
	}
}
