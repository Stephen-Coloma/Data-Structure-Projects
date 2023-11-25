package Finals.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * The UndirectedGraph class represents an undirected graph, consisting of nodes and undirected edges.
 * Nodes are connected by undirected edges, forming bidirectional relationships between them.
 */
public class UndirectedGraph {
    private List<Node> nodes;
    private List<Edge> edges;
    private int nodeCount;

    /**
     * Constructs a new UndirectedGraph with an empty list of nodes and edges.
     * The node count is initially set to 0.
     */
    public UndirectedGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        nodeCount = 0;
    }

    /**
     * Gets the list of nodes in the undirected graph.
     *
     * @return The list of nodes.
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Gets the list of undirected edges in the graph.
     *
     * @return The list of undirected edges.
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Adds a node to the undirected graph.
     *
     * @param node The node to be added.
     */
    public void addNode(Node node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
            nodeCount++;
        }
    }

    /**
     * Adds an undirected edge to the graph, connecting the specified nodes bidirectionally.
     * Updates the neighbor lists of both nodes.
     *
     * @param firstNode  The first node of the undirected edge.
     * @param secondNode The second node of the undirected edge.
     */
    public void addEdge(Node firstNode, Node secondNode, int weight) {
        Edge edge = new Edge(firstNode, secondNode,weight);
        firstNode.getNeighbors().add(secondNode); // Adding the secondNode as the neighbor of the firstNode
        secondNode.getNeighbors().add(firstNode); // Adding the firstNode as the neighbor of the secondNode
        edges.add(edge);
    }

    /**
     * Returns a string representation of the directed edges in the graph.
     * @return A string representing the directed edges.
     */
    @Override
    public String toString() {
        String temp = "";
        for (Edge edge : edges) {
            temp += edge.getFirstNode() + " ---- " + edge.getSecondNode() + " " + edge.getWeight() + "\n";
        }
        return temp;
    }

    /**TESTING PURPOSES ONLY*/
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        Node node1 = new Node("Stephen");
        Node node2 = new Node("Alliah");
        Node node3 = new Node("Sugo");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        System.out.println(graph.getNodes()); // [Stephen, Alliah, Sugo]

        graph.addEdge(node1,node2,2); //Stephen ---- Alliah
        graph.addEdge(node2,node3,3); //Alliah ---- Sugo

        System.out.println(graph.toString());
        /*
        Stephen ---- Alliah
        Alliah ---- Sugo
        */

        System.out.println(node2.getNeighbors()); //[Stephen, Sugo]
    }
}
