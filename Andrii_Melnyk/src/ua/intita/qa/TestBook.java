package ua.intita.qa;

public class TestBook {
    public static void main(String[] args) {
        Book[] books = new Book[5];

        books[0] = new Book("wref", "Lev Tolstoy", "famousPublisher", 1921, 687, "hard");
        books[1] = new Book("Master and Margarita", "Bulgakov", "NotSoFamousPublisher", 1910, 410, "soft");
        books[2] = new Book("War and Peace", "famousAuthor, Lev Tolstoy", "simplePublisher", 1891, 100500, "hard");
        books[3] = new Book("popularBook", "Lev Tolsoy", "simplePublisher", 2015, 147, "hard");
        books[4] = new Book("aaaa", "unknownAuthor", "-", 1900, 68, "hard");

        Book.printByAuthor(books);
        Book.printByPublisher(books);
        Book.printAfterYear(books);
    }
}
