package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);

    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

//    public User findByPassport(String passport) {
//        for (User s : users.keySet()) {
//            if (s.getPassport().equals(passport)) {
//                return s;
//            }
//        }
//        return null;
//    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
               .filter(a -> a.getPassport().equals(passport))
               .findFirst()
                .orElse(null);
    }


//    public Account findByRequisite(String passport, String requisite) {
//        User user = findByPassport(passport);
//        if (user != null) {
//            for (Account s : users.get(user)) {
//                if (s.getRequisite().equals(requisite)) {
//                    return s;
//                }
//            }
//        }
//        return null;
//    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);

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