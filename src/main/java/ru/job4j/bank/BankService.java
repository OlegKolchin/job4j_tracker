package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);

    }

    public void addAccount(String passport, Account account) {
        Optional <User> user = Optional.of(findByPassport(passport));
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
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
//        return null ;
//    }

    public Account findByRequisite(String passport, String requisite) {
        Optional<User> user = Optional.ofNullable(findByPassport(passport));
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);

        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> src = Optional.of(findByRequisite(srcPassport, srcRequisite));
        Optional<Account> dest = Optional.of(findByRequisite(destPassport, destRequisite));
        if (src.isPresent()  && dest.isPresent() && src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            return true;
        }
        return false;
    }
}