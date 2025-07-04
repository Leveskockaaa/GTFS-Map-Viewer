package dataimport.factory;

import java.util.ArrayList;
import java.util.List;

import model.Coordinate;
import model.Station;

public class StationFactory implements IComponentFactory
{
    private final List<Station> stations;

    public StationFactory()
    {
        stations = new ArrayList<>();
    }

    @Override
    public void processLine(String[] line)
    {
        String stationName = line[1];
        float latitude = Float.parseFloat(line[2]);
        float longitude = Float.parseFloat(line[3]);

        Coordinate location = new Coordinate(latitude, longitude);
        Station station = new Station(stationName, location, 0);
        stations.add(station);
    }

    public List<Station> getStations()
    {
        return stations;
    }
}
