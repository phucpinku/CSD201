/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlistprogram;



public class SinglyLinkedListProgram {

    
    private Node head;

    public static class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }
    
    public void addToHead(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addToTail(String value) {
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
        newNode.next = null;
    }

    public void addAfter(String value, int pos) {
        if (pos == 1) {
            this.addToHead(value);
            return;
        }
        if (pos > this.count() || pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        Node current = head;
        int count = 0;
        while (count < pos - 1) {
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
        while (current != null) {
            System.out.print(current.value + " ----> ");
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
    }

    public void deleteFromTail() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteAfter(int pos) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (pos == 1) {
            this.deleteFromHead();
            return;
        }
        if (pos > this.count() || pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        int count = 1;
        Node current = head;
        while (count < pos - 1) {
            current = current.next;
            count++;
        }

        current.next = current.next.next;
    }
    
    public Node search(String x) {
        Node current = head;
        while (current != null) {
            if (current.value.equalsIgnoreCase(x)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Function 11: Delete a specific node
    public void delete(Node p) {
        if (head == null || p == null) return;

        if (head == p) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }

        if (current.next == p) {
            current.next = p.next;
        }
    }   
    
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedListProgram list = new SinglyLinkedListProgram();

    // Add elements to the head
    System.out.println("Adding to head:");
    list.addToHead("Hello");
    list.addToHead("World");
    list.traverse();

    // Add elements to the tail
    System.out.println("\nAdding to tail:");
    list.addToTail("Java");
    list.addToTail("Programming");
    list.traverse();

    // Add an element after a specific position
    System.out.println("\nAdding after position 2:");
    list.addAfter("Awesome", 2);
    list.traverse();

    // Count the elements in the list
    System.out.println("\nCount of elements in the list:");
    System.out.println(list.count());

    // Delete from the head
    System.out.println("\nDeleting from head:");
    list.deleteFromHead();
    list.traverse();

    // Delete from the tail
    System.out.println("\nDeleting from tail:");
    list.deleteFromTail();
    list.traverse();

    // Delete after a specific position
    System.out.println("\nDeleting after position 2:");
    list.deleteAfter(2);
    list.traverse();

    // Search for an element
    System.out.println("\nSearching for 'Java':");
    Node searchResult = list.search("Java");
    if (searchResult != null) {
        System.out.println("Found: " + searchResult.value);
    } else {
        System.out.println("Not Found");
    }

    // Delete a specific node
    System.out.println("\nDeleting a specific node (Node with value 'Java'):");
    Node nodeToDelete = list.search("Java");
    list.delete(nodeToDelete);
    list.traverse();

    // Check the list after all operations
    System.out.println("\nFinal state of the list:");
    list.traverse();
    }
    
}
