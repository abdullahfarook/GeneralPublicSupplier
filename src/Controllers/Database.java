package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.eclipse.persistence.config.PersistenceUnitProperties.*;
public  class Database {

   public static          EntityManagerFactory entityManagerFactory;
   public static          EntityManager entityManager;


        public void DatabaseConnect() {

            try {
                //String fileUrl = new File("src/AddressBook.accdb").toURI().toURL().getPath();
                Map properties = new HashMap();

                // Ensure RESOURCE_LOCAL transactions is used.
//            properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

                // Configure the internal EclipseLink connection pool
                properties.put(JDBC_DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                properties.put(JDBC_URL, "jdbc:sqlserver://localhost:1433;databaseName=TestDatabase;");


                // Configure logging. FINE ensures all SQL is shown
                properties.put(LOGGING_LEVEL, "FINE");
                properties.put(LOGGING_TIMESTAMP, "false");
                properties.put(LOGGING_THREAD, "false");
                properties.put(LOGGING_SESSION, "false");
                properties.put(LOGGING_PARAMETERS, "true");
                // Ensure that no server-platform is configured


                //properties.put(TARGET_SERVER, TargetServer.None);
                // Now the EntityManagerFactory can be instantiated for testing using:

                System.out.println(properties.toString());
               this.entityManagerFactory = Persistence.createEntityManagerFactory("GPS", properties);
                this.entityManager= entityManagerFactory.createEntityManager();

                System.out.println("Database Connected Successfully...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static final EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public final void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public static final   EntityManager getEntityManager() {
        return entityManager;
    }

    public final   void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
