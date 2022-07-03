import processing.core.PImage;

import java.util.List;

public class Lava extends Entity{
    public Lava(String id, Point position,
                    List<PImage> images)
    {
        super(id, position, images);
        //imageStore is 0 for all so we can set this in Entity abstract method

    }
}
