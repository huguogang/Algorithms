package name.huguogang.Algorithms;
/**
 * implementation of various sorting algorithms
 * insertion sort, bubble sort, quick sort, merge sort
 * @author ghu
 *
 */
public class Sorting {
    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for(int i = 1; i < len; ++i) {
            int val = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = val;
        }
    }
    
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
        //part that is less than pivot
        int l = left + 1;
        //part that is greater than pivot
        int r = right;
        while(true) {
            //note <= here to deal with duplicated value
            //if use < only, we may stuck in infinite loop in one of the test case
            //however values equal to val cannot be on the right side,
            //because r scan may go past left and hit illegal value
            while(l <= right && array[l] <= val) {
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
