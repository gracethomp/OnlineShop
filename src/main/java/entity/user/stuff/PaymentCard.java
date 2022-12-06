package entity.user.stuff;

import entity.enums.CardType;
import exceptions.PaymentCardIllegalArgumentException;
import org.apache.log4j.Logger;

import java.util.Objects;

public class PaymentCard {
    private long number;
    private int month;
    private int year;
    private int CVV;
    private CardType cardType;

    private static final Logger LOGGER = Logger.getLogger(Order.class);
    
    public PaymentCard() {

    }

    public PaymentCard(long number, int month, int year, int CVV, CardType cardType) {
        if(String.valueOf(number).length() != 16){
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_CARD_NUMBER);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_CARD_NUMBER);
        }
        if(month < 1 || month > 12 || year < 2021 || year > 2027) {
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_DATE);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_DATE);
        }
        if (String.valueOf(CVV).length() != 3){
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_CVV);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_CVV);
        }
        this.number = number;
        this.month = month;
        this.year = year;
        this.CVV = CVV;
        this.cardType = cardType;
    }

    public long getNumber() {
        LOGGER.trace("number was gotten");
        return number;
    }

    public int getMonth() {
        LOGGER.trace("month was gotten");
        return month;
    }

    public int getYear() {
        LOGGER.trace("year was gotten");
        return year;
    }

    public int getCVV() {
        LOGGER.trace("CVV was gotten");
        return CVV;
    }

    public CardType getCardType() {
        LOGGER.trace("card type was gotten");
        return cardType;
    }

    public void setCVV(int CVV) {
        if (String.valueOf(CVV).length() != 3){
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_CVV);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_CVV);
        }
        LOGGER.trace("CVV was set");
        this.CVV = CVV;
    }

    public void setNumber(long number) {
        if(String.valueOf(number).length() != 16){
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_CARD_NUMBER);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_CARD_NUMBER);
        }
        LOGGER.trace("number was set");
        this.number = number;
    }

    public void setMonth(int month) {
        if(month < 1 || month > 12) {
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_DATE);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_DATE);
        }
        LOGGER.trace("month was set");
        this.month = month;
    }

    public void setYear(int year) {
        if(year < 2021 || year > 2027) {
            LOGGER.error(PaymentCardIllegalArgumentException.MESSAGE_DATE);
            throw new PaymentCardIllegalArgumentException(PaymentCardIllegalArgumentException.MESSAGE_DATE);
        }
        LOGGER.trace("year was set");
        this.year = year;
    }

    public void setCardType(CardType cardType) {
        LOGGER.trace("card type was set");
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
