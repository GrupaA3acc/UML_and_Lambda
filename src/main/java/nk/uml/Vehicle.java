package nk.uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String name;
    private double fuelNeeds;
    private double distance;

    public double getFuelNeeds() {
        return fuelNeeds;
    }

    public double getDistance() {
        return distance;
    }

    double calculateFuelConsumption(){
        return getFuelNeeds()* getDistance();
    }

    void go(){
        System.out.println("Włączam silnik");
    }

    void stop(){
        System.out.println("Wyłączam silnik");
    }


}
