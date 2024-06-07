package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Books {
    @Id
    @GeneratedValue
    private int bookId;
    private String bookName;

    private int authorId;

    public Books(int bookId, String bookName, int authorId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorId = authorId;
    }

    public Books() {

    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author=" + authorId +
                '}';
    }
}
