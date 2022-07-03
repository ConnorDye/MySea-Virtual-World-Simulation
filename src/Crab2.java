import processing.core.PImage;

import java.util.List;
import java.util.Optional;


//public class Crab2 extends AnimationEntity
public class Crab2 extends moveAbleEntites{
    public static final String QUAKE_KEY = "quake";
    public static final PathingStrategy path = new AStarPathingStrategy();

    public Crab2(String id, Point position,
                 List<PImage> images,
                 int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod, path);
        //this.path = new SingleStepPathingStrategy(id, position, images, actionPeriod, animationPeriod);
    }


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

    public boolean moveToCrab(WorldModel world, Entity target, EventScheduler scheduler)
    {
        if (Point.adjacent(this.position, target.getPosition()))
        {
            world.removeEntity( target);
            scheduler.unscheduleAllEvents(target);
            return true;
        }
        else
        {
            Point nextPos = nextPositionCrab(world, target.getPosition()); //replaced with  //world.getOccupant(p) != world.findNearest(this.position, Obstacle.class) //world.isOccupied(p)
            //List<Point> nextPosition = path.computePath(this.position, target.getPosition(), p ->  world.withinBounds(p) && world.getOccupancyCell(p) != ((Object)Obstacle.class), (p1, p2) -> neighbors(p1,p2), PathingStrategy.CARDINAL_NEIGHBORS);
            //Point nextPos = nextPos1.get(0);

                if (!this.position.equals(nextPos)) {
                    Optional<Entity> occupant = world.getOccupant(nextPos);
                    if (occupant.isPresent()) {
                        scheduler.unscheduleAllEvents(occupant.get());
                    }

                    world.moveEntity(this, nextPos);
                }
                return false;

        }
    }

//    private static boolean neighbors(Point p1, Point p2)
//    {
//        return p1.getX()+1 == p2.getX() && p1.getY() == p2.getY() ||
//                p1.getX()-1 == p2.getX() && p1.getY() == p2.getY() ||
//                p1.getX() == p2.getX() && p1.getY()+1 == p2.getY() ||
//                p1.getX() == p2.getX() && p1.getY()-1 == p2.getY();
//    }

    public Point nextPositionCrab(WorldModel world, Point destPos)
    {
//        int horiz = Integer.signum(destPos.getX() - this.position.getX());
//        Point newPos = new Point(this.position.getX() + horiz,
//                this.position.getY());
//
//        Optional<Entity> occupant = world.getOccupant(newPos);
//
//        if (horiz == 0 ||
//                (occupant.isPresent() && !(occupant.get() instanceof Fish)))
//        {
//            int vert = Integer.signum(destPos.getY() - this.position.getY());
//            newPos = new Point(this.position.getX(), this.position.getY() + vert);
//            occupant = world.getOccupant(newPos);
//
//            if (vert == 0 ||
//                    (occupant.isPresent() && !(occupant.get() instanceof Fish)))
//            {
//                newPos = this.position;
//            }
//        }
//
//        return newPos;
        List<Point> nextPositionPath = path.computePath(this.position, destPos, p ->
                world.withinBounds(p) && !checkOccupancy(world, p),
                (p1, p2) -> neighbors(p1,p2), PathingStrategy.DIAGONAL_CARDINAL_NEIGHBORS);

        if (nextPositionPath.size() == 0){
            return this.getPosition();
        }
        else{
            return nextPositionPath.get(0);
        }


    } //

    public boolean checkOccupancy(WorldModel world, Point newPos){
        Optional<Entity> occupant = world.getOccupant(newPos);
        return (occupant.isPresent() && !(occupant.get() instanceof Fish));
    }

    //pass world & newPos check if occupant is present and not a fish
    public Point nextPositionCrabSingleStep(WorldModel world, Point destPos)
    {
        int horiz = Integer.signum(destPos.getX() - this.position.getX());
        Point newPos = new Point(this.position.getX() + horiz,
                this.position.getY());

        Optional<Entity> occupant = world.getOccupant(newPos);

        if (horiz == 0 ||
                (occupant.isPresent() && !(occupant.get() instanceof Fish)))
        {
            int vert = Integer.signum(destPos.getY() - this.position.getY());
            newPos = new Point(this.position.getX(), this.position.getY() + vert);
            occupant = world.getOccupant(newPos);

            if (vert == 0 ||
                    (occupant.isPresent() && !(occupant.get() instanceof Fish)))
            {
                newPos = this.position;
            }
        }

        return newPos;
    }

//    public Point nextPositionCrab(WorldModel world, Point destPos)
//    {
//        //SingleStepPathingStrategy s = new SingleStepPathingStrategy();
//        int horiz = Integer.signum(destPos.getX() - this.position.getX());
//        Point newPos = new Point(this.position.getX() + horiz,
//                this.position.getY());
//
//        Optional<Entity> occupant = world.getOccupant(newPos);
//
//        if (horiz == 0 ||
//                (occupant.isPresent() && !(occupant.get() instanceof Fish)))
//        {
//            int vert = Integer.signum(destPos.getY() - this.position.getY());
//            newPos = new Point(this.position.getX(), this.position.getY() + vert);
//            occupant = world.getOccupant(newPos);
//
//            if (vert == 0 ||
//                    (occupant.isPresent() && !(occupant.get() instanceof Fish)))
//            {
//                newPos = this.position;
//            }
//        }
//
//        return newPos;
//    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(this, 0), this.animationPeriod);
    }

//    public static Crab2 createCrab(String id, Point position,
//                                    int actionPeriod, int animationPeriod, List<PImage> images)
//    {
//        return new Crab2(id, position, images, actionPeriod, animationPeriod);
//    }

//    public void executeActivityAction(Activity action, EventScheduler scheduler) {
//        executeCrabActivity(action.getWorld(), action.getImageStore(), scheduler);
//    }

    public void executeActivityAction(Activity action, EventScheduler scheduler) {
        Optional<Entity> crabTarget = action.getWorld().findNearest(
                this.position, SGRASS.class);
        long nextPeriod = this.actionPeriod;

        if (crabTarget.isPresent())
        {
            Point tgtPos = crabTarget.get().getPosition();

            if (this.moveToCrab(action.getWorld(), crabTarget.get(), scheduler))
            {
                Quake quake = Quake.createQuake(tgtPos,
                        action.getImageStore().getImageList(QUAKE_KEY));

                action.getWorld().addEntity( quake);
                nextPeriod += this.actionPeriod;
                quake.scheduleActions(scheduler, action.getWorld(), action.getImageStore());
            }
        }

        scheduler.scheduleEvent( this,
                Activity.createActivityAction(this, action.getWorld(), action.getImageStore()),
                nextPeriod);
    }

//    public void executeAnimationAction(Animation action, EventScheduler scheduler){
//        nextImage();
//
//        if (action.getRepeatCount() != 1)
//        {
//            scheduler.scheduleEvent(this,
//                    Animation.createAnimationAction(this,
//                            Math.max(action.getRepeatCount() - 1, 0)),
//                    getAnimationPeriod());
//        }
//    }


}
