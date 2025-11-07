package org.example.model.idea;

import org.example.model.Edge;
import org.example.model.Node;
import org.example.model.enums.EdgeShape;
import org.example.model.enums.EdgeType;

public class IdeaEdge extends Edge {
    private EdgeType type;
    private EdgeShape shape;

    public IdeaEdge(String id, Node from, Node to, EdgeType type, EdgeShape shape) {
        super(id, from, to);
        this.type = type;
        this.shape = shape;
    }

    @Override
    public String getDetails() {
        return "IdeaEdge[" + type + ", " + shape + "]";
    }
}
