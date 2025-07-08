package main;

import java.util.List;

import collection.ShapeCollection;
import collection.StationCollection;
import dataimport.reader.ShapeReader;
import dataimport.reader.StationReader;
import model.Shape;
import model.Station;
import view.Converter;
import view.MapWindow;
import view.ShapeCollectionView;
import view.StationCollectionView;

public class Main
{
    public static void main(String[] args)
    {
        List<Station> stations;

        StationReader stationReader = new StationReader("src/main/resources/stops.txt");
        stationReader.readData();
        stations = stationReader.getStations();

        StationCollection stationCollection = new StationCollection(stations);

        int width = 1600;
        int height = 900;
        Converter.setBounds(stationCollection.getMinLatitude(), stationCollection.getMaxLatitude(), stationCollection.getMinLongitude(), stationCollection.getMaxLongitude());
        Converter.setDimensions(width, height);

        MapWindow mapWindow = new MapWindow(width, height);
        StationCollectionView stationCollectionView = new StationCollectionView(stationCollection);
        mapWindow.addPanel(stationCollectionView);

        List<Shape> shapes;

        ShapeReader shapeReader = new ShapeReader("src/main/resources/shapes.txt");
        shapeReader.readData();
        shapes = shapeReader.getShapes();
 
        ShapeCollection shapeCollection = new ShapeCollection(shapes);

        Converter.setBounds(shapeCollection.getMinLatitude(), shapeCollection.getMaxLatitude(), shapeCollection.getMinLongitude(), shapeCollection.getMaxLongitude());
        Converter.setDimensions(width, height);

        ShapeCollectionView shapeCollectionView = new ShapeCollectionView(shapeCollection);
        mapWindow.addPanel(shapeCollectionView);
    }
}