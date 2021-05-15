package hust.soict.hedspi.test.media;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import hust.soict.hedspi.aims.media.Book;

class BookTest {

    @Test
    void test() {
        String content = "This    is a. line.  The word This has the frequency of 2." +
                         "And the word word should has the frequency of 3!";
        List<String> authors = new ArrayList<String>();
        authors.add("authorName");
        Book book = new Book(0, "a", "", authors, 0.0f, content);
        System.out.println(book.toString());
        assertEquals(22, book.getNumberOfContentToken(), "Book.contentTokens(): wrong size");
        assertEquals(2, book.getWordFrequency().get("This"), "Book.wordFrequency(): wrong value");
        assertEquals(3, book.getWordFrequency().get("word"), "Book.wordFrequency(): wrong value");
    }

}