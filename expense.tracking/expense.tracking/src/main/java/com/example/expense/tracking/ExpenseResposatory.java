package com.example.expense.tracking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expense.tracking.Entity.Expense;

@Repository
public interface ExpenseResposatory extends JpaRepository<Expense,Long> {

}
