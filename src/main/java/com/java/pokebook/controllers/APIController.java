package com.java.pokebook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.pokebook.models.Expense;
import com.java.pokebook.services.ExpenseService;

@RestController
@RequestMapping("/api")
public class APIController {

	
	// Imports expenseService
	
	@Autowired
	ExpenseService expenseService;
	
	//  ^^^^^ SAME AS ABOVE ^^^^^ 

	//	private final ExpenseRepository expenseRepo;
//	
//	public ExpenseService(ExpenseRepository expenseRepo) {
//		this.expenseRepo = expenseRepo;
//	}
	
	//  *************************
	
	@GetMapping("/findAll")
	public List<Expense> findAllExpenses() {
		return expenseService.allExpenses();
	}
	
	@PostMapping("/expenses")
	public Expense createExpense(
			@RequestParam("name") String name,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") double amount,
			@RequestParam("description") String description) {
		Expense newExpense = new Expense(name, vendor, amount, description);
		return expenseService.addExpense(newExpense);
	}
	
	@GetMapping("/expenses/{id}")
	public Expense findOneExpense(@PathVariable("id")Long id) {
		return expenseService.findOne(id);
	}
	
	@PutMapping("/expenses/{id}")
	public Expense processUpdateExpense(@PathVariable("id") Long id,
		@RequestParam("name") String name,
		@RequestParam("vendor") String vendor,
		@RequestParam("amount") double amount,
		@RequestParam("description") String description	) {
		return expenseService.updateExpense(id, name, vendor, amount, description);
	}
	
//    @PutMapping("/expenses/{id}")
//    public String processEditExpense( @Valid @ModelAttribute("expense")Expense expense,
//            BindingResult result,@PathVariable("id")Long id) {
//        if(result.hasErrors()) {
//            return "index.jsp";
//        }else {
//            expenseService.processUpdateExpense(expense);
//            return "redirect:/dashboard";            
//        }
//    }    
	
	
	
	
	@DeleteMapping("/expenses/{id}")
	public void processDeleteExpense(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
	}
	
}
