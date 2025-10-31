import java.util.ArrayList;
import java.util.List;

interface GraphNodePrototype extends Cloneable {
    GraphNodePrototype clone();
    String getId();
    void setId(String id);
    void process();
    void addNeighbor(GraphNodePrototype neighbor);
    List<GraphNodePrototype> getNeighbors();

}
