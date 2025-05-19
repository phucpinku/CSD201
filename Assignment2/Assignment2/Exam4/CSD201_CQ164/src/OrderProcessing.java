/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==========================================================================
import java.util.*;
import java.io.*;

class ItemList {

    Node head, tail;

    ItemList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataItem(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    void addLast(String name, int quantity, int price) {
        //You should write here appropriate statements to complete this function.
        //---------------------------------------------------------------------
        Item newItem = new Item(name, quantity, price);
        Node newNode = new Node(newItem);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        //---------------------------------------------------------------------
    }
}

class OrderQueue {

    Node front, rear;

    OrderQueue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void clear() {
        front = rear = null;
    }

    void loadDataOrder(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(String name, int quantity) {
        //You should write here appropriate statements to complete this function.
        //---------------------------------------------------------------------
        Item newItem = new Item(name, quantity);
        Node newNode = new Node(newItem);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        //---------------------------------------------------------------------
    }

    Item deQueue() {
        Item tmp = new Item();
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (isEmpty()) {
            return null;
        }
        tmp = front.info;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        //---------------------------------------------------------
        return tmp;
    }
}

class OrderProcessing {

    ItemList iList = new ItemList();
    OrderQueue oQueue = new OrderQueue();

    OrderProcessing() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = iList.head;
        f.writeBytes("Available items: ");
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Order list: ");
        p = oQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getName() + "," + p.info.getQuantity() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        iList.loadDataItem(k);
        oQueue.loadDataOrder(k);
    }

//=============================================================================
//=========YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//=============================================================================
    void f1() throws Exception {
        load(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        f.close();
    }

    int purchase(Item t) throws Exception {
        int r = 0;
        //You should write here appropriate statements to complete this function.
        //---------------------------------------------------------------------
        Node p = iList.head;
        while (p != null) {
            if (p.info.getName().equals(t.getName())) {
                if (p.info.getQuantity() >= t.getQuantity()) {
                    int revenue = t.getQuantity() * p.info.getPrice();
                    p.info.setQuantity(p.info.getQuantity() - t.getQuantity());
                    return revenue;
                }
                return r;

            }
            p = p.next;
        }
        //---------------------------------------------------------------------
        return r;
    }

    void f2() throws Exception {
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //---------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        Item t = oQueue.deQueue();
        if (t != null) {
            purchase(t);
        }

        //---------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //---------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        while (!oQueue.isEmpty()) {
            Item t = oQueue.deQueue();
            purchase(t);
        }

        //---------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void sortList() {
        //You should write here appropriate statements to complete this function.
        //---------------------------------------------------------------------
        if (iList.head == null || iList.head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node p = iList.head;
            while (p.next != null) {
                if (p.info.getPrice() < p.next.info.getPrice()) {
                    Item temp = p.info;
                    p.info = p.next.info;
                    p.next.info = temp;
                    swapped = true;
                }
                p = p.next;
            }

        } while (swapped);
//---------------------------------------------------------------------

    }

    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int s = 0;
        //---------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        while (!oQueue.isEmpty()) {
            Item t = oQueue.deQueue();
            s += purchase(t);
        }

        //---------------------------------------------------------------------
        sortList();
        ftraverse(f);
        f.writeBytes("Sales: " + s + " ");
        f.close();
    }
}
