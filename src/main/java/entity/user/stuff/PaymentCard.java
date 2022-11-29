package entity.user.stuff;

import java.util.Objects;

public class PaymentCard {
    private long number;
    private int month;
    private int year;
    private int CVV;
    public PaymentCard() {

    }

    public PaymentCard(long number, int month, int year, int CVV) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.CVV = CVV;
    }

    public long getNumber() {
        return number;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentCard that = (PaymentCard) o;
        return number == that.number && month == that.month && year == that.year && CVV == that.CVV;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, month, year, CVV);
    }

    @Override
    public String toString() {
        return "PaymentCard has" + "number: " + number + ", expire date:" + month + "/" + year + ", CVV: " + CVV;
    }
}
