package pk.uml;

public class Truck extends Car {

    public Truck(String name){super(name);}

    @Override
    public double getFuelNeeds() {
        return 15;
    }
}
