//2
import java.util.*;
import java.util.ArrayList;
public class BookDB {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book("TitIe1", "Authorl ", "Publisherl ", 100));
		books.add(new Book("TitIe2", "Authorl ", "Publisher2", 1000));
		books.add(new Book("TitIe3", "Author2", "Publisher3", 1001));
		books.add(new Book("TitIe4", "Author3", "Publisher4", 13));
		books.add(new Book("Title5", "Author4", "Publisher5", 10203));

		for(Book b: books) {
			System.out.println(b);
		}


		Collections.sort(books);
		for (Book b : books) {
			 System.out.println(b);
		}


		System.out.print("Enter the author name:");
		String author = sc.next();
		ArrayList<Book> queryResult = new ArrayList<>();
		for (Book b: books) {
		if (author.equalsIgnoreCase(b.author)) {
			 queryResult.add(b);
		}
		}
		System.out.println("All books by author " + author + ". ");
		for (Book b :queryResult) {
			System.out.println(b);
		}
		 
		if (queryResult.size() == 0) {
			System.out.println(author + " has no books");
		}



		ArrayList<Book> queryResultl = new ArrayList<>();
		System.out.print("Enter the price: ");
		double price = sc.nextDouble();
		for (Book b : books) {
			if (price < b.price) {
				queryResultl.add(b);
			}
		}
		System.out.println("All books with price greater than " + price + ". ");
		for (Book b :queryResultl ) {
			System.out.println(b);
		}
		if (queryResultl.size() == 0) {
			System.out.println("There are no books with price greater than " + price);
		}
	}
}
		class Book implements Comparable<Book>{
			String title,author,publisher;
			double price; 
			public Book(String title, String author ,String publisher ,double price) {
				this.title = title;
				this.author = author;
				this.publisher = publisher;
				this.price = price;
			}
			public String tostring() {
				return ("------\n"+ "Title. " + title + "\n"+ "Author. " + author + "\n"+ "Price. " + price + "\n"+"----");
			}
			
			public int compareTo(Book other) {
				return(int)(this.price-other.price);
				
			}
		}
