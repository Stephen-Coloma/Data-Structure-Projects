package Midterms.midlab2.tree;

import Midterms.midlab2.Huffman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HuffmanGUI {
    private JFrame frame;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton encodeButton;
    private JButton decodeButton;
    private Huffman huffman;

    public HuffmanGUI() {
        huffman = new Huffman();

        // Setting up the main frame
        frame = new JFrame("Huffman Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout());
        JButton homeButton = new JButton("Home");
        navPanel.add(homeButton);
        JButton inputButton = new JButton("Input File");
        navPanel.add(inputButton);
        frame.add(navPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        inputTextArea = new JTextArea();
        outputTextArea = new JTextArea();
        centerPanel.add(inputTextArea, BorderLayout.NORTH);
        centerPanel.add(outputTextArea, BorderLayout.CENTER);
        frame.add(centerPanel, BorderLayout.CENTER);

        // South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        encodeButton = new JButton("Encode to Huffman Code");
        decodeButton = new JButton("Decode to Text");
        southPanel.add(encodeButton);
        southPanel.add(decodeButton);
        frame.add(southPanel, BorderLayout.SOUTH);

        // Add event listeners
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = inputTextArea.getText();
                    String encoded = huffman.encrypt(text);
                    outputTextArea.setText(encoded);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error encoding the text");
                }
            }
        });

        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement decoding method in Huffman class and use it here.
                JOptionPane.showMessageDialog(frame, "Decoding is not yet implemented");
            }
        });

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        huffman.createHuffmanTree(file);
                        JOptionPane.showMessageDialog(frame, "File loaded successfully");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error reading the file");
                    }
                }
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement a method to reset the UI to the home state
            }
        });
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        HuffmanGUI gui = new HuffmanGUI();
        gui.display();
    }
}
