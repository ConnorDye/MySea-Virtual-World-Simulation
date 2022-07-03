import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class OctoFull extends OctoNextPosition{
    private int resourceLimit;
    private int resourceCount;
    //public static final PathingStrategy octoPath = new SingleStepPathingStrategy();

    public OctoFull(String id, Point position,
                    List<PImage> images, int resourceLimit, int resourceCount,
                    int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod);//, octoPath);
        this.resourceLimit = resourceLimit;
        this.resourceCount = resourceCount;

    }

//    public static OctoFull createOctoFull(String id, int resourceLimit,
//                                        Point position, int actionPeriod, int animationPeriod,
//                                        List<PImage> images)
//    {
//        return new OctoFull(id, position, images,
//                resourceLimit, resourceLimit, actionPeriod, animationPeriod);
//    }



    public boolean moveToFull(WorldModel world,
                              Entity target, EventScheduler scheduler)
    {
        if (Point.adjacent(this.position, target.getPosition()))
        {
            return true;
        }
        else
        {
            Point nextPos = this.nextPositionOcto(world, target.getPosition());

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

    public void transformFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore)
    {
        OctoNotFull octo = new OctoNotFull(this.id, this.position, this.images, this.resourceLimit,
                 this.resourceCount, this.actionPeriod, this.animationPeriod);


        world.removeEntity(this);
        scheduler.unscheduleAllEvents(this);

        world.addEntity(octo);
        octo.scheduleActions(scheduler, world, imageStore);
    }


    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this, Animation.createAnimationAction(this, 0),
                this.animationPeriod);
    }

    public void executeActivityAction(Activity action, EventScheduler scheduler) {
        Optional<Entity> fullTarget = action.getWorld().findNearest(this.position,
                Atlantis.class);


        if (fullTarget.isPresent() &&
                this.moveToFull(action.getWorld(), fullTarget.get(), scheduler))
        {
            //at atlantis trigger animationf
            ((AnimationEntity)fullTarget.get()).scheduleActions(scheduler, action.getWorld(), action.getImageStore());

            //transform to unfull
            this.transformFull(action.getWorld(), scheduler, action.getImageStore());
        }
        else
        {
            scheduler.scheduleEvent( this,
                    Activity.createActivityAction(this, action.getWorld(), action.getImageStore()),
                    this.actionPeriod);
        }
    }

    //    public void executeActivityAction(Activity action, EventScheduler scheduler) {
    //        executeOctoFullActivity(action.getWorld(), action.getImageStore(), scheduler);
    //    }

    //    public void executeOctoFullActivity(WorldModel world,
    //                                        ImageStore imageStore, EventScheduler scheduler)
    //    {
    //        Optional<Entity> fullTarget = world.findNearest(this.position,
    //                Atlantis.class);
    //
    //        if (fullTarget.isPresent() &&
    //                this.moveToFull(world, fullTarget.get(), scheduler))
    //        {
    //            //at atlantis trigger animationf
    //            ((AnimationEntity)fullTarget.get()).scheduleActions(scheduler, world, imageStore);
    //
    //            //transform to unfull
    //            this.transformFull(world, scheduler, imageStore);
    //        }
    //        else
    //        {
    //            scheduler.scheduleEvent( this,
    //                    Activity.createActivityAction(this, world, imageStore),
    //                    this.actionPeriod);
    //        }
    //    }




}
