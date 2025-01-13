package singlylinkedlist;

public class SinglyLinkedList {

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
        newNode.next = null;
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

    public void deleteNode2(int i) {
        if (i <= 0 || head == null) return;

        if (i == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int pos = 1; pos < i - 1 && current.next != null; pos++) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void addBefore(Node p, int x) {
        if (head == null || p == null) return;

        if (head == p) {
            addToHead(x);
            return;
        }

        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }

        if (current.next == p) {
            Node newNode = new Node(x);
            newNode.next = p;
            current.next = newNode;
        }
    }

    public void sort() {
        if (head == null || head.next == null) return;

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.value > j.value) {
                    int temp = i.value;
                    i.value = j.value;
                    j.value = temp;
                }
            }
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public int[] toArray() {
        int size = count();
        int[] arr = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList result = new SinglyLinkedList();
        Node dummy = new Node(0);
        Node tail = dummy;

        Node p1 = list1.head;
        Node p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                tail.next = new Node(p1.value);
                p1 = p1.next;
            } else {
                tail.next = new Node(p2.value);
                p2 = p2.next;
            }
            tail = tail.next;
        }

        while (p1 != null) {
            tail.next = new Node(p1.value);
            p1 = p1.next;
            tail = tail.next;
        }

        while (p2 != null) {
            tail.next = new Node(p2.value);
            p2 = p2.next;
            tail = tail.next;
        }

        result.head = dummy.next;
        return result;
    }

    public void attach(SinglyLinkedList list) {
        if (head == null) {
            head = list.head;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }

    public int max() {
        if (head == null) throw new IllegalStateException("List is empty");

        int max = head.value;
        Node current = head.next;
        while (current != null) {
            if (current.value > max) max = current.value;
            current = current.next;
        }
        return max;
    }

    public int min() {
        if (head == null) throw new IllegalStateException("List is empty");

        int min = head.value;
        Node current = head.next;
        while (current != null) {
            if (current.value < min) min = current.value;
            current = current.next;
        }
        return min;
    }

    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.value;
            current = current.next;
        }
        return sum;
    }

    public double avg() {
        int count = count();
        if (count == 0) throw new IllegalStateException("List is empty");
        return (double) sum() / count;
    }

    public boolean sorted() {
        if (head == null || head.next == null) return true;

        Node current = head;
        while (current.next != null) {
            if (current.value > current.next.value) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void insert(int x) {
        Node newNode = new Node(x);

        if (head == null || head.value >= x) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value < x) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }
    
    public boolean isEqual(SinglyLinkedList other) {
        Node current1 = this.head;
        Node current2 = other.head;

        while (current1 != null && current2 != null) {
            if (current1.value != current2.value) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addToHead(10);
        list.addToHead(20);
        list.addToTail(5);
        list.addToTail(15);
        list.traverse();

        System.out.println("Search for 10: " + (list.search(10) != null));
        System.out.println("Search for 100: " + (list.search(100) != null));

        Node nodeToDelete = list.search(10);
        list.delete(nodeToDelete);
        list.traverse();

        list.deleteNode2(2);
        list.traverse();

        Node nodeToAddBefore = list.search(15);
        list.addBefore(nodeToAddBefore, 12);
        list.traverse();

        list.sort();
        list.traverse();

        list.reverse();
        list.traverse();

        int[] array = list.toArray();
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addToTail(1);
        list1.addToTail(3);
        list1.addToTail(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToTail(2);
        list2.addToTail(4);
        list2.addToTail(6);

        SinglyLinkedList mergedList = SinglyLinkedList.merge(list1, list2);
        mergedList.traverse();

        list1.attach(list2);
        list1.traverse();

        System.out.println("Max: " + list1.max());
        System.out.println("Min: " + list1.min());
        System.out.println("Sum: " + list1.sum());
        System.out.println("Avg: " + list1.avg());

        System.out.println("Is sorted: " + list1.sorted());

        list1.sort();
        list1.insert(4);
        list1.traverse();

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addToHead(5);
        list3.addToHead(3);
        list3.addToHead(1);

        System.out.println("List1 and List3 are equal: " + list1.isEqual(list3));

        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.addToHead(6);
        list4.addToHead(4);
        list4.addToHead(2);

        System.out.println("List1 and List4 are equal: " + list1.isEqual(list4));
    }

}
