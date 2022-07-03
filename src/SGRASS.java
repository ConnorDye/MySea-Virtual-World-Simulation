import processing.core.PImage;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SGRASS extends scheduleActivityAction{
    public static final String FISH_KEY = "fish";
    public static final Random rand = new Random();
    public static final String FISH_ID_PREFIX = "fish -- ";
    public static final int FISH_CORRUPT_MIN = 20000;
    public static final int FISH_CORRUPT_MAX = 30000;

    public SGRASS(String id, Point position, int actionPeriod, List<PImage> images){
        super(id, position,images, actionPeriod);
    }

//    public void executeSgrassActivity(WorldModel world,ImageStore imageStore, EventScheduler scheduler)
//    {
//        Optional<Point> openPt = world.findOpenAround(this.position);
//
//        if (openPt.isPresent())
//        {
//            Fish fish = new Fish(FISH_ID_PREFIX + this.id,
//                    openPt.get(), FISH_CORRUPT_MIN +
//                            rand.nextInt(FISH_CORRUPT_MAX - FISH_CORRUPT_MIN),
//                    imageStore.getImageList(FISH_KEY));
//            world.addEntity(fish);
//            fish.scheduleActions(scheduler, world, imageStore);
//
//        }
//
//        scheduler.scheduleEvent(this,
//                Activity.createActivityAction(this, world, imageStore),
//                this.actionPeriod);
//    }

    public void executeActivityAction(Activity action, EventScheduler scheduler){
        //executeSgrassActivity(action.getWorld(), action.getImageStore(), scheduler);
        Optional<Point> openPt = action.getWorld().findOpenAround(this.position);

        if (openPt.isPresent())
        {
            Fish fish = new Fish(FISH_ID_PREFIX + this.id,
                    openPt.get(), FISH_CORRUPT_MIN +
                    rand.nextInt(FISH_CORRUPT_MAX - FISH_CORRUPT_MIN),
                    action.getImageStore().getImageList(FISH_KEY));
            action.getWorld().addEntity(fish);
            fish.scheduleActions(scheduler, action.getWorld(), action.getImageStore());

        }

        scheduler.scheduleEvent(this,
                Activity.createActivityAction(this, action.getWorld(), action.getImageStore()),
                this.actionPeriod);
    }

//    public void executeActivityAction(Activity action, EventScheduler scheduler){
//        executeSgrassActivity(action.getWorld(), action.getImageStore(), scheduler);
//    }

//    public static SGRASS createSgrass(String id, Point position, int actionPeriod,
//                                      List<PImage> images)
//    {
//        return new SGRASS(id, position, images, actionPeriod);
//    }

}
