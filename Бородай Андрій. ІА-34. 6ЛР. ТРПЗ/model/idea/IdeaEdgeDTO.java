package org.example.model.idea;

import org.example.model.enums.EdgeShape;
import org.example.model.enums.EdgeType;

public record IdeaEdgeDTO(
        String id,
        IdeaNode from,
        IdeaNode to,
        EdgeType type,
        EdgeShape shape
) {}
