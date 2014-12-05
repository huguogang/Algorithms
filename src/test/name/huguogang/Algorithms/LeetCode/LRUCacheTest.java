package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.*;
import name.huguogang.Algorithms.LeetCode.LRUCache;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        {
            int ret, expected;
            LRUCache cache = new LRUCache(2);
            cache.set(2, 1);
            cache.set(1, 1);

            ret = cache.get(2);
            expected = 1;
            assertEquals(expected, ret);

            cache.set(4, 1);

            ret = cache.get(1);
            expected = -1;
            assertEquals(expected, ret);

            ret = cache.get(2);
            expected = 1;
            assertEquals(expected, ret);
        }

        {
            int ret, expected;
            LRUCache cache = new LRUCache(1);
            cache.set(2, 1);

            ret = cache.get(2);
            expected = 1;
            assertEquals(expected, ret);

            cache.set(3, 2);

            ret = cache.get(2);
            expected = -1;
            assertEquals(expected, ret);

            ret = cache.get(3);
            expected = 2;
            assertEquals(expected, ret);
        }
        {
            LRUCache cache = new LRUCache(2);
            cache.set(1, 1);
            cache.set(1, 2);
            cache.set(2, 3);
            cache.set(1, 5);
            cache.set(3, 1);

            int ret, expected;
            ret = cache.get(3);
            expected = 1;
            assertEquals(expected, ret);

            ret = cache.get(2);
            expected = -1;
            assertEquals(expected, ret);

            ret = cache.get(1);
            expected = 5;
            assertEquals(expected, ret);
        }

    }

}
