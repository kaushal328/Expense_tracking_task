package com.example.expense.tracking.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ExpenseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private Date expense_date;

    private Long id;

    public Long getId() {
        return id;
    }

    public ExpenseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public ExpenseDTO setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
        return this;
    }

    @NotBlank(message = "expense name is required")
    private String expense_name;
    @NotNull
    private Double amount;

    @NotBlank(message = "description is required")
    private String description;

    public String getExpense_name() {
        return expense_name;
    }

    public ExpenseDTO setExpense_name(String expense_name) {
        this.expense_name = expense_name;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public ExpenseDTO setAmount(Double amount) {
        this.amount = amount;
        return this;
    }



    public String getDescription() {
        return description;
    }

    public ExpenseDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
