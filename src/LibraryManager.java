public class LibraryManager {
    public static void main(String[] args) {
        Book book1 = new Book("El extranjero", "Albert Camus",
                1942, true);
        Book book2 = new Book("Niebla", "Miguel de Unamuno",
                1914, true);
        Book book3 = new Book("Metamorfosis", "Franz Kafka",
                1915, true);

        book1.borrow();
        book1.borrow();
        book1.showInformation();
        book1.returnBook();

        book2.showInformation();

        book3.borrow();
        book3.returnBook();
    }
}
