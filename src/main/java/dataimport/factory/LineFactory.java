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
    public void processLine(String[] line)
    {
        int routeId = Integer.parseInt(line[0]);
        String tripId = line[1];
        String serviceId = line[2];
        String tripHeadsign = line[3];
    }

    public List<Line> getLines()
    {
        return lines;
    }
}
