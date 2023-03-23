package com.prateek.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.DTO.AccountDTO;
import com.prateek.entities.Account;
import com.prateek.exceptions.AccountException;
import com.prateek.exceptions.InsufficientFundException;
import com.prateek.repo.AccountRepo;


@Service
public class AccountServiceImpl implements AccountService{
    
	
	@Autowired
	private AccountRepo aRepo;
	
	@Override
	public Account openAccount(Account acc) throws AccountException {
		// TODO Auto-generated method stub
		aRepo.save(acc);
		
		return acc;
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		// TODO Auto-generated method stub
		
		Optional<Account> opt = aRepo.findById(accno);
		
		if(opt.isPresent()) {
			aRepo.delete(opt.get());
		}
		
     throw new AccountException("No Account present with account number "+accno);
	}

	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
		// TODO Auto-generated method stub
		
		Optional<Account> opt = aRepo.findById(accno);
		
		if(opt.isPresent()) {
			
			Account a = opt.get();
			
			a.setBalance(a.getBalance()+amount);
			
			aRepo.save(a);
			return a;
			
		}
		
		 throw new AccountException("No Account present with account number "+accno);
	}

	@Override
	public Account withdrawAmount(int accno, Integer amount) throws AccountException, InsufficientFundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException {
		// TODO Auto-generated method stub
		return null;
	}

	



}
