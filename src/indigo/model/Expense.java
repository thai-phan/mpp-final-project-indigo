package indigo.model;


import java.sql.Date;
import java.time.LocalDate;

public class Expense {
    private String expenseId;
    private String userId;
    private Double amount;
    private Date date;
    private String description;

    public Expense() {
    }

    public Expense(String expenseId, String userId, Double amount,
                   Date date, String description) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getUserId() {
        return userId;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getExpenseId() {
        return expenseId;
    }
}
