package dataimport.premodel;

public class Trip
{
    private final Route route;
    private final String id;

    public Trip(Route route, String id)
    {
        this.route = route;
        this.id = id;
    }

    public Route getRoute()
    {
        return route;
    }

    public String getId()
    {
        return id;
    }
}
