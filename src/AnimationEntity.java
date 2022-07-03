import processing.core.PImage;

import java.util.List;

public abstract class AnimationEntity extends scheduleActivityAction implements executeAnimationAction {
    //Not all animation/action entites use resourceCount so those can be added on an individual basis
    protected int animationPeriod;
//    private PathingStrategy path;

    public AnimationEntity(String id, Point position,
                        List<PImage> images, int actionPeriod, int animationPeriod, PathingStrategy path)
    {
        super(id, position, images, actionPeriod);
        this.animationPeriod = animationPeriod;
//        this.path = path;


    }

    public AnimationEntity(String id, Point position,
                           List<PImage> images, int actionPeriod, int animationPeriod)
    {
        super(id, position, images, actionPeriod);
        this.animationPeriod = animationPeriod;
    } //constructor for entities who do not have a path

    public void executeAnimationAction(Animation action, EventScheduler scheduler){
        nextImage();

        if (action.getRepeatCount() != 1)
        {
            scheduler.scheduleEvent(this,
                    Animation.createAnimationAction(this,
                            Math.max(action.getRepeatCount() - 1, 0)),
                    this.animationPeriod);
        }
    }

    public int getAnimationPeriod()
    {
        return this.animationPeriod;
    }
    public void nextImage()
    {
        this.imageIndex = (this.imageIndex + 1) % this.images.size();
    }
}
