import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public abstract class OctoNextPosition extends moveAbleEntites{
    //public Point nextPositionOcto(WorldModel world, Point destPos);
    public static final PathingStrategy octoPath = new AStarPathingStrategy();

    public OctoNextPosition(String id, Point position,List<PImage> images, int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod, animationPeriod, octoPath);
    }

    //Moved from each Octo
    public Point nextPositionOcto(WorldModel world, Point destPos)
    {
//        int horiz = Integer.signum(destPos.getX() - this.position.getX());
//        Point newPos = new Point(this.position.getX() + horiz,
//                this.position.getY());
//
//        if (horiz == 0 || world.isOccupied(newPos))
//        {
//            int vert = Integer.signum(destPos.getY() - this.position.getY());
//            newPos = new Point(this.position.getX(),
//                    this.position.getY() + vert);
//
//            if (vert == 0 || world.isOccupied(newPos))
//            {
//                newPos = this.position;
//            }
//        }
//
//        return newPos;
//        List<Point> nextPositionPath = octoPath.computePath(this.position, destPos, p ->
//                        world.withinBounds(p) && !checkOccupancy(world, p),
//                (p1, p2) -> neighbors(p1,p2), PathingStrategy.DIAGONAL_CARDINAL_NEIGHBORS);
        List<Point> nextPositionPath = octoPath.computePath(this.position, destPos, p ->
                        world.withinBounds(p) && !world.isOccupied(p),
                (p1, p2) -> neighbors(p1,p2), PathingStrategy.DIAGONAL_CARDINAL_NEIGHBORS);

        if (nextPositionPath.size() == 0){
            return this.getPosition();
        }
        else{
            return nextPositionPath.get(0);
        }
    }

    public boolean checkOccupancy(WorldModel world, Point newPos){
        Optional<Entity> occupant = world.getOccupant(newPos);
        return (occupant.isPresent() && !(occupant.get() instanceof Fish));
    }
}


