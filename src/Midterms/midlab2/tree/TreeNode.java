package Midterms.midlab2.tree;

import java.util.PriorityQueue;

public class TreeNode extends PriorityQueue<TreeNode> implements Comparable<TreeNode> {
    int count;
    char symbol;
    TreeNode left;
    TreeNode right;

    /**
     * Default constructor for TreeNode. Initializes count to 0, symbol to 'x',
     * and both left and right child references to null.
     */
    public TreeNode() {
        count = 0;
        symbol = 'x';
        left = null;
        right = null;
    }

    /**
     * Parameterized constructor for TreeNode.
     *
     * @param count  The count associated with the node.
     * @param symbol The symbol associated with the node.
     * @param left   The left child node.
     * @param right  The right child node.
     */
    public TreeNode(int count, char symbol, TreeNode left, TreeNode right) {
        this.count = count;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    /**
     * Get the count associated with this node.
     *
     * @return The count of the node.
     */
    public int getCount() {
        return count;
    }

    /**
     * Set the count associated with this node.
     *
     * @param count The new count value.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Get the symbol associated with this node.
     *
     * @return The symbol of the node.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Set the symbol associated with this node.
     *
     * @param symbol The new symbol value.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Get the left child node.
     *
     * @return The left child node.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Set the left child node.
     *
     * @param left The new left child node.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Get the right child node.
     *
     * @return The right child node.
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Set the right child node.
     *
     * @param right The new right child node.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Compares this TreeNode's count with another TreeNode's count for the purpose of sorting.
     * <p>
     * This method is used for ordering TreeNodes in a PriorityQueue. It compares the count of
     * this TreeNode with the count of another TreeNode.
     *
     * @param other The TreeNode to be compared with this TreeNode.
     * @return 0 if counts are equal, a negative value if this count is less than the other count,
     *         or a positive value if this count is greater than the other count.
     */
    @Override
    public int compareTo(TreeNode other) {
        if (this.getCount() == other.getCount()) {
            return 0;
        } else if (this.getCount() < other.getCount()) {
            return -1;
        } else {
            return 1;
        }
    }

    /**Checks if the character is a special character of not.
     * @param symbol to be checked
     * @return true if it is a special character, otherwise false*/
    private boolean isSpecialChar(char symbol){
        return (symbol == ' ' || symbol == '.' || symbol == '?' || symbol == '\'' || symbol == '!' || symbol == ',');
    }

    /**String representation of TreeNode with its count and symbol.*/
    @Override
    public String toString() {
        return symbol + " | " + count;
    }
}

