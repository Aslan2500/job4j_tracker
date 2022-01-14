package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book[] books = new Book[4];
        book1.setName("Alice in Wonderland");
        books[0] = book1;
        book2.setName("Process");
        books[1] = book2;
        book3.setName("Shining");
        books[2] = book3;
        book4.setName("Clean code");
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName());
        }
        System.out.println();
        Book book5 = new Book();
        book5.setName(book1.getName());
        book1.setName(book4.getName());
        book4.setName(book5.getName());
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName() == "Clean code") {
                System.out.println(bk.getName());
            }
        }
    }
}
