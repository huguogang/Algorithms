package name.huguogang.Algorithms;
/**
 * implementation of various sorting algorithms
 * 
 * @author ghu
 *
 */
public class Sorting {
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }
    
    private static void qSort(int[] array, int left, int right) {
        if(right <= left) {
            return;
        }
        int j = partition(array, left, right);
        qSort(array, left, j - 1);
        qSort(array, j + 1, right);
    }
    
    private static int partition(int[] array, int left, int right) {
        //use left value for pivot
        int val = array[left];
        int l = left + 1;
        int r = right;
        while(l < r) {
            while(l <= right && array[l] < val) {
                l++;
            }
            while(r >= left && array[r] > val) {
                r--;
            }
            if(l >= r) break;
            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
        }
        array[left] = array[r];
        array[r] = val;
        return r;
    }
}
