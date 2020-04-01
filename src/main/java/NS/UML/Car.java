package NS.UML;

public class Car extends Vehicle {

    @Override
    public double getFuelNeeds(double level) {
        return 50 - 50*level;
    }

    @Override
    public double getDistance(double km) {
        return km*0.62; //mila lądowa
    }
}
