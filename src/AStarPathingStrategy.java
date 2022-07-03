import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AStarPathingStrategy
        implements PathingStrategy
{
    /*define closed list
          define open list
          while (true){
            Filtered list containing neighbors you can actually move to
            Check if any of the neighbors are beside the target
            set the g, h, f values
            add them to open list if not in open list
            add the selected node to close list
          return path*/

    public List<Point> computePath(Point start, Point end,
                                   Predicate<Point> canPassThrough,
                                   BiPredicate<Point, Point> withinReach,
                                   Function<Point, Stream<Point>> potentialNeighbors)
    {
        List<Point> path = new LinkedList<>();
        List<Point> closed = new LinkedList<>();
        List<Point> open = new LinkedList<>();

        //ADD START NODE (LEAVE F AT 0)
        start.gCost = 0;
        start.hCost = 0;
        start.fCost = 0;
        start.parent = null;
        open.add(start);
        Point currentPoint = open.get(0); //set current position of entity to start

        //int count = 0;
        while(!open.isEmpty()){
            //System.out.println("entered path");
            int index = 0;
            currentPoint = open.get(0);
            for(int i = 0; i < open.size(); i++) {

                //current = node in OPEN with lowest f_cost
                if (open.get(i).fCost() < currentPoint.fCost()
                        || open.get(i).fCost() == currentPoint.fCost() && open.get(i).hCost < currentPoint.hCost) {
                    currentPoint = open.get(i);
                    index = i;

                }
            }

            open.remove(index);                  //remove visited node and add to closed set
            closed.add(currentPoint);


            //for(Point finish: neighborInReach) {
                if (Point.adjacent(currentPoint, end)) { //return if our currentPoint == our destination as we have found our path
                    //System.out.println("End found and returning");
                    //path =
                    while(currentPoint.parent != null)
                    {
                        path.add(currentPoint);
                        currentPoint = currentPoint.parent;
                    }
                    Collections.reverse(path);
                    return path;
                    //return path;
                }

            //}

            List<Point> neighbors =  potentialNeighbors.apply(currentPoint)    //reevaluate neighbors for currentPoint
                    .filter(canPassThrough)
                    .filter(pt ->
                            !pt.equals(start) && !pt.equals(end))
                    .collect(Collectors.toList());


//            List<Point> neighborInReach = potentialNeighbors.apply(currentPoint).
//                    filter(pt ->withinReach.test(pt, end)).collect(Collectors.toList());

            //this marks a case where the end point is surrounded by entities and cannot be traversed over
//            if(!neighborInReach.isEmpty() && neighbors.isEmpty() || neighbors.isEmpty() || count == 50) {
//                System.out.println("break no path found");
//                //break;
//                return path;
//            }

            for(Point neighbor: neighbors){
                if(closed.contains(neighbor))
                    continue;

                neighbor.gCost = Point.gCost(currentPoint, neighbor);
                neighbor.hCost = Point.hCost(neighbor, end);
                neighbor.fCost = neighbor.gCost + neighbor.hCost;
                neighbor.parent = currentPoint;

                for(Point neighborInOpen: open){
                    if (neighbor.getX() == neighborInOpen.getX() && neighbor.getY() ==neighborInOpen.getY()
                            && neighbor.gCost > neighborInOpen.gCost){
                        continue;
                    }
                }
                if(!open.contains(neighbor))
                    open.add(neighbor);
            }

            if(currentPoint ==null) {
                break;
            }
            //count++;
        }
        return path;
    }


//    public int gCost(Point current, Point neighbor){
//        int gCost = current.gCost + manDistance(current, neighbor);
//        return gCost;
//    }
//
//    public int hCost(Point current, Point end){
//        int hCost = manDistance(current, end);
//        return hCost;
//    }
//
//    public int manDistance(Point current, Point neighbor){
//        int distX = Math.abs(current.getX() - neighbor.getX());
//        int distY = Math.abs(current.getY() - neighbor.getY());
//        int manDistance = distX + distY;
//        return manDistance;
//    }



    //calculates the distance to the end node from your current start node (takes into account diagnols)
//    public int getDistance(Point pointA, Point pointB){
//        int distX = Math.abs(pointA.getX() - pointB.getX());
//        int distY = Math.abs(pointA.getY() - pointB.getY());
//        if(distX > distY)
//            return 14*distY + 10 * (distX - distY);
//        else
//            return 14*distX + 10 * (distY - distX);
//    }
//
//    public List<Point> retracePath(Point start, Point end, List<Point> path){
//        Point current = end;
//        while (current != start && current.parent != null){ //added current.parent!=null vs. current!=null
//            path.add(current);
//            current = current.parent;       //parent is previous node
//        }
//        Collections.reverse(path);
//        //System.out.println(path);
//        return path;
//    }


}
