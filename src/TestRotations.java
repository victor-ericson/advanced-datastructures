/*
Här ska treap ha minst antal rotations då det är ett slumpmässigt träd och utför därför inga rotationer vid access och insertions.
 */

import java.util.Arrays;
import java.util.Random;

public class TestRotations {

    public static void main(String[] args) {
        int[] smallData = generateRandomData(1000);
        int[] mediumData = generateRandomData(2000);
        int[] largeData = generateRandomData(3000);

        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        System.out.println("Splay Tree Rotations");
        testRotationsSplay(splayTree, smallData, "small");
        testRotationsSplay(splayTree, mediumData, "medium");
        testRotationsSplay(splayTree, largeData, "large");

        System.out.println();

        System.out.println("Red Black Tree Rotations");
        testRotationsRedBlack(redBlackTree, smallData, "small");
        testRotationsRedBlack(redBlackTree, mediumData, "medium");
        testRotationsRedBlack(redBlackTree, largeData, "large");

        System.out.println();

        System.out.println("Treap Rotations");
        testRotationsTreap(treap, smallData, "small");
        testRotationsTreap(treap, mediumData, "medium");
        testRotationsTreap(treap, largeData, "large");
    }

    private static int[] generateRandomData(int size) {
        int random = new Random().nextInt();
        int[] data = new int[size];
        Arrays.fill(data, random);
        return data;
    }

    private static void testRotationsSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        splayTree.resetRotations();
        for (int i = 0; i < data.length; i++) {
            splayTree.insert(i);
        }
        splayTree.insert(5);
        splayTree.insert(25);
        splayTree.contains(25);
        splayTree.contains(5);
        splayTree.insert(44);
        splayTree.contains(44);

        System.out.println("Dataset: " + type + ", Rotations: " + splayTree.getRotations());
        splayTree.resetRotations();
    }

    private static void testRotationsRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);

        redBlackTree.resetRotations();
        for (int i = 0; i < data.length; i++) {
            redBlackTree.insert(i);
        }
        redBlackTree.insert(5);
        redBlackTree.insert(25);
        redBlackTree.contains(25);
        redBlackTree.contains(5);
        redBlackTree.insert(44);
        redBlackTree.contains(44);

        System.out.println("Dataset: " + type + ", Rotations: " + redBlackTree.getRotations());
        redBlackTree.resetRotations();
    }

    private static void testRotationsTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        treap.resetRotations();

        for (int i = 0; i < data.length; i++) {
            treap.insert(i);
        }
        treap.insert(5);
        treap.insert(25);
        treap.contains(25);
        treap.contains(5);
        treap.insert(44);
        treap.contains(44);

        System.out.println("Dataset: " + type + ", Rotations: " + treap.getRotations());
        treap.resetRotations();
    }
}
