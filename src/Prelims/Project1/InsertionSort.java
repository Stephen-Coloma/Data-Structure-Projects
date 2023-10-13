package Prelims.Project1; /**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

import Prelims.Project1.util.CSVReader;       // Importing CSVReader utility for reading data from CSV files
import Prelims.Project1.util.FilePathReader;  // Importing FilePathReader utility for managing file paths
import java.util.ArrayList;  // Importing ArrayList class for creating dynamic lists

/**
 * The Prelims.Project1.InsertionSort class provides an implementation of the Insertion Sort algorithm for sorting arrays
 * of strings read from various CSV files. It includes functionality to sort data according to different
 * size variants and arrangement types (Best, Worst, Average). The class also includes methods to create
 * file paths, sort the data, and display the statement counts for different data sets.
 */
public class InsertionSort {
    /**
     * Main method initiates sorting and statement counting for various input sizes and arrangement variants.
     * @param args Command-line arguments
     */

    public static void main(String[] args) {
        /*
        ALGORITHM:
        1. Initiate the 2D array of length 5 by 3.
        2. The row will be the size variant (10k,50k,200k,500k,1M)
        3. The column will be the type arrangement variant (Best, Worst, Average)
        4. Create a list of strings that stores the file path above. Follow format BEST-WORST-AVERAGE
        5. Initiate variable int fileNumber = 0, it is the position of Best10k in the list
        6. Create a double for loop that populates the 2D array.
        7. Call the displayCount method and pass in the 2D array.
    */
        int sizeVariants = 5;
        int arrangementVariants = 3;

        // 2D array to store the results of statement counts
        long[][] results = new long[sizeVariants][arrangementVariants];


        ArrayList<String> filePathInList= FilePathReader.createFilePathInList();

        // Variable to track the current file number being processed
        int fileNumber = 0;

        for (int i = 0; i < sizeVariants; i++) {
            for (int j = 0; j < arrangementVariants; j++) {
                results[i][j] = insertionSort(filePathInList.get(fileNumber));
                fileNumber++;
                System.out.println("File: " + fileNumber);
            }
        }

        displayCounts(results);
    }


    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * @param filename name of file to be read.
     * @return int count of statements executed in the method.
     */
    /*
        ALGORITHM:
        1. Implement the Insertion Sort algorithm
        2. Initialize statementCount to 0;
        3. For every statement in the algorithm, increment the statementCount
        4. return statementCount variable
    */
    public static long insertionSort(String filename) {
        // Read the data from the CSV file into an array
        String[] arr = CSVReader.readDataFromFile(filename);

        // Initialize statement count to track the number of executed statements
        long statementCount=0;

        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            statementCount++;
            int j = i - 1;
            statementCount+=2;

            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                arr[j + 1] = arr[j]; // Shift the element
                statementCount+=2;
                j--; // Move to the previous element
                statementCount++;
                statementCount+=3; //iterative counter for while loop
            }
            statementCount+=3; //counter for falsy while
            // Place the key in its correct sorted position
            arr[j + 1] = key;
            statementCount+=2;

            statementCount+=2; //iterative counter for loop
        }
        statementCount+=2; //counter for falsy for
        return ++statementCount;
    }

    /**
     * Displays execution times for insertion sort in different cases and input sizes.
     * @param results a 2D array of execution times for insertion sort. The rows represent
     *                input sizes, while columns represent best, worst, and average cases.
     */
    public static void displayCounts(long[][] results) {
        /*
        ALGORITHM:
        1. Define labels for different data set sizes.
        2. Display a header with appropriate formatting.
        3. Loop through the results array to display execution times for each Prelims.Project1.dataset size.
            - For each Prelims.Project1.dataset size, display the execution times for best, worst, and average cases.
        */

        // Define the labels for different data set sizes
        String[] sizes = {"10 thousand", "50 thousand", "200 thousand", "500 thousand", "1 million"};

        // Display header
        System.out.printf("%-40S%-30S%-30S%-30S","INSERTION SORT RESULTS","BEST CASE","WORST CASE","AVERAGE CASE");
        System.out.println();

        // Loop through the results array to display execution times for each data set size
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j<1; j++) {
                System.out.printf("%-40s%,-30d%,-30d%,-30d",sizes[i],results[i][j],results[i][j+1],results[i][j+2]);
                System.out.println();
            }
        }
    }
}