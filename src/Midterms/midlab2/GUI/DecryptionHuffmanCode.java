package Midterms.midlab2.GUI;

import java.awt.*;
import javax.swing.*;

public class DecryptionHuffmanCode extends JPanel {
    private JButton inputFileButton;
    private JLabel TextToHuffmanLabel;
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
    private JButton decodeToHuffmanButton;

    public DecryptionHuffmanCode() {
        String[] huffmanCodeTableListItems = {"Item 1", "Item 2", "Item 3"};

        inputFileButton = new JButton ("INPUT FILE");
        TextToHuffmanLabel = new JLabel ("TEXT TO HUFFMAN");
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
        decodeToHuffmanButton = new JButton ("Decode to text");

        setPreferredSize (new Dimension (1600, 900));
        setLayout (null);

        addComponents();

        setComponentBounds();
    }

    private void addComponents() {
        add (inputFileButton);
        add (TextToHuffmanLabel);
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
        add (decodeToHuffmanButton);
    }

    private void setComponentBounds() {
        TextToHuffmanLabel.setBounds (860, 15, 250, 30);
        homeButton.setBounds (35, 40, 260, 90);
        inputFileButton.setBounds (35, 165, 260, 90);
        textToHuffmanButton.setBounds (40, 300, 260, 90);
        huffmanToText.setBounds (35, 415, 260, 90);
        storageSavingsButton.setBounds (35, 540, 260, 90);
        showTreeButton.setBounds (35, 665, 260, 90);
        huffmanCodeInputTextLabel.setBounds (335, 65, 250, 35);
        huffmanCodeINputTExtField.setBounds (335, 95, 1150, 50);
        huffmanCodeTextLabel.setBounds (335, 145, 250, 35);
        huffmanCodeINputTextField.setBounds (335, 175, 1150, 50);
        decodeToHuffmanButton.setBounds (770, 250, 260, 60);
        huffmanCodeTableList.setBounds (335, 325, 1150, 460);
        huffmanCodeTableLabel.setBounds (860, 790, 150, 35);
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new DecryptionHuffmanCode());
        frame.pack();
        frame.setVisible (true);
    }
}
