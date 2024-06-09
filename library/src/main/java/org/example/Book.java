package org.example;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int length;
    private boolean isAvailable;
    private Librarian lastSetBy;

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public int getLength() {return length;}
    public void setLength(int length) {this.length = length;}

    public boolean getIsAvailable() {return isAvailable;}
    public void setIsAvailable(boolean available) {isAvailable = available;}

    public Librarian getLastSetBy() {return lastSetBy;}
    public void setLastSetBy(Librarian librarian) {this.lastSetBy = librarian;}

    public Book(String title, String author, int length, Librarian librarian) {
        setTitle(title);
        setAuthor(author);
        setLength(length);
        setLastSetBy(librarian);
        System.out.println("Added "+ title + " by: " + author + " to the shelves!");
    }

    public void getBookInfo() {
        System.out.println("title     : " + getTitle());
        System.out.println("author    : " + getAuthor());
        System.out.println("length    : " + getLength());
        System.out.print("available : ");
        if (getIsAvailable()){System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public void getBookInfo(String mode) {
        getBookInfo();
        if (Objects.equals(mode, "adv")) {
            System.out.println("Last used by : ");
            System.out.println("Last set by  : " + lastSetBy.getName());
        }
    }

    public String toString() {
        return "\n{title = "+title+"\n author = "+author+"\n length = "+length+"}\n";
    }
}
