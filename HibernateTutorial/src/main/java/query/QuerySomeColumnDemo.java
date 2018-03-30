package query;

import java.util.List;

import org.hibernate.query.Query;

import entities.Employee;
import learn.eddypastika.HibernateTutorial.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

 
public class QuerySomeColumnDemo {
 
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionfactory();
 
        Session session = factory.getCurrentSession();
 
        try {
            session.getTransaction().begin();
  
            // Query some columns.
            String sql = "Select e.empId, e.empNo, e.empName from "
                    + Employee.class.getName() + " e ";
 
            Query<Object[]> query = session.createQuery(sql);
  
            // Execute Query.
            // Get the array of Object
            List<Object[]> datas = query.getResultList();
 
            for (Object[] emp : datas) {
                System.out.println("Emp Id: " + emp[0]);
                System.out.println(" Emp No: " + emp[1]);
                System.out.println(" Emp Name: " + emp[2]);
            }
  
            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
  
    }
}
