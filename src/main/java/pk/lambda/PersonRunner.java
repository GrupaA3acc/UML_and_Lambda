package pk.lambda;

import static pk.lambda.Person.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRunner {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Patryk","Kania","+48558774236"
                        ,new Person.Address("Poland","Tychy","Malinowa"), 23),
                new Person("Adam","Nowak","+50524445896"
                        ,new Person.Address("USA","LA","Poziomkowa"), 40),
                new Person("Wojtek","Malinowski","+48856321458"
                        ,new Person.Address("Poland","Krakow","Cytrynowa"), 35),
                new Person("Waldemar","Kania","+48236663254"
                        ,new Person.Address("Poland","Tychy","Bazantowa"), 23),
                new Person("Katarzyna","Kania","+48854412225"
                        ,new Person.Address("Poland","Tychy","Wiejska"), 16)
        );

        personList
                .stream()
                .filter(czyPelnoletni.and(imieZawierajaceK))
                .sorted(sortujPoMiescie)
                .forEach(System.out::println);

        List<String> nrZPolski = personList
                .stream()
                .filter(nrTelfonuZPolski)
                .map(Person::getPhone)
                .collect(Collectors.toList());

        List<String> osobyNieZPolski = personList
                .stream()
                .filter(person -> !person.getAddress().getCountry().toLowerCase().equals("poland"))
                .map(person -> person.getName().concat("-").concat(person.getLastName()))
                .collect(Collectors.toList());
    }
}
