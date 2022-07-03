/*
Action: ideally what our various entities might do in our virutal world
 */

interface Action
{
   public void executeAction(EventScheduler scheduler);


//   private ActionKind kind;
//   private Entity entity;
//   private WorldModel world;
//   private ImageStore imageStore;
//   private int repeatCount;


//   public Action(ActionKind kind, Entity entity, WorldModel world,
//      ImageStore imageStore, int repeatCount)
//   {
//      this.kind = kind;
//      this.entity = entity;
//      this.world = world;
//      this.imageStore = imageStore;
//      this.repeatCount = repeatCount;
//   }

//   public void executeAction(EventScheduler scheduler)
//   {
//      switch (this.kind)
//      {
//         case ACTIVITY:
//            executeActivityAction(scheduler);
//            break;
//
//         case ANIMATION:
//            executeAnimationAction(scheduler);
//            break;
//      }
//   }

//   public void executeAnimationAction(EventScheduler scheduler)
//   {
//      this.entity.nextImage();
//
//      if (this.repeatCount != 1)
//      {
//         scheduler.scheduleEvent(this.entity,
//                 createAnimationAction(this.entity,
//                         Math.max(this.repeatCount - 1, 0)),
//                 this.entity.getAnimationPeriod());
//      }
//   }

//   public void executeActivityAction(EventScheduler scheduler)
//   {
//      switch (this.entity.getKind())
//      {
//         case OCTO_FULL:
//            this.entity.executeOctoFullActivity(this.world,
//                    this.imageStore, scheduler);
//            break;
//
//         case OCTO_NOT_FULL:
//            this.entity.executeOctoNotFullActivity(this.world,
//                    this.imageStore, scheduler);
//            break;
//
//         case FISH:
//            this.entity.executeFishActivity(this.world, this.imageStore,
//                    scheduler);
//            break;
//
//         case CRAB:
//            this.entity.executeCrabActivity(this.world,
//                    this.imageStore, scheduler);
//            break;
//
//         case QUAKE:
//            this.entity.executeQuakeActivity(this.world, this.imageStore,
//                    scheduler);
//            break;
//
//         case SGRASS:
//            Entity.executeSgrassActivity(this.entity, this.world, this.imageStore,
//                    scheduler);
//            break;
//
//         case ATLANTIS:
//            this.entity.executeAtlantisActivity(this.world, this.imageStore,
//                    scheduler);
//            break;
//
//         default:
//            throw new UnsupportedOperationException(
//                    String.format("executeActivityAction not supported for %s",
//                            this.entity.getKind()));
//      }
//   }

//   public static Action createAnimationAction(Entity entity, int repeatCount)
//   {
//      return new Action(ActionKind.ANIMATION, entity, null, null, repeatCount);
//   }
//
//   public static Action createActivityAction(Entity entity, WorldModel world,
//                                             ImageStore imageStore)
//   {
//      return new Action(ActionKind.ACTIVITY, entity, world, imageStore, 0);
//   }

}
