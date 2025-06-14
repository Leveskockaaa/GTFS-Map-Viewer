package dataimport.premodel;

import model.Coordinate;

public class Stop
{
    private final String id;
    private final String name;
    private final Coordinate location;

    public Stop(String id, String name, Coordinate location)
    {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Coordinate getLocation()
    {
        return location;
    }
}
