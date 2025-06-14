package model;

public class Station
{
    private final String name;
    private final Coordinate location;
    private final int wheelchairBoarding;

    public Station(String name, Coordinate location, int wheelchairBoarding)
    {
        this.name = name;
        this.location = location;
        this.wheelchairBoarding = wheelchairBoarding;
    }

    public String getName()
    {
        return name;
    }

    public Coordinate getLocation()
    {
        return location;
    }

    public int getWheelchairBoarding()
    {
        return wheelchairBoarding;
    }

    @Override
    public String toString()
    {
        return "Station[name=" + name + ", location=" + location + "]";
    }
}
