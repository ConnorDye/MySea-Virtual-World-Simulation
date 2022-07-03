import processing.core.PImage;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Sailor extends moveAbleEntites{
    public static final PathingStrategy path = new AStarPathingStrategy();
    public int huntCount = 0; //holds the number of entities hunted
    public static final String BLOOD_KEY = "blood";
    public static final String SAILOR_ATLANTIS_KEY = "sailoratlantis";
    public static final String LAVA_KEY = "lava";

//    public Sailor(String id, Point position, extends Entity
//                  List<PImage> images)
//    {
//        super(id, position, images);
//        //System.out.println("Created");
//        //imageStore is 0 for all so we can set this in Entity abstract method
//
//    }

    public Sailor(String id, Point position,
                 List<PImage> images,
                 int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod, path);
        //this.path = new SingleStepPathingStrategy(id, position, images, actionPeriod, animationPeriod);
    }

    public Point nextPositionSailor(WorldModel world, Point destPos)
    {
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

    @Override
    public void executeActivityAction(Activity action, EventScheduler scheduler) {
        Random rand = new Random();
        int randomNumb = rand.nextInt(0, 3);
        Class target;


        if (randomNumb == 0 && action.getWorld().findNearest(this.position, Fish.class).isPresent())
            target = Fish.class;
        else if (randomNumb == 1  && action.getWorld().findNearest(this.position, OctoFull.class).isPresent())
            target = OctoFull.class;
        else if (randomNumb == 2 && action.getWorld().findNearest(this.position, Crab2.class).isPresent())
            target = Crab2.class;
        else
            target = OctoNotFull.class;

        Optional<Entity> sailorTarget = action.getWorld().findNearest(
                this.position, target);
        long nextPeriod = this.actionPeriod;

        if (sailorTarget.isPresent())
        {
            Point tgtPos = sailorTarget.get().getPosition();

            if(huntCount >= 5){
                moveToAtlantis(action.getWorld(), scheduler, action.getImageStore());
//                action.getWorld().removeEntity(this);
//                scheduler.unscheduleAllEvents(this);

//                System.out.println("Sailor is full");
            }
            else if (this.moveToSailor(action.getWorld(), sailorTarget.get(), scheduler, action.getImageStore()))
            {
//                Quake quake = Quake.createQuake(tgtPos,
//                        action.getImageStore().getImageList(QUAKE_KEY));
//
//                action.getWorld().addEntity( quake);
//                nextPeriod += this.actionPeriod;
//                quake.scheduleActions(scheduler, action.getWorld(), action.getImageStore());
//                  ADD BLOOD AFTER CRAB KILLED
//                System.out.println("True");
            }
        }


            scheduler.scheduleEvent(this,
                    Activity.createActivityAction(this, action.getWorld(), action.getImageStore()),
                    nextPeriod);

//        if(huntCount == 6){
//            action.getWorld().removeEntity(this);
//            scheduler.unscheduleAllEvents(this);
//        }


    }

    @Override
    public boolean checkOccupancy(WorldModel world, Point newPos) {
        Optional<Entity> occupant = world.getOccupant(newPos);
        return (occupant.isPresent() && !(occupant.get() instanceof Fish));
    }

    public boolean moveToSailor(WorldModel world, Entity target, EventScheduler scheduler, ImageStore imageStore)
    {
        //KILL THE CRAB IF IT'S ADJACENT AND PUT BLOOD IN WATER
        if (Point.adjacent(this.position, target.getPosition()))
        {
            Blood blood = new Blood("Blood", target.getPosition(), imageStore.getImageList(BLOOD_KEY));
            world.removeEntity( target);
            scheduler.unscheduleAllEvents(target);
            world.tryAddEntity(blood);
            huntCount = huntCount + 1;
//            System.out.println("Huntcount is " + huntCount);
            return true;
        }
        else
        {
            Point nextPos = nextPositionSailor(world, target.getPosition()); //replaced with  //world.getOccupant(p) != world.findNearest(this.position, Obstacle.class) //world.isOccupied(p)
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

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(this, 0), this.animationPeriod);
    }

    public boolean moveToAtlantis(WorldModel world, EventScheduler scheduler, ImageStore imageStore)
    {
        Optional<Entity> fullTarget = world.findNearest(this.position,
                Atlantis.class);

        if (fullTarget.isPresent() && Point.adjacent(this.position, fullTarget.get().position))
        {
            //SAILOR WILL ANIMATE ATLANTIS AND TRANSFORM IT TO SAILOR ATLANTIS
            ((AnimationEntity)fullTarget.get()).scheduleActions(scheduler, world, imageStore);
//            SailorAtlantis conqueredAtl = SailorAtlantis.createSailorAtlantis("sailoratlantis", fullTarget.get().getPosition(),
//                    imageStore.getImageList(SAILOR_ATLANTIS_KEY));
            Atlantis conqueredAtl = Atlantis.createAtlantis("sailoratlantis", fullTarget.get().getPosition(),
                    imageStore.getImageList(SAILOR_ATLANTIS_KEY));
            world.removeEntity(fullTarget.get());
            scheduler.unscheduleAllEvents(fullTarget.get());
            world.tryAddEntity(conqueredAtl);
            conqueredAtl.scheduleActions(scheduler, world, imageStore);
            huntCount = 0;

          // Point position = this.getPosition();
//            scheduler.unscheduleAllEvents(this);
//            world.removeEntity(this);
            //scheduler.unscheduleAllEvents(this);
            //world.removeEntity(this);


            //world.addEntity(new Lava("Lava", position,imageStore.getImageList(LAVA_KEY)));
//            System.out.println("Atlantis Antimation");
//            huntCount = 0;
            return true;
            //transform to unfull

        }
        else
        {
            Point nextPos = nextPositionSailor(world, fullTarget.get().position);
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

}
