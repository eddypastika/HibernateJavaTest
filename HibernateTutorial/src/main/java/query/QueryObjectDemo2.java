package query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entities.Department;
import entities.Employee;
import learn.eddypastika.HibernateTutorial.HibernateUtils;

public class QueryObjectDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtils.getSessionfactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.  
			session.getTransaction().begin();
			
			// Create an HQL statement, query the object.
            // HQL with parameters.            
            // Equivalent to the SQL statement:
            // Select e.* from EMPLOYEE e cross join DEPARTMENT d
            // where e.DEPT_ID = d.DEPT_ID and d.DEPT_NO = :deptNo; 
			String sql = "Select e from "+Employee.class.getName()+ " e "
					+ " where e.department.deptNo =:deptNo";
			
			// Create Query object.
			Query<Employee> query = session.createQuery(sql);
			
			query.setParameter("deptNo", "D10");
			
			// Execute query.
			List<Employee> employees = query.getResultList();
			
			for (Employee emp : employees) {
				
				System.out.println("Emp: " +emp.getEmpNo()+ ": "
						+ emp.getEmpName() + ", "+emp.getSalary());
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
