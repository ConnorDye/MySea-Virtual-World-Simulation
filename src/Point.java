final class Point
{
   private final int x;
   private final int y;

   //FOR A* ALGORITHM
   public int gCost;
   public int hCost;
   public int fCost;
   public Point parent = null;

   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public String toString()
   {
      return "(" + x + "," + y + ")";
   }

   public boolean equals(Object other)
   {
      return other instanceof Point &&
         ((Point)other).x == this.x &&
         ((Point)other).y == this.y;
   }

   public int hashCode()
   {
      int result = 17;
      result = result * 31 + x;
      result = result * 31 + y;
      return result;
   }

   public static boolean adjacent(Point p1, Point p2)
   {
      return (p1.x == p2.x && Math.abs(p1.y - p2.y) == 1) ||
              (p1.y == p2.y && Math.abs(p1.x - p2.x) == 1);
   }

   public static int distanceSquared(Point p1, Point p2)
   {
      int deltaX = p1.x - p2.x;
      int deltaY = p1.y - p2.y;

      return deltaX * deltaX + deltaY * deltaY;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }


   //FOR A* ALGORITHM
   public int fCost(){
      return gCost + hCost;
   }

   public static int gCost(Point current, Point neighbor){
      int gCost = current.gCost + Point.manDistance(current, neighbor);
      return gCost;
   }

   public static int hCost(Point current, Point end){
      int hCost = Point.manDistance(current, end);
      return hCost;
   }

   public static int manDistance(Point current, Point neighbor){
      int distX = Math.abs(current.getX() - neighbor.getX());
      int distY = Math.abs(current.getY() - neighbor.getY());
      int manDistance = distX + distY;
      return manDistance;
   }
}
