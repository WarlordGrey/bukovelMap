package ua.cn.stu.cs.bukovelmap.data;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class NeighborNodeData {

    private NodeData neighbor;
    private RoadData road;

    public NeighborNodeData(RoadData road, NodeData neighbor) {
        this.road = road;
        this.neighbor = neighbor;
    }

    public NodeData getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(NodeData neighbor) {
        this.neighbor = neighbor;
    }

    public RoadData getRoad() {
        return road;
    }

    public void setRoad(RoadData road) {
        this.road = road;
    }

}
