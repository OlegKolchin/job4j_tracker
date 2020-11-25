package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);

    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport).get();
        if (!users.get(user).contains(account)) {
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

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst();
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
//        return null ;
//    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return users.get(user.get()).stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            return true;
        }
        return false;
    }
}