import java.util.ArrayList;
import java.util.List;

class ProcessingNode implements GraphNodePrototype {
    protected String id;
    protected List<GraphNodePrototype> neighbors;
    private String operation;
    private int processingTime;

    public ProcessingNode(String id, String operation, int processingTime) {
        this.id = id;
        this.operation = operation;
        this.processingTime = processingTime;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public GraphNodePrototype clone() {
        ProcessingNode clone = new ProcessingNode(this.id + "_copy", this.operation, this.processingTime);
        cloneNeighbors(clone);
        return clone;
    }

    private void cloneNeighbors(ProcessingNode clone) {
        for (GraphNodePrototype neighbor : this.neighbors) {
            clone.neighbors.add(neighbor.clone());
        }
    }

    @Override
    public void process() {
        System.out.println("ProcessingNode " + id + ": Executing operation '" + operation +
                "' for " + processingTime + "ms");
        try {
            Thread.sleep(processingTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

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

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
    public int getProcessingTime() { return processingTime; }
    public void setProcessingTime(int processingTime) { this.processingTime = processingTime; }

    @Override
    public String toString() {
        return "ProcessingNode{id='" + id + "', operation='" + operation +
                "', processingTime=" + processingTime + "ms, neighbors=" + neighbors.size() + "}";
    }
}
