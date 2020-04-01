package NS.UML;

public class Truck extends Car {

    @Override
    public double getFuelNeeds(double level) {
        return 90 - level*90;
    }
}
