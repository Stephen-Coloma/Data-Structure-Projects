package Finals.finlab.graph;

import Finals.finlab.util.GraphLoader;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
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
     * Breadth First Search (DFS) traversal starting from a specified node.
     *
     * @param startNode The starting node for DFS.
     */
    public void breadthFirstSearch(Node startNode) throws Exception{
        // Checks if the graph is empty
        if (nodes.isEmpty()) {
            throw new Exception("The graph is empty");
        }

        // Checks if the starting vertex is invalid
        if (startNode == null || !nodes.contains(startNode)) {
            throw new Exception("Invalid Starting Vertex for BreadFirstSearch Traversal.");
        }

        //change the passed node so that it becomes the node that is in the nodes list
        for (Node node:nodes) {
            if (node.getData().equals(startNode.getData())){
                startNode = node;
            }
        }

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[nodeCount];

        // Queue for traversal
        Queue<Node> queue = new LinkedList<>();

        // Enqueue the starting node and mark it as visited
        queue.add(startNode);
        visited[getNodes().indexOf(startNode)] = true;

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
     * Depth First Search (DFS) traversal starting from a specified node.
     *
     * @param startNode The starting node for DFS.
     */
    public void depthFirstSearch(Node startNode) throws Exception{
        // Checks if the graph is empty
        if (nodes.isEmpty()) {
            throw new Exception("The graph is empty");
        }

        // Checks if the starting vertex is invalid
        if (startNode == null || !nodes.contains(startNode)) {
            throw new Exception("Invalid Starting Vertex for BreadFirstSearch Traversal.");
        }

        //change the passed node so that it becomes the node that is in the nodes list
        for (Node node:nodes) {
            if (node.getData().equals(startNode.getData())){
                startNode = node;
            }
        }

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[nodeCount];
        // Call the recursive helper function to perform DFS traversal
        DFSUtil(startNode, visited);
    }

    /**
     * A helper function for DFS traversal starting from a specific node.
     *
     * @param currentNode The current node being visited.
     * @param visited     An array to track visited nodes.
     */
    private void DFSUtil(Node currentNode, boolean[] visited) {
        if(currentNode == null){
            return;
        }
        // Mark the current node as visited and print it
        System.out.print(currentNode.getData() + " ");
        visited[nodes.indexOf(currentNode)] = true;
        // Recur for all the neighbors of the current node
        Iterator<Node> neighborIterator = currentNode.getNeighbors().iterator();
        while (neighborIterator.hasNext()) {
            Node neighbor = neighborIterator.next();
            if (!visited[nodes.indexOf(neighbor)]) {
                DFSUtil(neighbor, visited);
            }
        }
    }


    /**
     * Method that performs the shortest path algorithm (dijkstra's algorithm)
     *
     * @param startNode the node to which the traversal starts from to all other nodes
     */
    public void shortestPath(Node startNode) throws Exception {
        // Validate if the startNode is on the nodes
        if (!nodes.contains(startNode)) {
            throw new RuntimeException("Invalid Starting Vertex for Shortest Path.");
        }

        HashMap<String, Integer> pathWeightTable = new HashMap<>(); // stores the path as well as the weights
        HashMap<LinkedList<String>, Integer> tracker = new HashMap<>();
        List<Node> visitedNodes = new LinkedList<>();
        List<Node> unvisitedNodes = new LinkedList<>();

        // Putting all nodes in the table and on the unvisitedNode
        LinkedList<String> initialLinkedList = new LinkedList<>();
        initialLinkedList.add(startNode.getData());
        tracker.put(initialLinkedList, 0);

        for (Node node : nodes) {
            pathWeightTable.put(node.getData(), Integer.MAX_VALUE);
            unvisitedNodes.add(node);
        }

        // Set the distance of the starting node to 0
        pathWeightTable.put(startNode.getData(), 0);

        while (!unvisitedNodes.isEmpty()) {
            Node current = getMinimumDistanceNode(unvisitedNodes, pathWeightTable);
            unvisitedNodes.remove(current);
            visitedNodes.add(current);

            for (Node neighborNode : current.getNeighbors()) {
                if (!visitedNodes.contains(neighborNode)) {
                    int tentativeDistance = pathWeightTable.get(current.getData()) + getEdgeWeight(current, neighborNode);
                    if (tentativeDistance < pathWeightTable.get(neighborNode.getData())) {
                        // Update pathWeightTable
                        pathWeightTable.put(neighborNode.getData(), tentativeDistance);

                        LinkedList<String> adding = null;
                        for (LinkedList<String> previous : tracker.keySet()) {
                            if (previous.getLast().equals(current.getData())) {
                                // If the last node in the previous path is the current node, use it
                                adding = new LinkedList<>(previous);
                                break;
                            }
                        }

                        // Update tracker only if the new path is shorter
                        LinkedList<String> path = new LinkedList<>(adding);
                        path.add(neighborNode.getData());
                        tracker.put(path, tentativeDistance);

                    }
                }
            }
        }

        // Print the shortest paths and their weights
        int num = 0;
        for (LinkedList<String> path : tracker.keySet()) {
            String pathString="";
            for (int i = 0; i < path.size(); i++) {
                // Print the current element
                pathString+=path.get(i);

                // Add a dash if it's not the last element
                if (i < path.size() - 1) {
                    pathString+=(" -> ");
                }
            }

            if (num != 3){
                int weight = tracker.get(path);
                System.out.println("From " + startNode.getData() + " to " + path.getLast() +
                        ": \n" + pathString + ", Weight: " + weight);
            }
            num++;
        }
    }

    /**A helper method for the shortest path method that gets the weight of an edge
     * @param current the first node
     * @param neighborNode the second/neighboring node
     * @return - edge weight*/
    private Integer getEdgeWeight(Node current, Node neighborNode) {
        for (Edge edge : edges) {
            if ((edge.getFirstNode().equals(current) && edge.getSecondNode().equals(neighborNode)) || (edge.getFirstNode().equals(neighborNode) && edge.getSecondNode().equals(current))) {
                return edge.getWeight();
            }
        }
        throw new NoSuchElementException("An edge does not exist");
    }

    /**A helper method for the shortest path method that gets the minimum edge distnace to be used to determine the next node to
     * be visited in the algorithm.
     * @param unvisitedNodes list of unvisited nodes
     * @param pathWeightTable the table used to store the distances*/
    private Node getMinimumDistanceNode(List<Node> unvisitedNodes, HashMap<String, Integer> pathWeightTable) {
        Node minDistanceNode = null;
        int minDistance = Integer.MAX_VALUE;

        for (Node node : unvisitedNodes) {
            int nodeDistance = pathWeightTable.get(node.getData());
            if (nodeDistance < minDistance) {
                minDistanceNode = node;
                minDistance = nodeDistance;
            }
        }

        return minDistanceNode;
    }


    /**
     * TESTING PURPOSES ONLY
     */
    public static void main(String[] args) {
        Graph graph = null;
        try {
            graph = GraphLoader.loadGraphFromFile(new File("src/Finals/util/data_directed.csv"));
            graph.shortestPath(new Node("E"));
            graph.breadthFirstSearch(new Node("A"));
            graph.depthFirstSearch(new Node("A"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


