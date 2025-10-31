import java.util.ArrayList;
import java.util.List;

// 1. Інтерфейс Prototype (ЄДИНИЙ базовий тип)
interface GraphNodePrototype extends Cloneable {
    GraphNodePrototype clone();
    String getId();
    void setId(String id);
    void process();
    void addNeighbor(GraphNodePrototype neighbor);
    List<GraphNodePrototype> getNeighbors();
}