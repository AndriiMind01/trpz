package org.example.factory;

import org.example.model.Edge;
import org.example.model.Node;

public interface MindMapFactory<N extends Node, E extends Edge, NP, EP> {
    N createNode(NP params);
    E createEdge(EP params);
}