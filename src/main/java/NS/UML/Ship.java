package NS.UML;

public class Ship extends Vehicle implements Sailing  {

    @Override
    public double getFuelNeeds(double level)
    {
        return 1000 - 1000*level;
    }

    @Override
    public double getDistance(double km)
    {
        return km/1.85; //portugalska mila morska
    }

    @Override
    public void dock()
    {
        System.out.println("Statek wpłynął do portu");
    }

    @Override
    public void stop()
    {
        System.out.println("Statek został zatrzymany");
    }


}
