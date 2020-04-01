package NS.UML;

public class RaceCar extends Car {

    @Override
    public double getFuelNeeds(double level) {
        return 120 - level*120;
    }
}
