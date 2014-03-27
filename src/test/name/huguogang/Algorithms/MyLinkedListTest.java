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
    
    @Test
    public void findLoopBeginningTest() {
        Node head;
        Node actual;
        Node expected;
        
        head = null;
        expected = null;
        actual = findLoopBeginning(head);
        assertEquals(expected, actual);
        
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = expected = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = expected;
        actual = findLoopBeginning(head);
        assertEquals(expected, actual);
        
        head = new Node(1);
        head.next = new Node(2);
        expected = null;
        actual = findLoopBeginning(head);
        assertEquals(expected, actual);
    }
}
