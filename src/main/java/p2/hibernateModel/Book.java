package p2.hibernateModel;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOK")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="isbn", scope=Book.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    
    @Id
    @Column(name = "ISBN", unique = true, nullable = false)
    private String isbn;
    
    @Column(name = "Title", nullable = false)
    private String title;
    
    @Column(name = "Price")
    private double price;
    
    @Column(name = "PageCount")
    private int pageCount;
    
    @Column(name = "PublicationDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Books_Authors",
            joinColumns = {
                    @JoinColumn(name = "ISBN", nullable = false, updatable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "AuthorID" , nullable = false, updatable = false) }
    )
    private List<Author> authors = new ArrayList<Author>();
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PublisherID", nullable = false)
    private Publisher publisher;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CategoryID")
    private Category category;
    
    public Book() {}
    
    public String getISBN(){
        return isbn;
    }
    
    public void setISBN( String isbn ){
        this.isbn = isbn;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle( String title){
        this.title = title;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice( double price ){
        this.price = price;
    }
    
    public int getPageCount(){
        return pageCount;
    }
    
    public void setPageCount( int pageCount ){
        this.pageCount = pageCount;
    }
    
    public LocalDate getPublicationDate(){
        return publicationDate;
    }
    
    public void setPublicationDate( LocalDate publicationDate ){
        this.publicationDate = publicationDate;
    }
    
    public List<Author> getAuthors(){
        return authors;
    }
    
    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }
    
    public void addAuthor(Author author){
        this.authors.add(author);
    }
    
    public void removeAuthor(Author author){
        this.authors.remove(author);
    }
    
    public Publisher getPublisher(){
        return publisher;
    }
    
    public void setPublisher( Publisher publisher ){
        this.publisher = publisher;
    }
    
    public Category getCategory(){
        return category;
    }
    
    public void setCategory( Category category ){
        this.category = category;
    }
    
}