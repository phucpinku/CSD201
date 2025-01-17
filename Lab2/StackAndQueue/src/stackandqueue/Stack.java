

package stackandqueue;

import java.util.EmptyStackException;


public class Stack {
    private Node top;
    private int length;
    
    
    private static class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public Stack() {
        top = null;
        length = 0;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void clear() {
        top = null;
        length = 0;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }
    
    public int pop() {
        if (top == null) {
            System.out.println("Stack empty");    
            throw new EmptyStackException();
        }
        int temp = top.data;
        top = top.next;
        length--;
        return temp;
    }
    
    public int peek() {
        if (top == null) {
            System.out.println("Stack empty");
        }
        return top.data;
    }
    
        public void traverse() {
            if (top == null) {
                System.out.println("Stack empty");
            }
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
                
            }
        }
        
        public void decimalToBinary(int number) {
            clear();
            while (number > 0) {
                push(number % 2);
                number /= 2;
            }
            traverse();
        }
}
