package jdbc_task.mvc.model;

import java.util.Date;

public class Operation {

    private int id;
    private Date date;
    private String accCode;
    private int idAccountFrom;
    private int idAccountTo;
    private double sum;
    private double amountBefore;
    private double amountAfter;

    public Operation(int id, Date date, String accCode, int idAccountFrom,
                     int idAccountTo, double sum, double amountBefore, double amountAfter) {
        this.id = id;
        this.date = date;
        this.accCode = accCode;
        this.idAccountFrom = idAccountFrom;
        this.idAccountTo = idAccountTo;
        this.sum = sum;
        this.amountBefore = amountBefore;
        this.amountAfter = amountAfter;
    }

    public Operation(Date date, String accCode, int idAccountFrom,
                     int idAccountTo, double sum, double amountBefore, double amountAfter) {
        this.id = -1;
        this.date = date;
        this.accCode = accCode;
        this.idAccountFrom = idAccountFrom;
        this.idAccountTo = idAccountTo;
        this.sum = sum;
        this.amountBefore = amountBefore;
        this.amountAfter = amountAfter;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", дата перевода = '" + date + '\'' +
                ", валюта = '" + accCode + '\'' +
                ", счет с которого перевели = " + idAccountFrom +
                ", счет на который перевели = " + idAccountTo +
                ", сумма перевода = " + sum +
                ", Количетво средст до перевода = " + amountBefore +
                ", Количество после перевода = " + amountAfter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public int getIdAccountFrom() {
        return idAccountFrom;
    }

    public void setIdAccountFrom(int idAccountFrom) {
        this.idAccountFrom = idAccountFrom;
    }

    public int getIdAccountTo() {
        return idAccountTo;
    }

    public void setIdAccountTo(int idAccountTo) {
        this.idAccountTo = idAccountTo;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAmountBefore() {
        return amountBefore;
    }

    public void setAmountBefore(double amountBefore) {
        this.amountBefore = amountBefore;
    }

    public double getAmountAfter() {
        return amountAfter;
    }

    public void setAmountAfter(double amountAfter) {
        this.amountAfter = amountAfter;
    }
}
