import java.util.LinkedList;
import java.util.Queue;

// Class representing a node in a binary tree
/**
 * @author Joseph Kabesha
 * @author Isaiah Ayres
 * 
 */
class BinaryTreeNode {
    int value; // Value stored in the node
    BinaryTreeNode left, right; // References to left and right child nodes

    // Constructor to initialize a node with a given value
    public BinaryTreeNode(int value) {
        this.value = value;
        left = null; // Initialize left child as null
        right = null; // Initialize right child as null
    }
}

// Class representing a binary tree
class BinaryTree {
    BinaryTreeNode root; // Reference to the root node of the tree

    // Constructor to initialize an empty binary tree
    public BinaryTree() {
        root = null; // Initialize root as null (empty tree)
    }

    // Method to insert a value into the binary tree
    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    // Recursive method to insert a value into the binary tree
    private BinaryTreeNode insertRecursively(BinaryTreeNode root, int value) {
        // If the root is null, create a new node with the given value
        if (root == null) {
            return new BinaryTreeNode(value);
        }

        // If the value is less than the root's value, insert into the left subtree
        if (value < root.value) {
            root.left = insertRecursively(root.left, value);
        }
        // If the value is greater than the root's value, insert into the right subtree
        else if (value > root.value) {
            root.right = insertRecursively(root.right, value);
        }

        return root; // Return the modified root
    }

    // Method to perform breadth-first search on the binary tree
    public void breadthFirstSearch(int searchValue) {
        // If the tree is empty, print a message and return
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        // Create a queue for BFS traversal and add the root node to it
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean found = false; // Flag to indicate if the value is found during traversal
        // Perform BFS traversal
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll(); // Dequeue a node from the queue
            System.out.println("Visited node: " + current.value); // Print the value of the visited node

            // If the current node's value matches the search value, print a message and set found flag to true
            if (current.value == searchValue) {
                System.out.println("Value found: " + searchValue);
                found = true;
                return;
            }

            // Enqueue the left child if it exists and print the edge between the current node and its left child
            if (current.left != null) {
                queue.offer(current.left);
                System.out.println("Edge: (" + current.value + ", " + current.left.value + ")");
            }
            // Enqueue the right child if it exists and print the edge between the current node and its right child
            if (current.right != null) {
                queue.offer(current.right);
                System.out.println("Edge: (" + current.value + ", " + current.right.value + ")");
            }
        }

        // If the value is not found after traversal, print a message
        if (!found) {
            System.out.println("Value not found: " + searchValue);
        }
    }
}

// Class containing the main method to test the binary tree and BFS traversal
public class BinaryTreeBFS {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // Create a new binary tree instance

        // Insert some example values into the tree
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        // Perform BFS search for a value in the tree
        System.out.println("Searching for value 7:");
        tree.breadthFirstSearch(7); // Value found case
        System.out.println("\nSearching for value 100:");
        tree.breadthFirstSearch(100); // Value not found case
    }
}
