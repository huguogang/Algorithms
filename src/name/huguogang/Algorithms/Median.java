package name.huguogang.Algorithms;

/**
 * median algorithm
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
                // System.out.println("head: " + head);
            }
        }
        tmp = data[head];
        data[head] = data[right];
        data[right] = tmp;
        return head;
    }
}
