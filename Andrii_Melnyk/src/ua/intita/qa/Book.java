package ua.intita.qa;

import java.util.Scanner;

public class Book {

    static private int idGlobal;
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private String binding;

    public Book(String title, String author, String publisher, int year, int pages, String binding) {
        idGlobal++;
        this.id = idGlobal;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.binding = binding;
    }

    public Book() {
        idGlobal++;
        this.id = idGlobal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", binding='" + binding + '\'' +
                '}';
    }

    public static void printByAuthor(Book[] books) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        for (Book book :
                books) {
            if (book.author.contains(author)) {
                System.out.println(book.toString());
            }
        }
    }

    public static void printByPublisher(Book[] books) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter publisher:");
        String publisher = scanner.nextLine();

        for (Book book :
                books) {
            if (book.publisher.equalsIgnoreCase(publisher)) {
                System.out.println(book.toString());
            }
        }
    }

    public static void printAfterYear(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year to search (published after given year):");
        int year;
        while (true) {
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Error, enter correct year");
                    scanner.next();
                    continue;
                }
                break;
            } else {
                System.out.println("Error, enter correct year");
                scanner.next();
            }
        }

        for (Book book :
                books) {
            if (book.year > year) {
                System.out.println(book.toString());
            }
        }
    }


}
