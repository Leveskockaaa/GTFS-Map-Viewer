package model;

public class Coordinate
{
    private float longitude;
    private float latitude;

    public Coordinate(float longitude, float latitude)
    {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude()
    {
        return longitude;
    }

    public void setLongitude(float longitude)
    {
        this.longitude = longitude;
    }

    public float getLatitude()
    {
        return latitude;
    }

    public void setLatitude(float latitude)
    {
        this.latitude = latitude;
    }

    @Override
    public String toString()
    {
        return "Coordinate[longitude=" + longitude + ", latitude=" + latitude + "]";
    }
}
