import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: David Lutch
 * @version: December 6th, 2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Calls the helper function with the parameters of the root node and value
        return searchHelperFunction(root,val);
    }
    // This helper function takes in a node and the value that we are looking for and returns if it's in there or not
    private boolean searchHelperFunction(BSTNode node, int val) {
        // If the node doesn't exist, then return false
        if (node == null) {
            return false;
        }
        // If the current node's value is equal to the value, then return true
        if (node.getVal() == val) {
            return true;
        }
        // If the value is greater than the current nodes value, call the helper function with the  node to the right
        // and the value
        if (node.getVal() < val) {
            return searchHelperFunction(node.getRight(),val);
        }
        // Else this will call the helper function with the node to the left and the value
        return searchHelperFunction(node.getLeft(),val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Creates a new arraylist of node values
        ArrayList<BSTNode> inOrderList = new ArrayList<BSTNode>();
        // Calls the helper function with the parameters of the root node and the inOrder arraylist
        getInorderHelperFunction(root, inOrderList);
        return inOrderList;
    }
    // This helper function takes in a node and the arraylist called inOrderList and returns an arrayList
    private ArrayList<BSTNode> getInorderHelperFunction(BSTNode node, ArrayList<BSTNode> inOrderList) {
        // If the node doesn't exist, then return null
        if (node == null) {
            return null;
        }
        // If the node to the left is valid, then call the helper function again with that node and the orderList
        if (node.getLeft() != null) {
            getInorderHelperFunction(node.getLeft(), inOrderList);
        }
        // Adds the node to the inOrderList
        inOrderList.add(node);
        // If the node to the right is valid, call the helper function again with that node and the orderList
        if (node.getRight() != null) {
            getInorderHelperFunction(node.getRight(), inOrderList);
        }
        return inOrderList;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Creates a new arraylist of node values
        ArrayList<BSTNode> preorderList = new ArrayList<BSTNode>();
        // Calls the helper function with the parameters of the root node and the preorder arraylist
        getPreorderHelperFunction(root, preorderList);
        return preorderList;
    }
    // This helper function takes in a node and the arraylist called preorderList and returns an arrayList
   private ArrayList<BSTNode> getPreorderHelperFunction(BSTNode node, ArrayList<BSTNode> preorderList) {
       // If the node doesn't exist, then return null
       if (node == null) {
           return null;
       }
       // Adds the node to the preorderList
       preorderList.add(node);
       // If the node to the left is valid, then call the helper function with that node and the preorderList
       if (node.getLeft() != null) {
           getPreorderHelperFunction(node.getLeft(), preorderList);
       }
       // if the node to the right is valid, then call the helper function with that node and the preorderList
       if (node.getRight() != null) {
           getPreorderHelperFunction(node.getRight(), preorderList);
       }
       return preorderList;
   }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Creates a new arraylist of node values
        ArrayList<BSTNode> postorderList = new ArrayList<BSTNode>();
        // Calls the helper function with the parameters of the root node and the postorder arraylist
        getPostOrderHelperFunction(root, postorderList);
        return postorderList;
    }
    // This helper function takes in a node and the arraylist called postorderList and returns an arrayList
    private ArrayList<BSTNode> getPostOrderHelperFunction(BSTNode node, ArrayList<BSTNode> postorderList) {
        // If the node doesn't exist, return null
        if (node == null) {
            return null;
        }
        // If the node to the left is valid, then call the helper function with that node and the postorderList
        if (node.getLeft() != null) {
            getPostOrderHelperFunction(node.getLeft(), postorderList);
        }
        // If the node to the right is valid, then call the helper function with that node and the postorderList
        if (node.getRight() != null) {
            getPostOrderHelperFunction(node.getRight(), postorderList);
        }
        // Add the node to the postorderList
        postorderList.add(node);
        return postorderList;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Calls the helper function with the value and the root node
        insertHelperFunction(val, root);
    }
    // This helper function takes in a value and a node
    private void insertHelperFunction(int val, BSTNode node) {
        // If the node doesn't exist, then return null
        if (node == null) {
            return;
        }
        // If the value inputted is greater than the node's value, then call this helper function with the value
        // We are looking for and the node to the right
        if (node.getVal() < val) {
            insertHelperFunction(val, node.getRight());
            // If the node to the right doesn't exist, then we will set that location to the value inputted
            if (node.getRight() == null) {
                node.setRight(new BSTNode(val));
            }
        }
        // If the value inputted is less than the node's value, then call this helper function with the value
        // We are looking for and the node to the left
        if (node.getVal() > val) {
            insertHelperFunction(val, node.getLeft());
            // If the node to the left doesn't exist, then we will set that location to the value inputted
            if (node.getLeft() == null) {
                node.setLeft(new BSTNode(val));
            }
        }
    }
    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        // Calls the helper function with the root of the tree
        return isValidBSTHelperFunction(root);
    }
    // This helper function takes in a node and returns a boolean
    private boolean isValidBSTHelperFunction(BSTNode node) {
        // If the node doesn't exist, then return null
        if (node == null) {
            return false;
        }
        // If the value of the node to the left is less than the value of the node, then call this helper function
        // Again with the node to the left.
        if (node.getLeft().getVal() < node.getVal()) {
            return isValidBSTHelperFunction(node.getLeft());
        }
        // If the value of the node to the right is greater than the value of the node, then call this helper function
        // Again with the node to the right
        if (node.getRight().getVal() > node.getVal()) {
            return isValidBSTHelperFunction(node.getRight());
        }
        // If the tree isn't invalid, then it must be a valid tree
        return true;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}