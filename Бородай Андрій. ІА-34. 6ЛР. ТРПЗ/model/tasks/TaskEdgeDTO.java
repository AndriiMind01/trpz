package org.example.model.tasks;

import org.example.model.tasks.TaskNode;

public record TaskEdgeDTO(
        String id,
        TaskNode from,
        TaskNode to,
        String description,
        String responsible
) {}