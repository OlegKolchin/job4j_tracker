package ru.job4j.search;
import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();


    public String field(Person person) {
        return person.getName() + " " + person.getSurname() + " "
                + person.getAddress() + " " + person.getPhone();
    }

    public void add(Person person) {
        this.persons.add(person);
    }
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person s : this.persons) {
            if ((field(s).contains(key))) {
                result.add(s);
            }
        }
        return result;
    }
}
