/**
 *  Group B
 *  Class Code and Course Number: 9342 - CS 211
 *  Schedule: TF 9:00 - 10:30 AM
 *  <p>
 *      COLOMA, Stephen M.- 2232847@slu.edu.ph
 *      GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *      NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *      RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *      RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *      ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *      SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

package Finals;

import Finals.graph.Graph;
import Finals.graph.Node;
import Finals.util.GraphLoader;

import java.io.File;
import java.util.Scanner;

/**
 * MyProgram class is the main entry point for the graph processing application.
 * It offers a command-line interface for various graph-related operations,
 * including loading graph data, performing graph traversals, and finding shortest paths.
 */
public class MyProgram {
    private Graph graph;
    private Scanner scanner;

    /**
     * Constructor to initialize the scanner for user input.
     */
    public MyProgram() {
        scanner = new Scanner(System.in);
    }

    /**
     * The main method to start the program. It creates an instance of MyProgram and calls the run method.
     */
    public static void main(String[] args) {
        MyProgram myProgram = new MyProgram();
        myProgram.run();
    }

    /**
     * Contains the main loop of the program, displaying the menu and handling user input.
     */
    private void run() {
        displayWelcomeMessage();
        boolean exit = false;
        while (!exit) {
            displayMenu();

            System.out.print("Choose an option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    loadGraph();
                    break;
                case 2:
                    showDepthFirstTraversal();
                    break;
                case 3:
                    showBreadthFirstTraversal();
                    break;
                case 4:
                    showShortestPath();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the welcome message at the beginning of the program.
     */
    private void displayWelcomeMessage() {
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to the Graph Processing Application!");
        System.out.println("This program allows you to load, traverse, and analyze graphs.");
        System.out.println("You can perform depth-first and breadth-first traversals,");
        System.out.println("as well as find the shortest path between vertices.");
        System.out.println("------------------------------------------------------");
    }

    /**
     * Displays the menu options for the user.
     */
    private void displayMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Load file containing the graph's data");
        System.out.println("2. Perform Depth First Traversal of the graph");
        System.out.println("3. Perform Breadth First Traversal of the graph");
        System.out.println("4. Show the shortest path from one vertex to another");
        System.out.println("5. Exit");
        System.out.println("------------------------------------------------------");
    }

    /**
     * Handles loading a graph from a user-specified file path.
     */
    private void loadGraph() {
        System.out.print("Enter the file path: ");
        String path = "src/Finals/util/"+scanner.nextLine();
        try {
            graph = GraphLoader.loadGraphFromFile(new File(path));
            System.out.println("Graph loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading graph: " + e.getMessage());
        }
    }

    /**
     * Initiates a depth-first traversal on the loaded graph.
     */
    private void showDepthFirstTraversal() {
        if (graph != null) {
            System.out.println("Depth First Traversal:");
            do {
                System.out.print("Enter starting Vertex: ");
                String startingVertex = scanner.nextLine();
                try {
                    graph.depthFirstSearch(new Node(startingVertex)); //user input of starting vertex
                    break; //if goods ang input
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }while (true);
            System.out.println();
        } else {
            System.out.println("Graph not loaded. Please load a graph first.");
        }
    }


    /**
     * Initiates a breadth-first traversal on the loaded graph.
     */
    private void showBreadthFirstTraversal() {
        if (graph != null) {
            System.out.println("Breadth First Traversal:");
            do {
                System.out.print("Enter starting Vertex: ");
                String startingVertex = scanner.nextLine();
                try {
                    graph.breadthFirstSearch(new Node(startingVertex)); //user input of starting vertex
                    break; //if goods ang input
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }while (true);
            System.out.println();
        } else {
            System.out.println("Graph not loaded. Please load a graph first.");
        }
    }


    /**
     * Demonstrates the functionality to find the shortest path between two vertices.
     */
    private void showShortestPath() {
        if (graph != null) {
            System.out.println("Shortest Path:");
            do {
                System.out.print("Enter starting Vertex: ");
                String startingVertex = scanner.nextLine();
                try {
                    graph.shortestPath(new Node(startingVertex)); //user input of starting vertex
                    break; //if goods ang input
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }while (true);
            System.out.println();
        } else {
            System.out.println("Graph not loaded. Please load a graph first.");
        }
    }
}

