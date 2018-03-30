package demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Department;
import entities.Employee;
import learn.eddypastika.HibernateTutorial.DataUtils;
import learn.eddypastika.HibernateTutorial.HibernateUtils;

public class PersistDemo {

	//second commit
	public static void main(String[] args) {
		
	SessionFactory factory = HibernateUtils.getSessionfactory();
	Session session = factory.getCurrentSession();
    Department department = null;
    Employee emp = null;
    
    try {
		session.getTransaction().begin();
		
		Long maxEmpId = DataUtils.getMaxEmpId(session);
		Long empId = maxEmpId + 1;
		
		//Get Persistent Object
		department = DataUtils.findDepartment(session, "D10");
		
		// Create transient object
		emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpNo("E"+empId);
		emp.setEmpName("Name "+empId);
		emp.setJob("Coder");
		emp.setSalary(1000f);
		emp.setManager(null);
		emp.setHideDate(new Date());
		emp.setDepartment(department);
		
		// Using persist(..)
        // Now 'emp' is managed by Hibernate.
        // it has Persistent status.
        // No action at this time with DB.
		session.persist(emp);
		
		// At this step the data is pushed to the DB.
        // Execute Insert statement.
		session.getTransaction().commit();
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		session.getTransaction().rollback();
	}

	}

}
