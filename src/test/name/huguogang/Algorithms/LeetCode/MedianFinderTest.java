package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import name.huguogang.Algorithms.LeetCode.MedianFinder;

public class MedianFinderTest {
	@Test
	public void test() {
		double median;
		double sigma = 1e-10;

		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		median = mf.findMedian();
		assertTrue((median - 1) < sigma);
	}
}
