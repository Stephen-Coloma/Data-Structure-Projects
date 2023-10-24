package Midterms.midlab2;

import Midterms.midlab2.tree.TreeNode;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
    private static PriorityQueue<TreeNode> frequencyTable;
    private PriorityQueue<TreeNode> huffmanTree;
    public Huffman(File file){
        frequencyTable = null;
        huffmanTree = null;
    }

    private PriorityQueue<TreeNode> createHuffmanTree(File file) throws Exception{
        /*ALGO
        * 1. Read the file and store it in a string text.
        * 2. Create a string template that holds the valid characters
        * 3. Create an empty hashmap<Character, Integer> that stores a key value pair
        * 4. for each token of the text, check if it is included in the valid characters.
        * 5. If yes, then check if the hashmap has a key of that token,
            * 5.1. If it is present, then increment the value
            * 5.2 If not, then add the new token to the hashmap.
        * 6. If no, then throw an exception called invalid argument exception
        * 7. Convert the hashmap to PriorityQueue<TreeNode>, this is the forest.
        * 8. Create a single tree from the forest.
        * 8. Return the PriorityQueue<TreeNode> huffmanTree>*/

        //step 1
        String text="";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                 text+=currentLine;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PriorityQueue<TreeNode> huffmanForest = createHuffmanForest(text);

        //THIS IS INCOMPLETE
        /*TODO: Create a method that converts huffmanForest to single Tree */
        PriorityQueue<TreeNode> huffmanTree = convertToHuffmanTree(huffmanForest); //dito kayo create ng method
        this.huffmanTree = huffmanTree;
        return huffmanTree;
   }

   /*TODO: DITOOOOO*/
   private static PriorityQueue<TreeNode> convertToHuffmanTree(PriorityQueue<TreeNode> huffmanForest){

   }
   private static PriorityQueue<TreeNode>  createHuffmanForest(String text){
       //step 2
       String validCharacters = "abcdefghijklmnopqrstuvwxyz .?'!,";

       //step 3
       HashMap<Character, Integer> huffmanMap = new HashMap<>();

       //step 4
       for (char token : text.toCharArray()) {
           if (validCharacters.indexOf(token) >= 0) { // pag token is valid
               if (huffmanMap.containsKey(token)) { //step 5
                   huffmanMap.replace(token, (huffmanMap.get(token) + 1)); //replaces the value of the token by 1
               } else //step 6
                   huffmanMap.put(token, 1);
           }else //step 7
               throw new IllegalArgumentException("Invalid character is found: " + token);
       }

       //step 8
       PriorityQueue<TreeNode> huffmanForest = new PriorityQueue<>(); //this sorts also the queue
       for (char key : huffmanMap.keySet()) {
           int count = huffmanMap.get(key);
           char symbol = key;
           TreeNode current = new TreeNode(count, symbol, null, null);

           huffmanForest.add(current);
       }

       frequencyTable = huffmanForest; //the huffman forest should represent the frequency table;
       return huffmanForest;
   }

    public static void main(String[] args) {
        String filepath = "src/Midterms/midlab2/sample.txt";


    }
}
