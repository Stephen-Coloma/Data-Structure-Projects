/**

 Group MixAndMatch
 Class Code and Course Number: 9342 - CS 211
 Schedule: TF 9:00 - 10:30 AM
 <p>
 COLOMA, Stephen M.- 2232847@slu.edu.ph
 GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 </p>
 */
package Prelims.Project2.GUI;

import Prelims.Project2.GUI.UtilGUI.AddTopicPage;
import Prelims.Project2.GUI.UtilGUI.EditTopicPage;
import Prelims.Project2.GUI.UtilGUI.RoundButton;
import Prelims.Project2.ReferenceClasses.Term;
import Prelims.Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Represents a GUI page for listing topics within a term. Provides
 *  functionalities for adding, deleting, and editing topics.
 */
public class TopicListPage extends JPanel {
    // Declare GUI components and data structures
    private JScrollPane scrollPane;
    private JLabel topicsLabel;
    private RoundButton addButton, deleteButton, editButton;
    private JTextField searchBar;
    private JList<Topic> topicsList;
    private Term<Topic> selectedTerm;

    //Declare static instances of the Color class representing colors used in the GUI of the program.
    static  Color mustard = new Color(255, 219, 87);
    static Color royalBlue = new Color(17, 41, 107);
    static Color flashWhite = new Color(237, 237, 237);
    static Color polynesianBlue = new Color(0, 80, 157);

    /**
     * Custom cell renderer for changing the background color of selected items
     * in the course list.
     */
    class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                c.setBackground(mustard);
            } else {
                c.setBackground(list.getBackground());
            }
            return c;
        }
    }


    /**
     * Constructs a new TopicListPage displaying topics for the given term.
     *
     * @param term The term whose topics are to be displayed.
     */
    public TopicListPage(Term<Topic> term) {
        // Construct components
        topicsLabel = new JLabel("TOPICS FOR " + term.getTermName().toUpperCase());
        topicsList = new JList<>(new DefaultListModel<>());
        selectedTerm = term;

        // Add topics to the list
        DefaultListModel<Topic> topicListModel = new DefaultListModel<>();
        for (int i = 0; i < term.getSize(); i++) {
            topicListModel.addElement(term.getElement(i));
        }

        topicsList = new JList<>(topicListModel);
        scrollPane = new JScrollPane(topicsList);
        searchBar = new JTextField("Search...", 5);
        addButton = new RoundButton("Add");
        editButton = new RoundButton("Edit");
        deleteButton = new RoundButton("Delete");

        // Adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        // Modify appearance
        setBackground(royalBlue);
        topicsLabel.setFont(new Font("", Font.BOLD, 16));
        topicsLabel.setForeground(mustard);

        // Modify buttons' appearance
        buttonDesign(addButton);
        buttonDesign(editButton);
        buttonDesign(deleteButton);

        //set component bounds (only needed by Absolute Positioning)
        topicsList.setBounds(25, 60, 400, 330);
        topicsList.setBorder(BorderFactory.createLineBorder(mustard, 2));

        // Add components
        topicsLabel.setBounds (30, 15, 200, 35);
        searchBar.setBounds (245, 20, 180, 25);
        scrollPane.setBounds (25, 60, 400, 330);

        addButton.setBounds(24, 406, 120, 35);
        editButton.setBounds(165, 406, 120, 35);
        deleteButton.setBounds(307, 406, 120, 35);

        add(topicsLabel);
        add(searchBar);
        add(scrollPane);
        add(addButton);
        add(editButton);
        add(deleteButton);

        // Double-click on list event
        topicsList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Double-click detected
                    Topic selectedTopic = topicsList.getSelectedValue();
                    if (selectedTopic != null) {
                        openModulesTasksPage(selectedTopic);
                    }
                }
            }
        });

        topicsList.setCellRenderer(new TopicListPage.CustomListCellRenderer());

        // Add button implementation
        addButton.addActionListener(e -> {
            try {
                AddTopicPage addTopicFrame = new AddTopicPage(selectedTerm, (DefaultListModel<Topic>) topicsList.getModel());
                addTopicFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TopicListPage.this, "Error adding topic: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Delete button implementation
        deleteButton.addActionListener(e -> {
            try {
                int selectedIndex = topicsList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Topic selectedTopic = topicListModel.getElementAt(selectedIndex);
                    int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected Topic?", "Delete Topic", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        topicListModel.remove(selectedIndex);
                        selectedTerm.delete(selectedTopic);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a course to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TopicListPage.this, "Error deleting topic: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Edit button implementation
        editButton.addActionListener(e -> {
            try {
                int selectedIndex = topicsList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Topic selectedTopic = topicListModel.getElementAt(selectedIndex);

                    EditTopicPage editTopicPage = new EditTopicPage(topicListModel, selectedTopic, selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a course to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(TopicListPage.this, "Error editing topic: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add a FocusListener to clear the text when focused
        searchBar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if ("Search...".equals(searchBar.getText())) {
                    searchBar.setText("");
                    searchBar.setForeground(Color.BLACK);
                }
                searchBar.setBorder(BorderFactory.createLineBorder(mustard, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Search...");
                    searchBar.setForeground(Color.GRAY);
                }
            }
        });

        // Search functionality
        DefaultListModel<Topic> filteredListModel = new DefaultListModel<>();
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String searchText = searchBar.getText().toLowerCase();
                    filteredListModel.clear();

                    if (searchText.isEmpty()) {
                        for (int i = 0; i < topicListModel.size(); i++) {
                            filteredListModel.addElement(topicListModel.get(i));
                        }
                    } else {
                        for (int i = 0; i < topicListModel.size(); i++) {
                            String listItem = topicListModel.get(i).toString().toLowerCase();
                            if (listItem.contains(searchText)) {
                                filteredListModel.addElement(topicListModel.get(i));
                            }
                        }
                    }
                    topicsList.setModel(filteredListModel);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TopicListPage.this, "Error filtering topics: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Opens the ModulesTasksPage for the given topic.
     *
     * @param topic The topic for which the ModulesTasksPage should be opened.
     */
    private void openModulesTasksPage(Topic topic) {
        JFrame frame = new JFrame("Modules and Tasks");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ModulesTasksPage(topic));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        //this is for opening many ModuleTaskPage. Closes the active frame when clicked outside the frame
        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                // Do nothing when the frame gains focus
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // Close the frame when it loses focus
                frame.dispose();
            }
        });
    } // end of openModulesTasksPage method

    /**
     * Applies a uniform design to the given button.
     *
     * @param button The button to be styled.
     */
    private void buttonDesign(RoundButton button) {
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(mustard, 2, false),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)));
        button.setBackground(flashWhite);
        button.setForeground(polynesianBlue);
        button.addMouseListener(new MouseAdapter() {

            /**
             * Invoked when the mouse cursor has been moved onto the button.
             * Changes the button's appearance to give visual feedback to the user.
             *
             * @param e The MouseEvent containing information about the mouse action.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(mustard, 2, false),
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(mustard); // Set a new color when mouse hovers over the button
                button.setForeground(polynesianBlue);
            } // end of mouseEntered method

            /**
             * Invoked when the mouse cursor has been moved out of the button.
             * Reverts the button's appearance to its default state.
             *
             * @param e The MouseEvent containing information about the mouse action.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(mustard, 2, false),
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(flashWhite);
                button.setForeground(polynesianBlue);
            } // end of mouseExited method
        });
    } // end of buttonDesign method

} // end of TopicListPage class