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

/**
 * The Topic class represents a topic or module with a name and a task description.
 */
public class Topic {
    /**
     * The name of the module or topic.
     */
    private String module;

    /**
     * The description of the task associated with the module.
     */
    private String task;

    /**
     * Constructs a new `Topic` with the given module and task.
     * @param module The name of the module or topic.
     * @param task   The description of the task associated with the module.
     */
    public Topic(String module, String task) {
        this.module = module;
        this.task = task;
    }

    /**
     * Gets the name of the module or topic.
     * @return The module name.
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets the name of the module or topic.
     * @param module The new module name to set.
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * Gets the task description associated with the module.
     * @return The task description.
     */
    public String getTask() {
        return task;
    }

    /**
     * Sets the task description associated with the module.
     * @param task The new task description to set.
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Returns a string representation of the module or topic.
     * @return The module name as a string.
     */
    @Override
    public String toString() {
        return module;
    }
}