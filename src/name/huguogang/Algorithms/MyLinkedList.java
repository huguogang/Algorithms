package name.huguogang.Algorithms;

public class MyLinkedList {
    public static class Node {
        public int data;
        public Node next = null;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    /**
     * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
     * EXAMPLE
     * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
     * Output: 8 -> 0 -> 8
     * 
     * @param number1
     * @param Number2
     * @return
     */
    public static Node addLists(Node number1, Node number2) {
        Node root = null;
        Node n;
        Node pre = null;
        int carry = 0;
        while(!(number1 == null && number2 == null)) {
            int val = carry;
            if(number1 != null) {
                val += number1.data;
                number1 = number1.next;
            }
            if(number2 != null) {
                val += number2.data;
                number2 = number2.next;
            }
            carry = val / 10;
            n = new Node(val % 10);
            if(root == null) {
                root = n;
                pre = n;
            }
            else {
                pre.next = n;
                pre = n;
            }
        }
        return root;
    }
    
    public static void dumpList(Node root) {
        if(root == null) {
            System.out.println("null");
            return;
        }
        Node n = root;
        while(n != null) {
            System.out.print("" + n.data + ",");
            n = n.next;
        }
        System.out.print("\r\n");
    }
}
