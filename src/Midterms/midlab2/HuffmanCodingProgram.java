package Midterms.midlab2;

import Midterms.midlab2.GUI.HomePage;
import Midterms.midlab2.GUI.InputFilePage;
import Midterms.midlab2.GUI.ShowTreePage;
import Midterms.midlab2.GUI.StorageSavingsPage;
import javax.swing.*;

public class HuffmanCodingProgram extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JLabel PageLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton inputFileButton;
    private javax.swing.JButton textToHuffmanButton;
    private javax.swing.JButton huffmanToTextButton;
    private javax.swing.JButton storageSavingsButton;
    private javax.swing.JButton showTreeButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel headerPanel;

    /**
     * Creates new form HuffmanCodingProgram
     */
    public HuffmanCodingProgram() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        menuPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        inputFileButton = new javax.swing.JButton();
        textToHuffmanButton = new javax.swing.JButton();
        huffmanToTextButton = new javax.swing.JButton();
        storageSavingsButton = new javax.swing.JButton();
        showTreeButton = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        PageLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        HomePage homePage = new HomePage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPanel.setBackground(new java.awt.Color(17, 41, 107));
        menuPanel.setPreferredSize(new java.awt.Dimension(200, 524));
        menuPanel.setRequestFocusEnabled(false);

        homeButton.setBackground(new java.awt.Color(255, 219, 87));
        homeButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        homeButton.setText("  Home    ");
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeButtonMousePressed(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        inputFileButton.setBackground(new java.awt.Color(255, 219, 87));
        inputFileButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputFileButton.setText("Input File");
        inputFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputFileButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputFileButtonMousePressed(evt);
            }
        });
        inputFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFileButtonActionPerformed(evt);
            }
        });

        textToHuffmanButton.setBackground(new java.awt.Color(255, 219, 87));
        textToHuffmanButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textToHuffmanButton.setText("Text to Huffman Code");
        textToHuffmanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textToHuffmanButtonMousePressed(evt);
            }
        });
        textToHuffmanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textToHuffmanButtonActionPerformed(evt);
            }
        });

        huffmanToTextButton.setBackground(new java.awt.Color(255, 219, 87));
        huffmanToTextButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        huffmanToTextButton.setText("Huffman Code to Text");
        huffmanToTextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                huffmanToTextButtonMousePressed(evt);
            }
        });

        storageSavingsButton.setBackground(new java.awt.Color(255, 219, 87));
        storageSavingsButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        storageSavingsButton.setText("Storage Savings");
        storageSavingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storageSavingsButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                storageSavingsButtonMousePressed(evt);
            }
        });

        showTreeButton.setBackground(new java.awt.Color(255, 219, 87));
        showTreeButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        showTreeButton.setText("Show Tree");
        showTreeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTreeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showTreeButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textToHuffmanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(huffmanToTextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(storageSavingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(showTreeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(inputFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(textToHuffmanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(huffmanToTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(storageSavingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(showTreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(493, Short.MAX_VALUE))
        );

        headerPanel.setBackground(new java.awt.Color(255, 219, 87));
        headerPanel.setPreferredSize(new java.awt.Dimension(1720, 55));

        PageLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PageLabel.setText("HOME");
        PageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(394, 394, 394)
                                .addComponent(PageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(993, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        contentPanel.removeAll();
        contentPanel.add(homePage).setVisible(true);
        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void inputFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Handling code
    }

    private void textToHuffmanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Handling code
    }

    private void homeButtonMousePressed(java.awt.event.MouseEvent evt) {
        // Handling code
        PageLabel.setText("HOME");
    }

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // Handling code
        HomePage homePage = new HomePage();
        contentPanel.removeAll();
        contentPanel.add(homePage).setVisible(true);

    }

    private void inputFileButtonMousePressed(java.awt.event.MouseEvent evt) {
        // Handling code
        PageLabel.setText("INPUT FILE");
    }

    private void textToHuffmanButtonMousePressed(java.awt.event.MouseEvent evt) {
        // Handling code
        PageLabel.setText("TEXT TO HUFFMAN CODE CONVERTER");
    }

    private void huffmanToTextButtonMousePressed(java.awt.event.MouseEvent evt) {
        // Handling code
        PageLabel.setText("HUFFMAN CODE TO TEXT CONVERTER");
    }

    private void storageSavingsButtonMousePressed(java.awt.event.MouseEvent evt) {
        // Handling code
        PageLabel.setText("STORAGE SAVINGS");
    }

    private void showTreeButtonMousePressed(java.awt.event.MouseEvent evt) {
        // Handling code
        PageLabel.setText("HUFFMAN TREE");
    }

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Handling code
    }

    private void inputFileButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // Handling code
        InputFilePage inputFilePage = new InputFilePage();
        contentPanel.removeAll();
        contentPanel.add(inputFilePage).setVisible(true);
    }

    private void storageSavingsButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // Handling code
        StorageSavingsPage storageSavingsPage = new StorageSavingsPage();
        contentPanel.removeAll();
        contentPanel.add(storageSavingsPage).setVisible(true);
    }

    private void showTreeButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // Handling code
        ShowTreePage showTreePage = new ShowTreePage();
        contentPanel.removeAll();
        contentPanel.add(showTreePage).setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HuffmanCodingProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HuffmanCodingProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HuffmanCodingProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HuffmanCodingProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HuffmanCodingProgram myProgram = new HuffmanCodingProgram();
                myProgram.setVisible(true);
                myProgram.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }

}
