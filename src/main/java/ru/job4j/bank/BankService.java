package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(pass -> pass.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяющий найти аккаунт по реквизитам
     * Метод находит пользователя по данным паспорта, после чего находит у него аккаунт по данным реквизитов
     * @param passport паспорт Юзера, у которого необходимо найти аккаунт
     * @param requisite реквизиты аккаунта, который необходимо найти
     * @return если найден пользователь и найден аккаунт у пользователя,
     * то метод возвращает данный аккаунт, в ином случае метод возвращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return user.flatMap(value -> users.get(value)
                    .stream()
                    .filter(pass -> pass.getRequisite().equals(requisite))
                    .findFirst());
        }
        return Optional.empty();
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
        Optional<Account> accSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accDest = findByRequisite(destPassport, destRequisite);
        if (accSrc.isPresent() && accDest.isPresent() && accSrc.get().getBalance()  >= amount) {
            accSrc.get().setBalance(accSrc.get().getBalance() - amount);
            accDest.get().setBalance(accDest.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}

