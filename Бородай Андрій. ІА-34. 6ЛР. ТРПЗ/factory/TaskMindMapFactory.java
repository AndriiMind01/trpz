package org.example.factory;

import org.example.model.tasks.TaskEdge;
import org.example.model.tasks.TaskEdgeDTO;
import org.example.model.tasks.TaskNode;
import org.example.model.tasks.TaskNodeDTO;

public class TaskMindMapFactory implements MindMapFactory<TaskNode, TaskEdge, TaskNodeDTO, TaskEdgeDTO> {

    @Override
    public TaskNode createNode(TaskNodeDTO p) {
        return new TaskNode(p.id(), p.x(), p.y(), p.title(), p.text(),
                p.files(), p.deadline(), p.category());
    }

    @Override
    public TaskEdge createEdge(TaskEdgeDTO p) {
        return new TaskEdge(p.id(), p.from(), p.to(), p.description(), p.responsible());
    }
}