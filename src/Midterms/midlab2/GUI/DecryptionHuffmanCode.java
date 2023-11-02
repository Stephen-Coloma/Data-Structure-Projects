package Midterms.midlab2.GUI;

import Midterms.midlab2.Huffman;
import Midterms.midlab2.tree.TreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DecryptionHuffmanCode extends JPanel {
    // GUI Components
    private JButton inputFileButton;
    private JLabel textToHuffmanLabel;
    private JButton homeButton;
    private JButton textToHuffmanButton;
    private JButton huffmanToTextButton;
    private JButton storageSavingsButton;
    private JButton showTreeButton;
    private JList<String> huffmanCodeTableList;
    private JLabel huffmanCodeTableLabel;
    private JTextField huffmanCodeInputTextField;
    private JLabel huffmanCodeInputTextLabel;
    private JLabel huffmanCodeTextLabel;
    private JTextField decodedTextField;
    private JButton decodeToTextButton;

    // Huffman Object
    private Huffman huffman;

    public DecryptionHuffmanCode() {
        huffman = new Huffman();

        initializeComponents();
        setComponentBounds();
        addComponents();
        addEventListeners();
    }

    private void initializeComponents() {
        inputFileButton = new JButton("LOAD HUFFMAN TREE");
        textToHuffmanLabel = new JLabel("DECRYPTION: HUFFMAN TO TEXT");
        homeButton = new JButton("HOME");
        textToHuffmanButton = new JButton("TEXT TO HUFFMAN");
        huffmanToTextButton = new JButton("HUFFMAN TO TEXT");
        storageSavingsButton = new JButton("STORAGE SAVINGS");
        showTreeButton = new JButton("SHOW HUFFMAN TREE");
        huffmanCodeTableList = new JList<>();
        huffmanCodeTableLabel = new JLabel("Huffman Code Table");
        huffmanCodeInputTextField = new JTextField(5);
        huffmanCodeInputTextLabel = new JLabel("Enter Huffman Code:");
        huffmanCodeTextLabel = new JLabel("Decoded Text:");
        decodedTextField = new JTextField(5);
        decodeToTextButton = new JButton("Decode to Text");

        setPreferredSize(new Dimension(1600, 900));
        setLayout(null);
    }

    private void setComponentBounds() {
        textToHuffmanLabel.setBounds(840, 25, 250, 30);
        homeButton.setBounds(35, 25, 260, 90);
        inputFileButton.setBounds(35, 160, 260, 90);
        textToHuffmanButton.setBounds(35, 295, 260, 90);
        huffmanToTextButton.setBounds(35, 430, 265, 90);
        storageSavingsButton.setBounds(35, 565, 260, 90);
        showTreeButton.setBounds(35, 700, 260, 90);
        huffmanCodeInputTextLabel.setBounds(335, 65, 250, 35);
        huffmanCodeInputTextField.setBounds(335, 95, 1150, 50);
        huffmanCodeTextLabel.setBounds(335, 145, 250, 35);
        decodedTextField.setBounds(335, 175, 1150, 50);
        decodeToTextButton.setBounds(770, 250, 260, 60);
        huffmanCodeTableList.setBounds(335, 325, 1150, 465);
        huffmanCodeTableLabel.setBounds(840, 790, 150, 35);
    }

    private void addComponents() {
        add(textToHuffmanLabel);
        add(homeButton);
        add(inputFileButton);
        add(textToHuffmanButton);
        add(huffmanToTextButton);
        add(storageSavingsButton);
        add(showTreeButton);
        add(huffmanCodeTableList);
        add(huffmanCodeTableLabel);
        add(huffmanCodeInputTextField);
        add(huffmanCodeInputTextLabel);
        add(huffmanCodeTextLabel);
        add(decodedTextField);
        add(decodeToTextButton);
    }

    private void addEventListeners() {
        decodeToTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String huffmanCode = huffmanCodeInputTextField.getText();
                    String text = huffman.decrypt(huffmanCode);
                    decodedTextField.setText(text);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(DecryptionHuffmanCode.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Huffman Code Decryption");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DecryptionHuffmanCode());
        frame.pack();
        frame.setVisible(true);
    }
}
