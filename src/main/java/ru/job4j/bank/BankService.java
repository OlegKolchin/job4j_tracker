package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);

    }

    public void addAccount(String passport, Account account) {
        if (!users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User s : users.keySet()) {
            if (s.getPassport().equals(passport)) {
                return s;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account s : users.get(findByPassport(passport))) {
                if (s.getRequisite().equals(requisite)) {
                    return s;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            src.setBalance(src.getBalance() - amount);
            return true;
        }
        return false;
    }
}