package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.showInfo();
        Error error2 = new Error(true, 100, "Hello");
        error2.showInfo();
        Error error3 = new Error(false, 250, "Ready");
        error3.showInfo();
        Error error4 = new Error(true, 1, "Java");
        error4.showInfo();
    }
}


//4. Добавьте метод main(), в котором будете создавать объект с помощью явного конструктора по умолчанию, а также несколько объектов с помощью конструктора с параметрами. Вызовите на созданных объектах метод, добавленный в пункте 3;
//
//5. Залейте код в репозиторий, приложите ссылку на коммит;
//
//6. Переведите ответственно на Петра Арсентьева.