package org.example.model.tasks;

import java.util.List;

public record TaskNodeDTO(
        String id,
        double x,
        double y,
        String title,
        String text,
        List<String> files,
        String deadline,
        String category
) {}