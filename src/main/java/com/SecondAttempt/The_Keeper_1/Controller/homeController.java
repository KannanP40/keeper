package com.SecondAttempt.The_Keeper_1.Controller;

import java.util.List;
import java.util.Map;

import com.SecondAttempt.The_Keeper_1.DTO.UserDTO;
import com.SecondAttempt.The_Keeper_1.Entity.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.SecondAttempt.The_Keeper_1.Entity.Expense;
import com.SecondAttempt.The_Keeper_1.Entity.ExpenseService;

@Controller
public class homeController {
	
	@Autowired
	ExpenseService service;

	@Autowired
	UserService uService;

	
	@RequestMapping("keeper")
	public String home(ModelMap model, HttpSession session) {
//		String message = "Hello from Spring Boot!"; // Define your string data
	        
//	    Optional<Expense> e = r.findById(1);
//	    if (e.isPresent()) {
//            Expense expense = e.get();
//            double amount = expense.getAmt(); // Assuming getAmt() returns the amount value
//            model.addAttribute("message", "Amount: " + amount);
//        } else {
//            model.addAttribute("message", "Expense with ID 1 not found");
//        }
	    //model.addAttribute("message", e.getAmt()); // Add string to model
		int amount = 000000;//r.findBalanceByCustomFlag(true);
		model.addAttribute("amount", amount);

	    String name = (String) session.getAttribute("Name");
		if(name == null) return "redirect:/login";
		return "home";

	}
	
	@RequestMapping(value="IncomeLink",method=RequestMethod.GET)
	public String IncomePageGet(Model model) {
		System.out.print("Inside IncomePageGet");
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		return "Income";
	}
	
	@RequestMapping(value="IncomeLink",method=RequestMethod.POST)
	public String IncomePagePost(@ModelAttribute("expense") Expense e) {
        service.addToDb(e);
		return "redirect:keeper";
	}
	
	
	@RequestMapping(value="ExpenseLink",method=RequestMethod.GET)
	public String ExpensePageGet(Model model) {
		System.out.print("Inside ExpensePageGet");
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		return "Expense";
	}
	
	@RequestMapping(value="ExpenseLink",method=RequestMethod.POST)
	public String ExpensePagePost(@ModelAttribute("expense") Expense e) {
		e.setAmt(e.getAmt()*(-1));
        service.addToDb(e);
		return "redirect:keeper";
	}
	
	@RequestMapping("LogsLink")
	public String LogsPageGet(Model m) {
		List<Expense> expenses = service.TotalData();
		m.addAttribute("expenses", expenses);
		return "Logs";
	}
	
	@RequestMapping("income-expense-graph")
    public String showIncomeExpenseGraph(Model model) {
        // Add code to fetch income and expense data and populate the model attributes
        Map<String, Integer> incomeData = service.calculateIncome(); // Fetch income data from your service layer or repository
        Map<String, Integer> expenseData = service.calculateExpense();// Fetch expense data from your service layer or repository
        model.addAttribute("incomeData", incomeData);
        model.addAttribute("expenseData", expenseData);
        return "IncomeToExpense"; // Return the name of the Thymeleaf template
    }

	@GetMapping("login")
	public String LoginGet(Model model){
		UserDTO u = new UserDTO();
		model.addAttribute("userDTO", u);
		return "LoginPage";
	}

	@PostMapping("login")
	public String LoginPost(@ModelAttribute("userDTO") UserDTO u, Model model, HttpSession session){
		String s = uService.check(u);
		if(s.isEmpty()){
			session.setAttribute("Name",u.getUserName());
			return "home";
		}
		model.addAttribute("error",s);
		return "LoginPage";
	}
}
