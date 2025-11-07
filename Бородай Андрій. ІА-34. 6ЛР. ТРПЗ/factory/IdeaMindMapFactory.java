package org.example.factory;

import org.example.model.idea.IdeaEdge;
import org.example.model.idea.IdeaEdgeDTO;
import org.example.model.idea.IdeaNode;
import org.example.model.idea.IdeaNodeDTO;

public class IdeaMindMapFactory implements MindMapFactory<IdeaNode, IdeaEdge, IdeaNodeDTO, IdeaEdgeDTO> {

    @Override
    public IdeaNode createNode(IdeaNodeDTO p) {
        return new IdeaNode(p.id(), p.x(), p.y(), p.title(), p.text(),
                p.shape(), p.color(), p.author());
    }

    @Override
    public IdeaEdge createEdge(IdeaEdgeDTO p) {
        return new IdeaEdge(p.id(), p.from(), p.to(), p.type(), p.shape());
    }
}
