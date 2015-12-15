package ua.cn.stu.cs.bukovelmap.data;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class RoadData {

    public static int ROAD_LEVEL_EASY = 0;
    public static int ROAD_LEVEL_MEDIUM = 1;
    public static int ROAD_LEVEL_HARD = 2;

    private boolean isPassable = false;
    private int level;
    private double distance;

    public RoadData(boolean isPassable, int level, double distance) {
        this.isPassable = isPassable;
        this.level = level;
        this.distance = distance;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean isWayDown) {
        this.isPassable = isWayDown;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
