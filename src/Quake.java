import processing.core.PImage;

import java.util.List;

public class Quake extends AnimationEntity{
    //private int resourceLimit;
    //private int resourceCount;


    public static final String QUAKE_ID = "quake";
    public static final int QUAKE_ACTION_PERIOD = 1100;
    public static final int QUAKE_ANIMATION_PERIOD = 100;
    public static final int QUAKE_ANIMATION_REPEAT_COUNT = 10;


    public Quake(String id, Point position, List<PImage> images, int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod);
        //this.resourceLimit = resourceLimit;
        //this.resourceCount = resourceCount;
    }

//    public void executeQuakeActivity(WorldModel world,
//                                     ImageStore imageStore, EventScheduler scheduler)
//    {
//        scheduler.unscheduleAllEvents(this);
//        world.removeEntity( this);
//    }

    public static Quake createQuake(Point position, List<PImage> images)
    {
        return new Quake(QUAKE_ID, position, images, QUAKE_ACTION_PERIOD, QUAKE_ANIMATION_PERIOD);
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(this, QUAKE_ANIMATION_REPEAT_COUNT),
                this.animationPeriod);
    }


//    public void executeActivityAction(Activity action, EventScheduler scheduler) {
//        executeQuakeActivity(action.getWorld(), action.getImageStore(), scheduler);
//    }

    public void executeActivityAction(Activity action, EventScheduler scheduler) {
        //executeQuakeActivity(action.getWorld(), action.getImageStore(), scheduler);
        scheduler.unscheduleAllEvents(this);
        action.getWorld().removeEntity( this);
    }




}
