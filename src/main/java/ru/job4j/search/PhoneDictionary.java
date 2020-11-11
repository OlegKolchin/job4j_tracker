package ru.job4j.search;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
//        ArrayList<Person> result = new ArrayList<>();
//        for (Person s : this.persons) {
//            if (s.getName().contains(key) || s.getAddress().contains(key)
//                    || s.getSurname().contains(key) || s.getPhone().contains(key)) {
//                result.add(s);
//            }
//        }
//        return result;
        Predicate<Person> combine = (x) -> x.getName().contains(key)
        || x.getAddress().contains(key)
                || x.getSurname().contains(key)
                || x.getPhone().contains(key);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
