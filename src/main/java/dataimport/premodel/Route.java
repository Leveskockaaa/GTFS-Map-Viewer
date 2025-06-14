package dataimport.premodel;

public class Route
{
    private final String id;
    private final String shortName;

    public Route(String id, String shortName)
    {
        this.id = id;
        this.shortName = shortName;
    }

    public String getId()
    {
        return id;
    }

    public String getShortName()
    {
        return shortName;
    }
}
