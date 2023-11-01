package Midterms.midlab2.GUI;

import Midterms.midlab2.Huffman;

import javax.swing.*;
import java.awt.*;



public class EncryptionHuffmanCode extends JPanel {
    private JButton inputFileButton;
    private JLabel TextToHuffmanLabel;
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
    private JTextField huffmanCodeOutputTextField;
    private JButton encodeToHuffmanButton;
    private Huffman huffman;

    public EncryptionHuffmanCode() {
        huffman = new Huffman();

        inputFileButton = new JButton("INPUT FILE");
        TextToHuffmanLabel = new JLabel("HUFFMAN TO TEXT");
        homeButton = new JButton("HOME");
        textToHuffmanButton = new JButton("TEXT TO HUFFMAN");
        huffmanToTextButton = new JButton("HUFFMAN TO TEXT");
        storageSavingsButton = new JButton("STORAGE SAVINGS");
        showTreeButton = new JButton("SHOW TREE");
        huffmanCodeTableList = new JList<>();
        huffmanCodeTableLabel = new JLabel("Huffman Code Table");
        huffmanCodeInputTextField = new JTextField(5);
        huffmanCodeInputTextLabel = new JLabel("Enter a text:");
        huffmanCodeTextLabel = new JLabel("Huffman Code:");
        huffmanCodeOutputTextField = new JTextField(5);
        encodeToHuffmanButton = new JButton("Encode to Huffman Code");

        setPreferredSize(new Dimension(1600, 900));
        setLayout(null);

        addComponents();

        setComponentBounds();

        addActionListeners();
    }

    private void addComponents() {
        add(inputFileButton);
        add(TextToHuffmanLabel);
        add(homeButton);
        add(textToHuffmanButton);
        add(huffmanToTextButton);
        add(storageSavingsButton);
        add(showTreeButton);
        add(huffmanCodeTableList);
        add(huffmanCodeTableLabel);
        add(huffmanCodeInputTextField);
        add(huffmanCodeInputTextLabel);
        add(huffmanCodeTextLabel);
        add(huffmanCodeOutputTextField);
        add(encodeToHuffmanButton);
    }

    private void setComponentBounds() {
        TextToHuffmanLabel.setBounds(840, 25, 250, 30);
        homeButton.setBounds(35, 25, 260, 90);
        inputFileButton.setBounds(35, 160, 260, 90);
        textToHuffmanButton.setBounds(35, 295, 260, 90);
        huffmanToTextButton.setBounds(35, 430, 265, 90);
        storageSavingsButton.setBounds(35, 565, 260, 90);
        showTreeButton.setBounds(35, 700, 260, 90);
        huffmanCodeInputTextLabel.setBounds(335, 65, 250, 35);
        huffmanCodeInputTextField.setBounds(335, 95, 1150, 50);
        huffmanCodeTextLabel.setBounds(335, 145, 250, 35);
        huffmanCodeOutputTextField.setBounds(335, 175, 1150, 50);
        encodeToHuffmanButton.setBounds(770, 250, 260, 60);
        huffmanCodeTableList.setBounds(335, 325, 1150, 465);
        huffmanCodeTableLabel.setBounds(840, 790, 150, 35);
    }

    private void addActionListeners() {
        encodeToHuffmanButton.addActionListener(e -> encodeTextToHuffman());
    }

    private void encodeTextToHuffman() {
        String text = huffmanCodeInputTextField.getText();
        try {
            String huffmanCode = huffman.encrypt(text);
            huffmanCodeOutputTextField.setText(huffmanCode);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Huffman Code Decryption");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new EncryptionHuffmanCode());
        frame.pack();
        frame.setVisible(true);
    }
}
