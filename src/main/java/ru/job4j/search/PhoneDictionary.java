package ru.job4j.search;
import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        String sls = System.lineSeparator();
        for (Person s : this.persons) {
            if ((s.getPhone() + sls + s.getSurname() + sls +
                    s.getAddress() + sls + s.getName()).contains(key)) {
                result.add(s);
            }
        }
        return result;
    }
}
