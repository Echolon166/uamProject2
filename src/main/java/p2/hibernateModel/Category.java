package p2.hibernateModel;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "categoryID", scope=Category.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", unique = true, updatable = false, nullable = false)
    @JsonIgnore
    private Integer categoryID;
    
    @Column(name = "CategoryName", nullable = false)
    private String categoryName;
    
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<Book>();
    
    public Category() {}
    
    public Integer getCategoryID(){
        return categoryID;
    }
    
    public void setCategoryID(int categoryID){
        this.categoryID = categoryID;
    }
    
    public String getCategoryName(){
        return categoryName;
    }
    
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    
    public List<Book> getBooks(){
        return this.books;
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
}
