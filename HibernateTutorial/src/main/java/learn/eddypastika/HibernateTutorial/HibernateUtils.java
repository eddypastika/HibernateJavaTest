package learn.eddypastika.HibernateTutorial;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
 
   private static final SessionFactory sessionFactory = buildSessionFactory();
   
   //HB 5
   private static SessionFactory buildSessionFactory() {
	   
	   try {
		   
		//Create the ServiceRegistry from hibernate.cfg.xml
		   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				   .configure("hibernate.cfg.xml").build();
		   
		   //Create a metadata sources using the specified service registry.
		   Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		   return metadata.getSessionFactoryBuilder().build();
		   
		} catch (Throwable ex) {
			
			System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
		}
   }

	/**
	 * @return the sessionfactory
	 */
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
   
	public static void shutdown() {
		// Close caches and connection pools
		getSessionfactory().close();
	}
   
}
