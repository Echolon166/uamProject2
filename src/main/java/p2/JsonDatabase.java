package p2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import p2.hibernateModel.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDatabase {
    
    private EntityManager entityManager = null;
    private EntityManagerFactory entityManagerFactory = null;
    
    public void fromJsonToDatabase(){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
    
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JodaModule());
            mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.
                                        WRITE_DATES_AS_TIMESTAMPS , false);
            
            List<Book> booksRead = mapper.readValue(new File("C:\\Users\\Lenovo\\Desktop\\prolab_p2\\databaseModel.json"), new TypeReference<List<Book>>(){});
    
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
    
    public void fromDatabaseToJson() throws IOException {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
    
            entityManager.getTransaction().begin();
            
            Query query = entityManager.createQuery("SELECT k FROM Book k");
            List<Book> books = query.getResultList();
            
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JodaModule());
            mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.
                                     WRITE_DATES_AS_TIMESTAMPS , false);
            
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\Lenovo\\Desktop\\prolab_p2\\databaseModel.json"), books);
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(books);
            System.out.println(jsonInString);
    
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
