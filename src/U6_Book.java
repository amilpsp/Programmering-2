public class U6_Book {
    private String title;
    private String author;
    private String publisher;
    private String ISBN;

    public U6_Book(String title, String author, String publisher, String ISBN){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
    }

    public void displayBook(){
        System.out.println("This book's information is: ");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Publisher" + this.publisher);
        System.out.println("ISBN: " + this.ISBN);
        System.out.println();
    }

    public static void main(String[]args){
        U6_Book book1 = new U6_Book(
                "Pride & Prejudice",
                "Jane Austen",
                "whatever1",
                "111111111"
        );
        U6_Book book2 = new U6_Book(
                "Brave New World",
                "Aldous Huxley",
                "whatever2",
                "222222222222"
        );
        U6_Book book3 = new U6_Book(
                "1984",
                "George Orwell",
                "akjdfhk",
                "33333333333"
        );
        U6_Book book4 = new U6_Book(
                "Colorless Tsukuru Tazaki and His Years of Pilgrimage",
                "Haruki Murakami",
                "mnmnmnmnmn",
                "18723649127398"
        );
        book1.displayBook();
        book2.displayBook();
        book3.displayBook();
        book4.displayBook();
    }
}
