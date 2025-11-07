package org.example.model.tasks;

import org.example.model.Edge;
import org.example.model.Node;

public class TaskEdge extends Edge {
    private String description;
    private String responsiblePerson;

    public TaskEdge(String id, Node from, Node to, String description, String responsiblePerson) {
        super(id, from, to);
        this.description = description;
        this.responsiblePerson = responsiblePerson;
    }

    @Override
    public String getDetails() {
        return "TaskEdge[" + description + "] responsible=" + responsiblePerson;
    }
}