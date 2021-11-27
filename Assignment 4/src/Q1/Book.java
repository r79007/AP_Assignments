package Q1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Book {
    private String title;
    private long ISBN;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getISBN() {
        return this.ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public long getBarcode() {
        return this.barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    private long barcode;

    public Book(String title, long ISBN, long barcode) {
        this.title = title;
        this.ISBN = ISBN;
        this.barcode = barcode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PQComparator cmp = new PQComparator();
        PriorityQueue<Book> pq = new PriorityQueue<>(cmp);
        ArrayList<Book> arrl = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        System.out.print("Enter number of racks: ");
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.print("Enter name of book " + (int) (i + 1) + " : ");
            String name = sc.nextLine();
            System.out.print("Enter ISBN of book " + (int) (i + 1) + " : ");

            long isbn = sc.nextLong();
            while(Long.toString(isbn).length()!=13) {
                if (Long.toString(isbn).length() != 13) {
                    System.out.println("ISBN not of length 13, try again!");
                    isbn = sc.nextLong();
                }
            }

            long barcode = -1;

            while (true) {
                System.out.print("Enter Barcode of book " + (int) (i + 1) + " : ");
                boolean barcodeFlag = true;
                barcode = sc.nextLong();
                while(Long.toString(barcode).length()!=12){
                    if(Long.toString(barcode).length()!=12){
                        System.out.println("Barcode not of length 12, try again!");
                        barcode=sc.nextLong();
                    }
                }
                int idx = 0;
                for (Book b : arrl) {
                    if (b.getBarcode() == barcode) {
                        System.out.println("Book with this barcode already exists");
                        barcodeFlag = false;
                        idx++;
                    } else {
                        idx++;
                    }

                }
                if (idx == arrl.size() && barcodeFlag == true) {
                    break;
                }

            }
            Book b = new Book(name, isbn, barcode);

            pq.add(b);
            arrl.add(b);
        }
        ArrayList<Book> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        int shelfSize = n / k;
        int num = 0;
        int racNum = 0;
        while (num != ans.size()) {
            System.out.println("Books on rack " + (int) (racNum + 1));

            for (int i = 0; i < shelfSize; i++) {

                System.out.print(ans.get(num).getTitle() + " ISBN: " + ans.get(num).getISBN() + " Barcode: " + ans.get(num).getBarcode() + "| ");
                num++;
            }
            System.out.println();
            racNum++;
        }

        int op = -1;
        System.out.println("Enter 1 to search for books\n" + "Enter 2 to exit\n");
        op=sc.nextInt();
        while (op != 2) {
            if (op == 1) {
                System.out.print("Enter barcode of the book you are looking for: ");
                long brc = sc.nextLong();
                boolean found=false;
                for (int i = 0; i < ans.size(); i++) {
                    if (ans.get(i).getBarcode() == brc) {
                        int rack = i / shelfSize + 1;
                        int pos = i % shelfSize + 1;
                        System.out.println("Book present on rack " + rack + " at position " + pos);
                        found=true;
                    }
                }
                if(found==false){
                    System.out.println("No such book exists, try again!");
                }
                System.out.println("Enter 1 to search for books\n" + "Enter 2 to exit\n");
                op=sc.nextInt();
            }
        }
    }

}

class PQComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getTitle().compareTo(o2.getTitle())==0){
            if(o1.getISBN()==o2.getISBN()){
                if(o1.getBarcode()==o2.getBarcode()){
                    return 0;
                }else if(o1.getBarcode()<o2.getBarcode()){
                    return -1;
                }else{
                    return 1;
                }
            }else if(o1.getISBN()<o2.getISBN()){
                return -1;
            }else{
                return 1;
            }
        }else if(o1.getTitle().compareTo(o2.getTitle())<0){
            return -1;
        }else{
            return 1;
        }
    }
}


