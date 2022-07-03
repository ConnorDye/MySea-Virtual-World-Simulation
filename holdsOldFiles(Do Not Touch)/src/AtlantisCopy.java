//import processing.core.PImage;
//
//import java.util.List;
//
//public class Atlantis implements GetAnimationPeriod, executeAnimationAction{
//
//    public static final int ATLANTIS_ANIMATION_REPEAT_COUNT = 7;
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//    private int resourceLimit;
//    private int resourceCount;
//    private int actionPeriod;
//    private int animationPeriod;
//
//
//    //Constructor for Atlantis
//    public Atlantis(String id, Point position,
//                    List<PImage> images, int resourceLimit, int resourceCount,
//                    int actionPeriod, int animationPeriod)
//    {
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
//        this.resourceLimit = resourceLimit;
//        this.resourceCount = resourceCount;
//        this.actionPeriod = actionPeriod;
//        this.animationPeriod = animationPeriod;
//    }
//
//    public static Atlantis createAtlantis(String id, Point position,
//                                          List<PImage> images)
//    {
//        return new Atlantis(id, position, images,
//                0, 0, 0, 0);
//    }
//
//    //once you implement Entity this error will go away
//    public void executeAtlantisActivity(WorldModel world,
//                                        ImageStore imageStore, EventScheduler scheduler)
//    {
//        scheduler.unscheduleAllEvents(this);
//        world.removeEntity( this);
//    }
//
//    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore)
//    {
//        scheduler.scheduleEvent(this, Animation.createAnimationAction(this, ATLANTIS_ANIMATION_REPEAT_COUNT),
//                this.animationPeriod);
//
//    }
//
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
//
//
//    public void executeActivityAction(Activity action, EventScheduler scheduler) {
//        executeAtlantisActivity(action.getWorld(), action.getImageStore(), scheduler);
//    }
//
//    public int getAnimationPeriod()
//    {
//        return this.animationPeriod;
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
//    public int getActionPeriod() {
//        return actionPeriod;
//    }
//}
