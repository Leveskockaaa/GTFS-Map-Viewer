package dataimport.prereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dataimport.premodel.Route;

public class PreRouteReader
{
    private PreRouteReader() { }

    public static List<Route> readRoutes(String filePath) throws CsvValidationException
    {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile())
        {
            System.out.println("Invalid file path: " + filePath);
            return null;
        }
        
        List<Route> routes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file)))
        {
            String[] parts;
            reader.readNext();
            while ((parts = reader.readNext()) != null)
            {
                String id = parts[1].trim();
                String shortName = parts[2].trim();
                Route route = new Route(id, shortName);
                routes.add(route);
            }
        }
        catch (IOException exception)
        {
            System.out.println("Error reading routes file: " + exception.getMessage());
        }

        return routes;
    }    
}
