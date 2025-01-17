package stackandqueue;

public class Queue {

    private Node front;
    private Node rear;
    private int length;

    private static class Node {

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = rear = null;
        length = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = rear = null;
        length = 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int temp = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return temp;
    }

    public int first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void fractionalToBinary(double number) {
        clear();
        while (number > 0 && length < 32) { // Limit precision to 32 bits
            number *= 2;
            if (number >= 1) {
                enqueue(1);
                number -= 1;
            } else {
                enqueue(0);
            }
        }
        traverse();
    }
}
