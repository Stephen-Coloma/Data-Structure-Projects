package Finals.finlab.util;

import Finals.finlab.graph.Graph;
import Finals.finlab.graph.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class GraphLoader {


    /**A static method that generates a Graph based on the input file where the file holds the data for the graph
     * The type of the input file to be created will depend on the header of the File.
     *
     * @param filepath the file path from src that holds the data
     * @return the undirected graph generated
     * @throws Exception TODO: NOT SURE PA AKO SA HANDLING NETO IF MERON*/
    public static Graph loadGraphFromFile(File filepath) throws Exception{
        Graph graph = new Graph();
        List<Node> nodeList = graph.getNodes();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String type = reader.readLine();
            String line;
            switch (type){
                case "DIRECTED":
                    while ((line = reader.readLine()) != null){
                        String[] array = line.split(","); //A,C,12
                        Node start = new Node(array[0]);
                        Node end = new Node(array[1]);
                        int weight = Integer.parseInt(array[2]);

                        graph.addNode(start);
                        graph.addNode(end);

                        for (Node node:nodeList) {
                            if (start.toString().equals(node.toString())){
//                                graph.addEdgeToDirectedGraph(node,end,weight); // edge for the directed graph
                            }
                        }
                    }
                    break;
                case "UNDIRECTED":
                    while ((line = reader.readLine()) != null){
                        String[] array = line.split(","); //A,B,2
                        Node start = new Node(array[0]);
                        Node end = new Node(array[1]);
                        int weight = Integer.parseInt(array[2]);

                        graph.addNode(start);
                        graph.addNode(end);

                        for (Node node:nodeList) {
                            if (start.toString().equals(node.toString())){
//                                graph.addEdgeToUndirectedGraph(node,end,weight);
                            }
                        }
                    }
            }
        }
        return graph;
    }

    /**TESTING PURPOSES ONLY*/

    public static void main(String[] args) throws Exception {
        //the directed graph is functioning well already
        Graph graph1 = GraphLoader.loadGraphFromFile(new File("src/Finals/util/data_directed.csv"));
        System.out.println(graph1);
        System.out.println(graph1.getNodes());

        System.out.println("\n============================\n");
        //the undirected graph is functioning well already
        Graph graph2 = GraphLoader.loadGraphFromFile(new File("src/Finals/util/data_undirected.csv"));
        System.out.println(graph2);
        System.out.println(graph2.getNodes());

        /**
         sample run:
         A ---> C 12
         A ---> D 60
         B ---> A 10
         C ---> B 20
         C ---> D 32
         E ---> A 7

         [A, C, D, B, E]

         ============================

         A ---- B 2
         A ---- C 5
         B ---- C 2
         B ---- D 4
         C ---- E 5
         C ---- D 5
         E ---- D 2

         [A, B, C, D, E]

         Process finished with exit code 0
         */
    }
}
