

package stackandqueue;


public class Main {
    public static void main(String[] args) {
        // Testing Stack with Integer
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.print("Stack traverse: ");
        stack.traverse();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.print("Stack traverse after pop: ");
        stack.traverse();
        System.out.print("Binary of 10: ");
        stack.decimalToBinary(10);

        // Testing Queue with Integer
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.print("Queue traverse: ");
        queue.traverse();
        System.out.println("First element: " + queue.first());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.print("Queue traverse after dequeue: ");
        queue.traverse();
        System.out.print("Binary fraction of 0.625: ");
        queue.fractionalToBinary(0.625);
    }
}
