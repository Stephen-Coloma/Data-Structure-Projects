package Project2.GUI;

import Project2.GUI.UtilGUI.AddTopicPage;
import Project2.GUI.UtilGUI.EditTopicPage;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopicListPage extends JPanel {
    // Declare GUI components and data structures
    private JScrollPane scrollPane;
    private JLabel topicsLabel;
    private JButton addButton, deleteButton, editButton;
    private JTextField searchBar;
    private JList<Topic> topicsList;
    private Term<Topic> selectedTerm;

    // Custom cell renderer to change the background color of the selected item
    class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                c.setBackground(new Color(255, 219, 87));
            } else {
                c.setBackground(list.getBackground());
            }
            return c;
        }
    }

    public TopicListPage(Term<Topic> term) {

        // Construct components
        topicsLabel = new JLabel("TOPICS FOR" + term.getTermName());
        topicsList = new JList<>(new DefaultListModel<>());
        selectedTerm = term;

        // Add topics to the list
        DefaultListModel<Topic> topicListModel = new DefaultListModel<>();
        for (int i = 0; i < term.getSize(); i++) {
            topicListModel.addElement(term.getElement(i));
        }

        topicsList = new JList<>(topicListModel);
        scrollPane = new JScrollPane(topicsList);
        searchBar = new JTextField("Search", 5);
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        // Modify appearance
        setBackground(new Color(17, 41, 107));
        topicsLabel.setFont(new Font("", Font.BOLD, 20));
        topicsLabel.setForeground(new Color(255, 219, 87));

        Color buttonBgColor = new Color(237, 237, 237);

        // Modify buttons' appearance
        addButton.setFont(new Font("Roboto", Font.BOLD, 14));
        addButton.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
        addButton.setBackground(buttonBgColor);
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addButton.setBackground(new Color(255, 219, 87));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                addButton.setBackground(buttonBgColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                addButton.setBackground(buttonBgColor);
            }
        });

        editButton.setFont(new Font("Roboto", Font.BOLD, 14));
        editButton.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
        editButton.setBackground(buttonBgColor);
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                editButton.setBackground(new Color(255, 219, 87));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                editButton.setBackground(buttonBgColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                editButton.setBackground(buttonBgColor);
            }
        });

        deleteButton.setFont(new Font("Roboto", Font.BOLD, 14));
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
        deleteButton.setBackground(buttonBgColor);
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                deleteButton.setBackground(new Color(255, 219, 87));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                deleteButton.setBackground(buttonBgColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteButton.setBackground(buttonBgColor);
            }
        });

        //set component bounds (only needed by Absolute Positioning)
        topicsList.setBounds(25, 60, 400, 330);
        topicsList.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));

        // Add components
        topicsLabel.setBounds (30, 15, 130, 35);
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
                if ("Search".equals(searchBar.getText())) {
                    searchBar.setText("");
                }
                searchBar.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Search");
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

    // Open a new page for a selected topic
    private void openModulesTasksPage(Topic topic) {
        JFrame frame = new JFrame(topic.getModule()); // Use getModule to set the frame title
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the icon to the JFrame
        String iconPath = "D:\\cs211_9342_mixandmatch\\src\\Project2\\GUI\\Icons\\COURSE ICON.jpg";
        ImageIcon icon = new ImageIcon(iconPath);
        frame.setIconImage(icon.getImage());

        frame.getContentPane().add(new ModuleTaskPage(topic));
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
} // end of TopicListPage class