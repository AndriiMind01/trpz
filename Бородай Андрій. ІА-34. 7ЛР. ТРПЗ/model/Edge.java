package org.example.model;

public class Edge {
    private String id;
    private String fromNodeId;
    private String toNodeId;
    private String label;
    private String color;
    private String style;

    public Edge(String fromNodeId, String toNodeId, String label, String color, String style) {
        this.fromNodeId = fromNodeId;
        this.toNodeId = toNodeId;
        this.label = label;
        this.color = color;
        this.style = style;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromNodeId() {
        return fromNodeId;
    }

    public void setFromNodeId(String fromNodeId) {
        this.fromNodeId = fromNodeId;
    }

    public String getToNodeId() {
        return toNodeId;
    }

    public void setToNodeId(String toNodeId) {
        this.toNodeId = toNodeId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
