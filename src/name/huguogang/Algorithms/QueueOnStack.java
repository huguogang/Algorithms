package name.huguogang.Algorithms;

import java.util.Stack;

/**
 * A queue implemented using stack
 * 
 * @author ghu
 *
 */
public class QueueOnStack<E> {
    private Stack<E> s1;
    private Stack<E> s2;
    
    public QueueOnStack() {
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }
    
    public void enqueue(E ele) {
        s1.push(ele);
    }
    
    /**
     * Remove one element from queue. 
     * 
     * @return The element in the front of queue, or null if queue is empty
     */
    public E dequeue() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        
        if(!s2.empty()) {
            return s2.pop();
        }
        return null;
    }
}
