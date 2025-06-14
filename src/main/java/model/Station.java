package model;

public class Station
{
    private String name;
    private Coordinate location;

    public Station(String name, Coordinate location)
    {
        this.name = name;
        this.location = location;
    }

    public String getName()
    {
        return name;
    }

    public Coordinate getLocation()
    {
        return location;
    }

    @Override
    public String toString()
    {
        return "Station[name=" + name + ", location=" + location + "]";
    }
}
