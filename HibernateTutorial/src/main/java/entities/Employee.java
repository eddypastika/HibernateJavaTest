package entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"EMP_NO"})})

public class Employee {
	private Long empId;
	private String empNo;
	 
	private String empName;
	private String job;
	private Employee manager;
	private Date hideDate;
	private Float salary;
	private byte[] image;
	 
	private Department department;
	private Set<Employee> employees = new HashSet<Employee>(0);
	
	public Employee() {
		super();
	}

	public Employee(Long empId, String empNo, String empName, String job, Employee manager, Date hideDate, Float salary,
			byte[] image, Department department) {
		super();
		this.empId = empId;
		this.empNo = "E" + this.empId;
		this.empName = empName;
		this.job = job;
		this.manager = manager;
		this.hideDate = hideDate;
		this.salary = salary;
		this.image = image;
		this.department = department;
	}

	/**
	 * @return the empId
	 */
	@Id
	@Column(name = "EMP_ID")
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empNo
	 */
	@Column(name = "EMP_NO", length = 20, nullable = false)
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the empName
	 */

	@Column(name = "EMP_NAME", length = 50, nullable = false)
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the job
	 */
	@Column(name = "JOB", length = 30, nullable = false)
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the manager
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MNG_ID")
	public Employee getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/**
	 * @return the hideDate
	 */
	@Column(name = "HIRE_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getHideDate() {
		return hideDate;
	}

	/**
	 * @param hideDate the hideDate to set
	 */
	public void setHideDate(Date hideDate) {
		this.hideDate = hideDate;
	}

	/**
	 * @return the salary
	 */
	@Column(name = "SALARY", nullable = false)
	public Float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}

	/**
	 * @return the image
	 */
	@Column(name = "IMAGE", length = 1111111, nullable = true)
	@Lob
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the department
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID", nullable = false)
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the employees
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empId")
	public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	

}
