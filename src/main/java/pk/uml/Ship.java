package pk.uml;

public class Ship extends Vehicle implements Sailing {
    @Override
    public double getFuelNeeds() {
        return 35;
    }

    @Override
    public double getDistance() {
        return 150;
    }

    @Override
    public void stop() {
        System.out.println("Statek zatrzymał się");
    }

    @Override
    public void dock() {
        System.out.println("Statek dokuje");
    }
}
