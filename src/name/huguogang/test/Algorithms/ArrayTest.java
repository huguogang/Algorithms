package name.huguogang.test.Algorithms;

import static org.junit.Assert.*;
import name.huguogang.Algorithms.ArrayAlgo;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void removeDupFromSortedTest() {
		int[] array;
		int ret;
		
		System.out.println("-- removeDupFromSortedIITest --");
		
		array = new int[] {};
		ret = ArrayAlgo.removeDupFromSorted(array);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1};
		ret = ArrayAlgo.removeDupFromSorted(array);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 3, 4};
		ret = ArrayAlgo.removeDupFromSorted(array);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 4};
		ret = ArrayAlgo.removeDupFromSorted(array);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
	}
	
	@Test
	public void removeDupFromSortedIITest() {
		int[] array;
		int ret;
		
		System.out.println("-- removeDupFromSortedIITest --");
		
		array = new int[] {};
		ret = ArrayAlgo.removeDupFromSortedII(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1};
		ret = ArrayAlgo.removeDupFromSortedII(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedII(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedII(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 3, 3, 5};
		ret = ArrayAlgo.removeDupFromSortedII(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {};
		ret = ArrayAlgo.removeDupFromSortedII(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1};
		ret = ArrayAlgo.removeDupFromSortedII(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedII(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedII(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 3, 3, 5};
		ret = ArrayAlgo.removeDupFromSortedII(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 3, 3, 5};
		ret = ArrayAlgo.removeDupFromSortedII(array, 3);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
	}
	
	@Test
	public void removeDupFromSortedIISolution2Test() {
		int[] array;
		int ret;
		
		System.out.println("-- removeDupFromSortedIISolution2Test --");
		
		array = new int[] {};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 3, 3, 5};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 1);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 4};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 3, 3, 5};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 2);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
		array = new int[] {1, 2, 2, 3, 3, 3, 3, 5};
		ret = ArrayAlgo.removeDupFromSortedIISolution2(array, 3);
		System.out.println("Output Length: " + ret);
		ArrayAlgo.printArray(array);
		
	}
}
