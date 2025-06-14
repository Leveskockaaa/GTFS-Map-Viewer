package dataimport.reader;

import java.util.List;

import dataimport.factory.StationFactory;
import model.Station;

public class StationReader extends GTFSReader
{
    private final StationFactory stationFactory;

    public StationReader(String filePath)
    {
        super(filePath);
        stationFactory = new StationFactory();
        super.setComponentFactory(stationFactory);
    }
    
    public List<Station> getStations()
    {
        return stationFactory.getStations();
    }
}
