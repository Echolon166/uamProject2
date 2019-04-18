package p2;

import p2.hibernateModel.*;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.*;

public class DatabaseQueryTest {
    
    @Test
    public void Q1test() {
        boolean success = true;
        
        DatabaseData databaseData = new DatabaseData();
        List<Book> books = databaseData.q1BooksWrittenByTolkien();
        
        try {
            assertThat(books, containsInAnyOrder(
                    hasProperty("ISBN", is("0261103573")),
                    hasProperty("ISBN", is("0261103580")),
                    hasProperty("ISBN", is("0261103597"))
            ));
            
            System.out.println("\nBooks written by author J.R.R. Tolkien: ");
            for(int i=0; i<books.size(); i++){
                System.out.println(books.get(i).getISBN() + " " + books.get(i).getTitle());
            }
        }
        catch(AssertionError e){
            success = false;
        }
        
        assertTrue(success);
    }
    
    @Test
    public void Q2test() {
        boolean success = true;
        
        DatabaseData databaseData = new DatabaseData();
        List<Publisher> publishers = databaseData.q2PublishersWhomPublishedScienceFiction();
        try {
            
            assertThat(publishers, containsInAnyOrder(
                    hasProperty("publisherName", is("Harper Collins")),
                    hasProperty("publisherName", is("Penguin Books")),
                    hasProperty("publisherName", is("Dover Publications"))
            ));
            
            System.out.println("\nPublishers whom published an Science Fiction book: ");
            for(int i=0; i<publishers.size(); i++){
                System.out.println(publishers.get(i).getPublisherName());
            }
        }
        catch(AssertionError e){
            success = false;
        }
        
        assertTrue(success);
    }
    
    @Test
    public void Q3test() {
        DatabaseData databaseData = new DatabaseData();
        AuthorContactInfo authorContactInfo = databaseData.q3ContactInfoWriterOfUlysses();
            
        assertEquals(authorContactInfo.getCity(), "Rathgar");
        assertEquals(authorContactInfo.getCountry(), "Ireland");
        assertEquals(authorContactInfo.getPhone(), 9212886432L);
        
        System.out.println("\nContact info of the writer of the book Ulysses: ");
        System.out.println("ID: " + authorContactInfo.getAuthorID() + "\nCity: " + authorContactInfo.getCity() +
                                   "\nCountry: " +authorContactInfo.getCountry() + "\nPhone: " + authorContactInfo.getPhone());
    }
    
    @Test
    public void Q4test() {
        DatabaseData databaseData = new DatabaseData();
        Long phone = databaseData.q4PhoneOfHarperCollins();
        
        assertTrue(phone == 5466122123L);
            
        System.out.println("\nPhone number of the publisher Harper Collins: ");
        System.out.println(phone);
    }
    
    @Test
    public void Q5testWithPagination() {
        boolean success = true;
    
        int pageSize = 10;
        
        DatabaseData databaseData = new DatabaseData();
        List<Book> booksLastPage = databaseData.q5BooksPaginated();
    
        try {
            assertThat(booksLastPage, hasSize(lessThan(pageSize + 1)));
    
            System.out.println("\nPaginated result of books: ");
            for(int i=0; i< booksLastPage.size(); i++){
                System.out.println((i+1) + "- " + booksLastPage.get(i).getISBN() + " " + booksLastPage.get(i).getTitle());
            }
        }
        catch(AssertionError e){
            success = false;
        }
        
        assertTrue(success);
    }
    
}