package com.example.expense.tracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.expense.tracking.ExpenseResposatory;
import com.example.expense.tracking.DAO.ExpenseDTO;
import com.example.expense.tracking.Entity.Expense;
import com.example.expense.tracking.Entity.Users;
import com.example.expense.tracking.UserReposatory;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseResposatory expenseResposatory;
    @Autowired
    private UserReposatory userRepository;

    public Expense addExpense(ExpenseDTO expenseDTO) {
        // Users user = userRepository.findById(dto.getUser_id())
        // .orElseThrow(() -> new RuntimeException("User not found"));
        Expense expense = new Expense();
        // expense.setUser(user);
        expense.setAmount(expenseDTO.getAmount());
        expense.setExpense_name(expenseDTO.getExpense_name());
        expense.setExpense_date(expenseDTO.getExpense_date());
        expense.setDescription(expenseDTO.getDescription());
        expense.setStatus(Boolean.valueOf("true"));
        expenseResposatory.save(expense);
        return expense;
    }

    public List<Expense> getAllExpenses() {
        return expenseResposatory.findAll();
    }

    public Expense updateExpense(Long id, ExpenseDTO dto) {
        Expense existing = expenseResposatory.findById(id).orElse(null); // fix typo if needed
        if (existing == null) {
            return null;
        }
        existing.setAmount(dto.getAmount());
        existing.setExpense_name(dto.getExpense_name());
        existing.setExpense_date(dto.getExpense_date());
        existing.setDescription(dto.getDescription());
        return expenseResposatory.save(existing);
    }

    public Expense getExpenseById(Long id) {
        return expenseResposatory.findById(id).orElse(null);
    }
}
