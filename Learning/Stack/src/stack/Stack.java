
package stack;
import java.util.*;

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
    
    public int length() {
        return length;
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

    public static void main(String[] args) {
        // TODO code application logic here
        
        Stack myStack = new Stack();
        
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.traverse();
        System.out.println();
        myStack.pop();
        myStack.traverse();
        System.out.println();
        System.out.println(myStack.peek());
        
    }
    
}
