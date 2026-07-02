public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String title, String author, int publicationYear,
                boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;

    }

    public void borrow() {
        if (isAvailable) {
            System.out.println("You have borrowed the book " + title + " by " + author + ".");
            isAvailable = false;
        } else {
            System.out.println("The book: " + title + " - " + author + " is not available.");
        }
    }

    public void returnBook() {
        if (isAvailable) {
            System.out.println("The book is already available.");
        } else {
            isAvailable = true;
            System.out.println("You have returned the book: " + title + " - " + author);
        }
    }

    public void showInformation() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + publicationYear);
        System.out.println("Status: " + (isAvailable ? "Yes" : "No"));
    }
}
