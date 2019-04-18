package p2.hibernateModel;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Entity
@Table(name = "AUTHOR_CONTACT_INFO")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "authorID", scope=AuthorContactInfo.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AuthorContactInfo {
    
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "author"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "AuthorID", unique = true, updatable = false, nullable = false)
    @JsonIgnore
    private Integer authorID;
    
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Author author;
    
    @Column(name = "City")
    private String city;
    
    @Column(name = "Country")
    private String country;
    
    @Column(name = "Phone")
    private long phone;
    
    public AuthorContactInfo() {}
    
    public Integer getAuthorID(){
        return authorID;
    }
    
    public Author getAuthor(){
        return author;
    }
    
    public void setAuthor(Author author){
        this.author = author;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public long getPhone(){
        return phone;
    }
    
    public void setPhone(long phone){
        this.phone = phone;
    }
    
}
