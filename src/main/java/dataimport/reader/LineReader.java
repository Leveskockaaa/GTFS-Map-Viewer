package dataimport.reader;

import java.util.List;

import dataimport.factory.LineFactory;
import model.Line;

public class LineReader extends GTFSReader
{
    private final LineFactory lineFactory;

    public LineReader(String filePath)
    {
        super(filePath);
        lineFactory = new LineFactory();
        super.setComponentFactory(lineFactory);
    }

    public List<Line> getLines()
    {
        return lineFactory.getLines();
    }
}
