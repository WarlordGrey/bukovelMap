package ua.cn.stu.cs.bukovelmap.data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class NodeData {
	
	private static int nextNodeName = 1;

    private Point coords;
    private List<NeighborNodeData> neighbors;
    private String name;

    public NodeData(Point coords) {
        this.coords = coords;
        this.name = String.valueOf(nextNodeName);
        nextNodeName++;
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
    
    public void setNeighbors(List<NeighborNodeData> neighbors){
    	this.neighbors = neighbors;
    }

	@Override
	public String toString() {
		return name;
	}

}
