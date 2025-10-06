class Library {
    private String name;

    Library(String name) {
        this.name = name;
        System.out.println("Library: " + name);
    }
    class Book {
        private String title;
        Book(String title) {
            this.title = title;
            System.out.println("Book added: " + title);
        }
        void display() {
            System.out.println(title + " at " + name);
        }
    }
    void addBook(String title) {
        Book b = new Book(title);
        b.display();
    }
 public static void main(String[] args) {
        Library lib = new Library("City Library");

        Library.Book book1 = lib.new Book("Java Guide");
        book1.display();
        lib.addBook("Python Guide");
    }
}
