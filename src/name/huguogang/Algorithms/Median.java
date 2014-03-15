package name.huguogang.Algorithms;

/**
 * Median algorithm
 * 
 * @author Guogang Hu
 * 
 */
public class Median {
    /**
     * find median by recursive partition
     * 
     * reference: Introduction to Algorithms, Chapter 9: Medians and Order
     * Statistics
     * 
     * @param data
     * @return
     */
    public static int selectMedian(int[] data) {
        return select(data, 0, data.length - 1, data.length / 2);
    }

    private static int select(int[] data, int left, int right, int k) {
        if (left == right) {
            return data[left];
        }
        int partition = partition(data, left, right);
        if (partition > left + k) {
            return select(data, left, partition - 1, k);
        } else if (partition == left + k) {
            return data[partition];
        } else {
            return select(data, partition + 1, right, k
                    - (partition - left + 1));
        }
    }

    private static int partition(int[] data, int left, int right) {
        int rVal = data[right];
        int head = left;
        int tmp;
        for (int i = left; i < right; i++) {
            if (data[i] <= rVal) {
                tmp = data[head];
                data[head] = data[i];
                data[i] = data[head];
                head++;
            }
        }
        tmp = data[head];
        data[head] = data[right];
        data[right] = tmp;
        return head;
    }
    
    /**
     * Find median or two sorted arrays.
     * 
     * Merge from left to right until hit median index.
     * Time: O(m+n), m: size of arr1, n: size of arr2
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int findMedian1(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if(len1 + len2 == 0) {
            throw new IllegalArgumentException("Median of empty array is not defined.");
        }
        int medianIdx = (len1 + len2) / 2;
        int count = 0;
        int pos1 = 0; 
        int pos2 = 0;
        int number = 0;
        while(count < medianIdx && pos1 < len1 && pos2 < len2) {
            if(arr1[pos1] < arr2[pos2]) {
                number = arr1[pos1];
                pos1++;
            }
            else {
                number = arr2[pos2];
                pos2++;
            }
            count++;
        }
        if(count == medianIdx) {
            return number;
        }
        //either arr1 or arr2 run out of bound
        if(pos1 >= len1) {
            return arr2[medianIdx - len1];
        }
        else {
            return arr1[medianIdx - len2];
        }
    }
}
