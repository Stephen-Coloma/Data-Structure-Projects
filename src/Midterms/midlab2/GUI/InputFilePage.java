package Midterms.midlab2.GUI;

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
        inputFileLabel = new JLabel ("INPUT FILE ");
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
        setPreferredSize(new Dimension(1600, 900));
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
        inputFileLabel.setBounds(840, 25, 250, 30);
        homeButton.setBounds(35, 25, 260, 90);
        inputFileButton.setBounds(35, 160, 260, 90);
        textToHuffman.setBounds(35, 295, 260, 90);
        huffmanToText.setBounds(35, 430, 265, 90);
        storageSavingsButton.setBounds(35, 565, 260, 90);
        showTreeButton.setBounds(35, 700, 260, 90);
        charactersUserInputLabel.setBounds(335, 65, 400, 35);
        huffmanCodeInputTextField.setBounds(335, 95, 1150, 140);
        saveAndShowButton.setBounds(770, 250, 260, 60);
        huffmanCodeTableList.setBounds(335, 325, 1150, 465);
        tableOfValuesLabel.setBounds(840, 790, 150, 35);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("InputFilePage");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new InputFilePage());
        frame.pack();
        frame.setVisible (true);
    }
}
