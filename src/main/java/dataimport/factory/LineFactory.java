package dataimport.factory;

import java.util.ArrayList;
import java.util.List;

import model.Line;

public class LineFactory implements IComponentFactory
{
    private List<Line> lines;

    public LineFactory()
    {
        lines = new ArrayList<>();
    }

    @Override
    public void processLine(String line)
    {
        String[] parts = line.split(",");
        
        if (parts.length < 9)
        {
            System.out.println("Invalid line data: " + line);
            return;
        }

        int routeId = Integer.parseInt(parts[0]);
        String tripId = parts[1];
        String serviceId = parts[2];
        String tripHeadsign = parts[3];
    }

    public List<Line> getLines()
    {
        return lines;
    }
}
