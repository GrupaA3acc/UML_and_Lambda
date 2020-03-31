package nk.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.var;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ZadaniaLambda {
    public static void main(String[] args) {
        List<Person3> usersList = List.of(
                new Person3("Bogdan", "Wilk", 50, "Katowice"),
                new Person3("Bartłomiej", "Wilk", 50, "Kraków"),
                new Person3("Bogdan", "Zając", 50, "Poznań"),
                new Person3("Zenon", "Owca", 50, "Poznań"),
                new Person3("Janusz", "Dudek", 50, "Kalisz"),
                new Person3("Sebastian", "Skowronek", 50, "Katowice"));

        System.out.println("Lista userów posortowana według imienia");
        List<Person3> usersListSortedByName = usersList
                .stream()
                .sorted(Person3.sortByName)
                .collect(Collectors.toList());
        usersListSortedByName.forEach(System.out::println);

        System.out.println("Lista userów posortowana według nazwiska, potem według imienia");
        usersList
                .stream()
                .sorted(Person3.sortByLastName.thenComparing(Person3.sortByName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Lista userów posortowana według miasta w odwrotnej kolejności, potem według nazwiska");
        List<Person3> usersListSortedByReversedCityThenByLastName = usersList
                .stream()
                .sorted(Person3.sortByCity.reversed().thenComparing(Person3.sortByLastName))
                .collect(Collectors.toList());
        usersListSortedByReversedCityThenByLastName.forEach(System.out::println);

    }
}

@Data
@AllArgsConstructor
class Person3{

    String name;
    String lastName;
    int age;
    String city;

    static Comparator<Person3> sortByLastName = Comparator.comparing(Person3::getLastName);
    static Comparator<Person3> sortByName = Comparator.comparing(Person3::getName);
    static Comparator<Person3> sortByCity = Comparator.comparing(Person3::getCity);



}
