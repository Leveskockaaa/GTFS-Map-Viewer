package view;

import model.Station;

public class StationView
{
    private Station station;
    private Position position;

    public StationView(Station station)
    {
        this.station = station;
        this.position = Converter.convertCoordinatePosition(station.getLocation());
    }

    public int getX()
    {
        return position.getX();
    }

    public int getY()
    {
        return position.getY();
    }
}
