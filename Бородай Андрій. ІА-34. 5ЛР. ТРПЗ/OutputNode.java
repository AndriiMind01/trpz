import java.util.ArrayList;
import java.util.List;

class OutputNode implements GraphNodePrototype {
    protected String id;
    protected List<GraphNodePrototype> neighbors;
    private String outputFormat;
    private boolean enabled;

    public OutputNode(String id, String outputFormat, boolean enabled) {
        this.id = id;
        this.outputFormat = outputFormat;
        this.enabled = enabled;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public GraphNodePrototype clone() {
        OutputNode clone = new OutputNode(this.id + "_copy", this.outputFormat, this.enabled);
        cloneNeighbors(clone);
        return clone;
    }

    private void cloneNeighbors(OutputNode clone) {
        for (GraphNodePrototype neighbor : this.neighbors) {
            clone.neighbors.add(neighbor.clone());
        }
    }

    @Override
    public void process() {
        if (enabled) {
            System.out.println("OutputNode " + id + ": Outputting in format '" + outputFormat + "'");
        } else {
            System.out.println("OutputNode " + id + ": Disabled - no output");
        }
    }

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

    @Override
    public void addNeighbor(GraphNodePrototype neighbor) {
        if (neighbor != null && !neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    @Override
    public List<GraphNodePrototype> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

    public String getOutputFormat() { return outputFormat; }
    public void setOutputFormat(String outputFormat) { this.outputFormat = outputFormat; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    @Override
    public String toString() {
        return "OutputNode{id='" + id + "', outputFormat='" + outputFormat +
                "', enabled=" + enabled + ", neighbors=" + neighbors.size() + "}";
    }
}
