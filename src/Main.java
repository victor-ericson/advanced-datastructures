import java.util.Arrays;
import java.util.Random;

public class TreeTest {
    public static void main(String[] args) {
        // Create sorted, reverse sorted, and unsorted data sets
        int[] sortedDataSet = {1, 2, 3, 4, 5};
        int[] reverseSortedDataSet = {5, 4, 3, 2, 1};
        int[] unsortedDataSet = {3, 2, 5, 1, 4};

        // Create instances of SplayTree, RedBlackTree, and Treap
        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        // Perform insert, delete, and random operations on each data set
        Random random = new Random();
        int numOperations = 0;
        for (int i = 0; i < sortedDataSet.length; i++) {
            splayTree.insert(sortedDataSet[i]);
            redBlackTree.insert(sortedDataSet[i]);
            treap.add(sortedDataSet[i]);
            numOperations += 3;
        }
        for (int i = 0; i < reverseSortedDataSet.length; i++) {
            splayTree.delete(reverseSortedDataSet[i]);
            redBlackTree.delete(reverseSortedDataSet[i]);
            treap.remove(reverseSortedDataSet[i]);
            numOperations += 3;
        }
        for (int i = 0; i < unsortedDataSet.length; i++) {
            int randomOperation = random.nextInt(3);
            if (randomOperation == 0) {
                splayTree.insert(unsortedDataSet[i]);
                redBlackTree.insert(unsortedDataSet[i]);
                treap.add(unsortedDataSet[i]);
                numOperations += 3;
            } else if (randomOperation == 1) {
                splayTree.delete(unsortedDataSet[i]);
                redBlackTree.delete(unsortedDataSet[i]);
                treap.remove(unsortedDataSet[i]);
                numOperations += 3;
            } else {
                splayTree.find(unsortedDataSet[i]);
                redBlackTree.contains(unsortedDataSet[i]);
                treap.contains(unsortedDataSet[i]);
                numOperations += 3;
            }
        }

        // Print the number of operations performed for each data structure
        System.out.println("SplayTree operations: " + numOperations);
        System.out.println("RedBlackTree operations: " + redBlackTree.getNumOperations());
        System.out.println("Treap operations: " + treap.getNumOperations());
    }
}
