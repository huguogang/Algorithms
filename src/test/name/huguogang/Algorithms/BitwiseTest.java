package test.name.huguogang.Algorithms;

import static name.huguogang.Algorithms.Bitwise.count1s;
import static name.huguogang.Algorithms.Bitwise.parity1;
import static name.huguogang.Algorithms.Bitwise.parity2;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitwiseTest {

    @Test
    public void count1sTest() {
        int num;
        int expected;
        int actual;

        num = 0;
        expected = 0;
        actual = count1s(num);
        assertEquals(expected, actual);

        num = 0xFFFF;
        expected = 16;
        actual = count1s(num);
        assertEquals(expected, actual);

        num = -1;
        expected = 32;
        actual = count1s(num);
        assertEquals(expected, actual);
    }
    
    @Test 
    public void parityTest() {
        int num;
        int expected;
        int actual;
        
        num = 0;
        expected = 0;
        actual = parity1(num);
        assertEquals(expected, actual);
        actual = parity2(num);
        assertEquals(expected, actual);
        
        num = 32;
        expected = 1;
        actual = parity1(num);
        assertEquals(expected, actual);
        actual = parity2(num);
        assertEquals(expected, actual);
        
        num = 0xFFFF;
        expected = 0;
        actual = parity1(num);
        assertEquals(expected, actual);
        actual = parity2(num);
        assertEquals(expected, actual);
        
        num = 0x7077;
        expected = 1;
        actual = parity1(num);
        assertEquals(expected, actual);
        actual = parity2(num);
        assertEquals(expected, actual);
    }

}
