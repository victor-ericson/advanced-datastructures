import java.util.Arrays;
import java.util.Random;

public class TestRotations {

    public static void main(String[] args) {
        int[] smallData = generateRandomData(50);
        int[] mediumData = generateRandomData(100);
        int[] largeData = generateRandomData(150);

        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        System.out.println("Splay Tree Rotations");
        testSearchForSplay(splayTree, smallData, "small");
        testSearchForSplay(splayTree, mediumData, "medium");
        testSearchForSplay(splayTree, largeData, "large");
        System.out.println();

        System.out.println("Red Black Tree Rotations");
        testSearchForRedBlack(redBlackTree, smallData, "small");
        testSearchForRedBlack(redBlackTree, mediumData, "medium");
        testSearchForRedBlack(redBlackTree, largeData, "large");
        System.out.println();

        System.out.println("Treap Rotations");
        testSearchForTreap(treap, smallData, "small");
        testSearchForTreap(treap, mediumData, "medium");
        testSearchForTreap(treap, largeData, "large");
    }

    private static int[] generateRandomData(int size) {
        Random random = new Random();
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(size);
        }
        return data;
    }

    private static void testSearchForSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        splayTree.insert(5);
        splayTree.insert(25);
        splayTree.contains(25);
        splayTree.contains(5);

        System.out.println("Dataset: " + type + ", Operations: " + splayTree.getRotations());
    }

    private static void testSearchForRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);

        redBlackTree.insert(5);
        redBlackTree.insert(25);
        redBlackTree.contains(25);
        redBlackTree.contains(5);
        redBlackTree.insert(44);
        redBlackTree.contains(44);

        System.out.println("Dataset: " + type + ", Operations: " + redBlackTree.getRotations());
    }

    private static void testSearchForTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        treap.insert(5);
        treap.insert(25);
        treap.contains(25);
        treap.contains(5);
        treap.insert(44);
        treap.contains(44);

        System.out.println("Dataset: " + type + ", Operations: " + treap.getRotations());
    }
}
