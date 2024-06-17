package org.example;

/* - A new librarian or member takes (name, age, id) where id is a String that starts with L for librarian
             and M for member.
             getInfo() can be run on a member or librarian to get their name, age & library id
           - Any librarian may add a book with args (title, author, length) where length is an int representing
             how many pages the book is
           - Any librarian may checkBook(title) to see if the book exists
           - ''                 getBooks() or getBooks("title") or getBooks("check typo", title)
             getBooks() gives all data on every book in the system
             getBooks("title") the same but only titles (no length, author, availability, last used, last set)
             getBooks("check typos", "title") check for any potential titles with an odd title, however
               this function is automatically executed in checkBook() if the title is not recognised right away

           - Every book object (created by .addBook() contains the args passed to it as well as isAvailable and
             lastSetBy where they represent the book's availability status and which librarian last handled the
             book respectively
           - getBookInfo() is run to get basic info such as title, author, length and availability, however
             getBookInfo("adv") will return basic info alongside the last member who used the book + the last
             librarian that set it*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Librarian rachael = new Librarian("Rachael", 22, "L1");

        rachael.addBook("The Great Gatsby", "John Lennon maybe?", 269);
        //rachael.checkBook("The Great Gatsby");

        Librarian mike = new Librarian("Mike", 28, "L2");
        mike.addBook("The Greatest Showman", "Geronimo Stilton", 805);
        mike.checkBook("The Greatest Showman");

        //ArrayList<Book> books = mike.getBooks();      ctrl click class and alt 7 to view methods
        //System.out.println(books);
        mike.checkBook("a");

        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("pee", 420);
        empIds.put("poo", 69);
        empIds.put("pa", 649);
        empIds.put("pe", 692);
        empIds.put("pal", 619);



        for (Map.Entry<String, Integer> entry : empIds.entrySet()) {
            if (Objects.equals(entry.getValue(), 69)) {
                entry.setValue(69420);
            }
            System.out.println(entry);

        }
        System.out.println(empIds.entrySet());
        System.out.println(empIds.entrySet().getClass());


    }
}