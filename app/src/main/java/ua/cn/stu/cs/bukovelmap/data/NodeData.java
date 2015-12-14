package ua.cn.stu.cs.bukovelmap.data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class NodeData {

    private Point coords;
    private List<NeighborNodeData> neighbors;

    public NodeData(Point coords) {
        this.coords = coords;
    }

    public Point getCoords() {
        return coords;
    }

    public void setCoords(Point coords) {
        this.coords = coords;
    }

    public List<NeighborNodeData> getNeighbors() {
        if (neighbors == null){
            neighbors = new LinkedList<NeighborNodeData>();
        }
        return neighbors;
    }

}
