package org.example.model.tasks;

import org.example.model.Node;

import java.util.List;

public class TaskNode extends Node {
    private List<String> attachedFiles;
    private String deadline;
    private String category;

    public TaskNode(String id, double x, double y, String title, String text,
                    List<String> attachedFiles, String deadline, String category) {
        super(id, x, y, title, text);
        this.attachedFiles = attachedFiles;
        this.deadline = deadline;
        this.category = category;
    }

    @Override
    public String getDetails() {
        return "TaskNode[" + title + "] category=" + category + ", deadline=" + deadline;
    }
}
