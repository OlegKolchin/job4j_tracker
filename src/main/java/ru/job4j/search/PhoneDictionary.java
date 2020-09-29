package ru.job4j.search;
import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person s : this.persons) {
            if (s.getName().contains(key) || s.getSurname().contains(key)) {
                result.add(s);
            }else if (s.getAddress().contains(key) || s.getPhone().contains(key)) {
                result.add(s);
            }
        }
        return result;
    }
}
