import processing.core.PImage;

import java.util.List;
//change from implements Entity
public class Obstacle extends Entity{

    public Obstacle(String id, Point position,
                          List<PImage> images)
    {
        super(id, position, images);
        //imageStore is 0 for all so we can set this in Entity abstract method

    }


//    public static Obstacle createObstacle(String id, Point position,
//                                        List<PImage> images)
//    {
//        return new Obstacle(id, position, images);
//    }

}
