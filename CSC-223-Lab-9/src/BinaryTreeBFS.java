import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
    int value;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinaryTree {
    BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRecu(root, value);
    }

    private BinaryTreeNode insertRecu(BinaryTreeNode root, int value) {
        if (root == null) {
            return new BinaryTreeNode(value);
        }

        if (value < root.value) {
            root.left = insertRecu(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecu(root.right, value);
        }

        return root;
    }

    public void breadthFirstSearch(int searchValue) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean found = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            System.out.println("Visited node: " + current.value);

            if (current.value == searchValue) {
                System.out.println("Value found: " + searchValue);
                found = true;
                return;
            }

            if (current.left != null) {
                queue.offer(current.left);
                System.out.println("Edge: (" + current.value + ", " + current.left.value + ")");
            }
            if (current.right != null) {
                queue.offer(current.right);
                System.out.println("Edge: (" + current.value + ", " + current.right.value + ")");
            }
        }

        if (!found) {
            System.out.println("Value not found: " + searchValue);
        }
    }
}

public class BinaryTreeBFS {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // Example insertions
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        // Perform BFS search
        System.out.println("Searching for value 7:");
        tree.breadthFirstSearch(7); // Value found case
        System.out.println("\nSearching for value 100:");
        tree.breadthFirstSearch(100); // Value not found case
    }
}
