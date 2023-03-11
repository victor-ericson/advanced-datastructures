/*
Testar en blandning av insert och access till olika träd.
Här bör red-black tree vara snabbast då dess stabila balansering gör att den är snabbast vid insert.

 */

import java.util.Arrays;
import java.util.Random;

public class TestInsert {

    public static void main(String[] args) {

        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        int[] sortedData = generateSortedData();
        int[] unsortedData = generateUnsortedData();
        int[] reverseSortedData = generateReverseSortedData();

        System.out.println("Splay Tree Inserts");
        testSearchForSplay(splayTree, sortedData, "sorted");
        testSearchForSplay(splayTree, unsortedData, "unsorted");
        testSearchForSplay(splayTree, reverseSortedData, "reverse sorted");

        System.out.println();

        System.out.println("Red Black Tree Inserts");
        testSearchForRedBlack(redBlackTree, sortedData, "sorted");
        testSearchForRedBlack(redBlackTree, unsortedData, "unsorted");
        testSearchForRedBlack(redBlackTree, reverseSortedData, "reverse sorted");

        System.out.println();

        System.out.println("Treap Inserts");
        testSearchForTreap(treap, sortedData, "sorted");
        testSearchForTreap(treap, unsortedData, "unsorted");
        testSearchForTreap(treap, reverseSortedData, "reverse sorted");
    }

    private static int[] generateSortedData() {
        int[] data = new int[150];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        return data;
    }

    private static int[] generateUnsortedData() {
        Random random = new Random();
        int[] data = new int[150];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(150);
        }
        return data;
    }

    private static int[] generateReverseSortedData() {
        int[] data = generateSortedData();
        int[] reverseData = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            reverseData[i] = data[data.length - i - 1];
        }
        return reverseData;
    }

    private static void testSearchForSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        splayTree.resetOperations();

        splayTree.insert(5);
        splayTree.insert(25);
        splayTree.insert(44);

        System.out.println("Dataset: " + type + ", Operations: " + splayTree.getOperations());
    }

    private static void testSearchForRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);

        redBlackTree.resetOperations();

        redBlackTree.insert(5);
        redBlackTree.insert(25);
        redBlackTree.insert(44);

        System.out.println("Dataset: " + type + ", Operations: " + redBlackTree.getOperations());
    }

    private static void testSearchForTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        treap.resetOperations();

        treap.insert(5);
        treap.insert(25);
        treap.insert(44);

        System.out.println("Dataset: " + type + ", Operations: " + treap.getOperations());
    }
}