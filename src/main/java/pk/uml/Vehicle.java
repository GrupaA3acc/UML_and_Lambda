package pk.uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String name;

    public double getFuelNeeds(){
        return 5;
    }

    public double getDistance(){
        return 10;
    }

    public double calculateFuelConsumption(){
        return getFuelNeeds() / getDistance();
    }

    public void go(){
        System.out.println("Pojazd ruszył");
    }

    public void stop(){
        System.out.println("Pojazd zatrzymał się");
    }
}
