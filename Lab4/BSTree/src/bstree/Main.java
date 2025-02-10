

package bstree;


public class Main {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Height: " + tree.height(tree.root));
        System.out.println("Sum: " + tree.sum(tree.root));
        System.out.println("Max Path Sum: " + tree.maxPathSum(tree.root));
        System.out.println("Is AVL: " + tree.isAVL(tree.root));
        System.out.println("Is Heap: " + tree.isHeap(tree.root));
    }
}
