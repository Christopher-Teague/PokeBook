package com.java.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.java.pokebook.models.Expense;
import com.java.pokebook.services.ExpenseService;

@Controller
public class HomeController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/pokebook")
	public String dashboard(Model model, @ModelAttribute("newExpense")Expense newExpense) {
		List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
	
	@GetMapping("/findAll")
	public List<Expense> findAllExpenses() {
		return expenseService.allExpenses();
	}

	
					// ***** CREATE ***** \\
	
	@PostMapping("/expenses")
	public String createNewExpense(@Valid @ModelAttribute("newExpense")Expense newExpense, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			System.out.println("FAIL");
			return "index.jsp";
		} else {
			System.out.println("PASS");
			expenseService.addExpense(newExpense);
			return "redirect:/pokebook";
		}
	}	
	
	
					// ***** RETRIEVE ***** \\
	
	@GetMapping("/show/{id}")
		public String showExpense(Model model, @PathVariable("id")Long id) {
		 Expense expense = expenseService.findOne(id);
		 model.addAttribute(expense);
			return "show.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public Expense findOneExpense(@PathVariable("id")Long id) {
		return expenseService.findOne(id);
	}
	
	
					// ***** UPDATE ***** \\
	
	@GetMapping("/expenses/{id}/edit")
		public String editExpense( Model model,@ModelAttribute("editExpense")Expense editExpense,@PathVariable("id")Long id) {
		Expense expense = expenseService.findOne(id);
		model.addAttribute("editExpense", expense);
		return "editExpense.jsp";
	}
	
	
	@PutMapping("/expenses/{id}/process")
	public String processEditExpense(@Valid @ModelAttribute("editExpense")Expense editExpense,BindingResult result,@PathVariable("id")Long id) {
		if (result.hasErrors()) {
			return "editExpense.jsp";
		} else {
			expenseService.addExpense(editExpense);
			return "redirect:/pokebook";
		}
	}	
	
				
					// ***** DELETE ***** \\
	
	@DeleteMapping("/expenses/{id}/delete")
	public String processDeleteExpense(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/pokebook";
	}
	

	
	
	
	
	
	
}
