package test.name.huguogang.Algorithms.LeetCode;

import static org.junit.Assert.*;
import name.huguogang.Algorithms.LeetCode.MinStack;

import org.junit.Test;

public class MinStackTest {

    @Test
    public void test() {
        MinStack s = new MinStack();
        s.push(3);
        s.push(2);
        s.push(2);
        s.push(1);
        s.push(5);
        s.push(8);
        s.push(0);
        s.push(9);
        
        assertEquals(s.getMin(), 0);
        
        s.pop();
        s.pop();
        assertEquals(s.getMin(), 1);

        s.pop();
        s.pop();
        s.pop();
        s.pop();
        assertEquals(s.getMin(), 2);

        s.pop();
        assertEquals(s.getMin(), 3);
    }

}
