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
 * The Term class represents a term or semester with a name and a list of topics.
 * @param <Topic> The type of topics that the term contains.
 */
public class Term<Topic> extends DoublyLinkedList<Topic> {
    /**
     * The name of the term or semester.
     */
    private String termName;

    /**
     * Constructs a new `Term` with the given term name.
     * @param termName The name of the term.
     */
    public Term(String termName) {
        this.termName = termName;
    }

    /**
     * Gets the name of the term.
     * @return The term name.
     */
    public String getTermName() {
        return termName;
    }

    /**
     * Sets the name of the term.
     * @param termName The new term name to set.
     */
    public void setTermName(String termName) {
        this.termName = termName;
    }

    /**
     * Returns a string representation of the term.
     * @return The term name as a string.
     */
    @Override
    public String toString() {
        return this.termName;
    }
}