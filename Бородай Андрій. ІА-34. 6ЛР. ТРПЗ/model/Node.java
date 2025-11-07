package org.example.model;

public abstract class Node {
    protected String id;
    protected double x;
    protected double y;
    protected String title;
    protected String text;

    public Node(String id, double x, double y, String title, String text) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.title = title;
        this.text = text;
    }

    public abstract String getDetails();
}