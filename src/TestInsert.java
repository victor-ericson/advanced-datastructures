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
        testInsertForSplay(splayTree, sortedData, "sorted");
        testInsertForSplay(splayTree, unsortedData, "unsorted");
        testInsertForSplay(splayTree, reverseSortedData, "reverse sorted");
        System.out.println();
        System.out.println("Red Black Tree Inserts");
        testInsertForRedBlack(redBlackTree, sortedData, "sorted");
        testInsertForRedBlack(redBlackTree, unsortedData, "unsorted");
        testInsertForRedBlack(redBlackTree, reverseSortedData, "reverse sorted");
        System.out.println();
        System.out.println("Treap Inserts");
        testInsertForTreap(treap, sortedData, "sorted");
        testInsertForTreap(treap, unsortedData, "unsorted");
        testInsertForTreap(treap, reverseSortedData, "reverse sorted");
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

    private static void testInsertForSplay(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        for (int i = 0; i < data.length; i++) {
            int random = new Random(100).nextInt();
            splayTree.insert(random);
            }
        System.out.println("Dataset: " + type + ", Operations: " + splayTree.getOperations());
    }

    private static void testInsertForRedBlack(RedBlackTree<Integer> redBlackTree, int[] data, String type) {
        Arrays.stream(data).forEach(redBlackTree::insert);

        for (int i = 0; i < data.length; i++) {
            int random = new Random(100).nextInt();
            redBlackTree.insert(random);
        }
        System.out.println("Dataset: " + type + ", Operations: " + redBlackTree.getOperations());
    }

    private static void testInsertForTreap(Treap<Integer> treap, int[] data, String type) {
        Arrays.stream(data).forEach(treap::insert);

        for (int i = 0; i < data.length; i++) {
            int random = new Random(100).nextInt();
            treap.insert(random);
        }
        System.out.println("Dataset: " + type + ", Operations: " + treap.getOperations());
    }
}