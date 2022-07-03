import processing.core.PImage;

import java.util.List;

public abstract class ActiveEntity extends Entity implements executeActivityAction{
    //INSTANCE VARIABLES
    protected int actionPeriod;

    public ActiveEntity(String id, Point position,
                          List<PImage> images,  int actionPeriod)
    {
        super(id, position, images);
        this.actionPeriod = actionPeriod;

    }

    public int getActionPeriod() {
        return actionPeriod;
    }

}
