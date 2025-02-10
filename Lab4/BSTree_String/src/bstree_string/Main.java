package bstree_string;

public class Main {

    public static void main(String[] args) {
        BSTree_String tree = new BSTree_String();
        tree.insert("dog");
        tree.insert("cat");
        tree.insert("elephant");
        tree.insert("ant");
        tree.insert("bat");
        tree.insert("fish");
        tree.insert("goat");

        System.out.println("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Height: " + tree.height(tree.root));
        System.out.println("Is AVL: " + tree.isAVL(tree.root));
    }
}
