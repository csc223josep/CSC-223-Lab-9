
import java.util.*;

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

    public void depthFirstSearch(BinaryTreeNode searchValue) {
        Stack <BinaryTreeNode> stack= new Stack<BinaryTreeNode>();
        BinaryTreeNode  current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
    
            BinaryTreeNode top = stack.pop();
            if (searchValue.value == top.value){
                System.out.println("Found!");
                return;
            }
            current= top.right;
            
        }
    }
}

public class BinaryTreeDFS {
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
        tree.depthFirstSearch(7); // Value found case
        System.out.println("\nSearching for value 100:");
        tree.depthFirstSearch(100); // Value not found case
    }
}


