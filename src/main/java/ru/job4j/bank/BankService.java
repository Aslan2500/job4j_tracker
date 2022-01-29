package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountGiveMoney = findByRequisite(srcPassport, srcRequisite);
        Account accountGetMoney = findByRequisite(destPassport, destRequisite);
        if (accountGetMoney != null && accountGiveMoney != null) {
            double wallet1 = accountGiveMoney.getBalance();
            double wallet2 = accountGetMoney.getBalance();
            if (wallet1 < amount) {
                return false;
            } else {
                accountGiveMoney.setBalance(wallet1 - amount);
                accountGetMoney.setBalance(wallet2 + amount);
                return true;
            }
        }
        return false;
    }
}

