import java.awt.*;
import javax.swing.*;

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
        inputFileButton = new JButton("INPUT FILE");
        huffmanCodingLabel = new JLabel("Huffman Coding");
        homeButton = new JButton("HOME");
        textToHuffman = new JButton("TEXT TO HUFFMAN");
        huffmanToText = new JButton("HUFFMAN TO TEXT");
        storageSavingsButton = new JButton("STORAGE SAVINGS");
        showTreeButton = new JButton("SHOW TREE");
        storageSavingsResultLabel = new JLabel("Storage Savings:");
        ASCIICodingLabel = new JLabel("ASCII Coding ");
        huffmanCodingComputationTextField = new JTextArea(5, 20);
        ASCIICodingComputationTextField = new JTextArea(5, 20);
        huffmanComputationLabel = new JLabel("Computation");
        storageSavingsResultTextField = new JTextArea(5, 20);
        ASCIIComputationLabel = new JLabel("Computation");

        //adjust size and set layout
        setPreferredSize(new Dimension(1600, 900));
        setLayout(null);

        //add components
        add(inputFileButton);
        add(huffmanCodingLabel);
        add(homeButton);
        add(textToHuffman);
        add(huffmanToText);
        add(storageSavingsButton);
        add(showTreeButton);
        add(storageSavingsResultLabel);
        add(ASCIICodingLabel);
        add(huffmanCodingComputationTextField);
        add(ASCIICodingComputationTextField);
        add(huffmanComputationLabel);
        add(storageSavingsResultTextField);
        add(ASCIIComputationLabel);

        //set component bounds (only needed by Absolute Positioning)
        inputFileButton.setBounds(35, 160, 260, 90);
        huffmanCodingLabel.setBounds(335, 25, 250, 30);
        homeButton.setBounds(35, 25, 260, 90);
        textToHuffman.setBounds(35, 295, 260, 90);
        huffmanToText.setBounds(35, 430, 265, 90);
        storageSavingsButton.setBounds(35, 565, 260, 90);
        showTreeButton.setBounds(35, 700, 260, 90);
        storageSavingsResultLabel.setBounds(875, 700, 150, 35);
        ASCIICodingLabel.setBounds(935, 30, 250, 25);
        huffmanCodingComputationTextField.setBounds(335, 60, 550, 520);
        ASCIICodingComputationTextField.setBounds(935, 60, 550, 520);
        huffmanComputationLabel.setBounds(575, 600, 100, 25);
        storageSavingsResultTextField.setBounds(820, 730, 200, 50);
        ASCIIComputationLabel.setBounds(1175, 600, 100, 25);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StorageSavingsPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StorageSavingsPage());
        frame.pack();
        frame.setVisible(true);
    }
}
