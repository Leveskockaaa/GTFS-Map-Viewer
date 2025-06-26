package main;

import java.util.List;

import com.opencsv.exceptions.CsvValidationException;

import dataimport.premodel.Route;
import dataimport.premodel.Stop;
import dataimport.premodel.StopTime;
import dataimport.premodel.Trip;
import dataimport.prereader.PreRouteReader;
import dataimport.prereader.PreStopReader;
import dataimport.prereader.PreStopTimeReader;
import dataimport.prereader.PreTripReader;

public class Main
{
    public static void main(String[] args)
    {
        List<Stop> stops;
        List<Route> routes;
        List<Trip> trips;
        List<StopTime> stopTimes;

        try
        {
            stops = PreStopReader.readStops("src/main/resources/stops.txt");
            routes = PreRouteReader.readRoutes("src/main/resources/routes.txt");
            trips = PreTripReader.readTrips("src/main/resources/trips.txt", routes);
            stopTimes = PreStopTimeReader.readStopTimes("src/main/resources/stop_times.txt", stops, trips);
        }
        catch (CsvValidationException exception)
        {
            System.out.println("Error reading data files: " + exception.getMessage());
            return;
        }
        
        for (StopTime stopTime : stopTimes)
        {
            System.out.println("Stop: " + stopTime.getStop().getId() + ", Trip: " + stopTime.getTrip().getId());
        }
    }
}