package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Alice in Wonderland");
        Book book2 = new Book("Process");
        Book book3 = new Book("Shining");
        Book book4 = new Book("Clean code");
        Book[] books = {book1, book2, book3, book4};
        printBooks(books);
        Book book5 = books[0];
        books[0] = books[3];
        books[3] = book5;
        printBooks(books);
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName());
            }
        }
    }

    public static void printBooks(Book[] books) {
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName());
        }
        System.out.println();
    }
}