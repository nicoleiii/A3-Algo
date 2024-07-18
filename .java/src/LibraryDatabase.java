import java.util.Scanner;

public class LibraryDatabase {
    private static final int MAX_ISBNS = 100;
    private String[] isbns = new String[MAX_ISBNS];
    private int count = 0;

    public boolean validateISBN(String isbn) {
        if (isbn.length() == 10 || isbn.length() == 13) {
            return true;
        } else {
            return false;
        }
    }

    public void addISBN(String isbn) {
        if (count < MAX_ISBNS) {
            if (validateISBN(isbn)) {
                isbns[count] = isbn;
                count++;
            } else {
                System.out.println("Invalid.");
            }
        } else {
            System.out.println("The database is full.");
        }
    }

    public boolean searchISBN(String isbn) {
        for (int i = 0; i < count; i++) {
            if (isbns[i].equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public void printAllISBNs() {
        for (int i = 0; i < count; i++) {
            System.out.println(isbns[i]);
        }
    }

    public static void main(String[] args) {
        LibraryDatabase db = new LibraryDatabase();
        Scanner scanner = new Scanner(System.in);
        String isbn;

        while (true) {
            System.out.println("Enter ISBN ");
            isbn = scanner.nextLine();
            if (isbn.equalsIgnoreCase("exit")) {
                break;
            }
            db.addISBN(isbn);
        }

        while (true) {
            System.out.println("Search for ISBN ");
            isbn = scanner.nextLine();
            if (isbn.equalsIgnoreCase("exit")) {
                break;
            }
            if (db.searchISBN(isbn)) {
                System.out.println("ISBN found.");
            } else {
                System.out.println("ISBN not found.");
            }
        }

        System.out.println("All ISBNs in the database:");
        db.printAllISBNs();

        scanner.close();
    }
}
