//import processing.core.PImage;
//
//import java.util.List;
//import java.util.Optional;
//
//public class Crab implements GetAnimationPeriod, executeAnimationAction{
//
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//    private int actionPeriod;
//    private int animationPeriod;
//    public static final String QUAKE_KEY = "quake";
//
//    public Crab(String id, Point position,
//                  int actionPeriod, int animationPeriod, List<PImage> images)
//    {
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
//        this.actionPeriod = actionPeriod;
//        this.animationPeriod = animationPeriod;
//    }
//
////    public void executeCrabActivity(WorldModel world,
////                                    ImageStore imageStore, EventScheduler scheduler)
////    {
//////        Optional<Entity> crabTarget = world.findNearest(
//////                this.position, EntityKind.SGRASS);
////        Optional<Entity> crabTarget = world.findNearest(
////                this.position, SGRASS.class);
////
////        long nextPeriod = this.actionPeriod;
////
////        if (crabTarget.isPresent())
////        {
////            Point tgtPos = crabTarget.get().getPosition();
//////            if (this.moveToCrab(world, crabTarget.get(), scheduler)) CAST TO SGRASS????
////            if (this.moveToCrab(world, crabTarget.get(), scheduler))
////            {
////                Quake quake = Quake.createQuake(tgtPos,
////                        imageStore.getImageList(QUAKE_KEY));
////
////                world.addEntity( quake);
////                nextPeriod += this.actionPeriod;
////                //scheduleActions(quake, scheduler, world, imageStore); REPLACE WITH
////                quake.scheduleActions(scheduler, world, imageStore);
////            }
////        }
////
////        scheduler.scheduleEvent( this,
////                Activity.createActivityAction(this, world, imageStore),
////                nextPeriod);
////    }
//
//    public void executeCrabActivity(WorldModel world,
//                                    ImageStore imageStore, EventScheduler scheduler)
//    {
//        Optional<Entity> crabTarget = world.findNearest(
//                this.position, SGRASS.class);
//        long nextPeriod = this.actionPeriod;
//
//        if (crabTarget.isPresent())
//        {
//            Point tgtPos = crabTarget.get().getPosition();
//
//            if (this.moveToCrab(world, crabTarget.get(), scheduler))
//            {
//                Quake quake = Quake.createQuake(tgtPos,
//                        imageStore.getImageList(QUAKE_KEY));
//
//                world.addEntity( quake);
//                nextPeriod += this.actionPeriod;
//                quake.scheduleActions(scheduler, world, imageStore);
//            }
//        }
//
//        scheduler.scheduleEvent( this,
//                Activity.createActivityAction(this, world, imageStore),
//                nextPeriod);
//    }
//
//    public static Crab createCrab(String id, Point position,
//                                    int actionPeriod, int animationPeriod, List<PImage> images)
//    {
//        return new Crab(id, position, actionPeriod, animationPeriod, images);
//    }
//
//
//
//
//    public boolean moveToCrab(WorldModel world, Entity target, EventScheduler scheduler)
//    {
//        if (Point.adjacent(this.position, target.getPosition()))
//        {
//            world.removeEntity( target);
//            scheduler.unscheduleAllEvents(target);
//            return true;
//        }
//        else
//        {
//            Point nextPos = this.nextPositionCrab(world, target.getPosition());
//
//            if (!this.position.equals(nextPos))
//            {
//                Optional<Entity> occupant = world.getOccupant(nextPos);
//                if (occupant.isPresent())
//                {
//                    scheduler.unscheduleAllEvents(occupant.get());
//                }
//
//                world.moveEntity( this, nextPos);
//            }
//            return false;
//        }
//    }
//
//    public Point nextPositionCrab(WorldModel world, Point destPos)
//    {
//        int horiz = Integer.signum(destPos.getX() - this.position.getX());
//        Point newPos = new Point(this.position.getX() + horiz,
//                this.position.getY());
//
//        Optional<Entity> occupant = world.getOccupant(newPos);
//
//        if (horiz == 0 ||
////                (occupant.isPresent() && !(occupant.get().kind == EntityKind.FISH)))
////                (occupant.isPresent() && !(occupant.get().getKind().equals("FISH"))))
//                (occupant.isPresent() && !(occupant.get() instanceof Fish)));
//        {
//            int vert = Integer.signum(destPos.getY() - this.position.getY());
//            newPos = new Point(this.position.getX(), this.position.getY() + vert);
//            occupant = world.getOccupant(newPos);
//
//            if (vert == 0 ||
////                    (occupant.isPresent() && !(occupant.get().kind == EntityKind.FISH)))
////                    (occupant.isPresent() && !(occupant.get().getKind().equals("FISH"))))
//                    (occupant.isPresent() && !(occupant.get() instanceof Fish)))
//            {
//                newPos = this.position;
//            }
//        }
//
//        return newPos;
//    }
//
//    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
//        scheduler.scheduleEvent( this,
//                Activity.createActivityAction(this, world, imageStore),
//                this.actionPeriod);
//        scheduler.scheduleEvent(this,
//                Animation.createAnimationAction(this, 0), this.animationPeriod);
//
//    }
//
////    private Action createActivityAction(WorldModel world, ImageStore imageStore){
////        return new Activity(this, world, imageStore, 0);
////    }
////
////    private Animation createAnimationAction(int repeatCount){
////        return new Animation(this, null, null, repeatCount);
////    };
//
//    public Point getPosition() {
//        return position;
//    }
//
//    public void nextImage()
//    {
//        this.imageIndex = (this.imageIndex + 1) % this.images.size();
//    }
//
//    public int getAnimationPeriod()
//    {
//        return this.animationPeriod;
//    }
//
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
//        executeCrabActivity(action.getWorld(), action.getImageStore(), scheduler);
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
////    public static PImage getCurrentImage(Object entity)
////   {
////      if (entity instanceof Background)
////      {
////         return ((Background)entity).getImages()
////            .get(((Background)entity).getImageIndex());
////      }
////      else if (entity instanceof Entity)
////      {
////         return ((Entity)entity).getImages().get(((Entity)entity).getImageIndex());
////      }
////      else
////      {
////         throw new UnsupportedOperationException(
////            String.format("getCurrentImage not supported for %s",
////            entity));
////      }
////   }
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
//}
