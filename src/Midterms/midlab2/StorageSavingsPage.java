package Midterms.midlab2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class StorageSavingsPage extends JPanel {
    private JButton inputFileButton;
    private JLabel huffmanCodingLabel;
    private JButton homeButton;
    private JButton textToHuffman;
    private JButton huffmanToText;
    private JButton storageSavingsButton;
    private JButton showTreeButton;
    private JLabel storageSavingsResultLabel;
    private JLabel ASCIICodingLabel;
    private JTextArea huffmanCodingComputationTextField;
    private JTextArea ASCIICodingComputationTextField;
    private JLabel huffmanComputationLabel;
    private JTextArea storageSavingsResultTextField;
    private JLabel ASCIIComputationLabel;

    public StorageSavingsPage() {
        //construct components
        inputFileButton = new JButton ("INPUT FILE");
        huffmanCodingLabel = new JLabel ("Huffman Coding");
        homeButton = new JButton ("HOME");
        textToHuffman = new JButton ("TEXT TO HUFFMAN");
        huffmanToText = new JButton ("HUFFMAN TO TEXT");
        storageSavingsButton = new JButton ("STORAGE SAVINGS");
        showTreeButton = new JButton ("SHOW TREE");
        storageSavingsResultLabel = new JLabel ("Storage Savings:");
        ASCIICodingLabel = new JLabel ("ASCII Coding ");
        huffmanCodingComputationTextField = new JTextArea (5, 5);
        ASCIICodingComputationTextField = new JTextArea (5, 5);
        huffmanComputationLabel = new JLabel ("Computation");
        storageSavingsResultTextField = new JTextArea (5, 5);
        ASCIIComputationLabel = new JLabel ("Computation");

        //adjust size and set layout
        setPreferredSize (new Dimension (917, 587));
        setLayout (null);

        //add components
        add (inputFileButton);
        add (huffmanCodingLabel);
        add (homeButton);
        add (textToHuffman);
        add (huffmanToText);
        add (storageSavingsButton);
        add (showTreeButton);
        add (storageSavingsResultLabel);
        add (ASCIICodingLabel);
        add (huffmanCodingComputationTextField);
        add (ASCIICodingComputationTextField);
        add (huffmanComputationLabel);
        add (storageSavingsResultTextField);
        add (ASCIIComputationLabel);

        //set component bounds (only needed by Absolute Positioning)
        inputFileButton.setBounds (25, 105, 155, 60);
        huffmanCodingLabel.setBounds (205, 25, 300, 30);
        homeButton.setBounds (25, 20, 155, 60);
        textToHuffman.setBounds (25, 195, 155, 60);
        huffmanToText.setBounds (25, 285, 155, 60);
        storageSavingsButton.setBounds (25, 375, 155, 60);
        showTreeButton.setBounds (25, 465, 155, 60);
        storageSavingsResultLabel.setBounds (360, 480, 150, 35);
        ASCIICodingLabel.setBounds (560, 30, 300, 25);
        huffmanCodingComputationTextField.setBounds (205, 60, 330, 356);
        ASCIICodingComputationTextField.setBounds (560, 60, 330, 356);
        huffmanComputationLabel.setBounds (335, 420, 100, 25);
        storageSavingsResultTextField.setBounds (470, 485, 200, 30);
        ASCIIComputationLabel.setBounds (695, 420, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("StorageSavingsPage");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new StorageSavingsPage());
        frame.pack();
        frame.setVisible (true);
    }
}
