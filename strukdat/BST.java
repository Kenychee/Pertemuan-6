package strukdat;

import strukdat.BinarySearchTree;
import strukdat.Tree;

public class BST {
    public static void main(String[] args) {
        BinarySearchTree<Integer,String>bst= new
        BinarySearchTree<Integer,String>();
        bst.insert(6, "A");
        bst.insert(4, "B");
        bst.insert(8, "C");
        bst.insert(2, "D");
        bst.insert(5, "E");
        bst.insert(7, "F");
        bst.insert(10, "G");
        bst.insert(1, "H");
        bst.insert(3, "I");
        bst.insert(9, "J");
        bst.insert(11, "K");

        System.out.println("InOrder: ");
        bst.inOrder();
        System.out.println();

        System.out.println("PostOrder: ");
        bst.PostOrder();
        System.out.println();

        System.out.println("PreOrder: ");
        bst.preOrder();
        System.out.println();

        System.out.println("Level-Order: ");
        bst.LevelOrder();
        System.out.println();

        System.out.println();
        
        System.out.println("Deleted key 10: ");
        bst.delete(10);

        System.out.println("new InOrder: ");
        bst.inOrder();
        System.out.println();

        System.out.println("new PostOrder: ");
        bst.PostOrder();
        System.out.println();

        System.out.println("new PreOrder: ");
        bst.preOrder();
        System.out.println();

        System.out.println("new Level-Order: ");
        bst.LevelOrder();
        System.out.println();

        System.out.println("Max value: " + bst.max());
        System.out.println("Min value: " + bst.min());
    }
}
