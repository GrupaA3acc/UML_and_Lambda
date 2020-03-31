package NS.Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.var;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static NS.Lambda.Person.*;

public class Lambda {
    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Ala", "Bomba",20,150,56,"Polska"),
                new Person("Ala", "Kwak",25,170,76,"Polska"),
                new Person("Jakub", "Rakieta",19,182,70,"Czechy"),
                new Person("Kamil", "Nalesnik",30,179,74,"Norwegia"),
                new Person("Agnieszka", "Sosna",24,154,51,"Niemcy"),
                new Person("Jakub", "Sosna",28,173,68,"Norwegia"),
                new Person("Natalia","Rabarbar",14,155,46,"Ukraina")
        );

        personList
                .stream()
                .filter(imieKonczySieNaA.and(nazwiskoZawieraK))
                .sorted(posortujPoWieku)
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));

        System.out.println();

        personList.stream()
                .filter(imieKonczySieNaA.negate().and(nazwiskoZawieraK))
                .sorted(posortujPoNarodowosci.reversed().thenComparing(posortujPoWieku))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        personList.stream()
                .filter(wzrostWiekszyNiz150.and(imieKonczySieNaA).and(nazwiskoZawieraK.negate()))
                .sorted(posortujPoWadze.reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}

@Data
@AllArgsConstructor
class Person{

    private String name;
    private String lastName;
    private int age;
    private double height;
    private double weight;
    private String country;

    static Predicate<Person> imieKonczySieNaA = person -> person.name.toLowerCase().endsWith("a");
    static Predicate<Person> nazwiskoZawieraK = person -> person.lastName.toLowerCase().contains("k");
    static Predicate<Person> wzrostWiekszyNiz150 = person -> person.height > 150;

    static Comparator<Person> posortujPoWieku = Comparator.comparing(Person::getAge);
    static Comparator<Person> posortujPoWadze = Comparator.comparing(Person::getWeight);
    static Comparator<Person> posortujPoNarodowosci = Comparator.comparing(Person::getCountry);

    @Override
    public String toString() {
        return name + " " + lastName + ", " + age + " lat, " + height + " cm, " + weight + " kg, " + country;
    }
}