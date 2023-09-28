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
package Project2.ReferenceClasses;

import Project2.LinkedListImplementation.DoublyLinkedList;

/**
 * The Course class represents a course with a name, an ID, and a list of terms (semesters).
 * It extends the `DoublyLinkedList` class to manage its terms.
 * @param <Term> The type of terms (semesters) that the course contains.
 */
public class Course<Term> extends DoublyLinkedList<Term> {
    // Declare instance variables for the Course class
    /**
     * The name of the course.
     */
    private String courseName;

    /**
     * The unique identifier (ID) of the course.
     */
    private String courseID;

    /**
     * Constructs a new `Course` with the given course name and course ID.
     * @param courseName The name of the course.
     * @param courseID   The ID of the course.
     */
    public Course(String courseName, String courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }

    /**
     * Gets the course ID.
     *
     * @return The course ID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Sets the course ID.
     *
     * @param courseID The new course ID to set.
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the course name.
     * @return The course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     * @param courseName The new course name to set.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns a string representation of the course.
     * @return A string in the format "courseID (courseName)".
     */
    @Override
    public String toString(){
        return this.courseID + " (" + this.courseName + ")";
    }

    /**
     * Gets the term (semester) with the specified name.
     * @param termName The name of the term to retrieve.
     * @return The term with the specified name, or null if not found.
     */
    public Project2.ReferenceClasses.Term<Topic> getTerm(String termName) {
        for (int i = 0; i < getSize(); i++) {
            Project2.ReferenceClasses.Term<Topic> term = (Project2.ReferenceClasses.Term<Topic>) getElement(i);
            if (term.getTermName().equals(termName)) {
                return term;
            }
        }
        return null;
    }
}