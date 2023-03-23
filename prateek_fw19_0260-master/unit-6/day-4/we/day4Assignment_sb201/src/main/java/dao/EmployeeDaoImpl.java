package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import classes.Employee;
import exceptions.EmployeeException;
import utility.GetConnection;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		
		EntityManager em = GetConnection.entityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(employee);
		et.commit();
		
        Employee e = em.find(Employee.class, employee.getId());
		em.close();
		 if(e!=null) {
			 return e;
		 }else {
			 throw new EmployeeException("Employee is not added...");
		 }
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e = null;
		
		EntityManager em = GetConnection.entityManager();
		e = em.find(Employee.class, empId);
		em.close();
		if(e!=null) {
			return e;
		}else {
			throw new EmployeeException("Employee not found...");
		}
	}

	@Override
	public Employee deleteEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		EntityManager em = GetConnection.entityManager();
		Employee e = em.find(Employee.class, empId);
		
		if(e!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(e);
			et.commit();
			em.close();
			return e;
		}else {
		    em.close();
			throw new EmployeeException("Employee not found...");
		}
		
		
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em = GetConnection.entityManager();
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
		Employee e = em.find(Employee.class, employee.getId());
		em.close();
		if(e!=null) {
			return e;
		}else {
			throw new EmployeeException("Employee is not updated");
		}
	
		
	}

}
