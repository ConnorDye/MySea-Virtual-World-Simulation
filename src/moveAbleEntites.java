import processing.core.PImage;

import java.util.List;

public abstract class moveAbleEntites extends AnimationEntity {
    private PathingStrategy path;
    public moveAbleEntites(String id, Point position,
                           List<PImage> images, int actionPeriod, int animationPeriod, PathingStrategy path){
        super(id, position, images, actionPeriod, animationPeriod, path);
        this.path = path;
    }

    public static boolean neighbors(Point p1, Point p2)
    {
        return p1.getX()+1 == p2.getX() && p1.getY() == p2.getY() ||
                p1.getX()-1 == p2.getX() && p1.getY() == p2.getY() ||
                p1.getX() == p2.getX() && p1.getY()+1 == p2.getY() ||
                p1.getX() == p2.getX() && p1.getY()-1 == p2.getY();
    }
    public abstract boolean checkOccupancy(WorldModel world, Point newPos);
}
