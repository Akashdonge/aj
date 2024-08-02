import java.util.*;

public class pr45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Title1", "Author1", "Publisher1", 100));
        books.add(new Book("Title2", "Author1", "Publisher2", 1000));
        books.add(new Book("Title3", "Author2", "Publisher3", 1001));
        books.add(new Book("Title4", "Author3", "Publisher4", 13));
        books.add(new Book("Title5", "Author4", "Publisher5", 10203));

        System.out.println("Original Book Prices:");
        for (Book b : books) {
            System.out.println(b.price);
        }

        // Sort books by price and store in another list
        ArrayList<Book> sortedBooks = sortBooksByPrice(books);

        System.out.println("\nSorted Book Prices:");
        for (Book b : sortedBooks) {
            System.out.println(b.price);
        }

        System.out.print("\nEnter the author name: ");
        String author = sc.next();
        ArrayList<Book> queryResult = findBooksByAuthor(books, author);

        System.out.println("\nAll books by author " + author + ":");
        for (Book b : queryResult) {
            System.out.println(b);
        }

        if (queryResult.size() == 0) {
            System.out.println(author + " has no books.");
        }

        System.out.print("\nEnter the price: ");
        double price = sc.nextDouble();
        ArrayList<Book> booksAbovePrice = findBooksAbovePrice(books, price);

        System.out.println("\nAll books with price greater than " + price + ":");
        for (Book b : booksAbovePrice) {
            System.out.println(b);
        }

        if (booksAbovePrice.size() == 0) {
            System.out.println("There are no books with price greater than " + price);
        }

        System.out.print("\nEnter the publisher name: ");
        String publisher = sc.next();
        ArrayList<Book> booksByPublisher = findBooksByPublisher(books, publisher);

        System.out.println("\nAll books by publisher " + publisher + ":");
        for (Book b : booksByPublisher) {
            System.out.println(b);
        }

        if (booksByPublisher.size() == 0) {
            System.out.println("There are no books by publisher " + publisher);
        }

        sc.close();
    }

    public static ArrayList<Book> sortBooksByPrice(ArrayList<Book> books) {
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks);
        return sortedBooks;
    }

    public static ArrayList<Book> findBooksByAuthor(ArrayList<Book> books, String author) {
        ArrayList<Book> queryResult = new ArrayList<>();
        for (Book b : books) {
            if (author.equalsIgnoreCase(b.author)) {
                queryResult.add(b);
            }
        }
        return queryResult;
    }

    public static ArrayList<Book> findBooksAbovePrice(ArrayList<Book> books, double price) {
        ArrayList<Book> queryResult = new ArrayList<>();
        for (Book b : books) {
            if (price < b.price) {
                queryResult.add(b);
            }
        }
        return queryResult;
    }

    public static ArrayList<Book> findBooksByPublisher(ArrayList<Book> books, String publisher) {
        ArrayList<Book> queryResult = new ArrayList<>();
        for (Book b : books) {
            if (publisher.equalsIgnoreCase(b.publisher)) {
                queryResult.add(b);
            }
        }
        return queryResult;
    }
}

class Book implements Comparable<Book> {
    String title, author, publisher;
    double price;

    public Book(String title, String author, String publisher, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    @Override
    public String toString() {
        return "------\nTitle: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nPrice: " + price + "\n------";
    }

    @Override
    public int compareTo(Book other) {
        return Double.compare(this.price, other.price);
    }
}
