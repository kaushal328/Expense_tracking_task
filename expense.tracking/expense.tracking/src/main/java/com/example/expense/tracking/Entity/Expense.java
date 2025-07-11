package com.example.expense.tracking.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_name")
    private String expense_name;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "expense_date")
    private Date expense_date;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // foreign key to Users table
    private Users user;

    public Long getId() {
        return id;
    }

    public Expense setId(Long id) {
        this.id = id;
        return this;
    }

    public String getExpense_name() {
        return expense_name;
    }

    public Expense setExpense_name(String expense_name) {
        this.expense_name = expense_name;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Expense setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public Expense setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Expense setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public Expense setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
