package dataimport.premodel;

public class StopTime
{
    private final Stop stop;
    private final Trip trip;
    
    public StopTime(Stop stop, Trip trip)
    {
        this.stop = stop;
        this.trip = trip;
    }

    public Stop getStop()
    {
        return stop;
    }

    public Trip getTrip()
    {
        return trip;
    }
}
