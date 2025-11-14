package org.example.model;

import java.util.List;
import java.util.Map;

public class MentalMap {
    private String title;
    private List<Node> nodes;
    private List<Edge> edges;
    private Map<String, String> metadata;

    public MentalMap(String title, List<Node> nodes, List<Edge> edges, Map<String, String> metadata) {
        this.title = title;
        this.nodes = nodes;
        this.edges = edges;
        this.metadata = metadata;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}

