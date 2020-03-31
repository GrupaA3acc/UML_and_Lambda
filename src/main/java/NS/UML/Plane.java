package NS.UML;

public class Plane extends Vehicle implements Flying {

    @Override
    public double getFuelNeeds(double level) {
        return 300 - 300*level;
    }

    @Override
    public double getDistance(double km) {
        return km/1.852; //mile morskie SI
    }

    @Override
    public void takeOff() {
        System.out.println("Samolot wystartował");
    }

    @Override
    public void land() {
        System.out.println("Samolot ląduje");
    }

    @Override
    public void callAirControl() {
        System.out.println("Halo, ratunku!");
    }

    @Override
    public void go() {
        System.out.println("Możesz lecieć");
    }

    @Override
    public void stop() {
        System.out.println("Zatrzymaj się na najbliższym lotnisku");
    }
}
