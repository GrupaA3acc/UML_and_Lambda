package NS.UML;

public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }

    public double getFuelNeeds(double level)
    {
        return 100 - level*100;
    }

    public double getDistance(double km)
    {
        return km*3.2808; //stopy
    }

    public double calculateFuelConsumption(double level, double km)
    {
        return getFuelNeeds(level)/getDistance(km);
    }

    public void go()
    {
        System.out.println("Można ruszać");
    }

    public void stop()
    {
        System.out.println("Lepiej niech się zatrzyma");
    }


}
