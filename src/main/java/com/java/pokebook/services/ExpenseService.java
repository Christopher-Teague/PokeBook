package com.java.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.pokebook.models.Expense;
import com.java.pokebook.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	// IMPORT ExpenseRepository \\
	
	// @Autowired
	// ExpenseRepository expenseRepo;
	
				// ***** OR ***** \\
	
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
		// ********************************\\
	
	
	
			//	******* GET ALL ******* \\

	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}

	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense findOne(Long id) {
		Optional<Expense> optionalExpense =expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Long id, String name, String vendor, Double amount, String description) {
		Expense currExpense = this.findOne(id);
		currExpense.setName(name);
		currExpense.setVendor(vendor);
		currExpense.setAmount(amount);
		currExpense.setDescription(description);
		return expenseRepo.save(currExpense);		
	}
	
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
}
