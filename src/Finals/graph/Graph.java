package Finals.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * The DirectedGraph class represents a directed graph, consisting of nodes and directed edges.
 * Nodes are connected by directed edges, forming relationships between them.
 */
public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;
    private int nodeCount;

    /**
     * Constructs a new DirectedGraph with an empty list of nodes and edges.
     * The node count is initially set to 0.
     */
    public Graph() {
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
        if (!nodes.contains(node)) {
            nodes.add(node);
            nodeCount++;
        }
    }

    /**
     * Adds a directed edge to the graph, connecting the specified start and end nodes.
     * Updates the neighbor list of the start node.
     *
     * @param start The starting node of the directed edge.
     * @param end   The ending node of the directed edge.
     */
    public void addEdgeToDirectedGraph(Node start, Node end, int weight) {
        Edge edge = new Edge(start, end,weight);
        start.getNeighbors().add(end); // Adding the end as the neighbor of the start node
        edges.add(edge);
    }

    public void addEdgeToUndirectedGraph(Node firstNode, Node secondNode, int weight) {
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
    public String toString(){
        String temp="";
        for (Edge edge:edges) {
            temp+=edge.getFirstNode() + " ---> " +edge.getSecondNode() + " " + edge.getWeight() + "\n";
        }
        return temp;
    }

    /**TESTING PURPOSES ONLY*/
    public static void main(String[] args) {
        Graph graph = new Graph();
//
//        Node node1 = new Node("La Union");
//        Node node2 = new Node("Baguio");
//        Node node3 = new Node("Pangasinan");
//
//        graph.addNode(node1);
//        graph.addNode(node2);
//        graph.addNode(node3);
//
//        System.out.println(graph.getNodes()); // [La Union, Baguio, Pangasinan]
//
//        graph.addEdgeToDirectedGraph(node1,node2,3); //La Union ---> Baguio
//        graph.addEdgeToUndirectedGraph(node2,node3,4); //Baguio ---> Pangasinan
//
//        System.out.println(graph.toString());
//        /*
//        La Union ---> Baguio
//        Baguio ---> Pangasinan
//        */
//
//        System.out.println(node2.getNeighbors()); //[Pangasinan]

        Node node1 = new Node("Stephen");
        Node node2 = new Node("Alliah");
        Node node3 = new Node("Sugo");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        System.out.println(graph.getNodes()); // [Stephen, Alliah, Sugo]

        graph.addEdgeToUndirectedGraph(node1,node2,2); //Stephen ---- Alliah
        graph.addEdgeToUndirectedGraph(node2,node3,3); //Alliah ---- Sugo

        System.out.println(graph.toString());
        /*
        Stephen ---- Alliah
        Alliah ---- Sugo
        */

        System.out.println(node2.getNeighbors()); //[Stephen, Sugo]
    }
}
