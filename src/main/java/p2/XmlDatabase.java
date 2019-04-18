package p2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import p2.hibernateModel.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.util.List;

public class XmlDatabase {
    
    private EntityManager entityManager = null;
    private EntityManagerFactory entityManagerFactory = null;
    
    public void fromXmlToDatabase(){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
            
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JodaModule());
            xmlMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.
                                        WRITE_DATES_AS_TIMESTAMPS , false);
            
            List<Book> booksRead = xmlMapper.readValue(new File("C:\\Users\\Lenovo\\Desktop\\prolab_p2\\databaseModel.xml"), new TypeReference<List<Book>>(){});
            
            
            for(int i=0; i<booksRead.size(); i++){
                entityManager.persist(booksRead.get(i));
            }
    
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
    
    public void fromDatabaseToXml(){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
    
            Query query = entityManager.createQuery("SELECT k FROM Book k");
            List<Book> books = query.getResultList();
            
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JodaModule());
            xmlMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.
                                        WRITE_DATES_AS_TIMESTAMPS , false);
            
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\Lenovo\\Desktop\\prolab_p2\\databaseModel.xml"), books);
            String xmlInString = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(books);
            System.out.println(xmlInString);
        
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
    
}
