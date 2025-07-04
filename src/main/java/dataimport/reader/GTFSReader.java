package dataimport.reader;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;

import dataimport.factory.IComponentFactory;

public abstract class GTFSReader implements IGTFSReader
{
    private String filePath;
    private IComponentFactory componentFactory;

    protected GTFSReader(String filePath)
    {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setComponentFactory(IComponentFactory componentFactory)
    {
        this.componentFactory = componentFactory;
    }

    @Override
    public void readData()
    {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath)))
        {
            try (CSVReader csvReader = new CSVReader(reader))
            {
                String[] line;
                csvReader.readNext();
                while ((line = csvReader.readNext()) != null)
                {
                    if (componentFactory != null)
                    {
                        componentFactory.processLine(line);
                    }
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println("Error reading CSV file: " + filePath);
            exception.printStackTrace();
        }
    }
}
