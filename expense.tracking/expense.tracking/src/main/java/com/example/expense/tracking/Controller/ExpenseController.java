package com.example.expense.tracking.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.expense.tracking.ExpenseResposatory;
import com.example.expense.tracking.Response;
import com.example.expense.tracking.DAO.ExpenseDTO;
import com.example.expense.tracking.DAO.UserRegistrationDTO;
import com.example.expense.tracking.Entity.Expense;
import com.example.expense.tracking.Service.ExpenseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpenseResposatory expenseResposatory;

    @PostMapping("/add_expense")
    public ResponseEntity<?> addExpense(@Valid @RequestBody ExpenseDTO dto, HttpSession session) {
        Object userId = session.getAttribute("loggedInUser");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response<>(false, "Please login to continue!", null));
        }
        Expense expense = expenseService.addExpense(dto);
        if (expense == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response<>(false, "Something went wrong!!", null));
        }
        return ResponseEntity.ok("Expense Save Successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @PutMapping("/update_expense/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDTO dto,
            HttpSession session) {
        Object userId = session.getAttribute("loggedInUser");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response<>(false, "Please login to continue!", null));
        }

        Expense updatedExpense = expenseService.updateExpense(id, dto);
        if (updatedExpense == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Response<>(false, "Expense not found or update failed!", null));
        }

        return ResponseEntity.ok(new Response<>(true, "Expense updated successfully", updatedExpense));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        if (expense != null) {
            return ResponseEntity.ok(expense);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
