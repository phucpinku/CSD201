/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

/**
 *
 * @author ACER
 */
import java.util.*;
public class BSTree {
    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void clear() {
        root = null;
    }

    Node search(Node root, int x) {
        if (root == null || root.key == x)
            return root;
        if (root.key > x)
            return search(root.left, x);
        return search(root.right, x);
    }

    void insert(int x) {
        root = insertRec(root, x);
    }

    Node insertRec(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (x < root.key)
            root.left = insertRec(root.left, x);
        else if (x > root.key)
            root.right = insertRec(root.right, x);
        return root;
    }

    void breadth() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        System.out.println();
    }

    void preorder(Node p) {
        if (p != null) {
            System.out.print(p.key + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.key + " ");
            inorder(p.right);
        }
    }

    void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.key + " ");
        }
    }

    int count(Node root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

    void dele(int x) {
        root = deleteRec(root, x);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    Node min() {
        Node current = root;
        while (current != null && current.left != null)
            current = current.left;
        return current;
    }

    Node max() {
        Node current = root;
        while (current != null && current.right != null)
            current = current.right;
        return current;
    }

    int sum(Node root) {
        if (root == null) return 0;
        return root.key + sum(root.left) + sum(root.right);
    }

    int avg() {
        return count(root) == 0 ? 0 : sum(root) / count(root);
    }

    int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    int maxPathSum(Node root) {
        if (root == null) return 0;
        return root.key + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }

    boolean isAVL(Node root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isAVL(root.left) && isAVL(root.right);
    }

    int mystery(Node x) {
        if (x == null) return 0;
        else return Math.max(mystery(x.left), mystery(x.right));
    }

    boolean isHeap(Node root) {
        if (root == null) return true;
        if ((root.left != null && root.left.key > root.key) || (root.right != null && root.right.key > root.key))
            return false;
        return isHeap(root.left) && isHeap(root.right);
    }
    
}
