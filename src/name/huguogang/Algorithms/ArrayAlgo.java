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
	
	/**
	 * Search a value in a roated sorted array.
	 * Assumption: no duplicates
	 * 
	 * e.g. array 0, 1, 2, 3 rotated to 2, 3, 0, 1
	 * search for -2 return -1, search for 3 return 1 
	 * 
	 * @param arr 	rotated sorted array of integer
	 * @return	location of the search value or -1 if no match
	 */
	public static int searchRotatedSorted(int arr[], int val) {
		//modified binary search, time O(lgN), space O(1)
		return searchRotatedSortedRange(arr, val, 0, arr.length - 1);
	}
	
	private static int searchRotatedSortedRange(int arr[], int val, int left, int right) {
		if(right < left) {
			return -1;
		}
		int mid = (left + right) / 2;
		if(arr[mid] == val) {
			return mid;
		}
		if(arr[left] < arr[mid]) {
			//left side is in ascending order
			if(arr[left] <= val && val < arr[mid]) {
				return searchRotatedSortedRange(arr, val, left, mid - 1);
			}
			else {
				return searchRotatedSortedRange(arr, val, mid + 1, right);
			}
		}
		else {
			//rotation boundary is on the left side, right side must be ascending order
			if(arr[mid] < val && val <= arr[right]) {
				return searchRotatedSortedRange(arr, val, mid + 1, right);
			}
			else {
				return searchRotatedSortedRange(arr, val, left, mid - 1);
			}
		}
	}
}
