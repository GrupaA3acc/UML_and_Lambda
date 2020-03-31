package nk.uml;

public class Plane extends Vehicle implements Flying {
    @Override
    public double getFuelNeeds() {
        return 10;
    }

    @Override
    public double getDistance() {
        return 18;
    }

    @Override
    void go() {
        super.go();
        System.out.println("Halo Houston! Odpalamy silniki");
    }

    @Override
    void stop() {
        super.stop();
        System.out.println("Oklaski i brawa dla pilota!");
    }

    @Override
    public void takeOff() {
        System.out.println("Fruuuuu");

    }

    @Override
    public void land() {
        System.out.println("Houston! Ladujemy");

    }

    @Override
    public void callAirControl() {
        System.out.println("Halo Houston, we have a problem");
    }
}
