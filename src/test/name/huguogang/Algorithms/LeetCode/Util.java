package test.name.huguogang.Algorithms.LeetCode;

import java.util.List;

import name.huguogang.Algorithms.LeetCode.ListNode;
import name.huguogang.Algorithms.LeetCode.SolutionArchive;
import name.huguogang.Algorithms.LeetCode.TreeNode;

public class Util {
    public static <T> void printList(List<T> l) {
        System.out.print("[");
        for (T i : l) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("]\r\n");
    }

    public static <T> void printListList(List<List<T>> ll) {
        for (List<T> set : ll) {
            System.out.print("[");
            for (T i : set) {
                System.out.print(i);
                System.out.print(",");
            }
            System.out.print("]\r\n");
        }
    }
    
    public static <T> void printListArray(List<T[]> ll) {
        for (T[] row : ll) {
            System.out.println("[");
            for (T i : row) {
                System.out.print(i);
                System.out.print(",\r\n");
            }
            System.out.print("]\r\n");
        }
    }
    
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.printf("->");
            head = head.next;
        }
        System.out.print("\r\n");
    }

    public static void printArray(int[] A) {
        for (int i : A) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\r\n");
    }
    
    public static void printTreeByLevel(TreeNode root) {
        SolutionArchive solution = new SolutionArchive();
        List<List<Integer>> level = solution.levelOrder(root);
        printListList(level);
    }
    
}
