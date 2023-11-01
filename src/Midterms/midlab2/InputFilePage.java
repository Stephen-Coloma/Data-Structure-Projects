package Midterms.midlab2;

import java.awt.*;
import javax.swing.*;

public class InputFilePage extends JPanel {
    private JButton inputFileButton;
    private JLabel inputFileLabel;
    private JButton homeButton;
    private JButton textToHuffman;
    private JButton huffmanToText;
    private JButton storageSavingsButton;
    private JButton showTreeButton;
    private JList huffmanCodeTableList;
    private JLabel tableOfValuesLabel;
    private JTextField huffmanCodeInputTextField;
    private JLabel charactersUserInputLabel;
    private JButton saveAndShowButton;

    public InputFilePage() {
        //construct preComponents
        String[] huffmanCodeTableListItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        inputFileButton = new JButton ("INPUT FILE");
        inputFileLabel = new JLabel ("                                                                        INPUT FILE ");
        homeButton = new JButton ("HOME");
        textToHuffman = new JButton ("TEXT TO HUFFMAN");
        huffmanToText = new JButton ("HUFFMAN TO TEXT");
        storageSavingsButton = new JButton ("STORAGE SAVINGS");
        showTreeButton = new JButton ("SHOW TREE");
        huffmanCodeTableList = new JList (huffmanCodeTableListItems);
        tableOfValuesLabel = new JLabel ("Table of Values");
        huffmanCodeInputTextField = new JTextField (5);
        charactersUserInputLabel = new JLabel ("Enter a series of characters (sentences, phrase, paragraph, etc.):");
        saveAndShowButton = new JButton ("Save and Show Table of Values");

        //adjust size and set layout
        setPreferredSize (new Dimension (917, 587));
        setLayout (null);

        //add components
        add (inputFileButton);
        add (inputFileLabel);
        add (homeButton);
        add (textToHuffman);
        add (huffmanToText);
        add (storageSavingsButton);
        add (showTreeButton);
        add (huffmanCodeTableList);
        add (tableOfValuesLabel);
        add (huffmanCodeInputTextField);
        add (charactersUserInputLabel);
        add (saveAndShowButton);

        //set component bounds (only needed by Absolute Positioning)
        inputFileButton.setBounds (25, 105, 155, 60);
        inputFileLabel.setBounds (285, 20, 500, 30);
        homeButton.setBounds (25, 20, 155, 60);
        textToHuffman.setBounds (25, 195, 155, 60);
        huffmanToText.setBounds (25, 285, 155, 60);
        storageSavingsButton.setBounds (25, 375, 155, 60);
        showTreeButton.setBounds (25, 465, 155, 60);
        huffmanCodeTableList.setBounds (205, 275, 670, 275);
        tableOfValuesLabel.setBounds (485, 550, 150, 35);
        huffmanCodeInputTextField.setBounds (205, 95, 670, 110);
        charactersUserInputLabel.setBounds (205, 60, 400, 35);
        saveAndShowButton.setBounds (410, 220, 255, 40);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("InputFilePage");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new InputFilePage());
        frame.pack();
        frame.setVisible (true);
    }
}
