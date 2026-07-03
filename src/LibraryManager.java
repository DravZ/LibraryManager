import java.util.Objects;
import java.util.Scanner;

public class LibraryManager {
    static Scanner sc = new Scanner(System.in);
    private static final int MAX_BOOKS = 10;
    public static void main(String[] args) {

        Book[] books = new Book[MAX_BOOKS];
        boolean isRunning = true;
        int bookPosition = -1;

        while (isRunning){
            switch (showMenu()){
                case 1:
                    if(bookPosition == 10){
                        System.out.println("You already have 10 books, you can't add more books.");
                        break;
                    }
                    bookPosition++;
                    books[bookPosition] = addBook();
                    pause();
                    break;
                case 2:
                    showBooks(books, bookPosition);
                    pause();
                    break;
                case 3:
                    searchBookByName(books, bookPosition);
                    pause();
                    break;
                case 4:
                    borrowBook(books, bookPosition);
                    pause();
                    break;
                case 5:
                    returnBook(books, bookPosition);
                    pause();
                    break;
                case 6:
                    isRunning = false;
            }
        }

    }

    static int showMenu(){
        System.out.println("""
                1.- Add a book
                2.- Show books
                3.- Search book by name
                4.- Borrow book
                5.- Return book
                6.- Exit
                
                Select an option:""");
        return sc.nextInt();
    }

    static void pause(){
        System.out.println("Press any key to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    static Book addBook(){
        sc.nextLine();
        System.out.print("Enter the book name:");
        var title = sc.nextLine();
        System.out.print("Enter the name of the author:");
        var author = sc.nextLine();
        System.out.print("Enter the publication year:");
        var publicationYear = sc.nextInt();
        var isAvailable = true;
        return new Book(title,author,publicationYear,isAvailable);
    }

    static void showBooks(Book[] books, int bookPosition){
        if(bookPosition != -1){
            for (int i = 0; i <= bookPosition; i++){
                System.out.println("======================");
                System.out.println("Id: " + i);
                books[i].showInformation();
            }
        }else{
            System.out.println("No books to show.");
        }
    }

    static void searchBookByName(Book[] books, int bookPosition){
        sc.nextLine();
        System.out.print("Enter the title of the book:");
        var title = sc.nextLine();
        var wasBookFound = false;

        for (int i = 0; i <= bookPosition; i++){
            if(title.equalsIgnoreCase(books[i].getTitle())){
                System.out.println("Id:" + i);
                books[i].showInformation();
                wasBookFound = true;
            }
        }
        if(!wasBookFound) System.out.println("The book was not found.");
    }

    static void borrowBook(Book[] books, int bookPosition){
        System.out.println("Ingrese el id del libro:");
        var position = sc.nextInt();
        if(position >= 0 &&
                position <= bookPosition){
            books[position].borrow();
        }
        else {
            System.out.println("Book not found");
        }
    }

    static void returnBook(Book[] books, int bookPosition){

        System.out.println("Ingrese el id del libro:");
        var position = sc.nextInt();
        if(position >= 0 &&
                position <= bookPosition){
            books[position].returnBook();
        }
        else {
            System.out.println("Book not found");
        }
    }
}
