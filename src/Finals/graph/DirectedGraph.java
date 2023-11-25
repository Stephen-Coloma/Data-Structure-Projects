package Finals.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * The DirectedGraph class represents a directed graph, consisting of nodes and directed edges.
 * Nodes are connected by directed edges, forming relationships between them.
 */
public class DirectedGraph {
    private List<Node> nodes;
    private List<Edge> edges;
    private int nodeCount;

    /**
     * Constructs a new DirectedGraph with an empty list of nodes and edges.
     * The node count is initially set to 0.
     */
    public DirectedGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        nodeCount = 0;
    }

    /**
     * Gets the list of nodes in the graph.
     *
     * @return The list of nodes.
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Gets the list of directed edges in the graph.
     *
     * @return The list of directed edges.
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Adds a node to the graph.
     *
     * @param node The node to be added.
     */
    public void addNode(Node node) {
        nodes.add(node);
        nodeCount++;
    }

    /**
     * Adds a directed edge to the graph, connecting the specified start and end nodes.
     * Updates the neighbor list of the start node.
     *
     * @param start The starting node of the directed edge.
     * @param end   The ending node of the directed edge.
     */
    public void addEdge(Node start, Node end) {
        Edge edge = new Edge(start, end);
        start.getNeighbors().add(end); // Adding the end as the neighbor of the start node
        edges.add(edge);
    }

    /**
     * Returns a string representation of the directed edges in the graph.
     * @return A string representing the directed edges.
     */
    @Override
    public String toString(){
        String temp="";
        for (Edge edge:edges) {
            temp+=edge.getFirstNode() + " ---> " +edge.getSecondNode() + "\n";
        }
        return temp;
    }

    /**TESTING PURPOSES ONLY*/
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        Node node1 = new Node("La Union");
        Node node2 = new Node("Baguio");
        Node node3 = new Node("Pangasinan");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        System.out.println(graph.getNodes()); // [La Union, Baguio, Pangasinan]

        graph.addEdge(node1,node2); //La Union ---> Baguio
        graph.addEdge(node2,node3); //Baguio ---> Pangasinan

        System.out.println(graph.toString());
        /*
        La Union ---> Baguio
        Baguio ---> Pangasinan
        */

        System.out.println(node2.getNeighbors()); //[Pangasinan]
    }
}
