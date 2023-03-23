package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import beanClassed.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("empUnit");
	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();	
	    
	    et.begin();
	    
	    em.persist(emp);
	    
	    et.commit();
	 
	    em.close();
	    
	    System.out.println("Employee added successfully...");
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		// TODO Auto-generated method stub
	EntityManager em = emf.createEntityManager();
	Employee emp = em.find(Employee.class, empId);
	em.close();
	if(emp!=null) {
       return "Address of the employee with id "+empId+" is "+emp.getAddress();
	}else {
		return "Employee with id "+empId+" not found";
	}
	
//		return null;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Employee e = em.find(Employee.class, empId);
		em.close();
		if(e!=null) {
			
				return "Bonus for Employee with employee "+e.getName()+" is "+bonus+" rupees";
			
		}else {
			return "No employee with employee Id "+empId+" exists!";
		}
		
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction et = em.getTransaction();
	 Employee e = em.find(Employee.class, empId);
	 if(e!=null) {
		 et.begin();
		 em.remove(e);
		 et.commit();
		 em.close();
		 return true;
	 }else {
		 return false;
	 }
	
	 
	 
	 
	}

	
	
}
