package Midterms.midlab2.GUI;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class StorageSavingsPage extends javax.swing.JInternalFrame {
    // Variables declaration
    private javax.swing.JTextArea asciiCodingComputationTextArea;
    private javax.swing.JLabel asciiCodingLabel;
    private javax.swing.JLabel computationLabel1;
    private javax.swing.JLabel computationLabel2;
    private javax.swing.JTextArea huffmanCodingComputationTextArea;
    private javax.swing.JLabel huffmanCodingLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel storageSavingsLabel;
    private javax.swing.JTextArea storageSavingsResultTextArea;

    /**
     * Creates new form StorageSavingsPage
     */
    public StorageSavingsPage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        huffmanCodingLabel = new javax.swing.JLabel();
        asciiCodingLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        huffmanCodingComputationTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        asciiCodingComputationTextArea = new javax.swing.JTextArea();
        computationLabel1 = new javax.swing.JLabel();
        computationLabel2 = new javax.swing.JLabel();
        storageSavingsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storageSavingsResultTextArea = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        huffmanCodingLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        huffmanCodingLabel.setText("HUFFMAN CODING");

        asciiCodingLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        asciiCodingLabel.setText("ASCII CODING");

        huffmanCodingComputationTextArea.setColumns(20);
        huffmanCodingComputationTextArea.setRows(5);
        huffmanCodingComputationTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        huffmanCodingComputationTextArea.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(huffmanCodingComputationTextArea);

        asciiCodingComputationTextArea.setColumns(20);
        asciiCodingComputationTextArea.setRows(5);
        asciiCodingComputationTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(asciiCodingComputationTextArea);

        computationLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        computationLabel1.setText("Computation");

        computationLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        computationLabel2.setText("Computation");

        storageSavingsLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        storageSavingsLabel.setForeground(new java.awt.Color(0, 80, 157));
        storageSavingsLabel.setText("Storage Savings (%):");

        storageSavingsResultTextArea.setColumns(5);
        storageSavingsResultTextArea.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        storageSavingsResultTextArea.setRows(1);
        storageSavingsResultTextArea.setTabSize(3);
        storageSavingsResultTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(storageSavingsResultTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(311, 311, 311)
                                                .addComponent(storageSavingsLabel)
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(81, 81, 81)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(huffmanCodingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(283, 283, 283)
                                                                .addComponent(computationLabel1)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(235, 235, 235)
                                                                .addComponent(computationLabel2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(asciiCodingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(13936, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(huffmanCodingLabel)
                                        .addComponent(asciiCodingLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(computationLabel1)
                                        .addComponent(computationLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(storageSavingsLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(418, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 15017, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );

        pack();
    }
}
