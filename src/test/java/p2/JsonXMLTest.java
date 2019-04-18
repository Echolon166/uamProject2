package p2;

import org.junit.Test;
import p2.hibernateModel.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.*;

public class JsonXMLTest {
    
    private EntityManager entityManager = null;
    private EntityManagerFactory entityManagerFactory = null;
    
    DatabaseData databaseData = null;
    
    JsonDatabase jsonDatabase = null;
    XmlDatabase xmlDatabase = null;
    
    @Test
    public void databaseToJson() throws IOException {
        
        jsonDatabase = new JsonDatabase();
        jsonDatabase.fromDatabaseToJson();
        
        assertTrue(new File("C:\\Users\\Lenovo\\Desktop\\prolab_p2\\databaseModel.json").isFile());
    }
    
    @Test
    public void databaseToXml(){
        databaseData = new DatabaseData();
        databaseData.dataExample();
        
        xmlDatabase = new XmlDatabase();
        xmlDatabase.fromDatabaseToXml();
    
        assertTrue(new File("C:\\Users\\Lenovo\\Desktop\\prolab_p2\\databaseModel.xml").isFile());
    }
    
    @Test
    public void XmlToDatabase(){
        DatabaseData databaseData = new DatabaseData();
        databaseData.clearDatabase();
        
        boolean success = true;
        
        xmlDatabase = new XmlDatabase();
        xmlDatabase.fromXmlToDatabase();
    
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
        
            Query query = entityManager.createQuery("SELECT k FROM Book k");
            List<Book> books = query.getResultList();
        
            try {
                assertThat(books, containsInAnyOrder(
                        hasProperty("ISBN", is("0261103597")),
                        hasProperty("ISBN", is("0141036133")),
                        hasProperty("ISBN", is("1853260088")),
                        hasProperty("ISBN", is("1853260231")),
                        hasProperty("ISBN", is("1840226358")),
                        hasProperty("ISBN", is("1784873187")),
                        hasProperty("ISBN", is("0399501487")),
                        hasProperty("ISBN", is("0241951445")),
                        hasProperty("ISBN", is("0486470615")),
                        hasProperty("ISBN", is("0006546064")),
                        hasProperty("ISBN", is("0261103580")),
                        hasProperty("ISBN", is("0261103573")),
                        hasProperty("ISBN", is("0141441674"))
                ));
            }
            catch(AssertionError e){
                success = false;
            }
        
            entityManager.getTransaction().commit();
        
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            success = false;
        }
        finally {
            entityManagerFactory.close();
        }
        assertTrue(success);
    }
    
    @Test
    public void jsonToDatabase(){
        DatabaseData databaseData = new DatabaseData();
        databaseData.clearDatabase();
        
        boolean success = true;
        
        jsonDatabase = new JsonDatabase();
        jsonDatabase.fromJsonToDatabase();
    
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
        
            entityManager.getTransaction().begin();
        
            Query query = entityManager.createQuery("SELECT k FROM Book k");
            List<Book> books = query.getResultList();
    
            try {
                assertThat(books, containsInAnyOrder(
                        hasProperty("ISBN", is("0261103597")),
                        hasProperty("ISBN", is("0141036133")),
                        hasProperty("ISBN", is("1853260088")),
                        hasProperty("ISBN", is("1853260231")),
                        hasProperty("ISBN", is("1840226358")),
                        hasProperty("ISBN", is("1784873187")),
                        hasProperty("ISBN", is("0399501487")),
                        hasProperty("ISBN", is("0241951445")),
                        hasProperty("ISBN", is("0486470615")),
                        hasProperty("ISBN", is("0006546064")),
                        hasProperty("ISBN", is("0261103580")),
                        hasProperty("ISBN", is("0261103573")),
                        hasProperty("ISBN", is("0141441674"))
                ));
            }
            catch(AssertionError e){
                success = false;
            }
    
            entityManager.getTransaction().commit();
    
            entityManager.close();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            success = false;
        }
        finally {
            entityManagerFactory.close();
        }
        assertTrue(success);
    }
    
}