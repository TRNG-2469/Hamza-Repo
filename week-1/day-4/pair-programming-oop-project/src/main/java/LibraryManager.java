public class LibraryManager {
    public static void main(String[] args) {
        EBook ebook1 = new EBook("The Great Gatsby", "F. Scott Fitzgerald", 2.5);
        EBook ebook2 = new EBook("1984", "George Orwell", 1.8);
        EBook ebook3 = new EBook("To Kill a Mockingbird", "Harper Lee", 3.2);
        EBook[] arr = new EBook[]{ebook1, ebook2, ebook3};

        for (EBook book: arr){
            System.out.println(book.toString());
            book.borrowItem();
            book.returnItem();
            System.out.println("Downloading " + book.getTitle() + "...");
            book.downloadBook(500); // Download 500 KB
            System.out.println();
        }
    }
}
