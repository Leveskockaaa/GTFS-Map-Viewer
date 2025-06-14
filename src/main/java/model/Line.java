package model;

import java.util.List;

public class Line
{
    private String name;
    private Type type;
    private List<Station> stations;

    public Line(String name, Type type, List<Station> stations)
    {
        this.name = name;
        this.type = type;
        this.stations = stations;
    }

    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }

    public List<Station> getStations()
    {
        return stations;
    }

    @Override
    public String toString()
    {
        return "Line[name=" + name + ", type=" + type + ", stations=" + stations + "]";
    }
}
