//import processing.core.PImage;
//
//import java.util.List;
//
//public interface Entity {
//    public List<PImage> getImages();
//    public int getImageIndex();
//    public Point getPosition();
//    //    public void executeAnimationAction(Animation action, EventScheduler scheduler);
//    public void setPosition(Point position);
//    public static PImage getCurrentImage(Object entity) {
//        if (entity instanceof Background)
//        {
//            return ((Background)entity).getImages()
//                    .get(((Background)entity).getImageIndex());
//        }
//        else if (entity instanceof Entity)
//        {
//            return ((Entity)entity).getImages().get(((Entity)entity).getImageIndex());
//        }
//        else
//        {
//            throw new UnsupportedOperationException(
//                    String.format("getCurrentImage not supported for %s",
//                            entity));
//        }
//    }
//
//    //public void nextImage();
//
//    public int getActionPeriod();
//
//}
//
