package Finals.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Node class represents a node in a graph.
 * Each node contains data and a list of neighboring nodes.
 */
public class Node {
    /**
     * The data associated with the node.
     */
    private String data;

    /**
     * The list of neighboring nodes.
     */
    private List<Node> neighbors;

    /**
     * Constructs a new Node with the specified data.
     *
     * @param data The data to be associated with the node.
     */
    public Node(String data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    /**
     * Gets the data associated with the node.
     *
     * @return The data of the node.
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the data associated with the node.
     *
     * @param data The new data for the node.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Gets the list of neighboring nodes.
     *
     * @return The list of neighboring nodes.
     */
    public List<Node> getNeighbors() {
        return neighbors;
    }

    /**
     * Sets the list of neighboring nodes.
     *
     * @param neighbors The new list of neighboring nodes.
     */
    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    /**
     * Returns a string representation of the node.
     *
     * @return A string representing the data of the node.
     */
    @Override
    public String toString() {
        return this.data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node otherNode = (Node) obj;
        return Objects.equals(data, otherNode.data);
    }
}

