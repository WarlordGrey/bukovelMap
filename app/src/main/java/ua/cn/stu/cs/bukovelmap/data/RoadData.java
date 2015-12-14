package ua.cn.stu.cs.bukovelmap.data;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class RoadData {

    private boolean isWayDown = false;
    private ERoadLevel level;
    private double distance;

    public RoadData(boolean isWayDown, ERoadLevel level, double distance) {
        this.isWayDown = isWayDown;
        this.level = level;
        this.distance = distance;
    }

    public boolean isWayDown() {
        return isWayDown;
    }

    public void setWayDown(boolean isWayDown) {
        this.isWayDown = isWayDown;
    }

    public ERoadLevel getLevel() {
        return level;
    }

    public void setLevel(ERoadLevel level) {
        this.level = level;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
