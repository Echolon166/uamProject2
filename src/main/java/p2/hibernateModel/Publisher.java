package p2.hibernateModel;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PUBLISHER")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "publisherID", scope=Publisher.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publisher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PublisherID", unique = true, updatable = false, nullable = false)
    @JsonIgnore
    private Integer publisherID;
    
    @Column(name = "PublisherName", nullable = false)
    private String publisherName;
    
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<Book>();
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "publisher", cascade = CascadeType.ALL)
    @JoinColumn(name = "ContactInfo")
    private PublisherContactInfo publisherContactInfo;
    
    public Publisher() {}
    
    public Integer getPublisherID(){
        return publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }
    
    public void setPublisherName( String publisherName ) {
        this.publisherName = publisherName;
    }
    
    public List<Book> getBooks(){
        return this.books;
    }
    
    public void setBooks(List<Book> books){
        this.books = books;
    }
    
    public PublisherContactInfo getPublisherContactInfo() {
        return publisherContactInfo;
    }
    
    public void setPublisherContactInfo(PublisherContactInfo publisherContactInfo) {
        this.publisherContactInfo = publisherContactInfo;
    }
    
    public void addBook(Book book){
        this.books.add(book);
    }
    
    public void removeBook(Book book){
        this.books.remove(book);
    }
    
}
