/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlistprogram;

/**
 *
 * @author ACER
 */
public class DoublyLinkedListProgram {

    private Node head;
    private Node tail;

    public static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
     public void addToHead(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addToTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
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
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void deleteFromHead() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public void deleteFromTail() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = null;
        } else {
            head = null; // If there's only one element
        }
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
        Node nodeToDelete = current.next;
        if (nodeToDelete != null) {
            current.next = nodeToDelete.next;
            if (nodeToDelete.next != null) {
                nodeToDelete.next.prev = current;
            }
        }
    }

    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.value == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(Node p) {
        if (head == null || p == null) {
            return;
        }
        if (head == p) {
            head = p.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        if (p.next != null) {
            p.next.prev = p.prev;
        }
        if (p.prev != null) {
            p.prev.next = p.next;
        }
    }
    
    public static void main(String[] args) {
        DoublyLinkedListProgram list = new DoublyLinkedListProgram();

        System.out.println("Adding to head:");
        list.addToHead(10);
        list.addToHead(20);
        list.traverse();

        System.out.println("\nAdding to tail:");
        list.addToTail(30);
        list.addToTail(40);
        list.traverse();

        System.out.println("\nAdding after position 2:");
        list.addAfter(25, 2);
        list.traverse();

        System.out.println("\nDeleting from head:");
        list.deleteFromHead();
        list.traverse();

        System.out.println("\nDeleting from tail:");
        list.deleteFromTail();
        list.traverse();

        System.out.println("\nDeleting after position 2:");
        list.deleteAfter(2);
        list.traverse();

        System.out.println("\nSearching for 30:");
        Node result = list.search(30);
        System.out.println(result != null ? "Found: " + result.value : "Not Found");

        System.out.println("\nDeleting specific node (Node with value 30):");
        list.delete(result);
        list.traverse();

        System.out.println("\nFinal state of the list:");
        list.traverse();
    }
    
}
