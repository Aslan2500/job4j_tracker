package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса, с различными возможными действиями
 */
public class BankService {
    /**
     * Поле содержащее в себе коллекцию Map, в которой Юзер представляет собой ключ (key),
     * а список аккаунтов представляет собой значение (values)
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяющий добавить Юзера {@link User} в нашу коллекцию, если его там еще нет
     * @param user юзер, которого необходимо добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяющий добавить аккаунт {@link Account} для определенного Юзера,
     * Условиями для добавления аккаунта являются - существование юзера и отсутствие у него данного аккаунта
     * @param passport паспорт Юзера которому необходимо добавить аккаунт
     * @param account аккаунт, который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяющий найти Юзера по данными его паспорта
     * @param passport паспорт Юзера, которого необходимо найти
     * @return если данный юзер найден, то метод возвращает его, если данный пользователь не найден,
     * то метод возвращает null
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод позволяющий найти аккаунт по реквизитам
     * Метод находит пользователя по данным паспорта, после чего находит у него аккаунт по данным реквизитов
     * @param passport паспорт Юзера, у которого необходимо найти аккаунт
     * @param requisite реквизиты аккаунта, который необходимо найти
     * @return если найден пользователь и найден аккаунт у пользователя,
     * то метод возвращает данный аккаунт, в ином случае метод возвращает null
     */
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

    /**
     * Метод позволяет переводить деньги с баланса одного аккаунта, на баланс другого аккаунта
     * Перевод можно совершать как между аккаунтами разных Юзеров, так и между аккаунтами одного Юзера
     * @param srcPassport паспорт Юзера, который отправляет деньги со своего баланса
     * @param srcRequisite реквизиты аккаунта, у которого необходимо писать деньги
     * @param destPassport паспорт Юзера, которому отправляются деньги
     * @param destRequisite реквизиты аккаунта, на который необходимо начислить деньги
     * @param amount сумма, которую необходимо перечислять
     * @return метод возвращает true в случае успешного перевода денег
     *  метод возвращает false в случаях если - не найден пользователь, не найден аккаунт
     *  или если на счету отправителя нехватает средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDest = findByRequisite(destPassport, destRequisite);
        if (accSrc != null && accDest != null && accSrc.getBalance() >= amount) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDest.setBalance(accDest.getBalance() + amount);
            return true;
        }
        return false;
    }
}

