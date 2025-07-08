package model;

public class Shape
{
    private final String shapeId;
    private final Coordinate coordinate;

    public Shape(String shapeId, Coordinate coordinate)
    {
        this.shapeId = shapeId;
        this.coordinate = coordinate;
    }

    public String getShapeId()
    {
        return shapeId;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    @Override
    public String toString()
    {
        return "Shape[shapeId=" + shapeId + ", coordinate=" + coordinate + "]";
    }
}
