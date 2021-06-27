package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenWorksCorrectly() {
        Profiles profiles = new Profiles();
        Address address1 = new Address("Moscow", "Tverskaya", 10, 15);
        Address address2 = new Address("Tver", "Lenina", 15, 20);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> list = List.of(profile1, profile2);
        List<Address> rsl = List.of(address1, address2);
        List<Address> expect = profiles.collect(list);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenUniqueSorted() {
        Profiles profiles = new Profiles();
        Address address1 = new Address("Moscow", "Tverskaya", 10, 15);
        Address address2 = new Address("Tver", "Lenina", 15, 20);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address1);
        List<Profile> list = List.of(profile1, profile2, profile3);
        List<Address> rsl = List.of(address1, address2);
        List<Address> expect = profiles.collectUnique(list);
        assertThat(rsl, is(expect));
    }
}