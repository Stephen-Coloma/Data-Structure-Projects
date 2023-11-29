package Finals.finlab.graph;

/**
 * The Edge class represents a connection between two nodes in a graph.
 * It consists of two nodes, firstNode and secondNode, forming an edge between them.
 * Could be used for directed and undirected graph
 */
public class Edge {
    /**
     * The first node connected by the edge.
     */
    private Node firstNode;

    /**
     * The second node connected by the edge.
     */
    private Node secondNode;

    public int getWeight() {
        return weight;
    }

    /**
     * Constructs a new Edge connecting the specified nodes.
     *
     * @param firstNode The first node connected by the edge.
     * @param secondNode The second node connected by the edge.
     */
    public Edge(Node firstNode, Node secondNode, int weight) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.weight=weight;
    }

    /**
     * Gets the weight of the edge.
     *
     * @return The weight
     */
    private int weight;

    /**
     * Gets the first node connected by the edge.
     *
     * @return The first node of the edge.
     */
    public Node getFirstNode() {
        return firstNode;
    }

    /**
     * Sets the first node connected by the edge.
     *
     * @param firstNode The new first node of the edge.
     */
    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    /**
     * Gets the second node connected by the edge.
     *
     * @return The second node of the edge.
     */
    public Node getSecondNode() {
        return secondNode;
    }

    /**
     * Sets the second node connected by the edge.
     *
     * @param secondNode The new second node of the edge.
     */
    public void setSecondNode(Node secondNode) {
        this.secondNode = secondNode;
    }

    @Override
    public String toString() {
        return firstNode.toString() + " --- " + secondNode.toString();
    }
}

