package org.example.model.idea;

import org.example.model.enums.IdeaShape;

public record IdeaNodeDTO(
        String id,
        double x,
        double y,
        String title,
        String text,
        IdeaShape shape,
        String color,
        String author
) {}
