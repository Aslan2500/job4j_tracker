package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский аккаунт пользователя.
 * Каждый банковский аккаунт будет иметь свой собственный баланс и сосбственные реквезиты
 */
public class Account {
    /**
     * Поле харанящее в себе реквезиты аккаунта
     */
    private String requisite;
    /**
     * Поле хранящее в себе баланс аккаунта
     */
    private double balance;

    /**
     * Конструктор класса, который позволяет задать значения полям экземпляра
     * @param requisite номер реквезита, который необходимо задать полю класса
     * @param balance баланс, который необходимо задать полю экземпляра
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращающий реквезиты
     * @return возвращает строковое представление реквезитов аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяющий задать реквезиты аккаунту
     * @param requisite номер реквезитов, которые необходимо задать аккаунту
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращающий баланс аккаунта
     * @return возвращает число представляющее собой количество денег на балансе
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяющий задать баланс аккаунту
     * @param balance число представляющее собой количество денег, которые необбходимо задать балансу аккаунта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяет метод equals
     * @param o объект с которым будет сравниваться текущий объект
     * @return возвращает true, если аргументы равны, false, если аргументы не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределяет метод hashCode
     * @return возвращает hash code для ненулевого аргумента, возвращает 0 для нулевого аргумента
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
