package name.huguogang.Algorithms.LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> top = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> bottom = new PriorityQueue<>();
	
	// Adds a number into the data structure.
	public void addNum(int num) {
		top.add(num);
		bottom.add(top.poll());
		if(top.size() < bottom.size()) {
			top.add(bottom.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if(top.size() == bottom.size()) {
			return (top.peek() + bottom.peek())/(double)2.0;
		}
		
		return top.peek();
	}
}
