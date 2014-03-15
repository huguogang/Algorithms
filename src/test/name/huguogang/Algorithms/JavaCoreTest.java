package test.name.huguogang.Algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Some tests of Java language's core behavior
 * 
 * @author Guogang Hu
 * 
 */
public class JavaCoreTest {
    @Test
    public void EqualsTest() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s1;
        String s4 = "abc";
        assertTrue(s1.equals(s2));
        assertTrue(s1.equals(s3));
        assertTrue(s1.equals(s4));

        assertFalse(s1 == s2);
        assertTrue(s1 == s3);
        assertTrue(s1 == s4);
    }

    @Test(expected = java.lang.NumberFormatException.class)
    public void String2NumberErrorTest() {
        String s1 = "1234.3";
        int i = Integer.valueOf(s1).intValue();
        System.out.println(i);
    }

    @Test
    public void String2NumberTest() {
        // string >> number
        // 1. valueOf
        // 2. parseXXX
        String s1 = "1234";
        int i = Integer.valueOf(s1).intValue();
        System.out.println(i);
        
        s1 = "12.34";
        float f = Float.valueOf(s1).floatValue();
        System.out.println(f);
    }

    @Test
    public void Number2StringTest() {
        // number >> string
        // 1. "" + number
        // 2. String.valueOf
        // 3. Float.toString
        String s2;
        s2 = "" + 12.34;
        float f = Float.parseFloat(s2);
        s2 = String.valueOf(f);
        s2 = Float.toString(f);
    }
    
    @Test
    public void CastingTest(){
        //The following does not compile
        //long l = 1.234;
        //int i = l;
        long l = (long)1.234;
        int i = (int)l;
        i = 2000000000;
        System.out.println(i);
        //you get -27648 because java only keeps last 16 bits
        short s = (short)i;
        System.out.println(s);
    }
    
    @Test
    public void PrimitiveTypesTest() {
        //8 types: boolean, byte, char, short, int, long, float, double (9 if count String)
        byte b = (byte)255;
        //byte is signed, result is -1
        System.out.println(b);
        
        int a = 64;
        //convert ASCII to char
        char c = (char)a;
        System.out.println(c);
        //convert char to ASCII
        c = 'a';
        a = (int) c;
        System.out.println(a);
    }
}
