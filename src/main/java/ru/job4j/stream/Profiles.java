package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> collectUnique(List<Profile> profiles) {
        Comparator<Address> comparator = Comparator.comparing(Address::getCity);
        return profiles.stream()
                .map(Profile :: getAddress)
                .sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
    }
}
