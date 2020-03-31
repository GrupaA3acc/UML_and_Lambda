package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

class Person {

    private String name;
    private String lastName;
    private Integer age;

    public Person(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }


    public Integer getAge() {
        return this.age;
    }


    @Override
    public String toString() {
        return this.name.toString()+" "+this.lastName.toString() + " - " + this.age.toString();
    }


    public static Predicate<Person> nameStartsWithA() {
        return p -> p.getName().startsWith("A");
    }

    public static Predicate<Person> lastNameStartsWithB() {
        return p -> p.getLastName().startsWith("B");
    }

    public static Predicate<Person> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }


}


class Main {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Lukasz", "Kowalski", 20),
                new Person("Adam", "Kowalski", 21),
                new Person("Jan", "Kowalski", 18)
        );


        Comparator<Person> sortByName = Comparator.comparing(Person::getName);
        Comparator<Person> sortByLastName = Comparator.comparing(Person::getLastName);
        Comparator<Person> sortByAge = Comparator.comparing(Person::getAge);

        List<Person> sortedNames = people
                .stream()
                .sorted(sortByName)
                .collect(Collectors.toList());
        List<Person> sortedNamesThenLastNames = people
                .stream()
                .sorted(sortByName.thenComparing(sortByLastName))
                .collect(Collectors.toList());
        List<Person> sortedNamesThenLastNamesReversedAge = people
                .stream()
                .sorted(sortByName
                        .thenComparing(sortByLastName)
                        .thenComparing(sortByAge))
                .collect(Collectors.toList());
        System.out.println(sortedNames);
        System.out.println(sortedNamesThenLastNames);
        System.out.println(sortedNamesThenLastNamesReversedAge);
    }

}