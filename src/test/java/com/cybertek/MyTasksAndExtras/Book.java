package com.cybertek.MyTasksAndExtras;

public class Book {

    static String author = "J.K.Rowling";
    static {
        author = "Stephen King";
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.author = "Christpher Paolini";
        Book b2 = new Book();
        System.out.println(author);
        System.out.println(b1.author);
        System.out.println(b2.author);
        System.out.println(b1.author.equals(b2.author));
    }

}
