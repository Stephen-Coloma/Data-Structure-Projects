package Midterms.midlab2;

import Midterms.midlab2.tree.TreeNode;
import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
    private PriorityQueue<TreeNode> characterFrequencies;
    private PriorityQueue<TreeNode> huffmanTree;
    private HashMap<Character, String> huffmanCode = new HashMap<>(); //this stores the huffman code for each character

    public Huffman(){
        characterFrequencies = null;
        huffmanTree = null;
    }

    /**Returns the huffman tree*/
    public PriorityQueue<TreeNode> getHuffmanTree() {
        return huffmanTree;
    }

    /*Set a huffman tree.
    * @param huffmanTree to be set*/
    public void setHuffmanTree(PriorityQueue<TreeNode> huffmanTree) {
        this.huffmanTree = huffmanTree;
    }

    /*TO BE REMOVED:*/
    public HashMap<Character, String> getHuffmanCode() {
        return huffmanCode;
    }

    /**Generates a huffman tree from the text of a file.
     *
     * @param file contains the texts, sentences or paragraphs.
     * @return Huffman tree expressed in PriorityQueue data structure
     * @throws FileNotFoundException when file path is not found
     * @throws IOException when there is an error in running time
     * @throws IllegalArgumentException when the paragraph contains characters that is non-valid
     * */
    public void createHuffmanTree(File file) throws Exception{
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
        characterFrequencies = new PriorityQueue<>(huffmanForest);
        huffmanTree = convertToHuffmanTree(huffmanForest);
   }

    /**A helper method that creates huffman forest (i.e. many huffman tree but has no children inside a PriorityQueue)
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
        return huffmanForest;
    }


    /**
     * Converts a forest of Huffman trees into a single Huffman tree.
     * This method takes a PriorityQueue of TreeNode objects, where each node
     * represents a Huffman tree. It repeatedly combines the two trees with
     * the lowest frequencies until only one tree remains, which is the Huffman tree.
     * Additionally, it generates Huffman codes for each character based on the
     * Huffman tree.
     *
     * @param huffmanForest The PriorityQueue of TreeNode objects representing a forest of Huffman trees.
     * @return The PriorityQueue of TreeNode representing a single Huffman tree.
     */
    private PriorityQueue<TreeNode> convertToHuffmanTree(PriorityQueue<TreeNode> huffmanForest){
        TreeNode root = null;
        while (huffmanForest.size() > 1) {
            TreeNode l = huffmanForest.poll();
            TreeNode r = huffmanForest.poll();
            TreeNode p = new TreeNode(l.getCount() + r.getCount(), '\0', l, r);
            root=p;
            huffmanForest.add(p);
        }
        generateHuffmanCode(root,""); //this generates the huffman code
        return huffmanForest;
    }


    /**
     * Recursively generates Huffman codes for characters based on the Huffman tree.
     * This method traverses the Huffman tree and assigns binary codes to each character
     * based on their position in the tree.
     *
     * @param root The current TreeNode in the traversal, initially the root of the Huffman tree.
     * @param s The binary code accumulated during traversal, initially an empty string.
     */
    private void generateHuffmanCode(TreeNode root, String s){
        //base case (i.e. current node is the leaf)
        if (root.getLeft() == null && root.getRight() == null){
            huffmanCode.put(root.getSymbol(), s);
        }else {
            generateHuffmanCode(root.getLeft(), s+"0");
            generateHuffmanCode(root.getRight(), s+"1");
        }
    }


    /*======================================================================================*/

    /**
     * Encrypts the input text using Huffman coding.
     *
     * @param text The input text to be encrypted.
     * @return The encrypted text in the form of Huffman codes.
     * @throws IllegalArgumentException If an invalid character is encountered in the input text.
     */
    public String encrypt(String text){
        /*ALGO
        * 1. Declare a string variable
        * 2. For each character in text, validate if it is a valid character
        * 2.2. If it is not a valid character, return an error message
        * 2.3. Else, get its huffman code into the huffmanCode map
        * 3. Append each code onto the string
        * 4. Return the string*/

        //step 1
        String huffmanEquivalent = "";

        //step 2
        for (char token:text.toCharArray()) {
            //step 2.2
            if (!huffmanCode.containsKey(token)){
                throw new IllegalArgumentException("Huffman Code cannot be generated: Invalid Character " + token);
            }else //step 2.3
                huffmanEquivalent+=huffmanCode.get(token); //step 4
        }
        return huffmanEquivalent;
    }


    /*======================================================================================*/


    /*TODO: Method that accepts a huffman code and shows the string corresponding to the huffman code. //decrypt
        Handles error for invalid input of binary digits. (i.e. input other than 0’s and 1’s).
        Input: String
        Output: String

    /*TODO: method that displays the huffman tree.
        //dont work on this yet
     */





    /**THIS MAIN METHOD IS FOR TESTING PURPOSES ONLY!*/
    public static void main(String[] args) {
        String filepath = "src/Midterms/midlab2/sample.txt";
        Huffman test = new Huffman();
        try {
            test.createHuffmanTree(new File(filepath));
            System.out.println("Char | Huffman Code");
            System.out.println("-----------------------");
            for (char key: test.getHuffmanCode().keySet()) {
                System.out.println(key + " | " + test.getHuffmanCode().get(key));
            }

            System.out.println("=====================================");

            String text = "abc";
            System.out.println(test.encrypt(text));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
