import processing.core.PImage;

import java.util.List;

public class Blood extends Entity{
    public Blood(String id, Point position,
                    List<PImage> images)
    {
        super(id, position, images);
        //imageStore is 0 for all so we can set this in Entity abstract method

    }
}
