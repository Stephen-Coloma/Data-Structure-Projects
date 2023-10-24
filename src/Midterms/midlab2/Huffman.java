package Midterms.midlab2;

import Midterms.midlab2.tree.TreeNode;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
    private PriorityQueue<TreeNode> frequencyTable;
    private PriorityQueue<TreeNode> huffmanTree;
    public Huffman(){
        frequencyTable = null;
        huffmanTree = null;
    }

    /**Returns the frequency table*/
    public PriorityQueue<TreeNode> getFrequencyTable() {
        return frequencyTable;
    }

    /**Returns the frequency table*/
    public void setFrequencyTable(PriorityQueue<TreeNode> frequencyTable) {
        frequencyTable = frequencyTable;
    }

    /**Returns the huffman tree*/
    public PriorityQueue<TreeNode> getHuffmanTree() {
        return huffmanTree;
    }

    public void setHuffmanTree(PriorityQueue<TreeNode> huffmanTree) {
        this.huffmanTree = huffmanTree;
    }

    /**Generates a huffman tree from the text of a file.
     *
     * @param file contains the texts, sentences or paragraphs.
     * @return Huffman tree expressed in PriorityQueue data structure
     * @throws FileNotFoundException when file path is not found
     * @throws IOException when there is an error in running time
     * @throws IllegalArgumentException when the paragraph contains characters that is non-valid
     * */
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
//        Uncomment this after creating the convertToHuffmanTree() method
//        PriorityQueue<TreeNode> huffmanTree = convertToHuffmanTree(huffmanForest);
//        this.huffmanTree = huffmanTree;
        return huffmanForest; //need to change to "return huffmanTree"
   }

    /*TODO: method that converts Forest(PriorityQueue) to Single tree (Huffman Tree)
        Returns the huffman code for each character of the input string.
        The return of this method will be used in generating the output for huffman tree
        Input: PriorityQueue<TreeNode>
        Output: PriorityQueue<TreeNode> (i.e a single tree) return type.

        TODO: Generate a helper method that is similar to the printCode() method of sir dale. The purpose is to provide data for huffman code for each character.
            output: String?? not sure kayo mag decide
            sample run: Char | Huffman Code
            -----------------------
            F | 00000
            G | 00001
            H | 0001
            B | 001
            A | 01
            C | 100
            D | 101
            E | 11
     */
//    UNCOMMENT THIS IF YOU WANT TO WORK IN THIS TASK
//    private PriorityQueue<TreeNode> convertToHuffmanTree(PriorityQueue<TreeNode> huffmanForest){
//
//    }




   /*TODO: Method that accepts a string involving the characters in the set //encrypt
        Handles error for invalid input text (i.e a text that has a character other than the set of characters.
        Returns the huffman code for that text based from the huffman code generated from the main input file.
        Input: String
        Output: String
    */

    /*TODO: Method that accepts a huffman code and shows the string corresponding to the huffman code. //decrypt
        Handles error for invalid input of binary digits. (i.e. input other than 0’s and 1’s).
        Input: String
        Output: String

    /*TODO: method that displays the huffman tree.
        //dont work on this yet
     */


   /**--------------------------------HELPER METHODS---------------------------------------*/


   /**A helper methods that creates huffman forest (i.e. many huffman tree but has no children inside a PriorityQueue)
    * The huffman forest represents the symbol-frequency table which will be used to calculate storage savings.
    * @param text the text from which the huffman code will be based.
    * @return huffman forest expressed in PriorityQueue
    * */
   private PriorityQueue<TreeNode> createHuffmanForest(String text){
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


    /**THIS MAIN METHOD IS FOR TESTING PURPOSES ONLY!*/
    public static void main(String[] args) {
        String filepath = "src/Midterms/midlab2/sample.txt";
        Huffman test = new Huffman();

        try{
            test.createHuffmanTree(new File(filepath));

            while (test.getFrequencyTable().size() != 0){
                System.out.println(test.getFrequencyTable().poll());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
