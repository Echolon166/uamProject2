package p2;

import org.joda.time.LocalDate;
import p2.hibernateModel.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class DatabaseData {
    private EntityManager entityManager = null;
    private EntityManagerFactory entityManagerFactory = null;
    
    private Book book = null;
    private Author author = null;
    private AuthorContactInfo authorContactInfo = null;
    private Publisher publisher = null;
    private PublisherContactInfo publisherContactInfo = null;
    private Category category = null;
    
    public void dataExample(){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
    
            entityManager.getTransaction().begin();
            
            //<BOOK1>//
            book = new Book();
            book.setISBN("0261103573");
            book.setTitle("The Fellowship of the Ring (The Lord of the Rings, Part 1)");
            book.setPrice(56.42);
            book.setPageCount(408);
            book.setPublicationDate(new LocalDate("1987-04-02"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("J. R. R.");
            author.setLastName("Tolkien");
            authorContactInfo.setCity("Oxford");
            authorContactInfo.setCountry("United Kingdom");
            authorContactInfo.setPhone(5537264413L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
            
            book.addAuthor(author);
    
            publisher = new Publisher();
            publisherContactInfo = new PublisherContactInfo();
            publisher.setPublisherName("Harper Collins");
            publisherContactInfo.setCity("New York");
            publisherContactInfo.setCountry("ABD");
            publisherContactInfo.setPhone(5466122123L);
            publisherContactInfo.setPublisher(publisher);
            publisher.setPublisherContactInfo(publisherContactInfo);
            
            book.setPublisher(publisher);
    
            category = new Category();
            category.setCategoryName("Fantasy");
            
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
            
            //<BOOK2>//
            book = new Book();
            book.setISBN("0261103580");
            book.setTitle("The Two Towers (The Lord of the Rings, Part 2)");
            book.setPrice(53.40);
            book.setPageCount(328);
            book.setPublicationDate(new LocalDate("1992-09-29"));
            
            book.addAuthor(author);
            book.setPublisher(publisher);
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK3>//
            book = new Book();
            book.setISBN("0261103597");
            book.setTitle("The Return of the King (The Lord of the Rings, Part 3)");
            book.setPrice(62.24);
            book.setPageCount(390);
            book.setPublicationDate(new LocalDate("1999-01-20"));
    
            book.addAuthor(author);
            book.setPublisher(publisher);
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
            
            //<BOOK4>//
            book = new Book();
            book.setISBN("0006546064");
            book.setTitle("Fahrenheit 451");
            book.setPrice(33.03);
            book.setPageCount(192);
            book.setPublicationDate(new LocalDate("2006-07-16"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Ray");
            author.setLastName("Bradbury");
            authorContactInfo.setCity("Los Angeles");
            authorContactInfo.setCountry("ABD");
            authorContactInfo.setPhone(5327685532L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
            book.setPublisher(publisher);
    
            category = new Category();
            category.setCategoryName("Science Fiction");
    
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK5>//
            book = new Book();
            book.setISBN("0141036133");
            book.setTitle("Animal Farm");
            book.setPrice(29.96);
            book.setPageCount(112);
            book.setPublicationDate(new LocalDate("2012-12-11"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("George");
            author.setLastName("Orwell");
            authorContactInfo.setCity("Motihari");
            authorContactInfo.setCountry("India");
            authorContactInfo.setPhone(5961221287L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            publisher = new Publisher();
            publisherContactInfo = new PublisherContactInfo();
            publisher.setPublisherName("Penguin Books");
            publisherContactInfo.setCity("Berlin");
            publisherContactInfo.setCountry("Germany");
            publisherContactInfo.setPhone(4421268532L);
            publisherContactInfo.setPublisher(publisher);
            publisher.setPublisherContactInfo(publisherContactInfo);
    
            book.setPublisher(publisher);
    
            category = new Category();
            category.setCategoryName("Political");
    
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK6>//
            book = new Book();
            book.setISBN("1840226358");
            book.setTitle("Ulysses");
            book.setPrice(18.34);
            book.setPageCount(736);
            book.setPublicationDate(new LocalDate("1971-03-30"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("James");
            author.setLastName("Joyce");
            authorContactInfo.setCity("Rathgar");
            authorContactInfo.setCountry("Ireland");
            authorContactInfo.setPhone(9212886432L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            publisher = new Publisher();
            publisherContactInfo = new PublisherContactInfo();
            publisher.setPublisherName("Wordsworth Editions");
            publisherContactInfo.setCity("Stockholm");
            publisherContactInfo.setCountry("Sweden");
            publisherContactInfo.setPhone(7686427328L);
            publisherContactInfo.setPublisher(publisher);
            publisher.setPublisherContactInfo(publisherContactInfo);
    
            book.setPublisher(publisher);
    
            category = new Category();
            category.setCategoryName("Contemporary Fiction");
    
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK7>//
            book = new Book();
            book.setISBN("0399501487");
            book.setTitle("Lord of the Flies");
            book.setPrice(32.35);
            book.setPageCount(208);
            book.setPublicationDate(new LocalDate("2017-09-21"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("William");
            author.setLastName("Golding");
            authorContactInfo.setCity("Newquay");
            authorContactInfo.setCountry("United Kingdom");
            authorContactInfo.setPhone(9212886432L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            Query query = entityManager.createQuery("SELECT k FROM Publisher k WHERE publisherName='Penguin Books'");
            List<Publisher> publishers = query.getResultList();
            
            book.setPublisher(publishers.get(0));
    
            book.setCategory(category);
    
            author.addBook(book);
            publishers.get(0).addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publishers.get(0));
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK8>//
            book = new Book();
            book.setISBN("0241951445");
            book.setTitle("A Clockwork Orange");
            book.setPrice(28.95);
            book.setPageCount(144);
            book.setPublicationDate(new LocalDate("1991-04-19"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Anthony");
            author.setLastName("Burgess");
            authorContactInfo.setCity("Manchester");
            authorContactInfo.setCountry("United Kingdom");
            authorContactInfo.setPhone(6786432226L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            book.setPublisher(publishers.get(0));
    
            query = entityManager.createQuery("SELECT k FROM Category k WHERE categoryName='Science Fiction'");
            List<Category> categories = query.getResultList();
    
            book.setCategory(categories.get(0));
    
            author.addBook(book);
            publishers.get(0).addBook(book);
            categories.get(0).addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publishers.get(0));
            entityManager.persist(categories.get(0));
            entityManager.persist(book);
    
            //<BOOK9>//
            book = new Book();
            book.setISBN("0141441674");
            book.setTitle("Heart of Darkness");
            book.setPrice(25.25);
            book.setPageCount(192);
            book.setPublicationDate(new LocalDate("1986-08-15"));
            
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Joseph");
            author.setLastName("Conrad");
            authorContactInfo.setCity("Berdicev");
            authorContactInfo.setCountry("Ukraine");
            authorContactInfo.setPhone(5883542137L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            publisher = new Publisher();
            publisherContactInfo = new PublisherContactInfo();
            publisher.setPublisherName("Cengage Learning");
            publisherContactInfo.setCity("Boston");
            publisherContactInfo.setCountry("ABD");
            publisherContactInfo.setPhone(6886421652L);
            publisherContactInfo.setPublisher(publisher);
            publisher.setPublisherContactInfo(publisherContactInfo);
    
            book.setPublisher(publisher);
    
            category = new Category();
            category.setCategoryName("Historical Fiction");
    
            book.setCategory(category);
    
            author.addBook(book);
            publisher.addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK10>//
            book = new Book();
            book.setISBN("1853260088");
            book.setTitle("Moby Dick");
            book.setPrice(15.84);
            book.setPageCount(544);
            book.setPublicationDate(new LocalDate("1995-07-01"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Herman");
            author.setLastName("Melville");
            authorContactInfo.setCity("New York");
            authorContactInfo.setCountry("ABD");
            authorContactInfo.setPhone(7448642175L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            query = entityManager.createQuery("SELECT k FROM Publisher k WHERE publisherName='Wordsworth Editions'");
            publishers = query.getResultList();
    
            book.setPublisher(publishers.get(0));
    
            category = new Category();
            category.setCategoryName("Adventure");
    
            book.setCategory(category);
    
            author.addBook(book);
            publishers.get(0).addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publishers.get(0));
            entityManager.persist(category);
            entityManager.persist(book);
    
            //<BOOK11>//
            book = new Book();
            book.setISBN("0486470615");
            book.setTitle("The Trial");
            book.setPrice(17.67);
            book.setPageCount(176);
            book.setPublicationDate(new LocalDate("2002-06-18"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Franz");
            author.setLastName("Kafka");
            authorContactInfo.setCity("Prague");
            authorContactInfo.setCountry("Czech Republic");
            authorContactInfo.setPhone(7795432775L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            publisher = new Publisher();
            publisherContactInfo = new PublisherContactInfo();
            publisher.setPublisherName("Dover Publications");
            publisherContactInfo.setCity("Warsaw");
            publisherContactInfo.setCountry("Poland");
            publisherContactInfo.setPhone(6684327548L);
            publisherContactInfo.setPublisher(publisher);
            publisher.setPublisherContactInfo(publisherContactInfo);
    
            book.setPublisher(publisher);
    
            query = entityManager.createQuery("SELECT k FROM Category k WHERE categoryName='Science Fiction'");
            categories = query.getResultList();
    
            book.setCategory(categories.get(0));
    
            author.addBook(book);
            publisher.addBook(book);
            categories.get(0).addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(categories.get(0));
            entityManager.persist(book);
    
            //<BOOK12>//
            book = new Book();
            book.setISBN("1784873187");
            book.setTitle("The Handmaid's Tale");
            book.setPrice(38.50);
            book.setPageCount(336);
            book.setPublicationDate(new LocalDate("2009-10-01"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Margaret");
            author.setLastName("Atwood");
            authorContactInfo.setCity("Ottowa");
            authorContactInfo.setCountry("Canada");
            authorContactInfo.setPhone(6964327512L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            publisher = new Publisher();
            publisherContactInfo = new PublisherContactInfo();
            publisher.setPublisherName("Vintage Publishing");
            publisherContactInfo.setCity("Paris");
            publisherContactInfo.setCountry("France");
            publisherContactInfo.setPhone(6439965958L);
            publisherContactInfo.setPublisher(publisher);
            publisher.setPublisherContactInfo(publisherContactInfo);
    
            book.setPublisher(publisher);
            
            query = entityManager.createQuery("SELECT k FROM Category k WHERE categoryName='Contemporary Fiction'");
            categories = query.getResultList();
    
            book.setCategory(categories.get(0));
    
            author.addBook(book);
            publisher.addBook(book);
            categories.get(0).addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publisher);
            entityManager.persist(categories.get(0));
            entityManager.persist(book);
    
            //<BOOK13>//
            book = new Book();
            book.setISBN("1853260231");
            book.setTitle("Frankenstein");
            book.setPrice(14.11);
            book.setPageCount(208);
            book.setPublicationDate(new LocalDate("1999-08-18"));
    
            author = new Author();
            authorContactInfo = new AuthorContactInfo();
            author.setFirstName("Mary");
            author.setLastName("Shelley");
            authorContactInfo.setCity("London");
            authorContactInfo.setCountry("United Kingdom");
            authorContactInfo.setPhone(3478474853L);
            authorContactInfo.setAuthor(author);
            author.setAuthorContactInfo(authorContactInfo);
    
            book.addAuthor(author);
    
            query = entityManager.createQuery("SELECT k FROM Publisher k WHERE publisherName='Wordsworth Editions'");
            publishers = query.getResultList();
    
            book.setPublisher(publishers.get(0));
    
            category = new Category();
            category.setCategoryName("Horror");
    
            book.setCategory(category);
    
            author.addBook(book);
            publishers.get(0).addBook(book);
            category.addBook(book);
    
            entityManager.persist(author);
            entityManager.persist(publishers.get(0));
            entityManager.persist(category);
            entityManager.persist(book);
            
            
            entityManager.getTransaction().commit();
    
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
    }
    
    public void clearDatabase(){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
            
            entityManager.createQuery("DELETE FROM Book").executeUpdate();
            entityManager.createQuery("DELETE FROM Author").executeUpdate();
            entityManager.createQuery("DELETE FROM AuthorContactInfo").executeUpdate();
            entityManager.createQuery("DELETE FROM Publisher").executeUpdate();
            entityManager.createQuery("DELETE FROM PublisherContactInfo").executeUpdate();
            entityManager.createQuery("DELETE FROM Category").executeUpdate();
            
            entityManager.getTransaction().commit();
        
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
    }
    
    public List<Book> q1BooksWrittenByTolkien(){
        List<Book> books = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
            
            entityManager.getTransaction().begin();
            
            Query query = entityManager.createQuery("SELECT BK FROM Book BK " +
                                                           "INNER JOIN BK.authors BKA " +
                                                            "INNER JOIN Author A ON A.authorID = BKA.authorID " +
                                                            "WHERE A.firstName = 'J. R. R.' AND A.lastName = 'Tolkien'");
            books = query.getResultList();
            entityManager.getTransaction().commit();
            
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
        return books;
    }
    
    public List<Publisher> q2PublishersWhomPublishedScienceFiction(){
        List<Publisher> publishers = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
    
            Query query = entityManager.createQuery("SELECT DISTINCT PB FROM Publisher PB " +
                                                            "INNER JOIN PB.books BK " +
                                                            "INNER JOIN BK.category CG " +
                                                            "WHERE CG.categoryName = 'Science Fiction'");
            publishers = query.getResultList();
            
            entityManager.getTransaction().commit();
        
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
        return publishers;
    }
    
    public AuthorContactInfo q3ContactInfoWriterOfUlysses(){
        AuthorContactInfo authorContactInfo = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
    
            Query query = entityManager.createQuery("SELECT AC FROM AuthorContactInfo AC " +
                                                            "INNER JOIN AC.author A " +
                                                            "INNER JOIN A.books AB " +
                                                            "INNER JOIN Book BK ON BK.isbn = AB.isbn " +
                                                            "WHERE BK.title = 'Ulysses'");
    
            authorContactInfo = (AuthorContactInfo) query.getSingleResult();
        
            entityManager.getTransaction().commit();
        
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
        return authorContactInfo;
    }
    
    public Long q4PhoneOfHarperCollins(){
        Long phone = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
    
            Query query = entityManager.createQuery("SELECT PC.phone FROM PublisherContactInfo PC " +
                                                            "INNER JOIN PC.publisher P " +
                                                            "WHERE P.publisherName = 'Harper Collins'");
    
            phone = (Long) query.getSingleResult();
            
            entityManager.getTransaction().commit();
        
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
        return phone;
    }
    
    public List<Book> q5BooksPaginated(){
        List<Book> booksLastPage = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
    
            int pageSize = 10;
    
            Query countQuery = entityManager.createQuery("SELECT COUNT(BK.isbn) FROM Book BK ");
            Long countResults = (Long) countQuery.getSingleResult();
            int lastPageNumber = (int) (Math.ceil(countResults / pageSize));
    
            Query selectQuery = entityManager.createQuery("FROM Book");
            selectQuery.setFirstResult((lastPageNumber -1) * pageSize);
            selectQuery.setMaxResults(pageSize);
            booksLastPage = selectQuery.getResultList();
            
            entityManager.getTransaction().commit();
        
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {
            entityManagerFactory.close();
        }
        return booksLastPage;
    }
}
