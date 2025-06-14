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
    public void processLine(String line)
    {
        String[] parts = line.split(",");

        if (parts.length < 9)
        {
            System.out.println("Invalid station data: " + line);
            return;
        }

        String stationName = parts[1];
        float latitude = Float.parseFloat(parts[2]);
        float longitude = Float.parseFloat(parts[3]);
        int wheelchairBoarding = Integer.parseInt(parts[8]);

        Coordinate location = new Coordinate(latitude, longitude);
        Station station = new Station(stationName, location, wheelchairBoarding);
        stations.add(station);
    }

    public List<Station> getStations()
    {
        return stations;
    }
}
