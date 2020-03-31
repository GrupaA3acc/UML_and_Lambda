package pk.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private String phone;
    private Address address;
    private int age;

    @Data
    @AllArgsConstructor
    static class Address{
        private String country;
        private String city;
        private String street;
    }

    static Predicate<Person> imieZawierajaceA = person -> person.name.toLowerCase().contains("a");
    static Predicate<Person> nrTelfonuZPolski = person -> person.phone.contains("+48");
    static Predicate<Person> czyPelnoletni = person -> person.age >= 18;

    static Comparator<Person> sortujPoWieku = Comparator.comparing(Person::getAge);
    static Comparator<Person> sortujPoImieniu = Comparator.comparing(Person::getName);
    static Comparator<Person> sortujPoMiescie = Comparator.comparing(person -> person.address.city);
}
