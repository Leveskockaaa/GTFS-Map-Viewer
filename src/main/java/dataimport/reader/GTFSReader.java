package dataimport.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
        File file = new File(filePath);
        if (!isFileValid(file))
        {
            System.out.println("Invalid file: " + filePath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (componentFactory != null)
                {
                    componentFactory.processLine(line);
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println("Error reading file: " + filePath);
            exception.printStackTrace();
        }
    }

    protected boolean isFileValid(File file)
    {
        return !(file == null || !file.exists() || !file.isFile());
    }
}
