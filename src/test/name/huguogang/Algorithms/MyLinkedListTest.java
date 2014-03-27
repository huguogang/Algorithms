package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import static name.huguogang.Algorithms.MyLinkedList.*;

public class MyLinkedListTest {

    @Test
    public void addListsTest() {
        Node n1;
        Node n2;
        
        n1 = null;
        n2 = null;
        dumpList(addLists(n1, n2));
        
        n1 = new Node(3);
        n1.next = new Node(1);
        n1.next.next = new Node(5);
        n2 = new Node(5);
        n2.next = new Node(9);
        n2.next.next = new Node(2);
        dumpList(addLists(n1, n2));
    }
}
