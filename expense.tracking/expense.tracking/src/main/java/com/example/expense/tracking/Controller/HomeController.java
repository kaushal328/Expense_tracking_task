package com.example.expense.tracking.Controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.expense.tracking.Entity.Expense;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registor")
    public String registorPage() {
        return "registor";
    }

    @GetMapping("/index")
    public String dashboard(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/expense-list")
    public String expenseList(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        return "expense_list";
    }

    @GetMapping("/add-expense")
    public String expensePage(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        return "Expense";
    }

    @GetMapping("/update-expense-page/{id}")
    public String loadUpdateExpensePage(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        model.addAttribute("expenseId", id);
        return "update_expense";
    }

}
