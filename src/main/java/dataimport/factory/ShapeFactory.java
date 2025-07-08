package dataimport.factory;

import java.util.ArrayList;
import java.util.List;

import model.Coordinate;
import model.Shape;

public class ShapeFactory implements IComponentFactory
{
    private final List<Shape> shapes;

    public ShapeFactory()
    {
        shapes = new ArrayList<>();
    }

    @Override
    public void processLine(String[] line)
    {
        String shapeId = line[0];
        float latitude = Float.parseFloat(line[2]);
        float longitude = Float.parseFloat(line[3]);

        Coordinate coordinate = new Coordinate(latitude, longitude);
        Shape shape = new Shape(shapeId, coordinate);
        shapes.add(shape);
    }

    public List<Shape> getShapes()
    {
        return shapes;
    }
}
