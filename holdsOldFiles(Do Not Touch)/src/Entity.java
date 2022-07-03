//import java.util.List;
//import java.util.Optional;
//
//import processing.core.PImage;
//
///*
//Entity ideally would includes functions for how all the entities in our virtual world might act...
// */
//
//
//final class Entity
//{
//   private EntityKind kind;
//   private String id;
//   private Point position;
//   private List<PImage> images;
//   private int imageIndex;
//   private int resourceLimit;
//   private int resourceCount;
//   private int actionPeriod;
//   private int animationPeriod;
//
//   public static final String QUAKE_ID = "quake";
//   public static final int QUAKE_ACTION_PERIOD = 1100;
//   public static final int QUAKE_ANIMATION_PERIOD = 100;
//   public static final String CRAB_KEY = "crab";
//   public static final String CRAB_ID_SUFFIX = " -- crab";
//   public static final int CRAB_PERIOD_SCALE = 4;
//   public static final int CRAB_ANIMATION_MIN = 50;
//   public static final int CRAB_ANIMATION_MAX = 150;
//
//   public static final String QUAKE_KEY = "quake";
//
//   public static final String FISH_ID_PREFIX = "fish -- ";
//   public static final int FISH_CORRUPT_MIN = 20000;
//   public static final int FISH_CORRUPT_MAX = 30000;
//   public static final int QUAKE_ANIMATION_REPEAT_COUNT = 10;
//   public static final int ATLANTIS_ANIMATION_REPEAT_COUNT = 7;
//
//
//   public Entity(EntityKind kind, String id, Point position,
//      List<PImage> images, int resourceLimit, int resourceCount,
//      int actionPeriod, int animationPeriod)
//   {
//      this.kind = kind;
//      this.id = id;
//      this.position = position;
//      this.images = images;
//      this.imageIndex = 0;
//      this.resourceLimit = resourceLimit;
//      this.resourceCount = resourceCount;
//      this.actionPeriod = actionPeriod;
//      this.animationPeriod = animationPeriod;
//   }
//
//   public int getActionPeriod() {
//      return actionPeriod;
//   }
//
//   public List<PImage> getImages() {
//      return images;
//   }
//
//   public EntityKind getKind() {
//      return kind;
//   }
//
//   public Point getPosition() {
//      return position;
//   }
//
//   public int getImageIndex() {
//      return imageIndex;
//   }
//
//   public void setPosition(Point position) {
//      this.position = position;
//   }
//
////   public static Entity createAtlantis(String id, Point position,
////                                       List<PImage> images)
////   {
////      return new Entity(EntityKind.ATLANTIS, id, position, images,
////              0, 0, 0, 0);
////   }
//
////   public static Entity createOctoFull(String id, int resourceLimit,
////                                       Point position, int actionPeriod, int animationPeriod,
////                                       List<PImage> images)
////   {
////      return new Entity(EntityKind.OCTO_FULL, id, position, images,
////              resourceLimit, resourceLimit, actionPeriod, animationPeriod);
////   }
//
////   public static Entity createOctoNotFull(String id, int resourceLimit,
////                                          Point position, int actionPeriod, int animationPeriod,
////                                          List<PImage> images)
////   {
////      return new Entity(EntityKind.OCTO_NOT_FULL, id, position, images,
////              resourceLimit, 0, actionPeriod, animationPeriod);
////   }
//
////   public static Entity createObstacle(String id, Point position,
////                                       List<PImage> images)
////   {
////      return new Entity(EntityKind.OBSTACLE, id, position, images,
////              0, 0, 0, 0);
////   }
//
////   public static Entity createFish(String id, Point position, int actionPeriod,
////                                   List<PImage> images)
////   {
////      return new Entity(EntityKind.FISH, id, position, images, 0, 0,
////              actionPeriod, 0);
////   }
//
////   public static Entity createCrab(String id, Point position,
////                                   int actionPeriod, int animationPeriod, List<PImage> images)
////   {
////      return new Entity(EntityKind.CRAB, id, position, images,
////              0, 0, actionPeriod, animationPeriod);
////   }
//
////   public static Entity createQuake(Point position, List<PImage> images)
////   {
////      return new Entity(EntityKind.QUAKE, QUAKE_ID, position, images,
////              0, 0, QUAKE_ACTION_PERIOD, QUAKE_ANIMATION_PERIOD);
////   }
//
////   public static Entity createSgrass(String id, Point position, int actionPeriod,
////                                     List<PImage> images)
////   {
////      return new Entity(EntityKind.SGRASS, id, position, images, 0, 0,
////              actionPeriod, 0);
////   }
//
//   public int getAnimationPeriod()
//   {
//      switch (this.kind)
//      {
//         case EntityKind.OCTO_FULL:
//         case EntityKind.OCTO_NOT_FULL:
//         case EntityKind.CRAB:
//         case EntityKind.QUAKE:
//         case EntityKind.ATLANTIS:
//            return this.animationPeriod;
//         default:
//            throw new UnsupportedOperationException(
//                    String.format("getAnimationPeriod not supported for %s",
//                            this.kind));
//      }
//   }
//
////   public void transformFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore)
////   {
////      Entity octo = OctoNotFull.createOctoNotFull(this.id, this.resourceLimit,
////              this.position, this.actionPeriod, this.animationPeriod,
////              this.images);
////
////      world.removeEntity(this);
////      scheduler.unscheduleAllEvents(this);
////
////      world.addEntity(octo);
////      Entity.scheduleActions(octo, scheduler, world, imageStore);
////   }
//
////   public boolean moveToNotFull(WorldModel world,
////                                       Entity target, EventScheduler scheduler)
////   {
////      if (Point.adjacent(this.position, target.position))
////      {
////         this.resourceCount += 1;
////         world.removeEntity(target);
////         scheduler.unscheduleAllEvents(target);
////
////         return true;
////      }
////      else
////      {
////         Point nextPos = nextPositionOcto(world, target.position);
////
////         if (!this.position.equals(nextPos))
////         {
////            Optional<Entity> occupant = world.getOccupant(nextPos);
////            if (occupant.isPresent())
////            {
////               scheduler.unscheduleAllEvents(occupant.get());
////            }
////
////            world.moveEntity(this, nextPos);
////         }
////         return false;
////      }
////   }
//
////   public boolean moveToFull(WorldModel world,
////                                    Entity target, EventScheduler scheduler)
////   {
////      if (Point.adjacent(this.position, target.position))
////      {
////         return true;
////      }
////      else
////      {
////         Point nextPos = nextPositionOcto(world, target.position);
////
////         if (!this.position.equals(nextPos))
////         {
////            Optional<Entity> occupant = world.getOccupant(nextPos);
////            if (occupant.isPresent())
////            {
////               scheduler.unscheduleAllEvents(occupant.get());
////            }
////
////            world.moveEntity(this, nextPos);
////         }
////         return false;
////      }
////   }
//
////   public boolean moveToCrab(WorldModel world, Entity target, EventScheduler scheduler)
////   {
////      if (Point.adjacent(this.position, target.position))
////      {
////         world.removeEntity( target);
////         scheduler.unscheduleAllEvents(target);
////         return true;
////      }
////      else
////      {
////         Point nextPos = nextPositionCrab(world, target.position);
////
////         if (!this.position.equals(nextPos))
////         {
////            Optional<Entity> occupant = world.getOccupant(nextPos);
////            if (occupant.isPresent())
////            {
////               scheduler.unscheduleAllEvents(occupant.get());
////            }
////
////            world.moveEntity( this, nextPos);
////         }
////         return false;
////      }
////   }
//
////   public void executeOctoFullActivity(WorldModel world,
////                                              ImageStore imageStore, EventScheduler scheduler)
////   {
////      Optional<Entity> fullTarget = world.findNearest(this.position,
////              EntityKind.ATLANTIS);
////
////      if (fullTarget.isPresent() &&
////              this.moveToFull(world, fullTarget.get(), scheduler))
////      {
////         //at atlantis trigger animation
////         Entity.scheduleActions(fullTarget.get(), scheduler, world, imageStore);
////
////         //transform to unfull
////         this.transformFull(world, scheduler, imageStore);
////      }
////      else
////      {
////         scheduler.scheduleEvent( this,
////                 Activity.createActivityAction(this, world, imageStore),
////                 this.actionPeriod);
////      }
////   }
//
////   public void executeOctoNotFullActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
////   {
////      Optional<Entity> notFullTarget = world.findNearest(this.position,
////              EntityKind.FISH);
////
////      if (!notFullTarget.isPresent() ||
////              !this.moveToNotFull(world, notFullTarget.get(), scheduler) ||
////              !transformNotFull(this, world, scheduler, imageStore))
////      {
////         scheduler.scheduleEvent( this,
////                 Activity.createActivityAction(this, world, imageStore),
////                 this.actionPeriod);
////      }
////   }
//
////   public void executeFishActivity(WorldModel world,
////                                          ImageStore imageStore, EventScheduler scheduler)
////   {
////      Point pos = this.position;  // store current position before removing
////
////      world.removeEntity( this);
////      scheduler.unscheduleAllEvents(this);
////
////      Entity crab = Entity.createCrab(this.id + CRAB_ID_SUFFIX,
////              pos, this.actionPeriod / CRAB_PERIOD_SCALE,
////              CRAB_ANIMATION_MIN +
////                      Functions.rand.nextInt(CRAB_ANIMATION_MAX - CRAB_ANIMATION_MIN),
////              imageStore.getImageList(CRAB_KEY));
////
////      world.addEntity(crab);
////      Entity.scheduleActions(crab, scheduler, world, imageStore);
////   }
//
////   public void executeCrabActivity(WorldModel world,
////                                          ImageStore imageStore, EventScheduler scheduler)
////   {
////      Optional<Entity> crabTarget = world.findNearest(
////              this.position, EntityKind.SGRASS);
////      long nextPeriod = this.actionPeriod;
////
////      if (crabTarget.isPresent())
////      {
////         Point tgtPos = crabTarget.get().position;
////
////         if (this.moveToCrab(world, crabTarget.get(), scheduler))
////         {
////            Entity quake = Entity.createQuake(tgtPos,
////                    imageStore.getImageList(QUAKE_KEY));
////
////            world.addEntity( quake);
////            nextPeriod += this.actionPeriod;
////            Entity.scheduleActions(quake, scheduler, world, imageStore);
////         }
////      }
////
////      scheduler.scheduleEvent( this,
////              Activity.createActivityAction(this, world, imageStore),
////              nextPeriod);
////   }
//
////   public void executeQuakeActivity(WorldModel world,
////                                           ImageStore imageStore, EventScheduler scheduler)
////   {
////      scheduler.unscheduleAllEvents(this);
////      world.removeEntity( this);
////   }
//
////   public void executeAtlantisActivity(WorldModel world,
////                                              ImageStore imageStore, EventScheduler scheduler)
////   {
////      scheduler.unscheduleAllEvents(this);
////      world.removeEntity( this);
////   }
//
////   public static void executeSgrassActivity(Entity entity, WorldModel world,
////                                            ImageStore imageStore, EventScheduler scheduler)
////   {
////      Optional<Point> openPt = world.findOpenAround(entity.position);
////
////      if (openPt.isPresent())
////      {
////         Entity fish = Entity.createFish(FISH_ID_PREFIX + entity.id,
////                 openPt.get(), FISH_CORRUPT_MIN +
////                         Functions.rand.nextInt(FISH_CORRUPT_MAX - FISH_CORRUPT_MIN),
////                 imageStore.getImageList(Functions.FISH_KEY));
////         world.addEntity( fish);
////         Entity.scheduleActions(fish, scheduler, world, imageStore);
////      }
////
////      scheduler.scheduleEvent(entity,
////              Activity.createActivityAction(entity, world, imageStore),
////              entity.actionPeriod);
////   }
//
//   public static void scheduleActions(Entity entity, EventScheduler scheduler,
//                                      WorldModel world, ImageStore imageStore)
//   {
//      switch (entity.kind)
//      {
//         case EntityKind.OCTO_FULL:
//            scheduler.scheduleEvent( entity,
//                    Activity.createActivityAction(entity, world, imageStore),
//                    entity.actionPeriod);
//            scheduler.scheduleEvent(entity, Animation.createAnimationAction(entity, 0),
//                    entity.getAnimationPeriod());
//            break;
//
//         case EntityKind.OCTO_NOT_FULL:
//            scheduler.scheduleEvent(entity,
//                    Activity.createActivityAction(entity, world, imageStore),
//                    entity.actionPeriod);
//            scheduler.scheduleEvent(entity,
//                    Animation.createAnimationAction(entity, 0), entity.getAnimationPeriod());
//            break;
//
//         case EntityKind.FISH:
//            scheduler.scheduleEvent(entity,
//                    Activity.createActivityAction(entity, world, imageStore),
//                    entity.actionPeriod);
//            break;
//
//         case EntityKind.CRAB:
//            scheduler.scheduleEvent( entity,
//                    Activity.createActivityAction(entity, world, imageStore),
//                    entity.actionPeriod);
//            scheduler.scheduleEvent(entity,
//                    Animation.createAnimationAction(entity, 0), entity.getAnimationPeriod());
//            break;
//
//         case EntityKind.QUAKE:
//            scheduler.scheduleEvent(entity,
//                    Activity.createActivityAction(entity, world, imageStore),
//                    entity.actionPeriod);
//            scheduler.scheduleEvent(entity,
//                    Animation.createAnimationAction(entity, QUAKE_ANIMATION_REPEAT_COUNT),
//                    entity.getAnimationPeriod());
//            break;
//
//         case EntityKind.SGRASS:
//            scheduler.scheduleEvent(entity,
//                    Activity.createActivityAction(entity, world, imageStore),
//                    entity.actionPeriod);
//            break;
//         case EntityKind.ATLANTIS:
//            scheduler.scheduleEvent(entity,
//                    Animation.createAnimationAction(entity, ATLANTIS_ANIMATION_REPEAT_COUNT),
//                    entity.getAnimationPeriod());
//            break;
//
//         default:
//      }
//   }
//
////   public static boolean transformNotFull(Entity entity, WorldModel world,
////                                          EventScheduler scheduler, ImageStore imageStore)
////   {
////      if (entity.resourceCount >= entity.resourceLimit)
////      {
////         Entity octo = Entity.createOctoFull(entity.id, entity.resourceLimit,
////                 entity.position, entity.actionPeriod, entity.animationPeriod,
////                 entity.images);
////
////         world.removeEntity( entity);
////         scheduler.unscheduleAllEvents(entity);
////
////         world.addEntity( octo);
////         Entity.scheduleActions(octo, scheduler, world, imageStore);
////
////         return true;
////      }
////
////      return false;
////   }
//
////   public Point nextPositionOcto(WorldModel world, Point destPos)
////   {
////      int horiz = Integer.signum(destPos.getX() - this.position.getX());
////      Point newPos = new Point(this.position.getX() + horiz,
////              this.position.getY());
////
////      if (horiz == 0 || world.isOccupied(newPos))
////      {
////         int vert = Integer.signum(destPos.getY() - this.position.getY());
////         newPos = new Point(this.position.getX(),
////                 this.position.getY() + vert);
////
////         if (vert == 0 || world.isOccupied(newPos))
////         {
////            newPos = this.position;
////         }
////      }
////
////      return newPos;
////   }
//
////   public Point nextPositionCrab(WorldModel world, Point destPos)
////   {
////      int horiz = Integer.signum(destPos.getX() - this.position.getX());
////      Point newPos = new Point(this.position.getX() + horiz,
////              this.position.getY());
////
////      Optional<Entity> occupant = world.getOccupant(newPos);
////
////      if (horiz == 0 ||
////              (occupant.isPresent() && !(occupant.get().kind == EntityKind.FISH)))
////      {
////         int vert = Integer.signum(destPos.getY() - this.position.getY());
////         newPos = new Point(this.position.getX(), this.position.getY() + vert);
////         occupant = world.getOccupant(newPos);
////
////         if (vert == 0 ||
////                 (occupant.isPresent() && !(occupant.get().kind == EntityKind.FISH)))
////         {
////            newPos = this.position;
////         }
////      }
////
////      return newPos;
////   }
//
//   public void nextImage()
//   {
//      this.imageIndex = (this.imageIndex + 1) % this.images.size();
//   }
//
//
//   public void executeActivityAction(Activity action,
//      EventScheduler scheduler)
//   {
//      switch (this.kind)
//      {
//      case EntityKind.OCTO_FULL:
//         executeOctoFullActivity(action.getWorld(),
//            action.getImageStore(), scheduler);
//         break;
//
//      case EntityKind.OCTO_NOT_FULL:
//         executeOctoNotFullActivity(action.getWorld(),
//            action.getImageStore(), scheduler);
//         break;
//
//      case EntityKind.FISH:
//         executeFishActivity(action.getWorld(), action.getImageStore(),
//            scheduler);
//         break;
//
//      case EntityKind.CRAB:
//         executeCrabActivity(action.getWorld(),
//            action.getImageStore(), scheduler);
//         break;
//
//      case EntityKind.QUAKE:
//         executeQuakeActivity(action.getWorld(), action.getImageStore(),
//            scheduler);
//         break;
//
//      case EntityKind.SGRASS:
//         executeSgrassActivity(this, action.getWorld(), action.getImageStore(),
//            scheduler);
//         break;
//
//      case EntityKind.ATLANTIS:
//         executeAtlantisActivity(action.getWorld(), action.getImageStore(),
//            scheduler);
//         break;
//
//      default:
//         throw new UnsupportedOperationException(
//            String.format("executeActivityAction not supported for %s",
//            this.kind));
//      }
//   }
//
//      public void executeAnimationAction(Animation action, EventScheduler scheduler){
//         nextImage();
//
//         if (action.getRepeatCount() != 1)
//         {
//            scheduler.scheduleEvent(this,
//               Animation.createAnimationAction(this,
//                  Math.max(action.getRepeatCount() - 1, 0)),
//               getAnimationPeriod());
//         }
//      }
//
//   public static PImage getCurrentImage(Object entity)
//   {
//      if (entity instanceof Background)
//      {
//         return ((Background)entity).getImages()
//                 .get(((Background)entity).getImageIndex());
//      }
//      else if (entity instanceof Entity)
//      {
//         return ((Entity)entity).getImages().get(((Entity)entity).getImageIndex());
//      }
//      else
//      {
//         throw new UnsupportedOperationException(
//                 String.format("getCurrentImage not supported for %s",
//                         entity));
//      }
//   }
//
//
//
//}
