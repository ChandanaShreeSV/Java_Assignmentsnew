import java.util.*;
class LibraryBook {
    private Set<String> books = new TreeSet<>();

    public void addBook(String title) {
        if (books.add(title)) {
            System.out.println("Book added: " + title);
        } else {
            System.out.println("Duplicate book ignored: " + title);
        }
    }
     public void displaySortedBooks() {
        System.out.println("Books in catalog:");
        for (String book : books) {
            System.out.println(book);
        }
    }    public static void main(String[] args) {
        LibraryBook catalog = new LibraryBook();
        catalog.addBook("Java Programming");
        catalog.addBook("Data Structures");
        catalog.addBook("Algorithms");
        catalog.addBook("Python Basics");
        catalog.addBook("Web Development");

        catalog.displaySortedBooks();
    }
}
