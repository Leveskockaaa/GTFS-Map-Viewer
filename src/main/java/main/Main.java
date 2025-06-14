package main;

import java.util.List;

import model.Coordinate;
import model.Station;

public class Main
{
    public static void main(String[] args)
    {
        Coordinate coordinate1 = new Coordinate(12.34f, 56.78f);
        Coordinate coordinate2 = new Coordinate(98.76f, 54.32f);

        Station station1 = new Station("Nyugati pályaudvar", coordinate1);
        Station station2 = new Station("Kelenföld vasútállomás", coordinate2);

        System.out.println(station1);
        System.out.println(station2);

        model.Line line = new model.Line("M3", model.Type.METRO, List.of(station1, station2));

        System.out.println(line);
    }
}