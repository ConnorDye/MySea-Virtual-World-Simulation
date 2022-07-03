import processing.core.PImage;

import java.util.List;

public abstract class scheduleActivityAction extends ActiveEntity{
    public scheduleActivityAction(String id, Point position,
                        List<PImage> images, int actionPeriod)
    {
        super(id, position, images, actionPeriod);
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        scheduler.scheduleEvent((Entity) this,
                Activity.createActivityAction((Entity)this, world, imageStore),
                this.actionPeriod);
    }
}
