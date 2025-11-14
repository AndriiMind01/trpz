package org.example.model;

import java.util.Map;

public class Node {
    private String id;
    private String content;
    private double x, y;
    private String color;
    private String shape;
    private Map<String, String> properties;

    public Node(String id, String content, double x, double y, String color, String shape, Map<String, String> properties) {
        this.id = id;
        this.content = content;
        this.x = x;
        this.y = y;
        this.color = color;
        this.shape = shape;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}