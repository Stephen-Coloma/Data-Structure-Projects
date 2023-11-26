package Finals.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Edge edge = new Edge(start, end, weight);
        start.getNeighbors().add(end); // Adding the end as the neighbor of the start node
        edges.add(edge);
    }

    public void addEdgeToUndirectedGraph(Node firstNode, Node secondNode, int weight) {
        Edge edge = new Edge(firstNode, secondNode, weight);
        firstNode.getNeighbors().add(secondNode); // Adding the secondNode as the neighbor of the firstNode
        secondNode.getNeighbors().add(firstNode); // Adding the firstNode as the neighbor of the secondNode
        edges.add(edge);
    }

    /**
     * Returns a string representation of the directed edges in the graph.
     *
     * @return A string representing the directed edges.
     */
    @Override
    public String toString() {
        String temp = "";
        for (Edge edge : edges) {
            temp += edge.getFirstNode() + " ---> " + edge.getSecondNode() + " " + edge.getWeight() + "\n";
        }
        return temp;
    }

    /**
     * TODO: BREADTH FIRST SEARCH
     * Lourdene Sanchie
     * 
     * SAMPLE RUN
     * Breadth First Search:
     * ==========================
     * Stephen Alliah Sugo Sanchie Lourd Chin Chie
     */
    public void breadthFirstSearch(Node node) {
        System.out.println();
        System.out.println("Breadth First Search: ");
        System.out.println("==========================");

        // Checks if the graph is empty
        if (nodes.isEmpty()) { 
            System.out.println("The graph is empty"); 
            return;
        }

        // Checks if the starting vertex is invalid
        if (node == null || !nodes.contains(node)) {
            System.out.println("Invalid starting vertex.");
            return;
        }

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[nodeCount];

        // Queue for traversal
        Queue<Node> queue = new LinkedList<>();

        // Enqueue the starting node and mark it as visited
        queue.add(node);
        visited[getNodes().indexOf(node)] = true;

        while (!queue.isEmpty()) {
            // Dequeue the current node
            Node current = queue.poll();

            // Print the data of the current node
            System.out.print(current.getData() + " ");

            // Get the neighbors of the current node
            List<Node> neighbors = current.getNeighbors();

            // For-loop that will traverse the neighbors list
            for (Node neighbor : neighbors) { 
                int index = getNodes().indexOf(neighbor);

                // Mark the neighbor as visited and enqueue the neighbor 
                if (!visited[index]) {
                    visited[index] = true; 
                    queue.add(neighbor);
                }
            }
        }
    }

    /**
     * TODO: DEPTH FIRST SEARCH
     * Marius Jerwin
     */
    public void depthFirstSearch(Node node) {
        //yung graph na ide depth first search nyo is yung "this"
    
    }

        /**TODO: DIJKSTRA'S SHORTEST PATH ALGORITHM
         * Stephen, Hannah, Rey*/
        public void shortestPath () {

        }


        /**TESTING PURPOSES ONLY*/
        public static void main (String[]args){
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
            Node node4 = new Node("Sanchie");
            Node node5 = new Node("Lourd");
            Node node6 = new Node("Chin");
            Node node7 = new Node("Chie");

            graph.addNode(node1);
            graph.addNode(node2);
            graph.addNode(node3);
            graph.addNode(node4);
            graph.addNode(node5);
            graph.addNode(node6);
            graph.addNode(node7);

            System.out.println(graph.getNodes()); // [Stephen, Alliah, Sugo]

            graph.addEdgeToUndirectedGraph(node1, node2, 2); //Stephen ---- Alliah
            graph.addEdgeToUndirectedGraph(node1, node3, 3); //Stephen ---- Sugo
            graph.addEdgeToUndirectedGraph(node2, node4, 1); //Alliah ---- Sanchie
            graph.addEdgeToUndirectedGraph(node2, node5, 3); //Alliah ---- Lourd
            graph.addEdgeToUndirectedGraph(node3, node6, 2); //Sugo ---- Chin
            graph.addEdgeToUndirectedGraph(node3, node7, 2); //Sugo ---- Chie

            System.out.println(graph.toString());
        /*
        Stephen ---- Alliah
        Alliah ---- Sugo
        */

            System.out.println(node2.getNeighbors()); //[Stephen, Sanchie, Lourd]
            graph.breadthFirstSearch(node1);
        }
    }

