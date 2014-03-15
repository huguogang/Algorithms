package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;
import name.huguogang.Algorithms.QueueOnStack;

import org.junit.Test;

public class QueueOnStackTest {

    @Test
    public void test() {
        QueueOnStack<Integer> q = new QueueOnStack<Integer>();
        int ele;
        Integer element;
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        ele = q.dequeue();
        assertEquals(ele, 1);
        
        q.enqueue(5);
        
        ele = q.dequeue();
        assertEquals(ele, 2);
        ele = q.dequeue();
        assertEquals(ele, 3);
        ele = q.dequeue();
        assertEquals(ele, 4);
        ele = q.dequeue();
        assertEquals(ele, 5);
        
        element = q.dequeue();
        assertNull(element);
    }

}
