package Midterms.midlab2.GUI;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class DecryptionHuffmanCode extends javax.swing.JInternalFrame {

    /**
     * Creates new form DecryptionHuffmanCode
     */
    public DecryptionHuffmanCode() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
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
        huffmanCodeLabel = new javax.swing.JLabel();
        huffmanCodeTextScroll = new javax.swing.JScrollPane();
        huffmanCodeTextArea = new javax.swing.JTextArea();
        decodedTextLabel = new javax.swing.JLabel();
        decodeToTextButton = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        tableOfValuesScrollPane = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        decodedTextResultLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        huffmanCodeLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        huffmanCodeLabel.setText("Enter Huffman Code:");

        huffmanCodeTextScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        huffmanCodeTextArea.setColumns(20);
        huffmanCodeTextArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        huffmanCodeTextArea.setRows(1);
        huffmanCodeTextScroll.setViewportView(huffmanCodeTextArea);

        decodedTextLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        decodedTextLabel.setText("Decoded Text:");

        decodeToTextButton.setBackground(new java.awt.Color(255, 219, 87));
        decodeToTextButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        decodeToTextButton.setText("Decode To Text");
        decodeToTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeToTextButtonActionPerformed(evt);
            }
        });

        tableOfValuesScrollPane.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableOfValuesScrollPane.setModel(new javax.swing.table.DefaultTableModel(
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

        decodedTextResultLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        decodedTextResultLabel.setText("<format decoded text result>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(decodedTextResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(decodedTextResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
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
                                                        .addComponent(huffmanCodeLabel)
                                                        .addComponent(decodedTextLabel)
                                                        .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
                                                        .addComponent(huffmanCodeTextScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(581, 581, 581)
                                                .addComponent(decodeToTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(14993, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(huffmanCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(huffmanCodeTextScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(decodedTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(decodeToTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
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

    private void decodeToTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton decodeToTextButton;
    private javax.swing.JLabel decodedTextLabel;
    private javax.swing.JLabel decodedTextResultLabel;
    private javax.swing.JLabel huffmanCodeLabel;
    private javax.swing.JTextArea huffmanCodeTextArea;
    private javax.swing.JScrollPane huffmanCodeTextScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tableOfValuesScrollPane;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration
}
