package name.huguogang.Algorithms;
/**
 * Some algorithms based on bitwise operators
 * 
 *  n * 2 ==> n << 1;
 *  n * 7 ==> n + n << 1 + n << 2
 *  n & (n - 1) ==> remove the last 1
 *  
 * @author ghu
 *
 */
public class Bitwise {
    /**
     * Count number of 1 bits in number
     * 
     * @param num
     * @return
     */
    public static int count1s(int num) {
        int c = 0;
        while(num != 0) {
            c++;
            num = num & (num - 1);
        }
        return c;
    }
    
    /**
     * Compute parity
    *  time: O(n), n: number of bits
     * 
     * @param num
     * @return
     */
    public static byte parity1(int num) {
        return (byte)(count1s(num)%2);
    }
    
    /**
     * compute parity
     * time: O(log n), n: number of bits
     * 
     * @param num
     * @return
     */
    public static byte parity2(int num) {
       int ret = (num  >> 16) ^ (num & 0xFFFF);
       ret = (ret >> 8) ^ (ret & 0xFF);
       ret = (ret >> 4) ^ (ret & 0xF);
       ret = (ret >> 2) ^ (ret & 0x3);
       ret = (ret >> 1) ^ (ret & 0x1);
       return (byte) ret;
    }
    
}
