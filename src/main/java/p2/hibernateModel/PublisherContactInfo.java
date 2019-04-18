package p2.hibernateModel;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "PUBLISHER_CONTACT_INFO")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "publisherID", scope=PublisherContactInfo.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PublisherContactInfo {
    
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "publisher"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "PublisherID", unique = true, updatable = false, nullable = false)
    @JsonIgnore
    private Integer publisherID;
    
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Publisher publisher;
    
    @Column(name = "City")
    private String city;
    
    @Column(name = "Country")
    private String country;
    
    @Column(name = "Phone")
    private long phone;
    
    public PublisherContactInfo() {}
    
    public Integer getPublisherID() {
        return publisherID;
    }
    
    public void setPublisherID(int publisherID){
        this.publisherID = publisherID;
    }
    
    public Publisher getPublisher() {
        return publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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
