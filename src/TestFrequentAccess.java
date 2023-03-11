/*
Testar access till frekventa element i olika träd.
Här bör splayträdet generellt vara snabbast då access till frekventa element är dess styrka.
 */

import java.util.Arrays;
import java.util.Random;

public class TestFrequentAccess {

    public static void main(String[] args) {

        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        int[] sortedData = generateSortedData();
        int[] unsortedData = generateUnsortedData();
        int[] reverseSortedData = generateReverseSortedData();

        System.out.println("Splay Tree Searches");
        testContainsForSplay(splayTree, sortedData, "sorted");
        testContainsForSplay(splayTree, unsortedData, "unsorted");
        testContainsForSplay(splayTree, reverseSortedData, "reverse sorted");

        System.out.println();

        System.out.println("Red Black Tree Searches");
        testContainsForRedBlack(redBlackTree, sortedData, "sorted");
        testContainsForRedBlack(redBlackTree, unsortedData, "unsorted");
        testContainsForRedBlack(redBlackTree, reverseSortedData, "reverse sorted");

        System.out.println();

        System.out.println("Treap Searches");
        testContainsForTreap(treap, sortedData, "sorted");
        testContainsForTreap(treap, unsortedData, "unsorted");
        testContainsForTreap(treap, reverseSortedData, "reverse sorted");
    }

    private static int[] generateSortedData() {
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        return data;
    }

    private static int[] generateUnsortedData() {
        Random random = new Random();
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
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

    private static void testContainsForSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        splayTree.resetOperations();

        for (int i = 0; i < 10; i++) {
            int random = new Random(10).nextInt();
            for (int j = 0; j < 20; j++) {
                splayTree.contains(random);
            }
        }
        System.out.println("Dataset: " + type + ", Operations: " + splayTree.getOperations());
    }

    private static void testContainsForRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);

        redBlackTree.resetOperations();

        for (int i = 0; i < 10; i++) {
            int random = new Random(10).nextInt();
            for (int j = 0; j < 20; j++) {
                redBlackTree.contains(random);
            }
        }
        System.out.println("Dataset: " + type + ", Operations: " + redBlackTree.getOperations());
    }

    private static void testContainsForTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        treap.resetOperations();

        for (int i = 0; i < 10; i++) {
            int random = new Random(10).nextInt();
            for (int j = 0; j < 20; j++) {
                treap.contains(random);
            }
        }
        System.out.println("Dataset: " + type + ", Operations: " + treap.getOperations());
    }
}