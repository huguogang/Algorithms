package name.huguogang.Algorithms.LeetCode;

import java.util.Hashtable;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 *
 * @author ghu
 *
 */
public class LRUCache {
    private class Entry {
        int key;
        int value;
        Entry next;
        Entry previous;
    }

    private Entry head;
    private Entry tail;
    private Hashtable<Integer, Entry> lookup;
    private int capacity;

    public LRUCache(int capacity) {
        head = tail = null;
        lookup = new Hashtable<Integer, LRUCache.Entry>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Entry e = lookup.get(key);
        if (e == null) {
            return -1;
        }
        touched(e);
        return e.value;
    }

    public void set(int key, int value) {
        // insert or update entry in lookup
        Entry e = lookup.get(key);
        if (e != null) {
            // update
            e.value = value;
            touched(e);

        } else {
            // check capacity before insert
            if (lookup.size() == capacity) {
                if (tail.previous != null) { // this check is necessary for
                                             // capacity 1
                    tail.previous.next = null;
                }
                lookup.remove(tail.key);
                tail = tail.previous;
            }
            // insert new entry
            e = new Entry();
            e.key = key;
            e.value = value;
            lookup.put(key, e);
            // new entry at top of list
            e.next = head;
            e.previous = null;
            if (head != null) {
                head.previous = e;
            }
            head = e;
        }

        if (tail == null) {
            // empty cache
            tail = e;
        }
    }

    /**
     * promote recently touched entry to head
     * 
     * @param e
     */
    private void touched(Entry e) {
        if (e != head) {
            // remove from current location
            if (e.previous != null) {
                e.previous.next = e.next;
            }
            if (e.next != null) {
                e.next.previous = e.previous;
            }
            if (e == tail) {
                tail = e.previous;
            }
            
            // put e to head of list
            e.next = head;
            e.previous = null;
            if (head != null) {
                head.previous = e;
            }
            head = e;
        }
    }
}