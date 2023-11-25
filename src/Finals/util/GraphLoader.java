package Finals.util;

import Finals.graph.DirectedGraph;
import Finals.graph.Node;
import Finals.graph.UndirectedGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class GraphLoader {

    /**A static method that generates an directed Graph based on the input file where the file holds the data for the graph
     *
     * @param filepath the file path from src that holds the data
     * @return the undirected graph generated
     * @throws Exception TODO: NOT SURE PA AKO SA HANDLING NETO IF MERON*/
    public static DirectedGraph loadDirectedGraph(File filepath) throws Exception{
        DirectedGraph directedGraph = new DirectedGraph();
        List<Node> nodeList = directedGraph.getNodes();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String type = reader.readLine();
            if (type != null && type.equals("DIRECTED")){
                String line;
                while ((line = reader.readLine()) != null){
                    String[] array = line.split(","); //A,C,12
                    Node start = new Node(array[0]);
                    Node end = new Node(array[1]);
                    int weight = Integer.parseInt(array[2]);

                    directedGraph.addNode(start);
                    directedGraph.addNode(end);

                    for (Node node:nodeList) {
                        if (start.toString().equals(node.toString())){
                            directedGraph.addEdge(node,end,weight);
                        }
                    }

                }
            }
        }
        return directedGraph;
    }

    /**A static method that generates an Undirected Graph based on the input file where the file holds the data for the graph
     *
     * @param filepath the file path from src that holds the data
     * @return the undirected graph generated
     * @throws Exception TODO: NOT SURE PA AKO SA HANDLING NETO IF MERON*/
    public static UndirectedGraph loadUndirectedGraph(File filepath) throws Exception{
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        List<Node> nodeList = undirectedGraph.getNodes();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String type = reader.readLine();
            if (type != null && type.equals("UNDIRECTED")){
                String line;
                while ((line = reader.readLine()) != null){
                    String[] array = line.split(","); //A,B,2
                    Node start = new Node(array[0]);
                    Node end = new Node(array[1]);
                    int weight = Integer.parseInt(array[2]);

                    undirectedGraph.addNode(start);
                    undirectedGraph.addNode(end);

                    for (Node node:nodeList) {
                        if (start.toString().equals(node.toString())){
                            undirectedGraph.addEdge(node,end,weight);
                        }
                    }

                }
            }
        }
        return undirectedGraph;
    }




    /**TESTING PURPOSES ONLY*/

    public static void main(String[] args) throws Exception {
        //the directed graph is functioning well already
        DirectedGraph graph1 = GraphLoader.loadDirectedGraph(new File("src/Finals/util/data_directed.csv"));
        System.out.println(graph1);
        System.out.println(graph1.getNodes());

        System.out.println("\n============================\n");
        //the directed graph is functioning well already
        UndirectedGraph graph2 = GraphLoader.loadUndirectedGraph(new File("src/Finals/util/data_undirected.csv"));
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

         Process finished with exit code 0*/
    }
}
