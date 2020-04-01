package nk.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.var;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
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
//3xUZYCIE COMPARATOR
        System.out.println("Lista userów posortowana według imienia");
        List<Person3> usersListSortedByName = usersList
                .stream()
                .sorted(Person3.sortByName)
                .collect(Collectors.toList());
        usersListSortedByName.forEach(System.out::println);

        System.out.println("=============================================================");
        System.out.println("Lista userów posortowana według nazwiska, potem według imienia");
        usersList
                .stream()
                .sorted(Person3.sortByLastName.thenComparing(Person3.sortByName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("=============================================================");
        System.out.println("Lista userów posortowana według miasta w odwrotnej kolejności, potem według nazwiska");
        List<Person3> usersListSortedByReversedCityThenByLastName = usersList
                .stream()
                .sorted(Person3.sortByCity.reversed().thenComparing(Person3.sortByLastName))
                .collect(Collectors.toList());
        usersListSortedByReversedCityThenByLastName.forEach(System.out::println);




        //3xUZYCIE PREDICATE
        System.out.println("=============================================================");
        System.out.println("Lista userów, których nazwisko kończy się na literę 'a'");
var collectFilterLastNameEndsWithA = usersList
        .stream()
        .filter(Person3.lastNameEndsWithA)
        .collect(Collectors.toList());

        collectFilterLastNameEndsWithA.forEach(System.out::println);


        System.out.println("=============================================================");
        System.out.println("Lista userów, których miasto to Katowice");
        var collectFilterCityIsKatowice = usersList
                .stream()
                .filter(Person3.cityIsKatowice)
                .collect(Collectors.toList());

        collectFilterCityIsKatowice.forEach(System.out::println);


        System.out.println("=============================================================");
        System.out.println("Lista userów, którzy mają powyżej 18 lat");
        var collectFilterOlderThan18 = usersList
                .stream()
                .filter(Person3.olderThan18)
                .collect(Collectors.toList());

        collectFilterOlderThan18.forEach(System.out::println);
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

    static Predicate<Person3> lastNameEndsWithA = person -> person.getLastName().toUpperCase().endsWith("A");
    static Predicate<Person3> cityIsKatowice = person -> person.getCity().equalsIgnoreCase("Katowice");
    static Predicate<Person3> olderThan18 = person -> (person.age > 18);





}
