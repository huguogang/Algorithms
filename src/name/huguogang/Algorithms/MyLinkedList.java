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
     * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
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
    
    /**
     * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
     * DEFINITION
     * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
     * EXAMPLE
     * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
     * Output: C
     * 
     * @param root
     * @return
     */
    public static Node findLoopBeginning(Node head) {
        Node p1, p2, pp1;
        p1 = p2 = head;
        //p1 go one node a time, p2 go two nodes a time
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null) {
                p2 = p2.next;
            }
            if(p1 == p2) {
                break;
            }
        }
        if(p2 == null) {
            //no loop
            return null;
        }
        //assuming N node before entering loop and L node in the loop
        //when p1 entered the loop, p2 is N nodes advanced in the loop
        //so when p1 and p2 met, p1 is (N - L) nodes into the loop
        pp1 = head;
        while(pp1 != p1) {
            pp1 = pp1.next;
            p1 = p1.next;
        }
        return p1;
    }
}
