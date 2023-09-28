/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

package Project2.GUI;

import Project2.GUI.UtilGUI.AddCoursePage;
import Project2.GUI.UtilGUI.EditCoursePage;
import Project2.GUI.UtilGUI.RoundButton;
import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents a GUI page for listing courses, providing functionality for
 *  adding, deleting, and editing courses.
 */
public class CourseListPage extends JPanel {
    private JLabel coursesLabel;
    private JTextField searchBar;
    private JList<Course<Term<Topic>>> listOfCourses;
    private RoundButton addButton, deleteButton, editButton;

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
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
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
     * Constructs a new CourseListPage with the given course list.
     *
     * @param courseList List of courses to be displayed.
     */
    public CourseListPage(DoublyLinkedList<Course<Term<Topic>>> courseList) {
        //changing courseList type to what is compatible to JList
        DefaultListModel<Course<Term<Topic>>> courseListModel = new DefaultListModel<>();
        for (int i = 0; i < courseList.getSize(); i++) {
            courseListModel.addElement(courseList.getElement(i));
        }

        //construct components
        coursesLabel = new JLabel("COURSES");
        searchBar = new JTextField( "Search...",4);
        searchBar.setForeground(Color.GRAY);
        listOfCourses = new JList(courseListModel);
        addButton = new RoundButton("Add");
        deleteButton = new RoundButton("Delete");
        editButton = new RoundButton("Edit");

        //adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        setBackground(royalBlue);
        coursesLabel.setFont(new Font("", Font.BOLD, 20));
        coursesLabel.setForeground(mustard);

        // Modify the term buttons' appearance
        buttonDesign(addButton);
        buttonDesign(deleteButton);
        buttonDesign(editButton);

        //set component bounds (only needed by Absolute Positioning)
        listOfCourses.setBounds(25, 60, 400, 330);
        listOfCourses.setBorder(BorderFactory.createLineBorder(mustard, 2));

        coursesLabel.setBounds(28, 14, 130, 35);
        searchBar.setBounds(245, 18, 180, 25);
        listOfCourses.setBounds(25, 60, 400, 330);
        
        addButton.setBounds(24, 406, 120, 35);
        editButton.setBounds(165, 406, 120, 35);
        deleteButton.setBounds(307, 406, 120, 35);

        //add components
        add(coursesLabel);
        add(searchBar);
        add(listOfCourses);
        add(addButton);
        add(editButton);
        add(deleteButton);
        add(editButton);

        //double click implementation
        listOfCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Double-click detected
                    Course selectedCourse = listOfCourses.getSelectedValue();
                    if (selectedCourse != null) {
                        openTermPage(selectedCourse);
                    }
                }
            }
        });

        listOfCourses.setCellRenderer(new CustomListCellRenderer());

        //add button implementation
        addButton.addActionListener(e -> {
            if (e.getSource() == addButton) {
                AddCoursePage addCoursePage = new AddCoursePage(courseListModel, courseList);
                addCoursePage.setVisible(true);
            }

        });

        // Action listener for Delete button
        deleteButton.addActionListener(e -> {
            int selectedIndex = listOfCourses.getSelectedIndex();
            if (selectedIndex >= 0) {
                Course selectedCourse = courseListModel.getElementAt(selectedIndex);
                int option = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete the selected course?",
                        "Delete Course", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        courseListModel.remove(selectedIndex);
                        courseList.delete(selectedCourse);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this,
                                "Error deleting course: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please select a course to delete.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for Edit button
        editButton.addActionListener(e -> {
            int selectedIndex = listOfCourses.getSelectedIndex();
            if (selectedIndex >= 0) {
                Course selectedCourse = courseListModel.getElementAt(selectedIndex);
                try {
                    EditCoursePage editCoursePage = new EditCoursePage(courseListModel, selectedCourse, selectedIndex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error editing course: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please select a course to edit.",
                        "Error", JOptionPane.ERROR_MESSAGE);
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

        DefaultListModel<Course<Term<Topic>>> filteredListModel = new DefaultListModel<>();
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = searchBar.getText().toLowerCase();
                // Clear the filtered list model
                filteredListModel.clear();

                if (searchText.isEmpty()) {
                    // If there's no search text, show the full original list
                    for (int i = 0; i < courseListModel.size(); i++) {
                        filteredListModel.addElement(courseListModel.get(i));
                    }
                } else {
                    // Filter and add matching items to the filtered list model
                    for (int i = 0; i < courseListModel.size(); i++) {
                        String listItem = courseListModel.get(i).toString().toLowerCase();
                        if (listItem.contains(searchText)) {
                            filteredListModel.addElement(courseListModel.get(i));
                        }
                    }
                }
                listOfCourses.setModel(filteredListModel);
            }
        });
    }

    /**
     * Opens the TermListPage for the given course.
     *
     * @param selectedCourse The course for which the term list page should be opened.
     */
    private void openTermPage(Course<Term<Topic>> selectedCourse) {
        JFrame frame = new JFrame(selectedCourse.getCourseName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new TermListPage(selectedCourse));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

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
                button.setBackground(mustard);
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

} // end of CourseListPage class