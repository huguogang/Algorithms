package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import name.huguogang.Algorithms.LeetCode.Twitter;

public class TwitterTest {

	@Test
	public void test() {
		Twitter obj = new Twitter();
		List<Integer> feed = obj.getNewsFeed(1);
		assertTrue(feed.isEmpty());
		
		obj.postTweet(1, 100);
		feed = obj.getNewsFeed(1);
		assertEquals(1, feed.size());
		
		obj.follow(0, 1);
		feed = obj.getNewsFeed(0);
		assertTrue(feed.size() == 1);
		assertEquals((Integer) 100, feed.get(0));
		
		obj.follow(0,  2);
		feed = obj.getNewsFeed(0);
		assertTrue(feed.size() == 1);
		assertEquals((Integer) 100, feed.get(0));
		
		obj.postTweet(2, 200);
		feed = obj.getNewsFeed(0);
		assertTrue(feed.size() == 2);
		assertEquals((Integer) 200, feed.get(0));
		assertEquals((Integer) 100, feed.get(1));

		/*
		 * Twitter obj = new Twitter();
		 * obj.postTweet(userId,tweetId);
		 * List<Integer> param_2 = obj.getNewsFeed(userId);
		 * obj.follow(followerId,followeeId);
		 * obj.unfollow(followerId,followeeId);
		 */
	}

}
