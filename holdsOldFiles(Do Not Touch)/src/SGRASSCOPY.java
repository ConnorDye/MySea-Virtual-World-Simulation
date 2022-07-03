//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//public class SGRASSCOPY {
//
//    import processing.core.PImage;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//    public class SGRASS implements executeActivityAction{
//        private String id;
//        private Point position;
//        private List<PImage> images;
//        private int imageIndex;
//        private int actionPeriod;
//        //NOT USED
//        //private int animationPeriod;
//        //private int resourceLimit;
//        //private int resourceCount;
//
//        public static final String FISH_KEY = "fish";
//        public static final Random rand = new Random();
//        public static final String FISH_ID_PREFIX = "fish -- ";
//        public static final int FISH_CORRUPT_MIN = 20000;
//        public static final int FISH_CORRUPT_MAX = 30000;
//
//        public SGRASS(String id, Point position, int actionPeriod, List<PImage> images)
//        {
//            this.id = id;
//            this.position = position;
//            this.images = images;
//            this.imageIndex = 0;
//            this.actionPeriod = actionPeriod;
//            //super(id, position, images, actionPeriod);
//
//
//            //this.animationPeriod = animationPeriod;
//            //this.resourceLimit = resourceLimit;
//            //this.resourceCount = resourceCount;
//        }
//
//        public void executeSgrassActivity(WorldModel world,ImageStore imageStore, EventScheduler scheduler)
//        {
//            Optional<Point> openPt = world.findOpenAround(this.position);
//
//            if (openPt.isPresent())
//            {
//                Fish fish = new Fish(FISH_ID_PREFIX + this.id,
//                        openPt.get(), FISH_CORRUPT_MIN +
//                        rand.nextInt(FISH_CORRUPT_MAX - FISH_CORRUPT_MIN),
//                        imageStore.getImageList(FISH_KEY));
//                world.addEntity( fish);
//                fish.scheduleActions(scheduler, world, imageStore);
//
//            }
//
//            scheduler.scheduleEvent(this,
//                    Activity.createActivityAction(this, world, imageStore),
//                    this.actionPeriod);
//        }
//
////    public static SGRASS createSgrass(String id, Point position, int actionPeriod,
////                                      List<PImage> images)
////    {
////        return new SGRASS(id, position, images, actionPeriod);
////    }
//
//        public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
//            scheduler.scheduleEvent(this,
//                    Activity.createActivityAction(this, world, imageStore),
//                    this.actionPeriod);
//        }
//
//        public void nextImage()
//        {
//            this.imageIndex = (this.imageIndex + 1) % this.images.size();
//        }
//
//        public Point getPosition() {
//            return this.position;
//        }
//
//        public void setPosition(Point position) {
//            this.position = position;
//        }
//
//        public List<PImage> getImages() {
//            return images;
//        }
//
//        public void executeActivityAction(Activity action, EventScheduler scheduler){
//            executeSgrassActivity(action.getWorld(), action.getImageStore(), scheduler);
//        }
//
//        public int getImageIndex() {
//            return imageIndex;
//        }
//
//
//        public int getActionPeriod() {
//            return actionPeriod;
//        }
//    }
//
//}
