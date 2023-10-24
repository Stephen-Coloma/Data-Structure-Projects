package Midterms.midlab2;

import Midterms.midlab2.tree.TreeNode;

import java.io.File;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    private PriorityQueue<TreeNode> huffmanTree;
    public Huffman(){
        huffmanTree = null;
    }

    public static PriorityQueue<TreeNode> readFile(){
        /*
        * algo:
        * 1. create string with valid characters*/

        String text = "Stephen Coloma asdjhfas asddfasfa asdfhasdlf";

        String validCharacters = "abcdefghijklmnopqrstuvwxyz .?'!,";

        HashMap <Character, Integer> huffmanTable = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            if (validCharacters.indexOf(text.indexOf(i)) >= 0){

                if (huffmanTable.containsKey(text.charAt(i))){
                    //continue mwhehe
                }else
                    huffmanTable.put(text.charAt(i) , 1);
            }
        }

        PriorityQueue<TreeNode> temp = null;
        return temp;
   }

    public static void main(String[] args) {
        readFile();
    }
}
