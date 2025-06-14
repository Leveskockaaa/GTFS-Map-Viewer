package dataimport.prereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dataimport.premodel.Route;
import dataimport.premodel.Trip;

public class PreTripReader
{
    private PreTripReader() { }

    public static List<Trip> readTrips(String filePath, List<Route> routes) throws CsvValidationException
    {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile())
        {
            System.out.println("Invalid file path: " + filePath);
            return null;
        }
        
        List<Trip> trips = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file)))
        {
            String[] parts;
            reader.readNext();
            while ((parts = reader.readNext()) != null)
            {
                String routeId = parts[0].trim();
                Route route = findRouteById(routes, routeId);
                if (route == null)
                {
                    System.out.println("Route not found for ID: " + routeId);
                    continue;
                }
                String id = parts[1].trim();

                Trip trip = new Trip(route, id);
                trips.add(trip);
            }
        }
        catch (IOException exception)
        {
            System.out.println("Error reading routes file: " + exception.getMessage());
        }

        return trips;
    }

    private static Route findRouteById(List<Route> routes, String routeId)
    {
        for (Route route : routes)
        {
            if (route.getId().equals(routeId))
            {
                return route;
            }
        }
        return null;
    }
}