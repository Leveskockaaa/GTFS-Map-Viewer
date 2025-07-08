package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import collection.StationCollection;
import model.Station;

public class StationCollectionView extends JPanel
{
    private StationCollection stationCollection;

    public StationCollectionView(StationCollection stationCollection)
    {
        this.stationCollection = stationCollection;
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));
        setSize(new Dimension(1600, 900));
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        graphics.setColor(Color.GREEN);

        for (Station station : stationCollection.getStations())
        {
            Position position = Converter.convertCoordinatePosition(station.getLocation());
            graphics.fillOval(position.getX() - 5, position.getY() - 5, 5, 5);
        }
    }
}