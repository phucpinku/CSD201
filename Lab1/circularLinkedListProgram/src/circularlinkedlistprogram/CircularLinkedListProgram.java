/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlinkedlistprogram;



public class CircularLinkedListProgram {
    
    private Node head;

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    public void addToHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself to form a circular structure
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addToTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself to form a circular structure
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head; // Close the circular link
        }
    }

    public void addAfter(int value, int pos) {
        if (pos == 1) {
            this.addToHead(value);
            return;
        }
        if (pos > this.count() || pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        Node current = head;
        int count = 1;
        while (count < pos) {
            current = current.next;
            count++;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.value + " ----> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    public int count() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public void deleteFromHead() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (head.next == head) { // Only one node in the list
            head = null;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        head = head.next;
        tail.next = head;
    }

    public void deleteFromTail() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (head.next == head) { // Only one node in the list
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != head) {
            current = current.next;
        }
        current.next = head; // Close the circular link
    }

    public void deleteAfter(int pos) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (pos <= 0 || pos >= this.count()) {
            System.out.println("Invalid position");
            return;
        }
        Node current = head;
        int count = 1;
        while (count < pos) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    public Node search(int x) {
        if (head == null) {
            return null;
        }
        Node current = head;
        do {
            if (current.value == x) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public void delete(Node p) {
        if (head == null || p == null) return;

        if (head == p) {
            this.deleteFromHead();
            return;
        }

        Node current = head;
        do {
            if (current.next == p) {
                current.next = p.next;
                return;
            }
            current = current.next;
        } while (current != head);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
         CircularLinkedListProgram list = new CircularLinkedListProgram();

        // Add elements to the head
        System.out.println("Adding to head:");
        list.addToHead(10);
        list.addToHead(20);
        list.traverse();

        // Add elements to the tail
        System.out.println("\nAdding to tail:");
        list.addToTail(30);
        list.addToTail(40);
        list.traverse();

        // Add after a position
        System.out.println("\nAdding after position 2:");
        list.addAfter(25, 2);
        list.traverse();

        // Delete from head
        System.out.println("\nDeleting from head:");
        list.deleteFromHead();
        list.traverse();

        // Delete from tail
        System.out.println("\nDeleting from tail:");
        list.deleteFromTail();
        list.traverse();

        // Delete after position
        System.out.println("\nDeleting after position 2:");
        list.deleteAfter(2);
        list.traverse();

        // Search for an element
        System.out.println("\nSearching for 30:");
        Node result = list.search(30);
        System.out.println(result != null ? "Found: " + result.value : "Not Found");

        // Delete a specific node
        System.out.println("\nDeleting specific node (Node with value 30):");
        list.delete(result);
        list.traverse();

        // Final state
        System.out.println("\nFinal state of the list:");
        list.traverse();
    }
    
}
