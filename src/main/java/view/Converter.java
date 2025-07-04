package view;

import model.Coordinate;

public class Converter
{
    private static float MIN_LATITUDE;
    private static float MAX_LATITUDE;
    private static float MIN_LONGITUDE;
    private static float MAX_LONGITUDE;

    private static int WIDTH;
    private static int HEIGHT;

    private Converter() { }

    public static void setBounds(float minLatitude, float maxLatitude, float minLongitude, float maxLongitude)
    {
        MIN_LATITUDE = minLatitude;
        MAX_LATITUDE = maxLatitude;
        MIN_LONGITUDE = minLongitude;
        MAX_LONGITUDE = maxLongitude;
    }

    public static void setDimensions(int width, int height)
    {
        WIDTH = width;
        HEIGHT = height;
    }

    public static Position convertCoordinatePosition(Coordinate coordinate)
    {
        float latitude = coordinate.getLatitude();
        float longitude = coordinate.getLongitude();

        int xPosition = (int) ((longitude - MIN_LONGITUDE) / (MAX_LONGITUDE - MIN_LONGITUDE) * WIDTH);
        int yPosition = (int) ((MAX_LATITUDE - latitude) / (MAX_LATITUDE - MIN_LATITUDE) * HEIGHT);

        return new Position(xPosition, yPosition);
    }
}
