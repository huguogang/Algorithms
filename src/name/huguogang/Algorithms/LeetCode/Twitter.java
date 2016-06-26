package name.huguogang.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	static class Tweet {
		// Logical clock
		private static long clock = 0;
		long timestamp;
		int userId;
		int tweetId;

		Tweet(int userId, int tweetId) {
			this.userId = userId;
			this.tweetId = tweetId;
			this.timestamp = clock;
			clock++;
		}

		/** Descending order comparator. Recent timestamp is smaller. */
		static class TimestampComparator implements Comparator<Tweet> {
			@Override
			public int compare(Tweet o1, Tweet o2) {
				return (int) Math.signum(o2.timestamp - o1.timestamp);
			}
		}
	}

	/** Look up user's tweets (in chronicle order) by user ID */
	HashMap<Integer, List<Tweet>> userTweetLookup;
	/** Look up user's tweet follows by user ID */
	HashMap<Integer, Set<Integer>> userFollow;

	/** Initialize your data structure here. */
	public Twitter() {
		userTweetLookup = new HashMap<>();
		userFollow = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		List<Tweet> tweets = getTweets(userId);
		tweets.add(new Tweet(userId, tweetId));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> follow = getFollows(userId);
		HashMap<Integer, Integer> scanPosLookup = new HashMap<>();
		PriorityQueue<Tweet> queue = new PriorityQueue<>(new Twitter.Tweet.TimestampComparator());

		for (int followeeId : follow) {
			List<Tweet> tweets = getTweets(followeeId);
			int lastIdx = tweets.size() - 1;
			scanPosLookup.put(followeeId, lastIdx);
			if (lastIdx >= 0) {
				queue.add(tweets.get(lastIdx));
			}
		}
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty() && result.size() < 10) {
			Tweet t = queue.remove();
			result.add(t.tweetId);
			int tweetIdx = scanPosLookup.get(t.userId) - 1;
			if (tweetIdx >= 0) {
				queue.add(getTweets(t.userId).get(tweetIdx));
				scanPosLookup.put(t.userId, tweetIdx);
			}
		}
		return result;
	}

	private List<Tweet> getTweets(int userId) {
		if (!userTweetLookup.containsKey(userId)) {
			userTweetLookup.put(userId, new ArrayList<>());
		}
		return userTweetLookup.get(userId);
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		Set<Integer> follows = getFollows(followerId);
		follows.add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId) {
			// cannot unfollow self
			return;
		}
		Set<Integer> follows = getFollows(followerId);
		if (follows.contains(followeeId)) {
			follows.remove(followeeId);
		}
	}

	private Set<Integer> getFollows(int userId) {
		if (!userFollow.containsKey(userId)) {
			Set<Integer> follows = new HashSet<>();
			follows.add(userId); // include self
			userFollow.put(userId, follows);
		}
		return userFollow.get(userId);
	}
}