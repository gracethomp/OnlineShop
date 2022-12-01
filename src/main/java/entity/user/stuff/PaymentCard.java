package entity.user.stuff;

import entity.enums.CardType;

import java.util.Objects;

public class PaymentCard {
    private long number;
    private int month;
    private int year;
    private int CVV;
    private CardType cardType;
    public PaymentCard() {

    }

    public PaymentCard(long number, int month, int year, int CVV, CardType cardType) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.CVV = CVV;
        this.cardType = cardType;
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

    public CardType getCardType() {
        return cardType;
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

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentCard that = (PaymentCard) o;
        return number == that.number && month == that.month && year == that.year
                && CVV == that.CVV && cardType == that.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, month, year, CVV, cardType);
    }

    @Override
    public String toString() {
        return "PaymentCard has" + "number: " + number + ", expire date:" + month + "/"
                + year + ", CVV: " + CVV + ", Card type: " + cardType;
    }
}
