package dataimport.prereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dataimport.premodel.Stop;
import dataimport.premodel.StopTime;
import dataimport.premodel.Trip;

public class PreStopTimeReader
{
        private PreStopTimeReader() { }

    public static List<StopTime> readStopTimes(String filePath, List<Stop> stops, List<Trip> trips) throws CsvValidationException
    {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile())
        {
            System.out.println("Invalid file path: " + filePath);
            return null;
        }
        
        List<StopTime> stopTimes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file)))
        {
            String[] parts;
            reader.readNext();
            while ((parts = reader.readNext()) != null)
            {
                String stopId = parts[0].trim();
                Stop stop = findStopById(stops, stopId);
                if (stop == null)
                {
                    System.out.println("Stop not found for ID: " + stopId);
                    continue;
                }

                String tripId = parts[1].trim();
                Trip trip = findTripById(trips, tripId);
                if (trip == null)
                {
                    System.out.println("Trip not found for ID: " + tripId);
                    continue;
                }

                StopTime stopTime = new StopTime(stop, trip);
                stopTimes.add(stopTime);
            }
        }
        catch (IOException exception)
        {
            System.out.println("Error reading routes file: " + exception.getMessage());
        }

        return stopTimes;
    }

    private static Stop findStopById(List<Stop> stops, String stopId)
    {
        for (Stop stop : stops)
        {
            if (stop.getId().equals(stopId))
            {
                return stop;
            }
        }
        return null;
    }

    private static Trip findTripById(List<Trip> trips, String tripId)
    {
        for (Trip trip : trips)
        {
            if (trip.getId().equals(tripId))
            {
                return trip;
            }
        }
        return null;
    }
}
