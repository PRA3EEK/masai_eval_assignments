package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Department;
import entities.Employee;
import exceptions.DepartmentException;
import exceptions.EmployeeException;
import utilities.EM;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void addDepartment(Department d) {
		// TODO Auto-generated method stub
		
		EntityManager em = EM.provideEM();
		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
EntityManager em = EM.provideEM();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void registerEmployeeTODepartment(int empId, int deptId) throws EmployeeException, DepartmentException {
		// TODO Auto-generated method stub
		EntityManager em = EM.provideEM();
		Department d = em.find(Department.class, deptId);
		Employee e = em.find(Employee.class, empId);
		
		if(d==null) {
			em.close();
			throw new DepartmentException("No Department found...");
			
		}else if(e == null) {
			em.close();
			throw new EmployeeException("No Employee found...");
		}else {
			d.getEmployees().add(e);
			e.setDept(d);
			em.getTransaction().begin();
			em.merge(d);
			em.getTransaction().commit();
			em.close();
		}
		
	
		
	}

	@Override
	public List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em = EM.provideEM();
		
		String st = "from Department where deptName = :dn";
		TypedQuery<Department> tq = em.createQuery(st, Department.class);
		tq.setParameter("dn", deptName);
		
		Department d = tq.getSingleResult();
		
		List<Employee> res = d.getEmployees();
		em.close();
		if(res.size()==0) {
			
			throw new EmployeeException("No Employee exist in the department "+d.getDeptName());
		}else {
		
			return res;
		}
		
//		return null;
	}

	@Override
	public Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException {
		// TODO Auto-generated method stub
		EntityManager em = EM.provideEM();
		String st = "from Employee where empId = :id";
		TypedQuery<Employee> tq = em.createQuery(st, Employee.class);
		tq.setParameter("id", empId);
		
		Employee e = tq.getSingleResult();
		
		Department d = e.getDept();
		em.close();
		if(d==null) {
			throw new DepartmentException("Employee "+e.getEmpName()+" does not works in any department");
		}else {
			return d;
		}
		
//		return null;
	}

}
