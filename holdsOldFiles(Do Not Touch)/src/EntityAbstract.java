//import processing.core.PImage;
//
//import java.util.List;
//
//public abstract class EntityAbstract {
//    protected String id;
//    protected Point position;
//    protected List<PImage> images;
//    protected int imageIndex;
//
//    public EntityAbstract(String id, Point position,
//                    List<PImage> images)
//    {
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
//
//    }
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
//    public int getImageIndex() {
//        return imageIndex;
//    }
//
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
//}
