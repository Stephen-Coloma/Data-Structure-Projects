package Project2;

import Project2.GUI.CourseListPage;
import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;

public class GoogleClassroomApp extends JFrame {
    private static DoublyLinkedList<Course> courseList;
    public static void main(String[] args) {
        GoogleClassroomApp program = new GoogleClassroomApp();
        program.run();
    }

    private void run() {
        //initial population of Courses, Terms and Topics
        courseList = initialPopulation();
        this.setContentPane(new CourseListPage(courseList));
        this.setTitle("Course List Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private DoublyLinkedList<Course> initialPopulation() {
        //FOR THE FIRST COURSE:
        Course c1 = new Course<>("DATA STRUCTURES" , "9342 - CS 211");

        Term prelimsC1 = new Term<>("Prelims");
        Term midtermsC1 = new Term<>("Midterms");
        Term finalsC1 = new Term<>("Midterms");

        Topic topic1PrelimsC1 = new Topic("Abstract Data Types", "Explaining ADT");
        Topic topic2PrelimsC1 = new Topic("Algorithm Complexity", "Technical Paper");
        Topic topic3PrelimsC1 = new Topic("Big Oh Notation", "Big Oh Identification");
        Topic topic4PrelimsC1 = new Topic("The List Data Structure and ADT", "Project on Implementation of List ADT");
        Topic topic5PrelimsC1 = new Topic("Singly, Doubly, and Circular Linked List", "Describing LinkedList Implementation");

        Topic topic1MidtermsC1 = new Topic("The Stack and Queue Data Structures", "Task Name Here");
        Topic topic2MidtermsC1 = new Topic("The Stack and Queue ADT", "Task Name Here");
        Topic topic3MidtermsC1 = new Topic("Applications of the Queue", "Task Name Here");
        Topic topic4MidtermsC1 = new Topic("The Tree Data Structures", "Task Name Here");
        Topic topic5MidtermsC1 = new Topic("Huffman Coding - Application of the Tree Data Structure", "Task Name Here");

        Topic topic1FinalsC1 = new Topic("The Graph Data Structure", "Task Name Here");
        Topic topic2FinalsC1 = new Topic("Graph Representation", "Task Name Here");
        Topic topic3FinalsC1 = new Topic("Graph Search/Traversal", "Task Name Here");
        Topic topic4FinalsC1 = new Topic("Hash Function and Table", "Task Name Here");
        Topic topic5FinalsC1 = new Topic("Collision Handling", "Task Name Here");

        prelimsC1.insert(topic1PrelimsC1);
        prelimsC1.insert(topic2PrelimsC1);
        prelimsC1.insert(topic3PrelimsC1);
        prelimsC1.insert(topic4PrelimsC1);
        prelimsC1.insert(topic5PrelimsC1);

        midtermsC1.insert(topic1MidtermsC1);
        midtermsC1.insert(topic2MidtermsC1);
        midtermsC1.insert(topic3MidtermsC1);
        midtermsC1.insert(topic3MidtermsC1);
        midtermsC1.insert(topic3MidtermsC1);

        finalsC1.insert(topic1FinalsC1);
        finalsC1.insert(topic1FinalsC1);
        finalsC1.insert(topic1FinalsC1);
        finalsC1.insert(topic1FinalsC1);
        finalsC1.insert(topic1FinalsC1);

        //FOR THE SECOND COURSE:
        Course c2 = new Course<>("OPERATING SYSTEMS" , "9343 - CS 212");

        Topic topic1PrelimsC2 = new Topic("Introduction to Operating Systems", "Task Name Here");
        Topic topic2PrelimsC2 = new Topic("Process Management", "Task Name Here");
        Topic topic3PrelimsC2 = new Topic("Memory Management", "Task Name Here");
        Topic topic4PrelimsC2 = new Topic("File Systems and Storage Management", "Task Name Here");
        Topic topic5PrelimsC2 = new Topic("I/O Systems and Device Management", "Task Name Here");

        Topic topic1MidtermsC2 = new Topic("Process Synchronization", "Task Name Here");
        Topic topic2MidtermsC2 = new Topic("CPU Scheduling and Multiprogramming", "Task Name Here");
        Topic topic3MidtermsC2 = new Topic("Virtual Memory Management", "Task Name Here");
        Topic topic4MidtermsC2 = new Topic("File System Implementation", "Task Name Here");
        Topic topic5MidtermsC2 = new Topic("I/O Systems Optimization", "Task Name Here");

        Topic topic1FinalsC2 = new Topic("Process and Thread Management", "Task Name Here");
        Topic topic2FinalsC2 = new Topic("Memory Protection and Security", "Task Name Here");
        Topic topic3FinalsC2 = new Topic("Graph Search/Traversal", "Task Name Here");
        Topic topic4FinalsC2 = new Topic("Security and Authentication", "Task Name Here");
        Topic topic5FinalsC2 = new Topic("Virtualization and Cloud Computing", "Task Name Here");

        Term prelimsC2 = new Term<>("Prelims");
        Term midtermsC2 = new Term<>("Midterms");
        Term finalsC2 =  new Term<>("Midterms");

        prelimsC2.insert(topic1PrelimsC2);
        prelimsC2.insert(topic2PrelimsC2);
        prelimsC2.insert(topic3PrelimsC2);
        prelimsC2.insert(topic4PrelimsC2);
        prelimsC2.insert(topic5PrelimsC2);

        midtermsC2.insert(topic1MidtermsC2);
        midtermsC2.insert(topic2MidtermsC2);
        midtermsC2.insert(topic3MidtermsC2);
        midtermsC2.insert(topic3MidtermsC2);
        midtermsC2.insert(topic3MidtermsC2);

        finalsC2.insert(topic1FinalsC2);
        finalsC2.insert(topic1FinalsC2);
        finalsC2.insert(topic1FinalsC2);
        finalsC2.insert(topic1FinalsC2);
        finalsC2.insert(topic1FinalsC2);


        //FOR THE THIRD COURSE:
        Course c3 = new Course<>("HUMAN COMPUTER INTERACTION" , "9344 - CS 213");

        Topic topic1PrelimsC3 = new Topic("Introduction to Operating Systems", "Task Name Here");
        Topic topic2PrelimsC3 = new Topic("Process Management", "Task Name Here");
        Topic topic3PrelimsC3 = new Topic("Memory Management", "Task Name Here");
        Topic topic4PrelimsC3= new Topic("File Systems and Storage Management", "Task Name Here");
        Topic topic5PrelimsC3 = new Topic("I/O Systems and Device Management", "Task Name Here");

        Topic topic1MidtermsC3 = new Topic("Process Synchronization", "Task Name Here");
        Topic topic2MidtermsC3 = new Topic("CPU Scheduling and Multiprogramming", "Task Name Here");
        Topic topic3MidtermsC3 = new Topic("Virtual Memory Management", "Task Name Here");
        Topic topic4MidtermsC3 = new Topic("File System Implementation", "Task Name Here");
        Topic topic5MidtermsC3 = new Topic("I/O Systems Optimization", "Task Name Here");

        Topic topic1FinalsC3 = new Topic("Process and Thread Management", "Task Name Here");
        Topic topic2FinalsC3 = new Topic("Memory Protection and Security", "Task Name Here");
        Topic topic3FinalsC3 = new Topic("Graph Search/Traversal", "Task Name Here");
        Topic topic4FinalsC3 = new Topic("Security and Authentication", "Task Name Here");
        Topic topic5FinalsC3 = new Topic("Virtualization and Cloud Computing", "Task Name Here");

        Term prelimsC3 = new Term<>("Prelims");
        Term midtermsC3 = new Term<>("Midterms");
        Term finalsC3 =  new Term<>("Midterms");

        prelimsC3.insert(topic1PrelimsC3);
        prelimsC3.insert(topic2PrelimsC3);
        prelimsC3.insert(topic3PrelimsC3);
        prelimsC3.insert(topic4PrelimsC3);
        prelimsC3.insert(topic5PrelimsC3);

        midtermsC3.insert(topic1MidtermsC3);
        midtermsC3.insert(topic2MidtermsC3);
        midtermsC3.insert(topic3MidtermsC3);
        midtermsC3.insert(topic3MidtermsC3);
        midtermsC3.insert(topic3MidtermsC3);

        finalsC3.insert(topic1FinalsC3);
        finalsC3.insert(topic1FinalsC3);
        finalsC3.insert(topic1FinalsC3);
        finalsC3.insert(topic1FinalsC3);
        finalsC3.insert(topic1FinalsC3);

        //FOR THE FOURTH COURSE:
        Course c4 = new Course<>("SCIENCE, TECHNOLOGY AND SOCIETY" , "9345 - CS - GSTS");

        Topic topic1PrelimsC4 = new Topic("General Concepts and STS Historical Developments", "Task Name Here");
        Topic topic2PrelimsC4 = new Topic("Intellectual Revolutions that Defined Society", "Task Name Here");
        Topic topic3PrelimsC4 = new Topic("Science and Technology and Nation Building", "Task Name Here");
        Topic topic4PrelimsC4 = new Topic("The Human Person Flourishing in Science and Technology", "Task Name Here");

        Topic topic1MidtermsC4 = new Topic("STS and Human Condition: The GOod Life", "Task Name Here");
        Topic topic2MidtermsC4 = new Topic("When Technology and Humanity Cross", "Task Name Here");
        Topic topic3MidtermsC4 = new Topic("The Information Age", "Task Name Here");

        Topic topic1FinalsC4 = new Topic("Biodiversity and Health Society", "Task Name Here");
        Topic topic2FinalsC4 = new Topic("The Nanotechnology World", "Task Name Here");
        Topic topic3FinalsC4 = new Topic("Genetic Engineering", "Task Name Here");

        Term prelimsC4 = new Term<>("Prelims");
        Term midtermsC4 = new Term<>("Midterms");
        Term finalsC4 =  new Term<>("Midterms");

        prelimsC4.insert(topic1PrelimsC4);
        prelimsC4.insert(topic2PrelimsC4);
        prelimsC4.insert(topic3PrelimsC4);
        prelimsC4.insert(topic4PrelimsC4);

        midtermsC4.insert(topic1MidtermsC4);
        midtermsC4.insert(topic2MidtermsC4);
        midtermsC4.insert(topic3MidtermsC4);

        finalsC4.insert(topic1FinalsC4);
        finalsC4.insert(topic2FinalsC4);
        finalsC4.insert(topic3FinalsC4);


        //--------------------------------------------------
        DoublyLinkedList<Course> courseList = new DoublyLinkedList<>();
        courseList.insert(c1);
        courseList.insert(c2);
        courseList.insert(c3);

        return courseList;
    }
}
