package collection;

import java.util.List;

import model.Station;

public class StationCollection
{
    private final List<Station> stations;

    private float minLatitude;
    private float maxLatitude;
    private float minLongitude;
    private float maxLongitude;

    public StationCollection(List<Station> stations)
    {
        this.stations = stations;
        this.minLatitude = Float.MAX_VALUE;
        this.maxLatitude = Float.MIN_VALUE;
        this.minLongitude = Float.MAX_VALUE;
        this.maxLongitude = Float.MIN_VALUE;
        processData();
    }

    public void setStations(List<Station> stations)
    {
        this.stations.clear();
        this.stations.addAll(stations);
        processData();
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public List<Station> getStations()
    {
        return stations;
    }

    public final void processData()
    {
        for (Station station : stations)
        {
            float latitude = station.getLocation().getLatitude();
            float longitude = station.getLocation().getLongitude();

            if (latitude < minLatitude) minLatitude = latitude;
            if (latitude > maxLatitude) maxLatitude = latitude;
            if (longitude < minLongitude) minLongitude = longitude;
            if (longitude > maxLongitude) maxLongitude = longitude;
        }
    }

    public float getMinLatitude()
    {
        return minLatitude;
    }

    public float getMaxLatitude()
    {
        return maxLatitude;
    }

    public float getMinLongitude()
    {
        return minLongitude;
    }

    public float getMaxLongitude()
    {
        return maxLongitude;
    }
}
