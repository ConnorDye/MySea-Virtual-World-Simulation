import processing.core.PImage;

import java.util.List;
import java.util.Optional;
                        //extends AnimationEntity implements OctoNextPosition
public class OctoNotFull extends OctoNextPosition{
    private int resourceLimit;
    private int resourceCount;
    //public static final PathingStrategy octoNotPath = new SingleStepPathingStrategy();

    public OctoNotFull(String id, Point position,
                       List<PImage> images, int resourceLimit, int resourceCount,
                       int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod); //, octoNotPath);
        this.resourceLimit = resourceLimit;
        this.resourceCount = resourceCount;
    }

    public static OctoNotFull createOctoNotFull(String id, int resourceLimit,
                                           Point position, int actionPeriod, int animationPeriod,
                                           List<PImage> images)
    {
        return new OctoNotFull(id, position, images,
                resourceLimit, 0, actionPeriod, animationPeriod);
    }

//    public void executeOctoNotFullActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
//    {
//        Optional<Entity> notFullTarget = world.findNearest(this.position,
//                Fish.class);
//
//        if (!notFullTarget.isPresent() ||
//                !this.moveToNotFull(world, notFullTarget.get(), scheduler) ||
//                !this.transformNotFull(world, scheduler, imageStore))
//        {
//            scheduler.scheduleEvent( this,
//                    Activity.createActivityAction(this, world, imageStore),
//                    this.actionPeriod);
//        }
//    }

    public boolean transformNotFull(WorldModel world,
                                           EventScheduler scheduler, ImageStore imageStore)
    {
        if (this.resourceCount >= this.resourceLimit)
        {
            OctoFull octo = new OctoFull(this.id, this.position, this.images, this.resourceLimit,
                    this.resourceCount, this.actionPeriod, this.animationPeriod);

            world.removeEntity( this);
            scheduler.unscheduleAllEvents(this);

            world.addEntity( octo);
            //Entity.scheduleActions(octo, scheduler, world, imageStore); REPLACE WITH
            octo.scheduleActions(scheduler, world, imageStore);

            return true;
        }

        return false;
    }

//    public boolean transformNotFull(WorldModel world,
//                                    EventScheduler scheduler, ImageStore imageStore)
//    {
//        if (this.resourceCount >= this.resourceLimit)
//        {
//            OctoFull octo = OctoFull.createOctoFull(this.id, this.resourceLimit,
//                    this.position, this.actionPeriod, this.animationPeriod,
//                    this.images);
//
//            world.removeEntity( this);
//            scheduler.unscheduleAllEvents(this);
//
//            world.addEntity( octo);
//            //Entity.scheduleActions(octo, scheduler, world, imageStore); REPLACE WITH
//            octo.scheduleActions(scheduler, world, imageStore);
//
//            return true;
//        }
//
//        return false;
//    }




    public boolean moveToNotFull(WorldModel world,
                                 Entity target, EventScheduler scheduler)
    {
        if (Point.adjacent(this.position, target.getPosition()))
        {
            this.resourceCount += 1;
            world.removeEntity(target);
            scheduler.unscheduleAllEvents(target);

            return true;
        }
        else
        {
            Point nextPos = nextPositionOcto(world, target.getPosition());

            if (!this.position.equals(nextPos))
            {
                Optional<Entity> occupant = world.getOccupant(nextPos);
                if (occupant.isPresent())
                {
                    scheduler.unscheduleAllEvents(occupant.get());
                }

                world.moveEntity(this, nextPos);
            }
            return false;
        }
    }


//    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
//        scheduler.scheduleEvent(this,
//                Activity.createActivityAction(this, world, imageStore),
//                this.actionPeriod);
//        scheduler.scheduleEvent(this,
//                Animation.createAnimationAction(this, 0), this.animationPeriod);
//    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(this, 0), this.animationPeriod);
    }

    public void executeActivityAction(Activity action, EventScheduler scheduler) {
        //executeOctoNotFullActivity(action.getWorld(), action.getImageStore(), scheduler);
        Optional<Entity> notFullTarget = action.getWorld().findNearest(this.position,
                Fish.class);

        if (!notFullTarget.isPresent() ||
                !this.moveToNotFull(action.getWorld(), notFullTarget.get(), scheduler) ||
                !this.transformNotFull(action.getWorld(), scheduler, action.getImageStore()))
        {
            scheduler.scheduleEvent( this,
                    Activity.createActivityAction(this, action.getWorld(), action.getImageStore()),
                    this.actionPeriod);
        }
    }


}
