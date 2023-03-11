/*
Victor Ericson vier1798
Filip Lingefelt fili8261
Samuel Bakall saba9460
 */

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

        int[] smallSet = generateSortedData(100);
        int[] mediumSet = generateSortedData(200);
        int[] largeSet = generateSortedData(300);

        System.out.println("Splay Tree Inserts");
        testSearchForSplay(splayTree, smallSet, "small");
        testSearchForSplay(splayTree, mediumSet, "medium");
        testSearchForSplay(splayTree, largeSet, "large");

        System.out.println();

        System.out.println("Red Black Tree Inserts");
        testSearchForRedBlack(redBlackTree, smallSet, "small");
        testSearchForRedBlack(redBlackTree, mediumSet, "medium");
        testSearchForRedBlack(redBlackTree, largeSet, "large");

        System.out.println();

        System.out.println("Treap Inserts");
        testSearchForTreap(treap, smallSet, "small");
        testSearchForTreap(treap, mediumSet, "medium");
        testSearchForTreap(treap, largeSet, "large");
    }

    private static int[] generateSortedData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        return data;
    }

    private static void testSearchForSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        splayTree.resetOperations();

        int[] randomNumbers = new int[50];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(50);
        }
        Arrays.stream(randomNumbers).forEach(splayTree::insert);

        System.out.println("Dataset: " + type + ", Operations: " + splayTree.getOperations());
    }

    private static void testSearchForRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);
        redBlackTree.resetOperations();
        // Insert all random numbers at once outside the loop
        int[] randomNumbers = new int[50];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(50);
        }
        Arrays.stream(randomNumbers).forEach(redBlackTree::insert);



        System.out.println("Dataset: " + type + ", Operations: " + redBlackTree.getOperations());
    }

    private static void testSearchForTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        treap.resetOperations();
        int[] randomNumbers = new int[50];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(50);
        }
        Arrays.stream(randomNumbers).forEach(treap::insert);

        System.out.println("Dataset: " + type + ", Operations: " + treap.getOperations());
    }
}