package org.example.model.idea;

import org.example.model.Node;
import org.example.model.enums.IdeaShape;

public class IdeaNode extends Node {
    private IdeaShape shape;
    private String color;
    private String author;

    public IdeaNode(String id, double x, double y, String title, String text,
                    IdeaShape shape, String color, String author) {
        super(id, x, y, title, text);
        this.shape = shape;
        this.color = color;
        this.author = author;
    }

    @Override
    public String getDetails() {
        return "IdeaNode[" + title + "] by " + author + " (" + shape + ", " + color + ")";
    }
}
