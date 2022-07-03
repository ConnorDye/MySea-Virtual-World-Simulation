import processing.core.PImage;

import java.util.List;
import java.util.Random;

public class Fish extends scheduleActivityAction{

    public static final Random rand = new Random();
    public static final String CRAB_KEY = "crab";
    public static final String CRAB_ID_SUFFIX = " -- crab";
    public static final int CRAB_PERIOD_SCALE = 4;
    public static final int CRAB_ANIMATION_MIN = 50;
    public static final int CRAB_ANIMATION_MAX = 150;


    public Fish(String id, Point position,int actionPeriod,
                List<PImage> images)
    {
        super(id, position,images, actionPeriod);
    }

//    public static Fish createFish(String id, Point position, int actionPeriod,
//                                    List<PImage> images)
//    {
//        return new Fish(id, position, images, actionPeriod);
//    }

//    public void executeFishActivity(WorldModel world,
//                                    ImageStore imageStore, EventScheduler scheduler)
//    {
//        Point pos = this.position;  // store current position before removing
//
//        world.removeEntity( this);
//        scheduler.unscheduleAllEvents(this);
//
//        Crab2 crab = new Crab2(this.id + CRAB_ID_SUFFIX,
//                pos, imageStore.getImageList(CRAB_KEY), this.actionPeriod / CRAB_PERIOD_SCALE,
//                CRAB_ANIMATION_MIN +
//                        rand.nextInt(CRAB_ANIMATION_MAX - CRAB_ANIMATION_MIN));
//        //        Crab2 crab = Crab2.createCrab(this.id + CRAB_ID_SUFFIX,
//        //                pos, this.actionPeriod / CRAB_PERIOD_SCALE,
//        //                CRAB_ANIMATION_MIN +
//        //                        rand.nextInt(CRAB_ANIMATION_MAX - CRAB_ANIMATION_MIN),
//        //                imageStore.getImageList(CRAB_KEY));
//
//        world.addEntity(crab);
//        crab.scheduleActions(scheduler, world, imageStore);
//    }

    public void executeActivityAction(Activity action, EventScheduler scheduler) {
        //executeFishActivity(action.getWorld(), action.getImageStore(),scheduler); executeFishActivity combined
        Point pos = this.position;  // store current position before removing

        action.getWorld().removeEntity( this);
        scheduler.unscheduleAllEvents(this);

        Crab2 crab = new Crab2(this.id + CRAB_ID_SUFFIX,
                pos, action.getImageStore().getImageList(CRAB_KEY), this.actionPeriod / CRAB_PERIOD_SCALE,
                CRAB_ANIMATION_MIN +
                        rand.nextInt(CRAB_ANIMATION_MAX - CRAB_ANIMATION_MIN));

        action.getWorld().addEntity(crab);
        crab.scheduleActions(scheduler, action.getWorld(), action.getImageStore());
    }

}
