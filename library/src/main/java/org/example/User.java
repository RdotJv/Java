package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public abstract class User {
    private String name;
    private int age;
    private String id;

    public User(String name, int age, String id) {
        setName(name);
        setAge(age);
        setId(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {System.out.println(name);return name;}

    public int getAge() {System.out.println(age);return age;}

    public String getId() {System.out.println(id);return id;}

    public void getInfo() {
        System.out.println("name : " + name);
        System.out.println("age  : " + age);
        System.out.println("id   : " + id);
    }
}

class Librarian extends User {
    static HashMap<String, HashMap<String, String>> allBooks = new HashMap<>();


    public Librarian(String name, int age, String id) {
        super(name, age, id);
    }

    public void addBook (String title, String author, int length) { //add book done from here so the librarian who added it can be tracked (lastSetBy)
        Book cbook = new Book(title, author, length, this);

        HashMap<String, String> dataBits = new HashMap<>();
        dataBits.put("Author", cbook.getAuthor());
        dataBits.put("length", ""+cbook.getLength());
        dataBits.put("Availability", cbook.getIsAvailable("y/n"));
        dataBits.put("Last set by", this.getName());
        allBooks.put(cbook.getTitle(), dataBits);

    }

    public void checkBook(String search) {   //check if the specified title exists
        if (search.isBlank()) {
            System.out.println("please enter a title in checkBook(__)");
            return;
        }

        if (allBooks.containsKey(search)) {

        }

        for (Book book : allBooks) {
            if (Objects.equals(book.getTitle(), search)) {
                book.getBookInfo();             //if the title exists Book's getBookInfo() method is triggered
                return;
            }
        }
        System.out.println("could not find [" + search +"]");  //if the title doesn't exist

        ArrayList<String> potentialSearches = getBooks("check typos", search);
        if (!potentialSearches.isEmpty()) {
            System.out.print("Did you mean [");
        }
        if (potentialSearches.size()>1) {
            System.out.println(String.join(" or ", potentialSearches) + "] ?\n" + potentialSearches.size()+" potential answers found");
        } else if (potentialSearches.size()==1) {
            for (Book i : getBooks()) {

                System.out.println( potentialSearches.getFirst()+ "] ?");
                if (Objects.equals(i.getTitle(), potentialSearches.getFirst())) {
                    i.getBookInfo();
                }
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return allBooks;
    }
    public ArrayList<String> getBooks(String mode, String... search) {
        ArrayList<String> arr = new ArrayList<>();
        if (Objects.equals(mode, "titles")) {
            for (Book book: getBooks()) {
                arr.add(book.getTitle());
            }
            return arr;
        }
        if (Objects.equals(mode, "check typos")) {
            String searchWords = search[0].toLowerCase();
            ArrayList<String> titles = getBooks("titles");
            for (String title : titles) {
                if (Objects.equals(title.toLowerCase(), searchWords)) {
                    arr.add(title);
                    return arr;
                }
            }
            for (String title : titles) {
                for (String searchWord : searchWords.split(" ")) {
                    if (title.toLowerCase().contains(searchWord) && !arr.contains(title)) {
                        arr.add(title);
                        break;
                    }
                }
            }
            return arr;
        }
        return null;
    }
}

