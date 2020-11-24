package ru.job4j.bank;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.findByRequisite("34", "5546");
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void transferMoney2() {
        User user = new User("3434", "Petr Arsentev");
        User user2 = new User("665", "Oleg");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user2.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user2.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user2.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void findByRequisite() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Account expect = new Account("5546", 150D);
        assertThat(bank.findByRequisite("3434", "5546").get(), is(expect));
    }
}