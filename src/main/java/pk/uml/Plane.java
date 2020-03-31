package pk.uml;

public class Plane extends Vehicle implements Flying {
    @Override
    public void takeOff() {
        System.out.println("Samolot wznosi się");
    }

    @Override
    public void land() {
        System.out.println("Samolot ląduje");
    }

    @Override
    public void callAirControl() {
        System.out.println("Kontrola lotu");
    }

    @Override
    public double getFuelNeeds() {
        return 100;
    }

    @Override
    public double getDistance() {
        return 1500;
    }

    @Override
    public void go() {
        System.out.println("Samolot wystartował");
    }

    @Override
    public void stop() {
        System.out.println("Samolot zatrzymał się");
    }
}
