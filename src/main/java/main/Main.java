package main;

import java.util.List;

import collection.StationCollection;
import dataimport.reader.StationReader;
import model.Station;
import view.Converter;
import view.MapWindow;
import view.StationCollectionView;

public class Main
{
    public static void main(String[] args)
    {
        List<Station> stations;

        StationReader stationReader = new StationReader("src/main/resources/stops.txt");
        stationReader.readData();
        stations = stationReader.getStations();

        StationCollection stationCollection = new StationCollection();
        stationCollection.setStations(stations);

        int width = 1600;
        int height = 900;
        Converter.setBounds(stationCollection.getMinLatitude(), stationCollection.getMaxLatitude(), stationCollection.getMinLongitude(), stationCollection.getMaxLongitude());
        Converter.setDimensions(width, height);

        MapWindow mapWindow = new MapWindow(width, height);
        StationCollectionView stationCollectionView = new StationCollectionView(stationCollection);
        mapWindow.addPanel(stationCollectionView);
    }
}