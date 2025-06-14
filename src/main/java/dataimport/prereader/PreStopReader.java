package dataimport.prereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dataimport.premodel.Stop;
import model.Coordinate;

public class PreStopReader
{
    private PreStopReader() { }

    public static List<Stop> readStops(String filePath) throws CsvValidationException
    {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile())
        {
            System.out.println("Invalid file path: " + filePath);
            return null;
        }
        
        List<Stop> stops = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file)))
        {
            String[] parts;
            reader.readNext();
            while ((parts = reader.readNext()) != null)
            {
                String id = parts[0].trim();
                String name = parts[1].trim();
                float longitude = Float.parseFloat(parts[2].trim());
                float latitude = Float.parseFloat(parts[3].trim());
                Coordinate location = new Coordinate(longitude, latitude);

                Stop stop = new Stop(id, name, location);
                stops.add(stop);
            }
        }
        catch (IOException exception)
        {
            System.out.println("Error reading stops file: " + exception.getMessage());
        }

        return stops;
    }
}
