package collection;

import java.util.List;

import model.Shape;

public class ShapeCollection
{
    private final List<Shape> shapes;

    private float minLatitude;
    private float maxLatitude;
    private float minLongitude;
    private float maxLongitude;

    public ShapeCollection(List<Shape> shapes)
    {
        this.shapes = shapes;
        this.minLatitude = Float.MAX_VALUE;
        this.maxLatitude = Float.MIN_VALUE;
        this.minLongitude = Float.MAX_VALUE;
        this.maxLongitude = Float.MIN_VALUE;
        processData();
    }

    public void setShapes(List<Shape> shapes)
    {
        this.shapes.clear();
        this.shapes.addAll(shapes);
        processData();
    }

    public final void processData()
    {
        for (Shape shape : shapes)
        {
            float latitude = shape.getCoordinate().getLatitude();
            float longitude = shape.getCoordinate().getLongitude();

            if (latitude < minLatitude) minLatitude = latitude;
            if (latitude > maxLatitude) maxLatitude = latitude;
            if (longitude < minLongitude) minLongitude = longitude;
            if (longitude > maxLongitude) maxLongitude = longitude;
        }
    }

    public List<Shape> getShapes()
    {
        return shapes;
    }

        public float getMinLatitude()
    {
        return minLatitude;
    }

    public float getMaxLatitude()
    {
        return maxLatitude;
    }

    public float getMinLongitude()
    {
        return minLongitude;
    }

    public float getMaxLongitude()
    {
        return maxLongitude;
    }
}
