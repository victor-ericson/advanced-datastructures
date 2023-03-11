/*
Victor Ericson vier1798
Filip Lingefelt fili8261
Samuel Bakall saba9460
 */

public class SplayTree<AnyType extends Comparable<? super AnyType>> {


    public int getOperations() {
        return operations;
    }

    public int getRotations(){
        return rotations;
    }

    public void resetOperations(){
        operations = 0;
    }
    public void resetRotations(){
        rotations = 0;
    }

    private int operations;
    private int rotations;
    public SplayTree() {
        nullNode = new BinaryNode<AnyType>(null);
        nullNode.left = nullNode.right = nullNode;
        root = nullNode;
        operations = 0;
        rotations = 0;

    }

    private BinaryNode<AnyType> newNode = null;  // Used between different inserts

    public void insert(AnyType x) {
        operations++;
        if (newNode == null){
            operations++;
            newNode = new BinaryNode<>(null);
        }
        newNode.element = x;


        if (root == nullNode) {
            newNode.left = newNode.right = nullNode;
            root = newNode;
        } else {
            root = splay(x, root);
            operations++;
            int compareResult = x.compareTo(root.element);

            if (compareResult < 0) {
                newNode.left = root.left;
                newNode.right = root;
                root.left = nullNode;
                root = newNode;
            } else if (compareResult > 0) {
                newNode.right = root.right;
                newNode.left = root;
                root.right = nullNode;
                root = newNode;
            } else
                return;   // No duplicates
        }
        newNode = null;   // So next insert will call new
    }

    public void remove(AnyType x) {
        operations++;
        if (!contains(x))
            return;

        BinaryNode<AnyType> newTree;


        if (root.left == nullNode)
            newTree = root.right;
        else {

            newTree = root.left;
            newTree = splay(x, newTree);
            newTree.right = root.right;
        }
        root = newTree;
    }

    public AnyType findMin() {
        operations++;
        if (isEmpty())
            throw new UnderflowException();

        BinaryNode<AnyType> ptr = root;

        while (ptr.left != nullNode) {
            ptr = ptr.left;
            operations++;
        }
        root = splay(ptr.element, root);
        return ptr.element;
    }

    public AnyType findMax() {
        operations++;
        if (isEmpty())
            throw new UnderflowException();

        BinaryNode<AnyType> ptr = root;

        while (ptr.right != nullNode){
            ptr = ptr.right;
            operations++;
        }

        root = splay(ptr.element, root);
        return ptr.element;
    }

    public boolean contains(AnyType x) {
        operations++;
        if (isEmpty())
            return false;

        root = splay(x, root);

        return root.element.compareTo(x) == 0;
    }

    public void makeEmpty() {
        operations++;
        root = nullNode;
    }

    public boolean isEmpty() {
        operations++;
        return root == nullNode;
    }

    private BinaryNode<AnyType> header = new BinaryNode<AnyType>(null);

    private BinaryNode<AnyType> splay(AnyType x, BinaryNode<AnyType> t) {
        BinaryNode<AnyType> leftTreeMax, rightTreeMin;

        header.left = header.right = nullNode;
        leftTreeMax = rightTreeMin = header;

        nullNode.element = x;   // Guarantee a match

        for (; ; ) {
            operations++;
            int compareResult = x.compareTo(t.element);

            if (compareResult < 0) {
                if (x.compareTo(t.left.element) < 0) {
                    t = rotateWithLeftChild(t);
                    rotations++;
                    //sätter operations till +1 här för att rotate är en statisk metod
                    operations++;
                }
                if (t.left == nullNode)
                    break;
                // Link Right
                rightTreeMin.left = t;
                rightTreeMin = t;
                t = t.left;
            } else if (compareResult > 0) {
                if (x.compareTo(t.right.element) > 0){
                    t = rotateWithRightChild(t);
                    rotations++;
                    //sätter operations till +1 här för att rotate är en statisk metod
                    operations++;
                }
                if (t.right == nullNode)
                    break;
                leftTreeMax.right = t;
                leftTreeMax = t;
                t = t.right;
            } else
                break;
        }

        leftTreeMax.right = t.left;
        rightTreeMin.left = t.right;
        t.left = header.right;
        t.right = header.left;
        return t;
    }

    private static <AnyType> BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> k2) {
        BinaryNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private static <AnyType> BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> k1) {
        BinaryNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    private static class BinaryNode<AnyType> {
        // Constructors
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }

    private BinaryNode<AnyType> root;
    private BinaryNode<AnyType> nullNode;


    public static void main(String[] args) {
        SplayTree<Integer> t = new SplayTree<Integer>();
        final int NUMS = 40000;
        final int GAP = 307;

        System.out.println("Checking... (no bad output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);
        System.out.println("Inserts complete");

        for (int i = 1; i < NUMS; i += 2)
            t.remove(i);
        System.out.println("Removes complete");

        if (t.findMin() != 2 || t.findMax() != NUMS - 2)
            System.out.println("FindMin or FindMax error!");

        for (int i = 2; i < NUMS; i += 2)
            if (!t.contains(i))
                System.out.println("Error: find fails for " + i);

        for (int i = 1; i < NUMS; i += 2)
            if (t.contains(i))
                System.out.println("Error: Found deleted item " + i);
    }
}
