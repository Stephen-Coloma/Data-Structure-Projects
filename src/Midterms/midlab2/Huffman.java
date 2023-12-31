package Midterms.midlab2;

import Midterms.midlab2.tree.TreeNode;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
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


    /**
     * Gets the Huffman code, which is a mapping of characters to their corresponding Huffman codes.
     *
     * @return A HashMap containing character-to-code mappings.
     */
    public HashMap<Character, String> getHuffmanCode() {
        return huffmanCode;
    }

    /**
     * Gets the character frequencies, represented as a PriorityQueue of TreeNodes.
     *
     * @return A PriorityQueue containing TreeNode objects representing character frequencies.
     */
    public PriorityQueue<TreeNode> getCharacterFrequencies() {
        return characterFrequencies;
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
     * @exception IllegalArgumentException when an input character is not valid*/
    private PriorityQueue<TreeNode> createHuffmanForest(String text) throws IllegalArgumentException{
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

    /**
     * Decrypts a Huffman-encoded text into the original text.
     *
     * @param huffmanEncodedText The input Huffman-encoded text to be decrypted.
     * @return The decrypted original text.
     * @throws IllegalArgumentException If an invalid binary digit is encountered in the input text.
     */
    public String decrypt(String huffmanEncodedText) {
        /* ALGO
         * 1. Declare a string variable to store the decrypted text.
         * 2. Initialize an empty StringBuilder to accumulate binary digits.
         * 3. Iterate through the Huffman-encoded text:
         *    3.1. Append the current character to the StringBuilder.
         *    3.2. Check if the accumulated binary digits match any Huffman code.
         *    3.3. If a match is found, add the corresponding character to the decrypted text,
         *         reset the StringBuilder, and continue searching for the next code.
         *    3.4. If no match is found, continue accumulating binary digits.
         *    3.5. Handle the case where invalid binary digits (other than '0' and '1') are encountered.
         * 4. Return the decrypted text.
         */

        // Step 1
        StringBuilder binaryDigits = new StringBuilder();
        StringBuilder decryptedText = new StringBuilder();

        // Step 3
        for (char token : huffmanEncodedText.toCharArray()) {
            // Step 3.1
            binaryDigits.append(token);

            // Step 3.2
            boolean matchFound = false;
            for (char key : huffmanCode.keySet()) {
                String huffmanCodeValue = huffmanCode.get(key);
                if (binaryDigits.toString().equals(huffmanCodeValue)) {
                    // Step 3.3
                    decryptedText.append(key);
                    binaryDigits.setLength(0); // Reset the StringBuilder
                    matchFound = true;
                    break; // Continue searching for the next code
                }
            }

            // Step 3.4
            if (!matchFound) {
                // Step 3.5 - Handle invalid binary digits
                if (!binaryDigits.toString().matches("[01]+")) {
                    throw new IllegalArgumentException("Invalid binary digit found in Huffman-encoded text: " + binaryDigits.toString());
                }
            }
        }

        // Step 4
        return decryptedText.toString();
    }


    /*======================================================================================*/

    /**
     * Calculates and returns the savings achieved by comparing the storage usage of ASCII encoding
     * with the storage usage of Huffman coding in percentage format.
     * @return A formatted String representing the percentage savings achieved.
     */
    public String calculateSavings(){
        /*ALGO
         * 1. Calculate the storage used for ASCII encoding. of the hashmap
         * 1.1. Total the number of characters based on the value on the characterFrequency
         * 1.2. Multiply the total to 7 (for ascii) then store it in a variable
         * 2. Calculate the storage used for huffman coding.
         * 2.1. For each character's frequency in the characterFrequency table,
         *       multiply it to the length of the huffman code for that character in huffmanCode
         * 2.2. Store it in a variable
         * 3. Divide and multiply the huffman coding to ascii coding
         * 4. Append the percentage sign then return the String*/

        //step 1.1
        int totalCharacters = 0;
        //step 2.2
        double huffmanStorageUsage=0.0;

        ArrayList<TreeNode> characterFrequencyArrayList = new ArrayList<>(characterFrequencies);

        for (TreeNode token : characterFrequencyArrayList) {
            totalCharacters += token.getCount(); //step 1.1
            int length = huffmanCode.get(token.getSymbol()).length(); //step 2.1
            int count = token.getCount(); //step 2.1
            huffmanStorageUsage+=(length*count);//step 2.2
        }

        //step 1.2
        double asciiStorageUsage=totalCharacters*7;

        //step 3
        double savings = ((asciiStorageUsage-huffmanStorageUsage)/asciiStorageUsage)*100;

        // Create a DecimalFormat object with the desired format
        DecimalFormat df = new DecimalFormat("#.00");

        // Format the result to two decimal places
        String formattedResult = df.format(savings);

        return formattedResult+"%";
    }
    /*======================================================================================*/



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

            String text = "this is huffman";
            System.out.println("TEXT: " + text);
            System.out.println("HUFFMAN EQUIVALENT: " + test.encrypt(text));
            System.out.println();
            System.out.println("PERCENTAGE SAVINGS: " + test.calculateSavings());
            String encryptedText = "10000111111000011101110000111010111111100111100011100000010111111101";
            String decryptedText = test.decrypt(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
