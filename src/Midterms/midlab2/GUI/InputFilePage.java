package Midterms.midlab2.GUI;

import Midterms.midlab2.Huffman;
import Midterms.midlab2.tree.TreeNode;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InputFilePage extends javax.swing.JInternalFrame {
    private Huffman huffman;

    /**
     * Creates new form InputFilePage
     */
    public InputFilePage(Huffman huffman) {
        this.huffman = huffman;
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);

        saveAndShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveAndShowButtonActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputLabel = new javax.swing.JLabel();
        saveAndShowButton = new javax.swing.JButton();
        tableOfValuesScrollPane = new javax.swing.JScrollPane();
        tableOfValues = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        inputLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputLabel.setText("Enter a series of characters (sentences, phrase, paragraph, etc.):");

        saveAndShowButton.setBackground(new java.awt.Color(255, 219, 87));
        saveAndShowButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveAndShowButton.setText("Save and Show Table of Values");
        saveAndShowButton.setToolTipText("");
        saveAndShowButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        saveAndShowButton.setPreferredSize(new java.awt.Dimension(94, 24));

        tableOfValuesScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableOfValuesScrollPane.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tableOfValues.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableOfValues.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Character", "Number of occurrence of the character in the text"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOfValues.getTableHeader().setReorderingAllowed(false);
        tableOfValuesScrollPane.setViewportView(tableOfValues);

        inputTextArea.setColumns(10);
        inputTextArea.setRows(5);
        inputTextArea.setTabSize(3);
        inputTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(inputTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(inputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tableOfValuesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(536, 536, 536)
                                                .addComponent(saveAndShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(13750, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(inputLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(saveAndShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(tableOfValuesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(303, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    private void saveAndShowButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        // First get the text from inputTextArea
        String inputText = inputTextArea.getText();
        // Now save the input text to the specified file path
        saveInputTextToFile(inputText);
    }

    private void saveInputTextToFile(String inputText) {
        // Specify the desired file path for saving the input text
        String filePath = "src\\Midterms\\midlab2\\sample.txt";

        // Convert the input text to lowercase
        inputText = inputText.toLowerCase();

        // Write the lowercase input text to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(inputText);
            JOptionPane.showMessageDialog(this, "Input text saved to file successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving input text to file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            huffman.createHuffmanTree(new File(filePath));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Huffman Cannot be Generated: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Finally, update the table
        updateTable(huffman.getCharacterFrequencies());
    }


    private void updateTable(PriorityQueue<TreeNode> characterFrequencies) {
        DefaultTableModel model = (DefaultTableModel) tableOfValues.getModel();

        // Convert the PriorityQueue to a sorted list
        List<TreeNode> sortedFrequencies = new ArrayList<>(characterFrequencies);
        Collections.sort(sortedFrequencies, Comparator.comparing(TreeNode::getSymbol));

        model.setRowCount(0); // Clear the existing data

        // Populate the table with the sorted data
        sortedFrequencies.forEach(element -> model.addRow(new Object[]{element.getSymbol(), element.getCount()}));
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel inputLabel;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveAndShowButton;
    private javax.swing.JTable tableOfValues;
    private javax.swing.JScrollPane tableOfValuesScrollPane;
    // End of variables declaration
}
