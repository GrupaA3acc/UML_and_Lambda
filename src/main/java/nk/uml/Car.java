package nk.uml;

public class Car extends Vehicle{

    @Override
    public double getFuelNeeds() {
        return 50;
    }

    @Override
    public double getDistance() {
        return 130;
    }
}
