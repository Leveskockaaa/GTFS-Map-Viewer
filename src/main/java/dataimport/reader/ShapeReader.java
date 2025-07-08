package dataimport.reader;

import java.util.List;

import dataimport.factory.ShapeFactory;
import model.Shape;

public class ShapeReader extends GTFSReader
{
    private final ShapeFactory shapeFactory;

    public ShapeReader(String filePath)
    {
        super(filePath);
        shapeFactory = new ShapeFactory();
        super.setComponentFactory(shapeFactory);
    }

    public List<Shape> getShapes()
    {
        return shapeFactory.getShapes();
    }
}
