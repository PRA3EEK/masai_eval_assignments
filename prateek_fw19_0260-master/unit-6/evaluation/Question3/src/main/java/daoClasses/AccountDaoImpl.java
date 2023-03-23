package daoClasses;

import classes.Account;
import javax.persistence.*;

public class AccountDaoImpl implements AccountDao{

	

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
	@Override
	
	public Account findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Account a = em.find(Account.class, id);
	    em.close();
		return a;
	}

	@Override
	public String save(Account account) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(account);
	    et.commit();
	    em.close();
		return "Account added successfully...";
	}

	@Override
	public String deleteAccountById(int id) {
		// TODO Auto-generated method stub
      EntityManager em = emf.createEntityManager();
		
      Account a = em.find(Account.class, id);
      if(a!=null) {
    	  EntityTransaction et = em.getTransaction();
    	  et.begin();
  		em.remove(a);
  	    et.commit();
  	    em.close();
  	    return "Account deleted successfully...";
      }else {
    	  return "Account not found";
      }
		
		
	}

	@Override
	public String withdraw(double amount, int accountId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Account a = em.find(Account.class, accountId);
		if(a!=null) {
			double bal = a.getBalance();
			if(amount<=bal) {
			a.setBalance(bal-amount);
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(a);
			et.commit();
		    em.close();
		    return "Withdrawal of rupees "+amount+" is successfull...";
			}else {
				return "Not enough balance in the account...";
			}
		}else {
			return "Account not found...";
		}
		
//		return null;
	}

	@Override
	public String deposit(double amount, int accountId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Account a = em.find(Account.class, accountId);
		if(a!=null) {
			double bal = a.getBalance();
			a.setBalance(bal+amount);
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(a);
			et.commit();
		    em.close();
		    return "Deposite of rupees "+amount+" is successfull...";
		}else {
			return "Account not found...";
		}
		
	}

}
