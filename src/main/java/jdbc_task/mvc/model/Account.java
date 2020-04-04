package jdbc_task.mvc.model;

public class Account {
    private int id;
    private int clientId;
    private double amount;
    private String accCode;

    public Account(int id, int clientId, double amount, String accCode) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.accCode = accCode;
    }

    public Account(int clientId, String accCode) {
        this.id = -1;
        this.clientId = clientId;
        this.accCode = accCode;
        this.amount = 0.;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", счёт = " + amount +
                ", тип валюты = " + accCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }
}
