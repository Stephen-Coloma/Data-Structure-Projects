package Midterms.midlab2;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DecryptionHuffmanCode extends JPanel {
    private JButton inputFileButton;
    private JLabel huffmanCodeConverterLabel;
    private JButton homeButton;
    private JButton textToHuffmanButton;
    private JButton huffmanToText;
    private JButton storageSavingsButton;
    private JButton showTreeButton;
    private JList huffmanCodeTableList;
    private JLabel huffmanCodeTableLabel;
    private JTextField huffmanCodeINputTExtField;
    private JLabel huffmanCodeInputTextLabel;
    private JLabel huffmanCodeTextLabel;
    private JTextField huffmanCodeINputTextField;
    private JButton encodeToHuffmanButton;

    public DecryptionHuffmanCode() {
        //construct preComponents
        String[] huffmanCodeTableListItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        inputFileButton = new JButton ("INPUT FILE");
        huffmanCodeConverterLabel = new JLabel ("HUFFMAN CODE CONVERTER");
        homeButton = new JButton ("HOME");
        textToHuffmanButton = new JButton ("TEXT TO HUFFMAN");
        huffmanToText = new JButton ("HUFFMAN TO TEXT");
        storageSavingsButton = new JButton ("STORAGE SAVINGS");
        showTreeButton = new JButton ("SHOW TREE");
        huffmanCodeTableList = new JList (huffmanCodeTableListItems);
        huffmanCodeTableLabel = new JLabel ("Huffman Code Table");
        huffmanCodeINputTExtField = new JTextField (5);
        huffmanCodeInputTextLabel = new JLabel ("Enter Huffman Code:");
        huffmanCodeTextLabel = new JLabel ("Decoded Text:");
        huffmanCodeINputTextField = new JTextField (5);
        encodeToHuffmanButton = new JButton ("Decode to text");

        //adjust size and set layout
        setPreferredSize (new Dimension (901, 579));
        setLayout (null);

        //add components
        add (inputFileButton);
        add (huffmanCodeConverterLabel);
        add (homeButton);
        add (textToHuffmanButton);
        add (huffmanToText);
        add (storageSavingsButton);
        add (showTreeButton);
        add (huffmanCodeTableList);
        add (huffmanCodeTableLabel);
        add (huffmanCodeINputTExtField);
        add (huffmanCodeInputTextLabel);
        add (huffmanCodeTextLabel);
        add (huffmanCodeINputTextField);
        add (encodeToHuffmanButton);

        inputFileButton.setBounds (25, 150, 155, 60);
        huffmanCodeConverterLabel.setBounds (25, 15, 880, 30);
        homeButton.setBounds (25, 65, 155, 60);
        textToHuffmanButton.setBounds (25, 235, 155, 60);
        huffmanToText.setBounds (25, 320, 155, 60);
        storageSavingsButton.setBounds (25, 405, 155, 60);
        showTreeButton.setBounds (25, 490, 155, 55);
        huffmanCodeTableList.setBounds (205, 250, 670, 295);
        huffmanCodeTableLabel.setBounds (490, 540, 150, 35);
        huffmanCodeINputTExtField.setBounds (425, 70, 450, 40);
        huffmanCodeInputTextLabel.setBounds (275, 75, 230, 35);
        huffmanCodeTextLabel.setBounds (280, 140, 100, 25);
        huffmanCodeINputTextField.setBounds (425, 130, 450, 40);
        encodeToHuffmanButton.setBounds (535, 190, 255, 40);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new DecryptionHuffmanCode());
        frame.pack();
        frame.setVisible (true);
    }
}
