package nk.uml;

public class Ship extends Vehicle implements Sailing {
    @Override
    public double getFuelNeeds() {
        return 15;
    }

    @Override
    public double getDistance() {
        return 3000;
    }

    @Override
    void stop() {
        super.stop();
        System.out.println("Silniki statku są wyłączone, zaraz będzie można pływać po zatoce");
    }

    @Override
    public void dock() {
        System.out.println("Statek zakotwiczony, już można pływać po zatoce");
    }
}
