/*
Victor Ericson vier1798
Filip Lingefelt fili8261
Samuel Bakall saba9460
 */
/*
Här ska treap ha minst antal rotations då det är ett slumpmässigt träd och utför därför inga rotationer vid access och insertions.
 */

import java.util.Arrays;
import java.util.Random;

public class TestRotations {

    public static void main(String[] args) {
        int[] dataSetOne = generateRandomData(100);
        int[] dataSetTwo = generateSortedData(100);
        int[] dataSetThree = generateReverseSortedData(100);

        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        System.out.println("Splay Tree Rotations");
        testRotationsSplay(splayTree, dataSetOne, "1");
        testRotationsSplay(splayTree, dataSetTwo, "2");
        testRotationsSplay(splayTree, dataSetThree, "3");

        System.out.println();

        System.out.println("Red Black Tree Rotations");
        testRotationsRedBlack(redBlackTree, dataSetOne, "1");
        testRotationsRedBlack(redBlackTree, dataSetTwo, "2");
        testRotationsRedBlack(redBlackTree, dataSetThree, "3");

        System.out.println();

        System.out.println("Treap Rotations");
        testRotationsTreap(treap, dataSetOne, "1");
        testRotationsTreap(treap, dataSetTwo, "2");
        testRotationsTreap(treap, dataSetThree, "3");
    }

    private static int[] generateRandomData(int size) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000);
        }
        return data;
    }

    private static int[] generateSortedData(int size) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
        return data;
    }

    private static int[] generateReverseSortedData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = size - i;
        }
        return data;
    }

    private static void testRotationsSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        splayTree.resetRotations();

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            splayTree.insert(random.nextInt(1000));
        }

        System.out.println("Dataset: " + type + ", Rotations: " + splayTree.getRotations());
    }

    private static void testRotationsRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);

        redBlackTree.resetRotations();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            redBlackTree.insert(random.nextInt(1000));
        }

        System.out.println("Dataset: " + type + ", Rotations: " + redBlackTree.getRotations());
    }

    private static void testRotationsTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        treap.resetRotations();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            treap.insert(random.nextInt(1000));
        }

        System.out.println("Dataset: " + type + ", Rotations: " + treap.getRotations());
    }
}
