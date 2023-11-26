package Finals.graph;

import Finals.util.GraphLoader;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.util.*;

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

    /**TODO: BREADTH FIRST SEARCH
     * Lourdene Sanchie*/
    public void breadthFirstSearch(){
        //yung graph na ibre breadth first search nyo is yung "this"

    }

    /**TODO: DEPTH FIRST SEARCH
     * Marius Jerwin*/
    public void depthFirstSearch(){
        //yung graph na ide depth first search nyo is yung "this"

    }

    /**TODO: DIJKSTRA'S SHORTEST PATH ALGORITHM
     * Stephen, Hannah, Rey*/
    public HashMap<String, Integer> shortestPath(Node startingNode) throws Exception{
        //validation if the startingNOde is on the nodes
        if (!nodes.contains(startingNode)){
            throw new Exception("Starting Node Not Found!");
        }

        HashMap<String,Integer> pathWeightTable = new HashMap<>(); //stores the path  as well as the weights
        List<Node> visitedNodes = new LinkedList<>();
        List<Node> unvisitedNodes = new LinkedList<>();

        //putting all nodes in the table and on the unvisitedNode
        for (Node node: nodes) {
            pathWeightTable.put(node.getData(),Integer.MAX_VALUE);
            unvisitedNodes.add(node);
        }

        // Set the distance of the starting node to 0
        pathWeightTable.put(startingNode.getData(), 0);

        while (!unvisitedNodes.isEmpty()){
            Node current = getMinimumDistanceNode(unvisitedNodes, pathWeightTable);
            unvisitedNodes.remove(current);
            visitedNodes.add(current);

            for (Node neighborNode: current.getNeighbors()) {
                if (!visitedNodes.contains(neighborNode)) {
                    int tentativeDistance = pathWeightTable.get(current.getData()) + getEdgeWeight(current, neighborNode);
                    if (tentativeDistance < pathWeightTable.get(neighborNode.getData())) {
                        pathWeightTable.put(neighborNode.getData(), tentativeDistance);
                    }
                }
            }
        }
        return pathWeightTable;
    }

    private Integer getEdgeWeight(Node current, Node neighborNode) {
        for (Edge edge:edges) {
            if ((edge.getFirstNode().equals(current) && edge.getSecondNode().equals(neighborNode) ) || (edge.getFirstNode().equals(neighborNode) && edge.getSecondNode().equals(current) )){
                return edge.getWeight();
            }
        }
        throw new NoSuchElementException("An edge does not exist");
    }

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



    /**TESTING PURPOSES ONLY*/
    public static void main(String[] args) {
        /*SAMPLE RUN:
        SHORTEST PATH FOR DIRECTED STARTING FROM NODE E:
        {A=7, B=39, C=19, D=51, E=0}

        --------------------------

        SHORTEST PATH FOR UNDIRECTED STARTING FROM NODE E:
        {A=8, B=6, C=5, D=2, E=0}
        */

        Graph graphDirected;
        Graph graphUndirected;
        try {
            graphDirected = GraphLoader.loadGraphFromFile(new File("src/Finals/util/data_directed.csv"));
            System.out.println("SHORTEST PATH FOR DIRECTED STARTING FROM NODE E: ");
            System.out.println(graphDirected.shortestPath(new Node("E"))); //specified starting vertex

            System.out.println("\n--------------------------\n");


            graphUndirected = GraphLoader.loadGraphFromFile(new File("src/Finals/util/data_undirected.csv"));
            System.out.println("SHORTEST PATH FOR UNDIRECTED STARTING FROM NODE E: ");
            System.out.println(graphUndirected.shortestPath(new Node("E"))); //specified starting vertex

        } catch (NullPointerException npe) {
            System.out.println("Not all vertex is connected to chosen node");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
