/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Midterms.midlab2.GUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.*;

import Midterms.midlab2.Huffman; // Import the Huffman class

public class EncryptionHuffmanCode extends javax.swing.JInternalFrame {

    private Huffman huffman;


    public EncryptionHuffmanCode(Huffman huffman) {
        this.huffman=huffman;
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        encodeToHuffmanCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeToHuffmanCodeButtonActionPerformed(evt);
            }
        });
    }

    private void encodeToHuffmanCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the entered text
        String inputText = huffmanCodeTextArea.getText();

        try {

            // Encode the input text into Huffman code
            String huffmanCode = huffman.encrypt(inputText);
            huffmanCodeResultLabel.setText(huffmanCode);

            // Update the table of values with characters and their Huffman codes
            updateTable();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Invalid Huffman code: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while creating the Huffman tree: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) tableOfValuesScrollPane.getModel();
        model.setRowCount(0); // Clear the table

        // Get the Huffman code map
        Map<Character, String> huffmanCodeMap = huffman.getHuffmanCode();

        // Sort the Huffman code map by character (lexicographical order)
        List<Map.Entry<Character, String>> sortedEntries = new ArrayList<>(huffmanCodeMap.entrySet());
        sortedEntries.sort(Comparator.comparing(Map.Entry::getKey));

        // Iterate through the sorted entries and add rows to the table
        for (Map.Entry<Character, String> entry : sortedEntries) {
            char character = entry.getKey();
            String huffmanCode = entry.getValue();
            model.addRow(new Object[]{character, huffmanCode});
        }
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
        inputTextLabel = new javax.swing.JLabel();
        huffmanCodeTextScroll = new javax.swing.JScrollPane();
        huffmanCodeTextArea = new javax.swing.JTextArea();
        huffmanCodeLabel = new javax.swing.JLabel();
        encodeToHuffmanCodeButton = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        tableOfValuesScrollPane = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        huffmanCodeResultLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        inputTextLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTextLabel.setText("Enter a text:");

        huffmanCodeTextScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        huffmanCodeTextArea.setColumns(20);
        huffmanCodeTextArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        huffmanCodeTextArea.setRows(1);
        huffmanCodeTextScroll.setViewportView(huffmanCodeTextArea);

        huffmanCodeLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        huffmanCodeLabel.setText("Huffman Code:");

        encodeToHuffmanCodeButton.setBackground(new java.awt.Color(255, 219, 87));
        encodeToHuffmanCodeButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        encodeToHuffmanCodeButton.setText("Encode to Huffman Code");
        encodeToHuffmanCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeToHuffmanCodeButtonActionPerformed(evt);
            }
        });

        tableOfValuesScrollPane.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableOfValuesScrollPane.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Characters", "Huffman Code"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableOfValuesScrollPane.getTableHeader().setReorderingAllowed(false);
        tableScrollPane.setViewportView(tableOfValuesScrollPane);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Table Of Values");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(232, 52));

        huffmanCodeResultLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        huffmanCodeResultLabel.setText("<format huffman code result>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(huffmanCodeResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(huffmanCodeResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(616, 616, 616)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(inputTextLabel)
                                                        .addComponent(huffmanCodeLabel)
                                                        .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
                                                        .addComponent(huffmanCodeTextScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(565, 565, 565)
                                                .addComponent(encodeToHuffmanCodeButton)))
                                .addContainerGap(14993, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(inputTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(huffmanCodeTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(huffmanCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(encodeToHuffmanCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addContainerGap(225, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>



    // Variables declaration - do not modify
    private javax.swing.JButton encodeToHuffmanCodeButton;
    private javax.swing.JLabel huffmanCodeLabel;
    private javax.swing.JLabel huffmanCodeResultLabel;
    private javax.swing.JTextArea huffmanCodeTextArea;
    private javax.swing.JScrollPane huffmanCodeTextScroll;
    private javax.swing.JLabel inputTextLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tableOfValuesScrollPane;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration
}