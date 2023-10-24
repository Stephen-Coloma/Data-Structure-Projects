package Midterms.midlab2.tree;

public class TreeNode implements Comparable<TreeNode> {
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
     * Compare this TreeNode to another TreeNode based on their counts.
     *
     * @param other The other TreeNode to compare to.
     * @return      0 if counts are equal, -1 if this count is less than the other,
     *              and 1 if this count is greater than the other.
     */
    @Override
    public int compareTo(TreeNode other) {
        if (isSpecialChar(this.symbol)) { //if invoker is special symbol
            if (isSpecialChar(other.symbol)) { //both are same special char
                // Compare special characters based on their custom order
                String specialCharOrder = " .?'!,";
                return specialCharOrder.indexOf(this.symbol) - specialCharOrder.indexOf(other.symbol);
            } else {
                return 1;  // Special character is greater than non-special character
            }
        } else if (isSpecialChar(other.symbol)) { //if invoker is not
            return -1;  // Non-special character is less than special character
        } else {
            return Character.compare(this.symbol, other.symbol);  // Compare non-special characters lexicographically
        }
    }

    private boolean isSpecialChar(char symbol){
        return (symbol == ' ' || symbol == '.' || symbol == '?' || symbol == '\'' || symbol == '!' || symbol == ',');
    }

    @Override
    public String toString() {
        return symbol + " | " + count;
    }
}

