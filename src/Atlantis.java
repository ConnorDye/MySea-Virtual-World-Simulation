import processing.core.PImage;

import java.util.List;

public class Atlantis extends AnimationEntity{

    public static final int ATLANTIS_ANIMATION_REPEAT_COUNT = 7;
    //NOT USED
    //private int resourceLimit;
    //private int resourceCount;

    public Atlantis(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount,
                    int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod);
        //this.resourceCount = resourceCount;
        //this.resourceLimit = resourceLimit;
    }

    public static Atlantis createAtlantis(String id, Point position,
                                        List<PImage> images)
    {
        return new Atlantis(id, position, images,
                0, 0, 0, 0);
    }

    //once you implement Entity this error will go away
//    public void executeAtlantisActivity(WorldModel world,
//                                        ImageStore imageStore, EventScheduler scheduler)
//    {
//        scheduler.unscheduleAllEvents(this);
//        world.removeEntity( this);
//    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore)
    {
        scheduler.scheduleEvent(this, Animation.createAnimationAction(this, ATLANTIS_ANIMATION_REPEAT_COUNT),
                        this.animationPeriod);

    }

    public void executeActivityAction(Activity action, EventScheduler scheduler) {
//        executeAtlantisActivity(action.getWorld(), action.getImageStore(), scheduler);
        scheduler.unscheduleAllEvents(this);
        action.getWorld().removeEntity( this);
    }
//    public void executeActivityAction(Activity action, EventScheduler scheduler) {
//        executeAtlantisActivity(action.getWorld(), action.getImageStore(), scheduler);
//
//    }

//    public void executeAnimationAction(Animation action, EventScheduler scheduler){
//        nextImage();
//
//        if (action.getRepeatCount() != 1)
//        {
//            scheduler.scheduleEvent(this,
//                    Animation.createAnimationAction(this,
//                            Math.max(action.getRepeatCount() - 1, 0)),
//                    this.animationPeriod);
//        }
//    }



}
