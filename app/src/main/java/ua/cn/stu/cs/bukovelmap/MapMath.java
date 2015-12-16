package ua.cn.stu.cs.bukovelmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ua.cn.stu.cs.bukovelmap.Exceptions.PathNotFoundException;
import ua.cn.stu.cs.bukovelmap.data.NeighborNodeData;
import ua.cn.stu.cs.bukovelmap.data.NodeData;
import ua.cn.stu.cs.bukovelmap.data.Point;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class MapMath {

    private static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int PLANE_ANGLE = 180;
    private static final String PATH_NOT_FOUND = "Пути между точками не существует.";

    public static double convertToRadians(double x) {
        return (x * Math.PI) / PLANE_ANGLE;
    }

    public static double getDistanceBetweenTwoPoints(Point start, Point end) {
        double dLat = convertToRadians(end.latitude - start.latitude);
        double dLong = convertToRadians(end.longitude - start.longitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(convertToRadians(start.latitude))
                * Math.cos(convertToRadians(end.latitude))
                * Math.sin(dLong / 2) * Math.sin(dLong / 2);
        return EARTH_RADIUS_IN_METERS * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
    }

    public static double getPolylineDistance(Point[] points) {
        double distance = 0;
        for (int i = 0; i < (points.length - 1); i++){
            distance += getDistanceBetweenTwoPoints(points[i],points[i+1]);
        }
        return distance;
    }

    public static List<NodeData> getPath(NodeData start, NodeData end, int level)
            throws PathNotFoundException
    {
        List<NodeData> opened = new LinkedList<NodeData>();
        opened.add(start);
        List<NodeData> closed = new LinkedList<NodeData>();
        // 1 э-т - точка куда идем, а 2-й э-т  - точка откуда идем.
        // P.S. элементом является NodeData
        HashMap<NodeData,NodeData> fromMap = new HashMap<NodeData,NodeData>();
        HashMap<NodeData,Double> g = new HashMap<NodeData,Double>();
        HashMap<NodeData,Double> f = new HashMap<NodeData,Double>();
        double h = getHeuristicFunction(start,end,true);
        g.put(start, 0.0);
        f.put(start,g.get(start) + h);
        boolean found = false;
        while ((!opened.isEmpty())){
            NodeData cur = getNodeWithMinF(f,opened);
            if (cur == end){
                found = true;
                break;
            }
            opened.remove(cur);
            closed.add(cur);
            for(NeighborNodeData neighbor : cur.getNeighbors()){
                if (
                        (level < neighbor.getRoad().getLevel())
                        || (!neighbor.getRoad().isPassable())
                ){
                    continue;
                }
                if(closed.contains(neighbor.getNeighbor())){
                    continue;
                }
                double tempG = g.get(cur) + getDistance(cur,neighbor.getNeighbor(),false);
                if(
                        !opened.contains(neighbor.getNeighbor())
                        || isGOldIsGreater(g,neighbor.getNeighbor(),tempG))
                {
                    fromMap.put(neighbor.getNeighbor(),cur);
                    g.put(neighbor.getNeighbor(),tempG);
                    f.put(
                            neighbor.getNeighbor(),
                            tempG + getHeuristicFunction(neighbor.getNeighbor(),end,true)
                    );
                }
                if(!opened.contains(neighbor.getNeighbor())){
                    opened.add(neighbor.getNeighbor());
                }
            }
        }
        if (!found){
            throw new PathNotFoundException(PATH_NOT_FOUND);
        }
        List<NodeData> retVal = new LinkedList<NodeData>();
        NodeData cur = end;
        retVal.add(cur);
        do {
            retVal.add(fromMap.get(cur));
            cur = fromMap.get(cur);
        } while (cur != start);
        return retVal;
    }
    
    private static boolean isGOldIsGreater(
            HashMap<NodeData,Double> g,
            NodeData node,
            double tempG
    ){
        if (g.containsKey(node)){
           if(tempG < g.get(node)) return true;
        }
        return false;
    }

    private static NodeData getNodeWithMinF(HashMap<NodeData,Double> f, List<NodeData> opened){
        NodeData retVal = null;
        double min = Double.NEGATIVE_INFINITY;
        for (NodeData node : f.keySet()){
        	if (!opened.contains(node)){
        		continue;
        	}
            if ((min > f.get(node)) || (min == Double.NEGATIVE_INFINITY)){
                min = f.get(node);
                retVal = node;
            }
        }
        return  retVal;
    }

    private static double getHeuristicFunction(NodeData start, NodeData end, boolean isLinePath){
        return getDistance(start,end,isLinePath);
    }

    private static double getDistance(NodeData start, NodeData end, boolean isLinePath){
        double retVal = -1;
        if (isLinePath){
            retVal = getDistanceBetweenTwoPoints(start.getCoords(),end.getCoords());
        } else {
            for(NeighborNodeData neighbor : start.getNeighbors()){
                if (neighbor.getNeighbor() == end){
                    retVal = neighbor.getRoad().getDistance();
                }
            }
        }
        return retVal;
    }

}
