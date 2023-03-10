import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SplayTree<Integer> splayTree = new SplayTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        Treap<Integer> treap = new Treap<>();

        int[] sortedData = generateSortedData();
        int[] unsortedData = generateUnsortedData();
        int[] reverseSortedData = generateReverseSortedData();

        System.out.println("Splay Tree Insertions");
        testContains(splayTree, sortedData, "sorted");
        testContains(splayTree, unsortedData, "unsorted");
        testContains(splayTree, reverseSortedData, "reverse sorted");
    }

    private static int[] generateSortedData() {
        int[] data = new int[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        return data;
    }

    private static int[] generateUnsortedData() {
        Random random = new Random();
        int[] data = new int[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1000);
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

    private static void testContains(SplayTree<Integer> splayTree, int[] data, String type) {
        Arrays.stream(data).forEach(splayTree::insert);

        for (int i = 0; i < data.length; i++) {
            splayTree.contains(i);
        }

        System.out.println("Dataset: " + type + ", Operations: " + splayTree.getOperations());
    }
}
