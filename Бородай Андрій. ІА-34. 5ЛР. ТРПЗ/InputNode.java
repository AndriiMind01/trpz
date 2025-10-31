import java.util.ArrayList;
import java.util.List;

class InputNode implements GraphNodePrototype {
    protected String id;
    protected List<GraphNodePrototype> neighbors;
    private String inputType;
    private double defaultValue;

    public InputNode(String id, String inputType, double defaultValue) {
        this.id = id;
        this.inputType = inputType;
        this.defaultValue = defaultValue;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public GraphNodePrototype clone() {
        InputNode clone = new InputNode(this.id + "_copy", this.inputType, this.defaultValue);
        cloneNeighbors(clone);
        return clone;
    }

    private void cloneNeighbors(InputNode clone) {
        for (GraphNodePrototype neighbor : this.neighbors) {
            clone.neighbors.add(neighbor.clone());
        }
    }

    @Override
    public void process() {
        System.out.println("InputNode " + id + ": Processing input type '" + inputType +
                "' with default value " + defaultValue);
        for (GraphNodePrototype neighbor : neighbors) {
            neighbor.process();
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

    public String getInputType() { return inputType; }
    public void setInputType(String inputType) { this.inputType = inputType; }
    public double getDefaultValue() { return defaultValue; }
    public void setDefaultValue(double defaultValue) { this.defaultValue = defaultValue; }

    @Override
    public String toString() {
        return "InputNode{id='" + id + "', inputType='" + inputType +
                "', defaultValue=" + defaultValue + ", neighbors=" + neighbors.size() + "}";
    }
}