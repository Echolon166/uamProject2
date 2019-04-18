package p2.hibernateModel;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "authorID", scope=Author.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID", unique = true, updatable = false, nullable = false)
    @JsonIgnore
    private Integer authorID;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ContactInfo")
    private AuthorContactInfo authorContactInfo;
    
    public Author() {}
    
    public Integer getAuthorID(){
        return authorID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public List<Book> getBooks(){
        return books;
    }
    
    public void setBooks(List<Book> books){
        this.books = books;
    }
    
    public void addBook(Book book){
        this.books.add(book);
    }
    
    public void removeBook(Book book){
        this.books.remove(book);
    }
    
    public AuthorContactInfo getAuthorContactInfo() {
        return authorContactInfo;
    }
    
    public void setAuthorContactInfo(AuthorContactInfo authorContactInfo) {
        this.authorContactInfo = authorContactInfo;
    }
    
}
