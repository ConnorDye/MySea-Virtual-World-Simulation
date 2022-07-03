//import processing.core.PImage;
//
//import java.util.List;
//import java.util.Random;
//
//public class Fish implements executeActivityAction{
//
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//    private int actionPeriod;
//
//    //private int resourceLimit;
//    //private int resourceCount;
//    //private int animationPeriod;
//
//    public static final Random rand = new Random();
//    public static final String CRAB_KEY = "crab";
//    public static final String CRAB_ID_SUFFIX = " -- crab";
//    public static final int CRAB_PERIOD_SCALE = 4;
//    public static final int CRAB_ANIMATION_MIN = 50;
//    public static final int CRAB_ANIMATION_MAX = 150;
//
//
//    //    public Fish(String id, Point position,int actionPeriod,
////                  List<PImage> images)
////    {
////        this.id = id;
////        this.position = position;
////        this.images = images;
////        this.imageIndex = 0;
////        //this.resourceLimit = resourceLimit;
////        //this.resourceCount = resourceCount;
////        this.actionPeriod = actionPeriod;
////        //this.animationPeriod = animationPeriod;
////    }
//    public Fish(String id, Point position,int actionPeriod,
//                List<PImage> images)
//    {
//        super(id, position,images, actionPeriod);
//    }
//
////    public static Fish createFish(String id, Point position, int actionPeriod,
////                                    List<PImage> images)
////    {
////        return new Fish(id, position, images, actionPeriod);
////    }
//
//    public void executeFishActivity(WorldModel world,
//                                    ImageStore imageStore, EventScheduler scheduler)
//    {
//        Point pos = this.position;  // store current position before removing
//
//        world.removeEntity( this);
//        scheduler.unscheduleAllEvents(this);
//
//        Crab2 crab = Crab2.createCrab(this.id + CRAB_ID_SUFFIX,
//                pos, this.actionPeriod / CRAB_PERIOD_SCALE,
//                CRAB_ANIMATION_MIN +
//                        rand.nextInt(CRAB_ANIMATION_MAX - CRAB_ANIMATION_MIN),
//                imageStore.getImageList(CRAB_KEY));
//
//        world.addEntity(crab);
//        crab.scheduleActions(scheduler, world, imageStore);
//    }
//
//    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
//        scheduler.scheduleEvent(this,
//                Activity.createActivityAction(this, world, imageStore),
//                this.actionPeriod);
//    }
//
//    public void nextImage()
//    {
//        this.imageIndex = (this.imageIndex + 1) % this.images.size();
//    }
//
//    public Point getPosition() {
//        return position;
//    }
//
//    public void setPosition(Point position) {
//        this.position = position;
//    }
//
//    public List<PImage> getImages() {
//        return images;
//    }
//
//    public void executeActivityAction(Activity action, EventScheduler scheduler) {
//        executeFishActivity(action.getWorld(), action.getImageStore(),scheduler);
//    }
//
////    public int getAnimationPeriod()
////    {
////        return this.animationPeriod;
////    }
//
////    public static PImage getCurrentImage(Object entity)
////    {
////        if (entity instanceof Background)
////        {
////            return ((Background)entity).getImages()
////                    .get(((Background)entity).getImageIndex());
////        }
////        else if (entity instanceof Entity)
////        {
////            return ((Entity)entity).getImages().get(((Entity)entity).getImageIndex());
////        }
////        else
////        {
////            throw new UnsupportedOperationException(
////                    String.format("getCurrentImage not supported for %s",
////                            entity));
////        }
////    }
//
//    public int getImageIndex() {
//        return imageIndex;
//    }
//
//
//
//    public int getActionPeriod() {
//        return actionPeriod;
//    }
//
//}
//
