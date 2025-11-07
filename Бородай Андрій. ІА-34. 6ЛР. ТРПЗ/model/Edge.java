package org.example.model;

public abstract class Edge {
    protected String id;
    protected Node from;
    protected Node to;

    public Edge(String id, Node from, Node to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public abstract String getDetails();
}

